/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author taneli
 */
public class PeliTest {
    
    private Peli jokin = new Peli();
    
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void oikeinKortit() { 
        jokin.sekoitaPakka();
        boolean totuus = jokin.arvaus1(1, 9);    
        assertTrue(totuus);
    }
    
    @Test
    public void vaarinKortit() { 
        jokin.sekoitaPakka();
        boolean totuus = jokin.arvaus1(1, 7);    
        assertFalse(totuus);
    }
    
    @Test
    public void korttiLoytyy() {        
        jokin.sekoitaPakka();
        boolean valinta1 = jokin.tarkistaNumero(17);   
        boolean valinta2 = jokin.tarkistaNumero(0);   
        assertFalse(valinta1);
        assertFalse(valinta2);
    }
    
    @Test
    public void vuoroVaihtuu() { 
        jokin.sekoitaPakka();
        jokin.arvaus1(8, 16);
        assertTrue(jokin.getVuoro()==2);
    }
    
    @Test
    public void samatKortit() { 
        jokin.sekoitaPakka();
        boolean totuus = jokin.arvaus1(1, 1);  
        assertFalse(totuus);
    }
    
    @Test
    public void nimiOikein() {
        jokin.sekoitaPakka();
        jokin.setPelaaja1nimi("matti");
        assertTrue(jokin.getNimi1().equals("matti"));
    }
    
    @Test
    public void pariPoistuu() {
        jokin.sekoitaPakka();
        jokin.arvaus1(1, 9);
        assertTrue(jokin.korttejaYhteensa()==14);
    }
    
    @Test
    public void pelaaja1Saapisteen() {
        jokin.sekoitaPakka();
        jokin.arvaus1(2, 10);
        assertTrue(jokin.getPisteet(1)==1);
    }
    
    @Test
    public void pelaaja2Saapisteen() {
        jokin.sekoitaPakka();
        jokin.arvaus2(2, 10);
        assertTrue(jokin.getPisteet(2)==1);
    }

    @Test
    public void pariEipoistu() {
        jokin.sekoitaPakka();
        jokin.arvaus1(1, 2);
        assertTrue(jokin.korttejaYhteensa()==16);
    }
}

