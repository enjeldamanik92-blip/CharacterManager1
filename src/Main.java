import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Character Manager v0.1 — Demo AP3 ===");
        System.out.println();

        // 1. Tiga Karakter Utama (Bagian A)
        Character char1 = new Character("Arthur", CharacterType.WARRIOR, 1);
        Character char2 = new Character("Merlin", CharacterType.MAGE, 5);
        Character char3 = new Character("Robin", CharacterType.ARCHER, 3);

        System.out.println("--- Daftar 3 Karakter Awal ---");
        System.out.println(char1);
        System.out.println(char2);
        System.out.println(char3);
        System.out.println();

        // Demo Level Up
        System.out.println("--- Demo Level Up Arthur ---");
        System.out.println("Sebelum: " + char1);
        char1.setLevel(2);
        System.out.println("Sesudah (Level 2): " + char1);
        System.out.println();

        // 2. Ekstensi Fitur Mandiri (Bagian B)
        System.out.println("--- Demo Fitur Mandiri (Mana & isAlive) ---");
        Character hero = new Character("Lancelot", CharacterType.WARRIOR, 3);
        
        // Menguji setMana()
        hero.setMana(100);
        System.out.println("Detail Karakter Baru: " + hero);
        
        // Menguji isAlive()
        System.out.println("Apakah '" + hero.getName() + "' masih hidup? " + hero.isAlive());
    }
}