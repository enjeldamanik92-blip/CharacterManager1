package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // 1. Siapkan DATA (Model)
        CharacterManager manager = new CharacterManager();
        manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 8));
        manager.addCharacter(new Character("Athena", CharacterType.WARRIOR, 12));
        manager.addCharacter(new Character("Legolas", CharacterType.ARCHER, 15));
        manager.addCharacter(new Character("Kage", CharacterType.ASSASSIN, 20));
        
        // 👉 LETAKKAN DI SINI untuk mengubah data / menambah karakter baru
        manager.addCharacter(new Character("Saitama", CharacterType.WARRIOR, 50));
        
        // Tambahan variasi level agar perbedaan visual terlihat
        manager.addCharacter(new Character("Gatotkaca", CharacterType.WARRIOR, 7)); // level tinggi
        manager.addCharacter(new Character("Morgana", CharacterType.MAGE, 1));      // level rendah

        // 2. Jalankan GUI di dalam Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager.getAllCharacters());
            window.setVisible(true);
        });
    }
}