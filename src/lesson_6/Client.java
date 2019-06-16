package lesson_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends JFrame {
    final private String ADDRESS = "localhost";
    final private int PORT = 8888;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    JTextField inputMessageField;
    JTextArea textArea;

    public Client() {
        try {
            openConnection();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error connection");
            e.printStackTrace();
        }
        clientGUI();
    }

    private void clientGUI() {
        int width = 520;
        int height = 520;
        setBounds(900, 300, width, height);
        setTitle("Client");
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
                try {
                    out.writeUTF("/end");
                    Thread.sleep(200);
                    closeConnection();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        setResizable(false);
        setVisible(true);
        inputMessageField.requestFocusInWindow();
    }

    private void openConnection() throws IOException {
        socket = new Socket(ADDRESS, PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            try {
                while (true) {
                    String strFromServer = in.readUTF();
                    if (strFromServer.equalsIgnoreCase("/end")) {
                        break;
                    }
                    textArea.append("Server: " + strFromServer);
                    textArea.append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void sendMessage() {
        if (!inputMessageField.getText().trim().isEmpty()) {
            try {
                out.writeUTF(inputMessageField.getText());
                textArea.append("Client: " + inputMessageField.getText() + "\n");
                inputMessageField.setText("");
                inputMessageField.requestFocusInWindow();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Send message error");
            }
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
        SwingUtilities.invokeLater(Client::new);
    }
}
