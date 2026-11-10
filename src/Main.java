
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Character Manager TP5 ===\n");

        // =====================================
        // BAGIAN AWAL: IMPLEMENTASI CHARACTER
        // =====================================

        Character hero = new Character(
                "Arjuna", CharacterType.WARRIOR, 5);

        Character wizard = new Character(
                "Merlin", CharacterType.MAGE, 3);

        Character scout = new Character(
                "Athena", CharacterType.ARCHER, 4);

        System.out.println("=== Daftar Karakter ===");
        System.out.println(hero);
        System.out.println(wizard);
        System.out.println(scout);

        // Demo Level Up
        System.out.println("\n=== Demo Level Up ===");
        System.out.println(">> " + hero.getName() + " level up!");

        hero.setLevel(hero.getLevel() + 1);

        System.out.println("After level up: " + hero);

        // Informasi Hero
        System.out.println("\n=== Informasi Hero ===");
        System.out.println("Nama: " + hero.getName());
        System.out.println("Jenis: " + hero.getType());
        System.out.println("Level: " + hero.getLevel());
        System.out.println("HP: " + hero.getHitPoints());
        System.out.println("Attack: " + hero.getAttackPower());

        // Mini-Challenge Mana dan isAlive
        System.out.println("\n=== Mini-Challenge: Mana dan isAlive ===");

        Character healer = new Character(
                "Luna", CharacterType.HEALER, 2);

        healer.setMana(80);

        System.out.println("Karakter baru: " + healer);
        System.out.println("Mana Luna: " + healer.getMana());
        System.out.println("Apakah Luna masih hidup? "
                + healer.isAlive());

        healer.setHitPoints(0);

        System.out.println("HP Luna setelah berubah: "
                + healer.getHitPoints());

        System.out.println("Apakah Luna masih hidup? "
                + healer.isAlive());

        System.out.println("\nTotal karakter dibuat: "
                + Character.getTotalCharacterCreated());


        // =====================================
        // BAGIAN A: CRUD CHARACTER MANAGER
        // =====================================

        System.out.println("\n=== BAGIAN A: CRUD TEST ===");

        CharacterManager manager = new CharacterManager();

        manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 5));

        manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 3));

        manager.addCharacter(
                new Character("Athena", CharacterType.ARCHER, 4));

        // Menguji nama duplikat
        System.out.println("\n--- Pengujian Duplikat ---");

        manager.addCharacter(
                new Character("Arjuna", CharacterType.HEALER, 1));

        // Menghitung total karakter
        System.out.println("\nTotal karakter: "
                + manager.getTotalCharacters());

        // Mencari karakter
        System.out.println("\n--- Pencarian ---");

        Character hasil = manager.findByName("Merlin");

        System.out.println(hasil != null
                ? "Ditemukan: " + hasil
                : "Merlin tidak ditemukan");

        Character tidakAda = manager.findByName("Zeus");

        System.out.println(tidakAda != null
                ? "Ditemukan: " + tidakAda
                : "Zeus tidak ditemukan");

        // Menghapus karakter
        System.out.println("\n--- Penghapusan ---");

        manager.removeCharacter("Athena");

        System.out.println("Total setelah hapus: "
                + manager.getTotalCharacters());

        // Menampilkan karakter tersisa
        System.out.println("\n--- Daftar Karakter Tersisa ---");

        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }


        // =====================================
        // BAGIAN A: OBJECT REFERENCE
        // =====================================

        System.out.println("\n=== Eksperimen Object Reference ===");

        Character asli = manager.findByName("Arjuna");

        Character duplikatReferensi = asli;

        System.out.println("Level Arjuna sebelum: "
                + asli.getLevel());

        duplikatReferensi.setLevel(99);

        System.out.println("Level Arjuna sesudah: "
                + asli.getLevel());

        System.out.println("asli == duplikatReferensi? "
                + (asli == duplikatReferensi));


        // =====================================
        // BAGIAN A: DEFENSIVE COPY
        // =====================================

        System.out.println("\n=== Eksperimen Defensive Copy ===");

        java.util.ArrayList<Character> salinanList =
                manager.getAllCharacters();

        salinanList.add(
                new Character("Hantu", CharacterType.MAGE, 1));

        System.out.println("Total di manager asli: "
                + manager.getTotalCharacters());

        System.out.println("Total di salinan list: "
                + salinanList.size());


        // =====================================
        // BAGIAN B: MINI-CHALLENGE
        // =====================================

        // Menghitung rata-rata level
        System.out.println("\n=== BAGIAN B: Rata-rata Level ===");

        System.out.println("Rata-rata level: "
                + manager.getAverageLevel());

        // Mencari karakter berdasarkan tipe
        System.out.println("\n--- Pencarian Berdasarkan Tipe ---");

        System.out.println("Karakter bertipe WARRIOR:");

        for (Character c : manager.findByType(CharacterType.WARRIOR)) {
            System.out.println(c);
        }

        System.out.println("\nKarakter bertipe MAGE:");

        for (Character c : manager.findByType(CharacterType.MAGE)) {
            System.out.println(c);
        }


        // =====================================
        // BAGIAN C: FITUR ANALITIK SENDIRI
        // =====================================

        System.out.println("\n=== BAGIAN C: Karakter Terkuat ===");

        Character strongest = manager.findStrongest();

        if (strongest != null) {
            System.out.println("Karakter terkuat: " + strongest);
        } else {
            System.out.println("Belum ada karakter.");
        }

    }
}