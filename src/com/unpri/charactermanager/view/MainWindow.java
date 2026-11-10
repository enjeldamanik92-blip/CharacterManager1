package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;
    private JLabel statsLabel;

    public MainWindow(ArrayList<Character> characterList) {
        super("Character Manager v0.3");
        this.characterList = characterList;

        initComponents();

        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

        // Header Title sesuai standar modul
        JLabel titleLabel = new JLabel("=== Daftar Karakter Game ===", JLabel.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);

        // Panel Utama dengan BoxLayout untuk data dinamis perulangan
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        double totalLevel = 0;
        for (Character c : characterList) {
            String info = String.format("• %s | Tipe: %s | Level: %d | HP: %d",
                    c.getName(), c.getType(), c.getLevel(), c.getHitPoints());
            
            JLabel charLabel = new JLabel(info);
            charLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
            mainPanel.add(charLabel);

            totalLevel += c.getLevel();
        }

        // Bungkus dengan ScrollPane agar rapi
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Footer Mini-Challenge: Statistik Rata-rata Level yang dinamis
        double avgLevel = characterList.isEmpty() ? 0.0 : totalLevel / characterList.size();
        statsLabel = new JLabel(String.format("Rata-rata Level: %.2f", avgLevel), JLabel.CENTER);
        statsLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(statsLabel, BorderLayout.SOUTH);
    }
}