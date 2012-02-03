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
    
    String kuva;
    
    
    /**
     * 
     * Katsotaan mikä kuva vastaa mitäkin numeroa. 
     * Tulen muuttamaan systeemin vielä järkeväksi esim. mathRandomilla.
     * 
     * @param syötetty luku;
     * @return lukua vastaava symboli.
     * 
     */
    
    
    public Kortti(int numero) {
        if (numero==1 || numero==9)
            kuva = "omena";
        if (numero==2 || numero==10)
            kuva = "tuoli";
        if (numero==3 || numero==11)
            kuva = "hevonen";
        if (numero==4 || numero==12)
            kuva = "kivi";
        if (numero==5 || numero==13)
            kuva = "kenkä";
        if (numero==6 || numero==14)
            kuva = "porkkana";
        if (numero==7 || numero==15)
            kuva = "koira";
        if (numero==8 || numero==16)
            kuva = "ovi";
        else kuva = "virhe";
            
    }
    
    /**
     * Tämän voisi periaatteessa korvata laitaKuvalla, 
     * mutta tämän hetkinen tilanne on hyvä tietää.
     * 
     * @param valitsema numero
     * @return numeroa vastaava symboli
     */
    
    public String toString(){
        return kuva;
    }
    
}
