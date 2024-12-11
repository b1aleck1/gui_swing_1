package zad6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Kalkulator BMI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLayout(new GridLayout(4, 2));

        // Ustawienie okna na środku ekranu
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        // Etykiety i pola tekstowe dla wagi i wzrostu
        JLabel weightLabel = new JLabel("Waga (kg):");
        JTextField weightField = new JTextField();

        JLabel heightLabel = new JLabel("Wzrost (m):");
        JTextField heightField = new JTextField();

        // Przycisk obliczania i etykieta wyniku
        JButton calculateButton = new JButton("Oblicz");
        JLabel resultLabel = new JLabel("Wynik BMI: ");

        // Dodawanie elementów do ramki
        frame.add(weightLabel);
        frame.add(weightField);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(calculateButton);
        frame.add(resultLabel);

        // Akcja po kliknięciu przycisku "Oblicz"
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Pobieranie wartości z pól tekstowych
                    double weight = Double.parseDouble(weightField.getText());
                    double height = Double.parseDouble(heightField.getText());

                    // Obliczanie BMI
                    double bmi = weight / (height * height);
                    String category;

                    if (bmi < 18.5) {
                        category = "Niedowaga";
                        resultLabel.setForeground(Color.BLUE); // Niedowaga
                    } else if (bmi >= 18.5 && bmi < 25) {
                        category = "Norma";
                        resultLabel.setForeground(Color.GREEN); // Norma
                    } else if (bmi >= 25 && bmi < 30) {
                        category = "Nadwaga";
                        resultLabel.setForeground(Color.YELLOW); // Nadwaga
                    } else {
                        category = "Otyłość";
                        resultLabel.setForeground(Color.RED); // Otyłość
                    }

                    // Wyświetlanie wyniku
                    resultLabel.setText(String.format("Wynik BMI: %.2f (%s)", bmi, category));

                } catch (NumberFormatException ex) {
                    // Obsługa błędu wprowadzania danych
                    JOptionPane.showMessageDialog(frame, "Proszę wprowadzić poprawne wartości liczbowe.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Wyświetlenie ramki
        frame.setVisible(true);
    }
}

