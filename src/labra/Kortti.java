package labra;

import java.util.*;
import labra.*;

/**
 *
 * Tämä on kortti, joka tuntee oman indeksinsä ja kuvansa.
 *
 *
 * @author tanelvir
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Kortti {

    ImageIcon kuva;
    int indeksi;

    /**
     *
     * Katsotaan mikä kuva vastaa mitäkin numeroa. Numerot ovat siis 1-16 ja
     * indeksit 1-8.
     *
     * @param syötetty luku;
     * @return lukua vastaava symboli.
     *
     */
    public Kortti(int numero) {
        if (numero == 1 || numero == 9) {
            kuva = new ImageIcon("omena.png");
            kuva.setDescription("omena");
            indeksi = 1;
        } else if (numero == 2 || numero == 10) {
            kuva = new ImageIcon("tuoli.png");
            kuva.setDescription("tuoli");
            indeksi = 2;
        } else if (numero == 3 || numero == 11) {
            kuva = new ImageIcon("hevonen.png");
            kuva.setDescription("hevonen");
            indeksi = 3;
        } else if (numero == 4 || numero == 12) {
            kuva = new ImageIcon("kivi.png");
            kuva.setDescription("kivi");
            indeksi = 4;
        } else if (numero == 5 || numero == 13) {
            kuva = new ImageIcon("kenka.png");
            kuva.setDescription("kenka");
            indeksi = 5;
        } else if (numero == 6 || numero == 14) {
            kuva = new ImageIcon("porkkana.png");
            kuva.setDescription("porkkana");
            indeksi = 6;
        } else if (numero == 7 || numero == 15) {
            kuva = new ImageIcon("koira.png");
            kuva.setDescription("koira");
            indeksi = 7;
        } else if (numero == 8 || numero == 16) {
            kuva = new ImageIcon("ovi.png");
            kuva.setDescription("ovi");
            indeksi = 8;
        } else {
            kuva = new ImageIcon("hellpari.jpg");
            kuva.setDescription("ERROR");
            indeksi = 0;
        }
    }

    public ImageIcon getKuva() {
        return this.kuva;
    }

    public int getIndeksi() {
        return this.indeksi;
    }

    /**
     * Pelkkä tulostus
     *
     *
     * @param valitsema numero
     * @return numeroa vastaava symboli
     */
    public String toString() {
        return kuva.getDescription();
    }
}
