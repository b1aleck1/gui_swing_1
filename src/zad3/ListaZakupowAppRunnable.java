package zad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaZakupowAppRunnable {
    private JFrame frame;
    private JTextField textField;
    private DefaultListModel<String> listModel;
    private JList<String> list;

    public ListaZakupowAppRunnable() {
        // Tworzymy główne okno aplikacji
        frame = new JFrame("Lista Zakupów");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Tworzymy pole tekstowe do wprowadzania nazw produktów
        textField = new JTextField();

        // Tworzymy przycisk do dodawania produktów
        JButton addButton = new JButton("Dodaj");

        // Tworzymy model listy (będzie to dynamicznie zmieniająca się lista produktów)
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);

        // Ustawiamy listę w oknie przewijania
        JScrollPane listScrollPane = new JScrollPane(list);

        // Dodajemy komponenty do okna
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(textField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(listScrollPane, BorderLayout.CENTER);

        // Akcja dodania produktu do listy
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String product = textField.getText().trim();
                if (!product.isEmpty()) {
                    listModel.addElement(product);
                    textField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Proszę wprowadzić nazwę produktu!", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Akcja usunięcia produktu z listy po kliknięciu na niego
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int selectedIndex = list.locationToIndex(evt.getPoint());
                    if (selectedIndex != -1) {
                        listModel.remove(selectedIndex);
                    }
                }
            }
        });

        // Ustawienie widoczności okna
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Uruchamiamy aplikację w wątku GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaZakupowAppRunnable();
            }
        });
    }
}

