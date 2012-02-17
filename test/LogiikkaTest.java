/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import labra.KorttiPakka;
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
        peli.aloitaPeli();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void oikeinKortit() {
        System.out.println(peli);
        peli.Arvaus(1, 9);    
        assertTrue(pelaaja.getPisteet()==1);
    }
    
    @Test
    public void vaarinKortit() { 
        pelaaja.arvausKerta(1, 7, peli);    
        assertTrue(pelaaja.getPisteet()==0);
    }
    
    @Test
    public void korttiLoytyy() {
        boolean valinta1 = peli.etsiKortti(17);   
        boolean valinta2 = peli.etsiKortti(4);   
        assertFalse(valinta1);
        assertTrue(valinta2);
    }
    
    @Test
    public void samatKortit() { 
        pelaaja.arvausKerta(1, 1, peli);  
        assertFalse(peli.korttejaYhteensa()==14);
    }
    
    @Test
    public void kertaVaihtuu() {
        pelaaja.ekaKerta(2);
        assertTrue(pelaaja.getKerta()==2);
    }
    
    @Test
    public void pariPoistuu() {
        pelaaja.arvausKerta(1, 9, peli);
        assertTrue(peli.korttejaYhteensa()==14);
    }
    
    @Test
    public void pelaajaSaapisteen() {
        pelaaja.arvausKerta(3, 11, peli);
        assertTrue(pelaaja.getPisteet()==1);
    }
    
    @Test
    public void samastaParistaeiSaaPisteita() {
        pelaaja.arvausKerta(2, 10, peli);
        pelaaja.arvausKerta(2, 10, peli);
        assertFalse(pelaaja.getPisteet()==2);
    }

    @Test
    public void pariEipoistu() {
        pelaaja.arvausKerta(1, 2, peli);
        assertTrue(peli.korttejaYhteensa()==16);
    }
}

