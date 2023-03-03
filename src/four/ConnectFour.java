package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class ConnectFour extends JFrame {
    private String player = "X";
    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        initComponents();
        setVisible(true);
        setLayout(null);
        setTitle("Connect Four");
    }
    public void initComponents() {

        JPanel panel = new JPanel(new GridLayout(6, 7, 5, 5));
        List<JButton> buttons = new ArrayList<>();
        for (int j = 6; j >= 1 ; j--) {
        for (char i = 'A'; i <= 'G'; i++) {

                JButton button = new JButton(" ");
                button.setName("Button" + i + j);
                button.addActionListener(e -> {
                    button.setText(this.player);
                    player = "X".equals(player) ? "O" : "X";
                });
                button.setFocusPainted(false);
                panel.add(button);
                buttons.add(button);
            }
        }
        add(panel);


    }

    public static void main(String[] args) {
        new ConnectFour();
    }
}
