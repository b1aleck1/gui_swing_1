package zad4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverter extends JFrame implements ActionListener {
    private JComboBox<String> inputUnitComboBox, outputUnitComboBox;
    private JTextField inputValueField, outputValueField;
    private JButton convertButton;

    public UnitConverter() {
        setTitle("Konwerter Jednostek");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);

        String[] lengthUnits = {"Metry", "Kilometry", "Centymetry", "Milimetry"};

        JPanel inputPanel = new JPanel();
        inputPanel.setBounds(50, 20, 250, 60);
        inputPanel.setLayout(null);

        JLabel inputLabel = new JLabel("Z:");
        inputLabel.setBounds(10, 10, 20, 25);
        inputPanel.add(inputLabel);

        inputUnitComboBox = new JComboBox<>(lengthUnits);
        inputUnitComboBox.setBounds(30, 10, 100, 25);
        inputPanel.add(inputUnitComboBox);

        inputValueField = new JTextField();
        inputValueField.setBounds(140, 10, 100, 25);
        inputPanel.add(inputValueField);

        add(inputPanel);

        JPanel outputPanel = new JPanel();
        outputPanel.setBounds(50, 100, 250, 60);
        outputPanel.setLayout(null);

        JLabel outputLabel = new JLabel("Na:");
        outputLabel.setBounds(10, 10, 20, 25);
        outputPanel.add(outputLabel);

        outputUnitComboBox = new JComboBox<>(lengthUnits);
        outputUnitComboBox.setBounds(30, 10, 100, 25);
        outputPanel.add(outputUnitComboBox);

        outputValueField = new JTextField();
        outputValueField.setBounds(140, 10, 100, 25);
        outputPanel.add(outputValueField);

        add(outputPanel);

        convertButton = new JButton("Przelicz");
        convertButton.setBounds(50, 180, 250, 25);
        convertButton.addActionListener(this);
        add(convertButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double inputValue = Double.parseDouble(inputValueField.getText());
            String inputUnit = (String) inputUnitComboBox.getSelectedItem();
            String outputUnit = (String) outputUnitComboBox.getSelectedItem();

            double outputValue = convertUnits(inputValue, inputUnit, outputUnit);
            outputValueField.setText(String.format("%.2f", outputValue));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Proszę wprowadzić prawidłową liczbę.");
        }
    }

    private double convertUnits(double value, String fromUnit, String toUnit) {
        double meters = 0;
        switch (fromUnit) {
            case "Metry":
                meters = value;
                break;
            case "Kilometry":
                meters = value * 1000;
                break;
            case "Centymetry":
                meters = value / 100;
                break;
            case "Milimetry":
                meters = value / 1000;
                break;
        }

        switch (toUnit) {
            case "Metry":
                return meters;
            case "Kilometry":
                return meters / 1000;
            case "Centymetry":
                return meters * 100;
            case "Milimetry":
                return meters * 1000;
            default:
                return meters;
        }
    }

    public static void main(String[] args) {
        new UnitConverter();
    }
}

