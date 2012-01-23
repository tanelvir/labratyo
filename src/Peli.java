
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taneli
 */
public class Peli {
  
    public int kerta = 1;
    public int vuoro = 1;
    public String nimi1;
    public String nimi2;
    public HashMap<Integer,String> kortit = new HashMap<Integer,String>();
    public int pisteet1 = 0;
    public int pisteet2 = 0;
    public int valinta1;
    public int valinta2;
    
    
    public void setPelaaja1nimi(String nimesi) {
        nimi1 = nimesi;
    }
    
    public void setPelaaja2nimi(String nimesi) {
        nimi1 = nimesi;
    }
    
    public HashMap sekoitaPakka() {
        for (int i = 1; i <= 16; i++) {
            kortit.put(i,laitaKuva(i));
        }       
        return kortit;
    }
    
    public void setVastaus1(int valinta) {
        valinta1 = valinta;
    }
    
    public void setVastaus2(int valinta) {
        valinta2 = valinta;
    }
    
    public int getVastaus1() {
        return valinta1;
    }
    
    public int getVastaus2() {
        return valinta2 ;
    }
    
    public String ilmoitus1(boolean totta) {
        if (totta==true) {
            return "Onneksi olkoon " + getNimi1() + "! sait pisteen";
        }
        else return "Valitettavasti " + getNimi1() + " et löytänyt paria :(";
    }
    
    
    public boolean arvaus1(int valinta1, int valinta2){
        if (etsiKortti(valinta1)==false || etsiKortti(valinta2)==false)
            return false;
        if (valinta1==valinta2)
            return false;
        if (kortit.get(valinta1).equals(kortit.get(valinta2))) {
            pisteet1++;
            vaihdaVuoro();
            kortit.remove(valinta1);
            kortit.remove(valinta2);
            return true;
        }
        else {
            vaihdaVuoro();
            return false;
        }
    }
    
    public boolean arvaus2(int valinta1, int valinta2){
        if (etsiKortti(valinta1)==false || etsiKortti(valinta2)==false)
            return false;
        if (valinta1==valinta2)
            return false;
        if (kortit.get(valinta1).equals(kortit.get(valinta2))) {
            pisteet2++;
            vaihdaVuoro();
            kortit.remove(valinta1);   
            kortit.remove(valinta2);   
            return true;
        }
        else {
            vaihdaVuoro();
            return false;
        }
    }
    
    public boolean tarkistaNumero(int luku) {
        if (luku > 0 && luku < 16)
            return true;
        else return false;
    }
    
    public String laitaKuva(int luku) {
        if (luku==1 || luku ==9)
            return "omena";
        if (luku==2 || luku ==10)
            return "tuoli";
        if (luku==3 || luku ==11)
            return "hevonen";
        if (luku==4 || luku ==12)
            return "kivi";
        if (luku==5 || luku ==13)
            return "kenkä";
        if (luku==6 || luku ==14)
            return "porkkana";
        if (luku==7 || luku ==15)
            return "koira";
        if (luku==8 || luku ==16)
            return "ovi";
        else return "virhe";
    }
    
    public void vaihdaKerta() {
        if (kerta==1)
        kerta++;
        else kerta = 1;
    }
    
    public int getKerta() {
        return kerta;
    }
    
    public String getNimi1() {
        return nimi1;
    }
    
    public String getNimi2() {
        return nimi2;
    }
    
    public void vaihdaVuoro() {
        if(vuoro==1)
            vuoro++;
        else vuoro=1;
    }
    
    public int getVuoro() {
        return vuoro;
    }
    
    public int getPisteet(int pelaaja) {
        if (pelaaja==1)
            return pisteet1;
        if (pelaaja==2)
            return pisteet2;
        else return 0;    
    }
    
    public boolean etsiKortti(int luku) {
        if (kortit.containsKey(luku)==true)
            return true;
        else return false;                 
    }
    
    public int korttejaYhteensa() {
        return kortit.size();
    }
    
}
