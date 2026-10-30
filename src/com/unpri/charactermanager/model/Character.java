package com.unpri.charactermanager.model;

/**
 * Class model Character yang menerapkan Encapsulation.
 */
public class Character {

    // ===== ATRIBUT PRIVATE =====
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int mana;
    private int attackPower;

    // ===== CONSTRUCTOR 1: Untuk Karakter Baru =====
    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.mana = calculateBaseMana();
        this.attackPower = calculateBaseAttack();
    }

    // ===== CONSTRUCTOR 2: Untuk Memuat Data dari Database =====
    public Character(int id, String name, CharacterType type, int level, int hitPoints, int mana, int attackPower) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.mana = mana;
        this.attackPower = attackPower;
    }

    // ===== GETTER & SETTER DENGAN VALIDASI =====
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CharacterType getType() { return type; }
    public void setType(CharacterType type) { this.type = type; }

    public int getLevel() { return level; }
    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal adalah 1");
        }
        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.mana = calculateBaseMana();
        this.attackPower = calculateBaseAttack();
    }

    public int getHitPoints() { return hitPoints; }

    public int getMana() { return mana; }
    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh negatif!");
        }
        this.mana = mana;
    }

    public int getAttackPower() { return attackPower; }

    // ===== METHOD BISNIS =====
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // ===== HELPER PRIVATE =====
    private int calculateBaseHP() {
        return 100 + (level * 10);
    }

    private int calculateBaseMana() {
        return 50 + (level * 5);
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);
    }

    // ===== TOSTRING() =====
    @Override
    public String toString() {
        return "Character{id=" + id +
               ", name='" + name + '\'' +
               ", type=" + type +
               ", level=" + level +
               ", hp=" + hitPoints +
               ", mana=" + mana +
               ", atk=" + attackPower + '}';
    }
}