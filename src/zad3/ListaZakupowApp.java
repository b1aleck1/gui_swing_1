package zad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaZakupowApp {
    public static void main(String[] args) {
        // Tworzenie głównego okna aplikacji
        JFrame frame = new JFrame("Lista Zakupów");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Panel główny
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Pole tekstowe do wprowadzania produktów
        JTextField productField = new JTextField();
        panel.add(productField, BorderLayout.NORTH);

        // Model listy zakupów
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> shoppingList = new JList<>(listModel);
        shoppingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(shoppingList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel z przyciskiem "Dodaj" i usuwania produktów
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Dodaj");
        JButton removeButton = new JButton("Usuń");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Akcja po kliknięciu przycisku "Dodaj"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String product = productField.getText().trim();
                if (!product.isEmpty()) {
                    listModel.addElement(product);
                    productField.setText("");
                }
            }
        });

        // Akcja po kliknięciu przycisku "Usuń"
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = shoppingList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        // Dodanie panelu do głównego okna
        frame.add(panel);
        frame.setVisible(true);
    }
}

