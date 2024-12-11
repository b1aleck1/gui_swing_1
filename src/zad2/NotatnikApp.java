package zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NotatnikApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NotatnikApp::createAndShowGUI); //(()->)
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                createAndShowGUI();
//            }
//        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Notatnik");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTextArea textArea = new JTextArea();
        frame.add(createScrollPane(textArea), BorderLayout.CENTER);
        frame.add(createToolBar(frame, textArea), BorderLayout.NORTH);
        //frame.setJMenuBar(createMenuBar(frame, textArea));

        frame.setVisible(true);
    }

    private static JScrollPane createScrollPane(JTextArea textArea) {
        return new JScrollPane(textArea);
    }

    private static JToolBar createToolBar(JFrame frame, JTextArea textArea) {
        JToolBar toolBar = new JToolBar();

        JButton newButton = new JButton("Nowy");
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        JButton openButton = new JButton("Otwórz");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile(frame, textArea);
            }
        });

        JButton saveButton = new JButton("Zapisz");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile(frame, textArea);
            }
        });

        JButton exitButton = new JButton("Zamknij");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        toolBar.add(newButton);
        toolBar.add(openButton);
        toolBar.add(saveButton);
        toolBar.add(exitButton);

        return toolBar;
    }
/*
    private static JMenuBar createMenuBar(JFrame frame, JTextArea textArea) {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Plik");

        JMenuItem newItem = new JMenuItem("Nowy");
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        JMenuItem openItem = new JMenuItem("Otwórz");
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile(frame, textArea);
            }
        });

        JMenuItem saveItem = new JMenuItem("Zapisz");
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile(frame, textArea);
            }
        });

        JMenuItem exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        return menuBar;
    }
*/
    private static void openFile(JFrame frame, JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, null);
            } catch (IOException ex) {
                showErrorDialog(frame, "Błąd podczas otwierania pliku");
            }
        }
    }

    private static void saveFile(JFrame frame, JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                textArea.write(writer);
            } catch (IOException ex) {
                showErrorDialog(frame, "Błąd podczas zapisywania pliku");
            }
        }
    }

    private static void showErrorDialog(JFrame frame, String message) {
        JOptionPane.showMessageDialog(frame, message, "Błąd", JOptionPane.ERROR_MESSAGE);
    }
}
