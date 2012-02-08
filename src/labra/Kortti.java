package labra;


import java.util.*;
import labra.*;

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
    
    
    public Kortti (int numero) {
        if (numero==1 || numero==9)
           kuva = "omena";
        else if (numero==2 || numero==10)
            kuva = "tuoli";
        else if (numero==3 || numero==11)
            kuva = "hevonen";
        else if (numero==4 || numero==12)
            kuva = "kivi";
        else if (numero==5 || numero==13)
            kuva = "kenkä";
        else if (numero==6 || numero==14)
            kuva = "porkkana";
        else if (numero==7 || numero==15)
            kuva = "koira";
        else if (numero==8 || numero==16)
            kuva = "ovi";
        else kuva = "virhe";          
    }
    
    /**
     * 
     * @return kyseisen kortin kuva 
     */
    
    public String getKuva() {
        return kuva;
    }
    
    /**
     * Pelkkä tulostus
     * 
     * 
     * @param valitsema numero
     * @return numeroa vastaava symboli
     */
    
    public String toString(){
        return kuva;
    }   
}
