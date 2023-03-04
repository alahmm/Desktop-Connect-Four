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
                button.setFocusPainted(false);
                panel.add(button);
                buttons.add(button);
            }
        }
        for (int i = 35; i < 42; i++) {
            Writer(i, buttons);
        }

        add(panel);

    }
    public void Writer(int begin, List<JButton> buttons) {
        for (int k = begin; k >= begin - 35 ; k -= 7) {
            buttons.get(k).addActionListener(e -> {
                FreeRow(begin, buttons);
                player = "X".equals(player) ? "O" : "X";
            });

        }
    }
    public void FreeRow(int begin, List<JButton> buttons) {
            for (int k = begin; k >= 0 ; k -= 7) {
                if (buttons.get(k).getText().equals(" ")) {
                    buttons.get(k).setText(this.player);
                    break;
                }
            }
    }
    public static void main(String[] args) {
        new ConnectFour();
    }

}
