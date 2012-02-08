/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import labra.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author taneli
 */
public class LabraTest {
    private Pelaaja pelaaja;
    private KorttiPakka peli;
    
    /**
     * 
     * sekoitetaan pakkaa
     * @return
     * 
     */
    public LabraTest() {
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
        peli = new KorttiPakka();
        peli.sekoitus();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void oikeinKortit() {
        pelaaja.arvausKerta(1, 9, peli);    
        assertTrue(pelaaja.getPisteet()==1);
    }
    
    @Test
    public void vaarinKortit() { 
        pelaaja.arvausKerta(1, 7, peli);    
        assertFalse(pelaaja.getPisteet()==0);
    }
    
    @Test
    public void korttiLoytyy() {
        boolean valinta1 = peli.etsiKortti(17);   
        boolean valinta2 = peli.etsiKortti(0);   
        assertFalse(valinta1);
        assertFalse(valinta2);
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
    public void pelaaja1Saapisteen() {
        pelaaja.arvausKerta(3, 11, peli);
        assertTrue(pelaaja.getPisteet()==1);
    }
    
    @Test
    public void samastaParistaeiPisteita() {
        pelaaja.arvausKerta(3, 11, peli);
        pelaaja.arvausKerta(3, 11, peli);
        assertFalse(pelaaja.getPisteet()==2);
    }

    @Test
    public void pariEipoistu() {
        pelaaja.arvausKerta(1, 2, peli);
        assertTrue(peli.korttejaYhteensa()==16);
    }
}

