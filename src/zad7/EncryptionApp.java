package zad7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptionApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> EncryptionApp.createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Aplikacja szyfrująca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JTextField inputField = new JTextField();
        panel.add(new JLabel("Wprowadź tekst do zaszyfrowania:"));
        panel.add(inputField);

        String[] encryptionMethods = {"Cezar", "ROT13"};
        JComboBox<String> encryptionSelector = new JComboBox<>(encryptionMethods);
        panel.add(new JLabel("Wybierz rodzaj szyfrowania:"));
        panel.add(encryptionSelector);

        JButton encryptButton = new JButton("Zaszyfruj");
        panel.add(encryptButton);

        JLabel resultLabel = new JLabel("Zaszyfrowany tekst: ");
        panel.add(resultLabel);

        frame.add(panel);

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                String selectedMethod = (String) encryptionSelector.getSelectedItem();
                String encryptedText = "";

                if ("Cezar".equals(selectedMethod)) {
                    encryptedText = caesarCipher(inputText, 3); // Przesunięcie o 3
                } else if ("ROT13".equals(selectedMethod)) {
                    encryptedText = rot13Cipher(inputText);
                }

                resultLabel.setText("Zaszyfrowany tekst: " + encryptedText);
            }
        });

        frame.setVisible(true);
    }

    private static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Metoda realizująca szyfr ROT13 - Cezar tylko z przesunięciem o 13
    private static String rot13Cipher(String text) {
        return caesarCipher(text, 13);
    }
}

