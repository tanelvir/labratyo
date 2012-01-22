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
        harjoitus jokin = new harjoitus();
        boolean totuus = jokin.parienTarkastus(12, 12);    
        assertTrue(totuus==true);
    }
    
    @Test
    public void korttiLoytyy() { 
        harjoitus jokin = new harjoitus();
        boolean valinta1 = jokin.tarkistaNumero(17);   
        boolean valinta2 = jokin.tarkistaNumero(0);   
        assertTrue(valinta1==false);
        assertTrue(valinta2==false);
    }
    
    @Test
    public void vainKaksikorttia() { 
        harjoitus jokin = new harjoitus();
        boolean valinta1 = jokin.tarkistaNumero(12);  
        boolean valinta2 = jokin.tarkistaNumero(13);
        boolean valinta3 = jokin.tarkistaNumero(13);
        assertTrue(jokin.getKerta()==0);
    }
    
    @Test
    public void eriKortit() { 
        harjoitus jokin = new harjoitus();
        boolean valinta1 = jokin.tarkistaNumero(12);  
        boolean valinta2 = jokin.tarkistaNumero(13);  
        assertFalse(valinta1==valinta2);
    }
}
