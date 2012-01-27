
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tanelvir
 */
public class Kortti {
    
    public HashMap<Integer,String> kortit = new HashMap<Integer,String>();
    
    public HashMap sekoitaPakka() {
        for (int i = 1; i <= 16; i++) {
            kortit.put(i,laitaKuva(i));
        }       
        return kortit;
    } 
    
    public boolean tarkistaNumero(int luku) {
        if (luku > 0 && luku < 17)
            return true;
        else return false;
    }
    
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
    
    
    
    
    public boolean etsiKortti(int luku) {
        if (kortit.containsKey(luku)==true)
            return true;
        else return false;                 
    }
    
    public int korttejaYhteensa() {
        return kortit.size();
    }
    
    public String symboli(int luku) {
        return kortit.get(luku);
    }
    
    public void poista(int numero1, int numero2) {
        kortit.remove(numero1);
        kortit.remove(numero2);
    }
    
}
