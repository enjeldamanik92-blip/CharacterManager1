package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import com.unpri.charactermanager.model.CharacterType;

public final class AppTheme {

    // Palet warna
    public static final Color BG_MAIN =
            Color.decode("#13131f");

    public static final Color TEXT_MAIN =
            Color.decode("#dfe6e9");

    public static final Color TEXT_LIGHT =
            Color.WHITE;

    public static final Color GOLD =
            Color.decode("#fdcb6e");

    // AP16: warna untuk bar status dan teks sekunder
    public static final Color BG_STATUS =
            Color.decode("#0d0d1a");

    public static final Color TEXT_MUTED =
            Color.decode("#9d9dbf");


    // Font
    public static final Font FONT_TITLE =
            new Font("SansSerif", Font.BOLD, 22);

    public static final Font FONT_BODY =
            new Font("SansSerif", Font.PLAIN, 14);

    public static final Font FONT_MONO =
            new Font("Monospaced", Font.PLAIN, 13);


    // Border
    public static final Border CARD_BORDER =
            BorderFactory.createEmptyBorder(8, 12, 8, 12);


    private AppTheme() {
    }


    // Warna berdasarkan tipe karakter
    public static Color colorFor(CharacterType type) {

        switch (type) {

            case WARRIOR:
                return Color.decode("#d63031");

            case MAGE:
                return Color.decode("#0984e3");

            case ARCHER:
                return Color.decode("#00b894");

            default:
                return Color.GRAY;
        }
    }


    // Deskripsi berdasarkan tipe karakter
    public static String describe(CharacterType type) {

        switch (type) {

            case WARRIOR:
                return "Warrior: jarak dekat, HP tinggi";

            case MAGE:
                return "Mage: serangan sihir, HP rendah";

            case ARCHER:
                return "Archer: jarak jauh, seimbang";

            default:
                return "Role belum terdaftar";
        }
    }
}