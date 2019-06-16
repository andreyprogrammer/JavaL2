package lesson_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Server extends JFrame {
    private static Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    JTextField inputMessageField;
    JTextArea textArea;

    public Server(){
        serverGUI();
        new Thread(() -> openConnection()).start();
    }

    private void serverGUI() {
        int width = 520;
        int height = 520;
        setBounds(350, 300, width, height);
        setTitle("Server");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel genPanel = new JPanel();
        JPanel pan1 = new JPanel();
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setPreferredSize(new Dimension(width - 25, height - 90));
        pan1.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel pan2 = new JPanel();
        pan2.setLayout(new BoxLayout(pan2, BoxLayout.X_AXIS));
        inputMessageField = new JTextField( 35);
        JButton btn = new JButton("Отправить");
        pan2.add(inputMessageField);
        pan2.add(btn);

        genPanel.add(pan1);
        genPanel.add(pan2);
        getContentPane().add(genPanel);

        inputMessageField.addActionListener(e -> sendMessage());
        btn.addActionListener(e -> sendMessage());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                closeConnection();
            }
        });

        setResizable(false);
        setVisible(true);
        inputMessageField.requestFocusInWindow();
    }

    private void openConnection() {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            textArea.append("Сервер запущен, ждёт подключения..." + "\n");
            socket = serverSocket.accept();
            textArea.append("Клиент подключился" + "\n");
            //прием сообщений от клиента
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String strFromClient = in.readUTF();
                        if (strFromClient.equalsIgnoreCase("/end")) {
                            out.writeUTF("/end");
                            break;
                        }
                        textArea.append("Client: " + strFromClient + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() { //отправка сообщений клиенту
        try {
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(inputMessageField.getText());
            textArea.append("Server: " + inputMessageField.getText() + "\n");
            inputMessageField.setText("");
            inputMessageField.requestFocusInWindow();
        } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Send message error");
        }
    }

    private void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "DataInputStream is already closed");
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "DataOutputStream is already closed");
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Socket is already closed");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Server::new);

    }
}
