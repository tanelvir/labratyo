/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import labra.KorttiPakka;
import labra.Kortti;
import labra.Pelaaja;
import labra.logiikka;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author taneli
 */
public class LogiikkaTest {
    logiikka peli = new logiikka();
    KorttiPakka pakka;
    Kortti[] taulu;
    
    
    /**
     * 
     * sekoitetaan pakkaa
     * @return
     * 
     */
    public LogiikkaTest() {
    }
      

    @BeforeClass
    public static void setUpClass() throws Exception {  
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        peli.aloitaHarjoituspeli();
        pakka = new KorttiPakka();
        taulu = pakka.sekoitusEiArvottuTaulu();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void oikeinKortit() {
        System.out.println(peli);
        peli.Arvaus(1, 1, taulu);    
        assertTrue(peli.getPelaaja1().getPisteet()==1);
    }
    
    @Test
    public void vaarinKortit() { 
        peli.Arvaus(1, 7, taulu);    
        assertTrue(peli.getPelaaja1().getPisteet()==0);
    }
    
    @Test
    public void korttiLoytyy() {
        boolean valinta1 = peli.getKP().etsiKortti(17);   
        boolean valinta2 = peli.getKP().etsiKortti(4);   
        assertFalse(valinta1);
        assertTrue(valinta2);
    }
    
    @Test
    public void samatKortit() { 
        peli.Arvaus(1, 1, taulu);  
        assertFalse(taulu.length==14);
    }
    
    public void toiselleVuoro() {
        peli.Arvaus(1, 7, taulu);
        peli.Arvaus(2, 8, taulu);
        assertTrue(peli.getPelaaja1().getPisteet()==1);
        assertTrue(peli.getPelaaja2().getPisteet()==1);
    }
    
    @Test
    public void kertaVaihtuu() {
        peli.getPelaaja1().ekaKerta(1);
        assertTrue(peli.getPelaaja1().getKerta()==2);
    }
    
    @Test
    public void pariPoistuu() {
        peli.getPelaaja1().arvausKerta(1, 9, peli.getKP());
        assertTrue(peli.getKP().korttejaYhteensa()==14);
    }
    
    @Test
    public void pelaajaSaapisteen() {
        peli.getPelaaja1().arvausKerta(4, 12, peli.getKP());
        assertTrue(peli.getPelaaja1().getPisteet()==1);
    }
    
    @Test
    public void arvontaToimii() {
        peli.Arvaus(1, 9, taulu);
        peli.getPelaaja1().arvausKerta(2, 10, pakka);
        assertTrue(peli.getPelaaja1().getPisteet()==1);
    }
    
    @Test
    public void samastaParistaeiSaaPisteita() {
        peli.getPelaaja1().arvausKerta(2, 10, pakka);
        peli.getPelaaja1().arvausKerta(2, 10, pakka);
        assertFalse(peli.getPelaaja1().getPisteet()==2);
    }

    @Test
    public void pariEipoistu() {
        peli.getPelaaja1().arvausKerta(1, 2, peli.getKP());
        assertTrue(peli.getKP().korttejaYhteensa()==16);
    }
}

