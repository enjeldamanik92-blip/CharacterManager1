
package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private ArrayList<Character> characterList;

    public CharacterManager() {
        characterList = new ArrayList<>();
    }

    // BAGIAN A: Menambahkan karakter dan menolak nama duplikat
    public void addCharacter(Character character) {
        if (character == null) {
            System.out.println("Karakter tidak boleh null!");
            return;
        }

        if (findByName(character.getName()) != null) {
            System.out.println("Gagal: nama karakter sudah ada!");
            return;
        }

        characterList.add(character);

        System.out.println("Karakter berhasil ditambahkan: "
                + character.getName());
    }

    // BAGIAN A: Mencari karakter berdasarkan nama
    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character c : characterList) {
            if (c.getName() != null
                    && c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }

        return null;
    }

    // BAGIAN A: Menghapus karakter
    public void removeCharacter(String name) {
        Character target = findByName(name);

        if (target != null) {
            characterList.remove(target);
            System.out.println("Karakter berhasil dihapus: " + name);
        } else {
            System.out.println("Karakter tidak ditemukan: " + name);
        }
    }

    // BAGIAN A: Menghitung jumlah karakter
    public int getTotalCharacters() {
        return characterList.size();
    }

    // BAGIAN A: Mengembalikan salinan ArrayList
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characterList);
    }

    // BAGIAN B: Menghitung rata-rata level
    public double getAverageLevel() {
        if (characterList.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character c : characterList) {
            totalLevel += c.getLevel();
        }

        return (double) totalLevel / characterList.size();
    }

    // BAGIAN B: Mencari karakter berdasarkan tipe
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character c : characterList) {
            if (c.getType() == type) {
                result.add(c);
            }
        }

        return result;
    }

    /**
     * BAGIAN C:
     * Mencari karakter dengan attack power tertinggi.
     * Mengembalikan null jika daftar karakter kosong.
     */
    public Character findStrongest() {
        if (characterList.isEmpty()) {
            return null;
        }

        Character strongest = characterList.get(0);

        for (Character c : characterList) {
            if (c.getAttackPower() > strongest.getAttackPower()) {
                strongest = c;
            }
        }

        return strongest;
    }
}
