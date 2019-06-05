package lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow() {
        int width = 520;
        int height = 520;
        setTitle("Чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 300, width, height);

        JPanel genPanel = new JPanel();

        JPanel pan1 = new JPanel();
        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(width - 25, height - 90));
        pan1.add(textArea);

        JPanel pan2 = new JPanel();
        pan2.setLayout(new BoxLayout(pan2, BoxLayout.X_AXIS));
        JTextField textField = new JTextField( 35);
        JButton btn = new JButton("Отправить");
        pan2.add(textField);
        pan2.add(btn);

        genPanel.add(pan1);
        genPanel.add(pan2);
        getContentPane().add(genPanel);

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(textField.getText() + "\n");
                textField.setText("");
                textField.requestFocusInWindow();
            }
        };

        textField.addActionListener(action);

        btn.addActionListener(action);

        setResizable(false);
        setVisible(true);
        textField.requestFocusInWindow();
    }

}
