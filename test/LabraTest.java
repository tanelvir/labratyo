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
    private KorttiPakka kortti;
    
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
        kortti = new KorttiPakka();
        kortti.sekoitus();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void oikeinKortit() {
        pelaaja.arvausKerta(1, 9, kortti);    
        assertTrue(pelaaja.getPisteet()==1);
    }
    
    @Test
    public void vaarinKortit() { 
        pelaaja.arvausKerta(1, 7, kortti);    
        assertFalse(pelaaja.getPisteet()==0);
    }
    
    @Test
    public void korttiLoytyy() {
        boolean valinta1 = kortti.etsiKortti(17);   
        boolean valinta2 = kortti.etsiKortti(0);   
        assertFalse(valinta1);
        assertFalse(valinta2);
    }
    
    @Test
    public void samatKortit() { 
        pelaaja.arvausKerta(1, 1, kortti);  
        assertFalse(kortti.korttejaYhteensa()==14);
    }
    
    @Test
    public void kertaVaihtuu() {
        pelaaja.ekaKerta(2);
        assertTrue(pelaaja.getKerta()==2);
    }
    
    @Test
    public void pariPoistuu() {
        pelaaja.arvausKerta(1, 9, kortti);
        assertTrue(kortti.korttejaYhteensa()==14);
    }
    
    @Test
    public void pelaaja1Saapisteen() {
        pelaaja.arvausKerta(3, 11, kortti);
        assertTrue(pelaaja.getPisteet()==1);
    }
    
    @Test
    public void samastaParistaeiPisteita() {
        pelaaja.arvausKerta(3, 11, kortti);
        pelaaja.arvausKerta(3, 11, kortti);
        assertFalse(pelaaja.getPisteet()==2);
    }

    @Test
    public void pariEipoistu() {
        pelaaja.arvausKerta(1, 2, kortti);
        assertTrue(kortti.korttejaYhteensa()==16);
    }
}

