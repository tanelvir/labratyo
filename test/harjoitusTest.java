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
public class harjoitusTest {
    
    
    public harjoitusTest() {
    }
    
    harjoitus jokin = new harjoitus();

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
    public void samatKortit() { 
        boolean totuus = jokin.parienTarkastus(12, 12);    
        assertTrue(totuus);
    }
    
    @Test
    public void korttiLoytyy() {        
        boolean valinta1 = jokin.tarkistaNumero(17);   
        boolean valinta2 = jokin.tarkistaNumero(0);   
        assertFalse(valinta1);
        assertFalse(valinta2);
    }
    
    @Test
    public void vainKaksikorttia() { 
        boolean valinta1 = jokin.tarkistaNumero(12);  
        boolean valinta2 = jokin.tarkistaNumero(13);
        boolean valinta3 = jokin.tarkistaNumero(11);
        assertTrue(jokin.getKerta()==0);
    }
    
    @Test
    public void eriKortit() { 
        boolean valinta1 = jokin.tarkistaNumero(12);  
        boolean valinta2 = jokin.tarkistaNumero(13);  
        assertFalse(valinta1==valinta2);
    }
    
    @Test
    public void nimiOikein() {
        assertFalse(jokin.getNimi().equals(""));
    }
    
    @Test
    public void pariPoistuu() {
        boolean totuus = jokin.parienTarkastus(12, 12);
        assertTrue(jokin.korttejaYhteensa()==14);
    }
    
    @Test
    public void pelaajaSaapisteen() {
        boolean totuus = jokin.parienTarkastus(12, 12);
        assertTrua(jokin.getPisteet(pelaaja1)==1);
    }
    
    @Test
    public void pelaajanVuoro1() {
        assertTrue(jokin.getVuoro()==1);
    }
    
    @Test
    public void pelaajanVuoro2() {
        assertTrue(jokin.getVuoro()==2);
    }

    @Test
    public void korttiParikatoaa() {
        boolean totuus = jokin.parienTarkastus(12, 12);
        asserFalse(jokin.etsiKortit(12));
    }
}

