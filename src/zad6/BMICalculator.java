package zad6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> BMICalculator.createAndShowGUI());
    }
        private static void createAndShowGUI () {
            JFrame frame = new JFrame("Kalkulator BMI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(370, 200);
            frame.setLayout(new GridLayout(4, 2));

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (screenSize.width - frame.getWidth()) / 2;
            int y = (screenSize.height - frame.getHeight()) / 2;
            frame.setLocation(x, y);

            JLabel weightLabel = new JLabel("Waga (kg):");
            JTextField weightField = new JTextField();

            JLabel heightLabel = new JLabel("Wzrost (m):");
            JTextField heightField = new JTextField();

            JButton calculateButton = new JButton("Oblicz");
            JLabel resultLabel = new JLabel("Wynik BMI: ");

            frame.add(weightLabel);
            frame.add(weightField);
            frame.add(heightLabel);
            frame.add(heightField);
            frame.add(calculateButton);
            frame.add(resultLabel);


            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        double weight = Double.parseDouble(weightField.getText());
                        double height = Double.parseDouble(heightField.getText());


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

                        resultLabel.setText(String.format("Wynik BMI: %.2f (%s)", bmi, category));

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Proszę wprowadzić poprawne wartości liczbowe.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            frame.setVisible(true);
        }
}

