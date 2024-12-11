package zad1;

import javax.swing.*;

public class RunnableTest {
    public static void main(String[] args) {
        // Ukryty sposób działania `SwingUtilities.invokeLater()`
        SwingUtilities.invokeLater(() -> {
            // Tworzenie okna
            JFrame frame = new JFrame("Color Changer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setVisible(true);
        });

    }
}
