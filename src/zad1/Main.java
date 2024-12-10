package zad1;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Tworzenie obiektu JFrame
        JFrame frame = new JFrame("Przykład JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Dodanie prostego komponentu
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        frame.add(panel);

        // Wyświetlenie okna
        frame.setVisible(true);
    }
}
