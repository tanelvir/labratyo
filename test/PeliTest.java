/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import labra.Pelaaja;
import labra.Kortti;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author taneli
 */
public class PeliTest {
    private Pelaaja pelaaja;
    private Kortti kortti;
    
    /**
     * 
     * sekoitetaan pakkaa
     * @return
     * 
     */
    public PeliTest() {
    }
      

    @BeforeClass
    public static void setUpClass() throws Exception {       
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("joku");
        kortti = new Kortti();
        kortti.sekoitaPakka();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void oikeinKortit() {
        boolean totuus = pelaaja.arvausKerta(1, 9);    
        assertTrue(totuus);
    }
    
    @Test
    public void vaarinKortit() { 
        boolean totuus = pelaaja.arvausKerta(1, 7);    
        assertFalse(totuus);
    }
    
    @Test
    public void korttiLoytyy() {
        boolean valinta1 = kortti.tarkistaNumero(17);   
        boolean valinta2 = kortti.tarkistaNumero(0);   
        assertFalse(valinta1);
        assertFalse(valinta2);
    }
    
    @Test
    public void vuoroVaihtuu() { 
        pelaaja.ekaKerta(1);
        pelaaja.ekaKerta(2);
        assertFalse(pelaaja.getVuoro()==2);
    }
    
    @Test
    public void samatKortit() { 
        boolean totuus = pelaaja.arvausKerta(1, 1);  
        assertFalse(totuus);
    }
    
    @Test
    public void kertaVaihtuu() {
        pelaaja.ekaKerta(2);
        assertTrue(pelaaja.getKerta()==2);
    }
    
    @Test
    public void pariPoistuu() {
        pelaaja.arvausKerta(1, 9);
        assertTrue(pelaaja.korttienLkm()==14);
    }
    
    @Test
    public void pelaaja1Saapisteen() {
        pelaaja.arvausKerta(3, 11);
        assertTrue(pelaaja.getPisteet()==1);
    }
    
    @Test
    public void samastaParistaeiPisteita() {
        pelaaja.arvausKerta(3, 11);
        pelaaja.arvausKerta(3, 11);
        assertFalse(pelaaja.getPisteet()==2);
    }

    @Test
    public void pariEipoistu() {
        pelaaja.arvausKerta(1, 2);
        assertTrue(pelaaja.korttienLkm()==16);
    }
}

