package zad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChangerGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> ColorChangerGUI.createAndShowGUI());
    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Zmiana koloru panelu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 500, 400, 200);
        frame.setLayout(new BorderLayout());

        JPanel colorPanel = new JPanel();
        frame.add(colorPanel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JTextField colorTextField = new JTextField(15);
        inputPanel.add(colorTextField);

        JButton changeColorButton = new JButton("Zmień kolor");
        inputPanel.add(changeColorButton);

        frame.add(inputPanel, BorderLayout.SOUTH);

        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String colorName = colorTextField.getText().trim().toLowerCase();
                Color newColor;

                switch (colorName) {
                    case "czerwony":
                        newColor = Color.RED;
                        break;
                    case "zielony":
                        newColor = Color.GREEN;
                        break;
                    case "niebieski":
                        newColor = Color.BLUE;
                        break;
                    case "żółty":
                        newColor = Color.YELLOW;
                        break;
                    case "czarny":
                        newColor = Color.BLACK;
                        break;
                    case "biały":
                        newColor = Color.WHITE;
                        break;
                    case "szary":
                        newColor = Color.GRAY;
                        break;
                    case "różowy":
                        newColor = Color.PINK;
                        break;
                    case "pomarańczowy":
                        newColor = Color.ORANGE;
                        break;
                    case "fioletowy":
                        newColor = new Color(128, 0, 128); // Niestandardowy kolor
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame,
                                "Nieprawidłowa nazwa koloru: " + colorName,
                                "Błąd",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                }

                colorPanel.setBackground(newColor);
            }
        });

        frame.setVisible(true);
    }
}

