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
                    FreeRow(35, buttons);
                  player = "X".equals(player) ? "O" : "X";
                });
                button.setFocusPainted(false);
                panel.add(button);
                buttons.add(button);
            }
        }
        add(panel);

    }
    public void FreeRow(int begin, List<JButton> buttons) {
            for (int k = begin; k >= 0 ; k -= 7) {
                if (buttons.get(k).getText().equals(" ")) {
                    buttons.get(k).setText(this.player);
                    break;
                }
                if (k == 0 || k == 1 || k == 2 || k == 3 || k == 4 || k == 5) {

                        begin ++;
                        FreeRow(begin, buttons);

                }
            }
    }
    public static void main(String[] args) {
        new ConnectFour();
    }

}
