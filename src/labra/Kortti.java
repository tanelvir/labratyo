package labra;


import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * Tämä on oikeastaan kortti(pakka). Eli siis tällä hetkellä tämä käsittää HashMapin, 
 * jossa on kortteja.
 * Teen todennäköisesti pakalle oman luokan kun pääsen graafiselle puolelle.
 *
 * @author tanelvir
 */
public class Kortti {
    
    public HashMap<Integer,String> kortit = new HashMap<Integer,String>();
    
    
    /**
     * 
     * sekoitetaan pakkaa, eli luodaan ns. koko pakka.
     * 
     * @return kortit, joissa on symbolit (kuvat):
     * 
     */
    
    public HashMap sekoitaPakka() {
        for (int i = 1; i <= 16; i++) {
            kortit.put(i,laitaKuva(i));
        }       
        return kortit;
    }
    
    /**
     * 
     * Tarkistetaan pelaajan syöttämä luku. Tämän metodin saatan poistaa jossain vaiheessa.
     * 
     * @param luku
     * 
     * @return löytyikö luku vai ei?
     * 
     */
    
    public boolean tarkistaNumero(int luku) {
        if (luku > 0 && luku < 17)
            return true;
        else return false;
    }
    
    /**
     * 
     * Katsotaan mikä kuva vastaa mitäkin numeroa. 
     * Tulen muuttamaan systeemin vielä järkeväksi esim. mathRandomilla.
     * 
     * @return lukua vastaava symboli.
     * 
     */
    
    public String laitaKuva(int luku) {
        if (luku==1 || luku==9)
            return "omena";
        if (luku==2 || luku==10)
            return "tuoli";
        if (luku==3 || luku==11)
            return "hevonen";
        if (luku==4 || luku==12)
            return "kivi";
        if (luku==5 || luku==13)
            return "kenkä";
        if (luku==6 || luku==14)
            return "porkkana";
        if (luku==7 || luku==15)
            return "koira";
        if (luku==8 || luku==16)
            return "ovi";
        else return "virhe";
    }
    
    /**
     * Etsitään löytyykö kortti pakasta. Varmaan korvaa tarkistaNumeron.
     * 
     * @param luku
     * 
     * @return löytyikö kortti vai ei? 
     */
    
    
    public boolean etsiKortti(int luku) {
        if (kortit.containsKey(luku)==true)
            return true;
        else return false;                 
    }
    
    /**
     * Tämän hetken korttien lukumäärä (aina parillinen):
     * 
     * @return korttien määrä
     */
    
    public int korttejaYhteensa() {
        return kortit.size();
    }
    
    /**
     * Tämän voisi periaatteessa korvata laitaKuvalla, 
     * mutta tämän hetkinen tilanne on hyvä tietää.
     * 
     * @param valitsema numero
     * @return numeroa vastaava symboli
     */
    
    public String symboli(int luku) {
        return kortit.get(luku);
    }
    
    /**
     * Kun pari ollaan löydetty, molemmat arvot avaimineen poistetaan.
     * 
     * @param numero1
     * @param numero2 
     */
    
    public void poista(int numero1, int numero2) {
        kortit.remove(numero1);
        kortit.remove(numero2);
    }
    
}
