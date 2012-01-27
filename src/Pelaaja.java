/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tanelvir
 */
public class Pelaaja {
    
    String nimi;
    int pisteet;
    int kerta;
    boolean vuoro = true;
    Kortti peli = new Kortti();
    int valinta1 = 1;
    int valinta2 = 9;
    
    public Pelaaja(String nimesi) {
        nimi = nimesi;
        pisteet = 0;
        kerta=1;
    }
    
    public void setPelaajannimi(String nimesi) {
        Pelaaja pelaaja = new Pelaaja(nimesi);
    }
    
    
    public String getNimi(Pelaaja pelaaja) {
        return nimi;
    }
    
    
    public void ekaKerta(int valinta) {
        this.valinta1 = valinta;
        vaihdaKerta();
    }
    
    public void tokakerta(int valinta) {
        this.valinta2 = valinta;
    }
    
    public boolean arvausKerta() {
        if (peli.etsiKortti(valinta1)==false || peli.etsiKortti(valinta2)==false) {
            System.out.println("LOL");
            vaihdaKerta();
            return false;
        }
        if (valinta1==valinta2) {
            System.out.println("TROLL");
            vaihdaKerta();
            return false;
        }
        if (peli.symboli(valinta1).equals(peli.symboli(valinta2))) {
            pisteet++;
            vaihdaKerta();
            peli.poista(valinta1, valinta2);
            System.out.println(ilmoitus(true));
            return true;
        }
        else {
            vaihdaKerta();
            System.out.println(ilmoitus(false));
            return false;
        }
    }
    
    public String ilmoitus(boolean totta) {
        if (totta) {
            return "Onneksi olkoon " + nimi + "! sait pisteen.";
        }
        else return "Valitettavasti " + nimi + " et löytänyt paria :(";
    }
    
    
    public int getPisteet() {
        return pisteet; 
    }
    
    public int getKerta() {
        return kerta;
    }
    
    public boolean getVuoro() {
        return vuoro;
    }
    
    public void vaihdaKerta() {
        if (kerta==3) {
            vuoro=false;
            this.kerta=1;
            this.kerta = kerta;
        }
        else if (kerta < 10) {
            kerta++;
        }         
    }
    
}
