package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    private static final int HIGH_LEVEL_THRESHOLD = 5;

    public MainWindow(List<Character> characters) {
        initComponents(characters);
    }

    private void initComponents(List<Character> characters) {
        setTitle("Character Manager v0.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(420, 300));
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(AppTheme.BG_MAIN); // Menggunakan AppTheme
        contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titleLabel = new JLabel("Daftar Karakter (" + characters.size() + ")");
        titleLabel.setFont(AppTheme.FONT_TITLE);     // Menggunakan AppTheme
        titleLabel.setForeground(AppTheme.TEXT_MAIN); // Menggunakan AppTheme
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(titleLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        for (Character c : characters) {
            JLabel card = createCharacterLabel(c);
            contentPanel.add(card);
            contentPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        }

        add(contentPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private JLabel createCharacterLabel(Character c) {
        String cardText = String.format(" %s | %s | Lv.%d | HP:%d | ATK:%d ",
                c.getName(),
                c.getType(),
                c.getLevel(),
                c.getHitPoints(),
                c.getAttackPower()
        );

        JLabel label = new JLabel(cardText);
        label.setFont(AppTheme.FONT_BODY);          // Menggunakan AppTheme
        label.setOpaque(true);
        label.setBackground(AppTheme.colorFor(c.getType())); // Menggunakan AppTheme
        label.setBorder(AppTheme.CARD_BORDER);      // Menggunakan AppTheme
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setToolTipText(AppTheme.describe(c.getType()));

        // Mini-Challenge: Logika Highlight Level Tinggi di View
        if (c.getLevel() >= HIGH_LEVEL_THRESHOLD) {
            label.setForeground(AppTheme.GOLD);
            label.setFont(label.getFont().deriveFont(Font.BOLD));
        } else {
            label.setForeground(AppTheme.TEXT_LIGHT);
            label.setFont(label.getFont().deriveFont(Font.PLAIN));
        }

        return label;
    }
}