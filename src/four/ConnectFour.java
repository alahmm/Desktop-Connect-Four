package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        JPanel panel = new JPanel(new GridLayout(6, 7));
        List<JButton> buttons = new ArrayList<>();
        for (int j = 6; j >= 1 ; j--) {
        for (char i = 'A'; i <= 'G'; i++) {
                JButton button = new JButton(" ");
                button.setName("Button" + i + j);
                button.setBackground(Color.LIGHT_GRAY);
                button.setFocusPainted(false);
                panel.add(button);
                buttons.add(button);
            }
        }
        for (int i = 35; i < 42; i++) {
            Writer(i, buttons);
        }

        JButton ButtonReset = new JButton("Reset");
        ButtonReset.setName("ButtonReset");
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(ButtonReset, BorderLayout.EAST);
        add(panel, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

        ButtonReset.addActionListener(e -> {
            for (JButton button : buttons
                 ) {
                button.setText(" ");
                button.setBackground(Color.LIGHT_GRAY);
            }
        });

    }
    public void Writer(int begin, List<JButton> buttons) {
        for (int k = begin; k >= begin - 35 ; k -= 7) {
            buttons.get(k).addActionListener(e -> {
                FreeRow(begin, buttons);
                player = "X".equals(player) ? "O" : "X";
            });

        }
    }
    public static String[][] ArrayToMatrixConverter(List<JButton> array) {
        String[][] matrix = new String[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                matrix[i][j] = array.get(j + i * 7).getText();
            }
        }
        return matrix;
    }
    public static boolean IsWinner(String var, List<JButton> buttons) {
        String[][] matrix = ArrayToMatrixConverter(buttons);
        boolean isWin = false;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i >= 3) {
                    if (Objects.equals(matrix[i][j], var) && Objects.equals(matrix[i - 1][j], var) &&
                            Objects.equals(matrix[i - 2][j], var) && Objects.equals(matrix[i - 3][j], var)){
                        isWin = true;

                    }
                }
                if (i >= 3 && j >= 3) {
                    if ((Objects.equals(matrix[i][j], var) && Objects.equals(matrix[i - 1][j - 1], var) &&
                                    Objects.equals(matrix[i - 2][j - 2], var) && Objects.equals(matrix[i - 3][j - 3], var))
                    || (Objects.equals(matrix[i - 3][j], var) && Objects.equals(matrix[i - 2][j - 1], var) &&
                            Objects.equals(matrix[i - 1][j - 2], var) && Objects.equals(matrix[i][j - 3], var))) {
                        isWin = true;

                    }
                }
                if (j >= 3) {
                    if (Objects.equals(matrix[i][j], var) && Objects.equals(matrix[i][j - 1], var) &&
                            Objects.equals(matrix[i][j - 2], var) && Objects.equals(matrix[i][j - 3], var)){
                        isWin = true;

                    }
                }
            }
        }
        return isWin;
    }
    public void FreeRow(int begin, List<JButton> buttons) {
            for (int k = begin; k >= 0 ; k -= 7) {
                if (buttons.get(k).getText().equals(" ")) {
                    buttons.get(k).setText(this.player);
                    if (IsWinner(this.player, buttons)) {
                        for (JButton button : buttons
                        ) {
                            button.setBackground(Color.BLUE);
                            button.setEnabled(false);
                        }
                    }
                    break;
                }
            }

    }
    public static void main(String[] args) {
        new ConnectFour();
    }

}
