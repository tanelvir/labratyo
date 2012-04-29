/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import labra.KorttiPakka; 
import labra.Kortti;
import labra.logiikka;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author taneli
 */
public class LogiikkaTest {
    logiikka peli = new logiikka(2, "lolli", "poppi");
    KorttiPakka pakka;
    
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
        peli.aloitaharjoitusPeli();
        pakka = new KorttiPakka();
        pakka.sekoitusEiArvottu();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void oikeinKortit() {
        System.out.println(peli);
        peli.arvausKerta(2, 10, peli.getKP(), peli.getPelaaja1());    
        assertTrue(peli.getPelaaja1().getPisteet()==1);
    }
    
    @Test
    public void nimiOikein() {
        assertTrue(peli.getPelaaja1().getNimi()=="lolli");
        assertTrue(peli.getPelaaja2().getNimi()=="poppi");
    }
    
    @Test
    public void vaarinKortit() { 
        peli.arvausKerta(1, 7, peli.getKP(), peli.getPelaaja1());    
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
    public void samatKortitEiSaaOlla() { 
        peli.arvausKerta(1, 1, peli.getKP(), peli.getPelaaja1());  
        assertFalse(peli.getPelaaja1().getPisteet()==1);
    }
    
    @Test
    public void toiselleVuoro() {
        peli.pelaajanVastaus(1);
        peli.pelaajanVastaus(9);
        peli.pelaajanVastaus(2);
        peli.pelaajanVastaus(10);
        assertTrue(peli.getPelaaja1().getPisteet()==1);
        assertTrue(peli.getPelaaja2().getPisteet()==1);
    }
    
    @Test
    public void kertaVaihtuu() {
        peli.getPelaaja1().ekaKertaToinen(1);
        assertTrue(peli.getPelaaja1().getKerta()==2);
    }
    
    @Test
    public void pariPoistuu() {
        peli.arvausKerta(1, 9, peli.getKP(), peli.getPelaaja1());
        assertTrue(peli.getKP().korttejaYhteensa()==14);
    }
    
    @Test
    public void pelaajaSaapisteen() {
        peli.arvausKerta(1, 9, peli.getKP(), peli.getPelaaja1());
        assertTrue(peli.getPelaaja1().getPisteet()==1);
    }
    
    @Test
    public void samastaParistaeiSaaPisteita() {
        peli.getPelaaja1().arvausKertaToinen(2, 10, pakka);
        peli.getPelaaja1().arvausKertaToinen(2, 10, pakka);   
        assertFalse(peli.getPelaaja1().getPisteet()==2);
    }

    @Test
    public void pariEipoistu() {
        peli.getPelaaja1().arvausKertaToinen(1, 2, peli.getKP());
        assertTrue(peli.getKP().korttejaYhteensa()==16);
    }
}

