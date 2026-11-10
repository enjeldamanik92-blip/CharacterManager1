package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {

    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    private static int totalCharacterCreated = 0;

    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        setLevel(level);
        this.mana = 50;
        totalCharacterCreated++;
    }

    public Character(String name, CharacterType type, int level,
                       int hitPoints, int attackPower, int mana) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = mana;
        totalCharacterCreated++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal 1");
        }

        this.level = level;
        this.hitPoints = 100 + (level * 10);
        this.attackPower = 10 + (level * 5);
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = Math.max(0, hitPoints);
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attackPower=" + attackPower +
                ", mana=" + mana +
                '}';
    }

    // ===== equals(): membandingkan ISI DATA, bukan alamat memori =====
    // Dua Character dianggap "sama" jika NAMA-nya identik (case-sensitive)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;                    // optimasi: jika memang object yang sama persis
        }

        if (!(obj instanceof Character)) {
            return false;                   // jika bukan Character, pasti tidak sama
        }

        Character other = (Character) obj;  // casting aman karena sudah dicek instanceof
        return Objects.equals(this.name, other.name); // bandingkan isi atribut name secara aman
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}