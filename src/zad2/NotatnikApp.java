package zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NotatnikApp {
    public static void main(String[] args) {
        // Tworzenie głównego okna aplikacji
        JFrame frame = new JFrame("Notatnik");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Obszar tekstowy
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Pasek narzędzi (toolbar)
        JToolBar toolBar = new JToolBar();
        JButton newButton = new JButton("Nowy");
        JButton openButton = new JButton("Otwórz");
        JButton saveButton = new JButton("Zapisz");
        JButton exitButton = new JButton("Zamknij");

        toolBar.add(newButton);
        toolBar.add(openButton);
        toolBar.add(saveButton);
        toolBar.add(exitButton);
        frame.add(toolBar, BorderLayout.NORTH);

        // Akcja "Nowy"
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        // Akcja "Otwórz"
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        textArea.read(reader, null);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Błąd podczas otwierania pliku", "Błąd", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Akcja "Zapisz"
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showSaveDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        textArea.write(writer);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Błąd podczas zapisywania pliku", "Błąd", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Akcja "Zamknij"
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // Pasek menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Plik");

        JMenuItem newItem = new JMenuItem("Nowy");
        JMenuItem openItem = new JMenuItem("Otwórz");
        JMenuItem saveItem = new JMenuItem("Zapisz");
        JMenuItem exitItem = new JMenuItem("Zamknij");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        // Połączenie akcji z menu
        newItem.addActionListener(e -> newButton.doClick());
        openItem.addActionListener(e -> openButton.doClick());
        saveItem.addActionListener(e -> saveButton.doClick());
        exitItem.addActionListener(e -> exitButton.doClick());

        // Wyświetlenie okna
        frame.setVisible(true);
    }
}
