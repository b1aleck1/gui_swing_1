package zad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChangerGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColorChangerFrame().setVisible(true));
    }
}

// Klasa reprezentująca główne okno aplikacji
class ColorChangerFrame extends JFrame {
    private JPanel colorPanel; // Panel, którego kolor będzie zmieniany
    private JTextField colorTextField; // Pole tekstowe do wprowadzania nazwy koloru

    public ColorChangerFrame() {
        setTitle("Zmiana koloru panelu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 500, 400, 200);
        setLayout(new BorderLayout());

        initComponents();
    }

    // Metoda inicjalizująca komponenty GUI
    private void initComponents() {
        colorPanel = new JPanel();
        add(colorPanel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new FlowLayout());
        colorTextField = new JTextField(15);
        JButton changeColorButton = new JButton("Zmień kolor");

        changeColorButton.addActionListener(new ColorChangeListener());

        inputPanel.add(colorTextField);
        inputPanel.add(changeColorButton);

        add(inputPanel, BorderLayout.SOUTH);
    }

    // Klasa wewnętrzna obsługująca zdarzenie zmiany koloru
    private class ColorChangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String colorName = colorTextField.getText().trim().toLowerCase();
            Color newColor = parseColor(colorName);

            if (newColor != null) {
                colorPanel.setBackground(newColor);
            } else {
                JOptionPane.showMessageDialog(ColorChangerFrame.this,
                        "Nieprawidłowa nazwa koloru: " + colorName,
                        "Błąd",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Metoda pomocnicza do przekształcenia nazwy koloru na obiekt Color
    private Color parseColor(String colorName) {
        switch (colorName) {
            case "czerwony":
                return Color.RED;
            case "zielony":
                return Color.GREEN;
            case "niebieski":
                return Color.BLUE;
            case "żółty":
                return Color.YELLOW;
            case "czarny":
                return Color.BLACK;
            case "biały":
                return Color.WHITE;
            case "szary":
                return Color.GRAY;
            case "różowy":
                return Color.PINK;
            case "pomarańczowy":
                return Color.ORANGE;
            case "fioletowy":
                return new Color(128, 0, 128); // Niestandardowy kolor
            default:
                return null;
        }
    }
}

