package labra;


import labra.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * Tämän luokan tarkoituksena on luoda pelaaja, joka voi valita kortin
 * ja jolla on oma pistetili. Kun pelataan kaksinpeliä luodaan 2 pelaajaa. 
 * Täydennyksiä on vielä tulossa.
 *
 * @author tanelvir
 */

    
public class Pelaaja {
    
    String nimi;
    int pisteet;
    int kerta;
    int vuoro = 1;
    int Valinta1;
    int Valinta2;
    
    
    /**
     * 
     * Luodaan pelaaja, joka saa tietyt kortit (huom! nyt puhutaan vain yksinpelistä)
     * 
     * @param String nimi;
     * 
     */
    
    public Pelaaja(String nimesi) {
        nimi = nimesi;
        pisteet = 0;
        kerta = 1;
    }
    
    
    /**
     * Palautetaan pelaajan nimi.
     * 
     * @return nimi
     */
    
    public String getNimi() {
        return nimi;
    }
    
    /**     
     * 
     * Ensimmäinen kerta kun arvataan. Syötetään pelaajan valinta. Kerta kuluu.
     * 
     * @param pelaajan vastaus;
     */
    
    
    public void ekaKerta(int valinta) {
        Valinta1 = valinta;
        vaihdaKerta();
    }
    
    /**     
     * 
     * Toinen kerta kun arvataan. Syötetään pelaajan valinta.
     * 
     * @param pelaajan vastaus;
     */
    
    
    public void tokakerta(int valinta) {
        Valinta2 = valinta;
    }
    
    /**
     * Pelaajan ensimmäinen valitsema kortti.
     * 
     * @return pelaajan ensimmäinen valinta 
     */
    
    public int getValinta1() {
        return Valinta1;
    }
        
    /**
     * Pelaajan toinen valitsema kortti.
     * 
     * @return pelaajan toinen valinta 
     */
    
    public int getValinta2() {
        return Valinta2;
    }
    
    /**
     * On aika arvata. Katsotaan onko numeroiden takan samat symbolit. Ilmoitus tulostetaan.
     * 
     * @param valinta1
     
     * @param valinta2
     * 
     * @param peli
     
     * @return KorttiPakka kortteineen.
     */
    
    public KorttiPakka arvausKerta(int valinta1, int valinta2, KorttiPakka peli) {
      while (true) {  
        if (peli.getKortti(valinta1).getKuva().equals(peli.getKortti(valinta2).getKuva())) {
            pisteet++;
            vaihdaKerta();
            peli.poista(valinta1, valinta2);
            System.out.println(ilmoitus(true));
            return peli;
        }
        else {
            vaihdaKerta();
            System.out.println(ilmoitus(false));
            return peli;
        }
      }
    }
    
    /**
     * Ilmoitetaan saiko pelaaja oikein vai ei.
     * 
     * @param totta vai ei? (true vai false)
     * 
     * @return Ilmoitus tulostettuna syöttövirtaan.
     */
    
    public String ilmoitus(boolean totta) {
        if (totta) {
            return "Onneksi olkoon " + nimi + "! sait pisteen.";
        }
        else return "Valitettavasti " + nimi + " et löytänyt paria :(";
    }
    
    /**
     * 
     * @return pelaajan pisteet
     */
    
    
    public int getPisteet() {
        return pisteet; 
    }
    
    /**
     * 
     * @return tämänhetkinen kerta joka on menossa
     */
    
    public int getKerta() {
        return kerta;
    }
    
    /**
     * Tässä vaihdetaan kerta kun vuoroja on kulunut kolme. Boolean systeemi voisi olla järkevämpi. 
     * 
     */
    
    
    public void vaihdaKerta() {      
        if (kerta%2==0) {     
            kerta=1;
        }
        else kerta++;
    }
    
}
