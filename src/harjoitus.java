
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taneli
 */
import java.util.*;

public class harjoitus  {
    
    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 
    private static Scanner lukija = new Scanner(System.in);
    public static int kerta = 1;
    public static String nimi;
    
    public static boolean tarkistaNumero(int luku) {
        if (luku > 0 && luku < 17)
            return true;
        else return false;
    }
    
    public static boolean parienTarkastus(int vastaus1, int vastaus2) {
        if (vastaus1==vastaus2)
            return true;
        else return false;
    }
    
    public static int getKerta() {
        return kerta;
    }
    
    public static String getNimi() {
        return nimi;
    }
    
    public static int getVuoro() {
        return kerta;
    }
  

  public static void main(String[] args) {
      int vastaus;
      int valinta1 = 0;
      int valinta2 = -1;

    System.out.print("Tervetuloa muistipeliin!\n" +
       "Valitse kortti antamalla numero 1-16 väliltä\n" +
       "Väärä syöte tukitaan virheeksi! \n" + 
       "Syötä nimesi ja paina enter jatkaaksesi.");
      
        nimi=lukija.nextLine();
      
      
      
      while (true) {  // "ikuinen" toisto keskeytetään break-lauseella   
          
          if (kerta==3) {
           if (parienTarkastus(valinta1, valinta2)) {
               System.out.println("Löysit samat parit!");
           }
           else System.out.println("Et onnistunut löytämään samoja pareja :(");
       }
          
       // kirjoitetaan kehotemerkki eli "prompti"
       System.out.println("Hei! " + nimi + " \n Anna luku 1-16 väliltä");
       
       
       vastaus=lukija.nextInt();
       // valitaan operaatio
       
       if (tarkistaNumero(vastaus)==true && kerta == 1) {
              System.out.println("Valitsit ensimmäisen kortin " + vastaus);
              valinta1 = vastaus;
              kerta++;
       }
       else if (tarkistaNumero(vastaus)==true && kerta == 2) {
              System.out.println("Valitsit toisen kortin " + vastaus);
              valinta2 = vastaus;
              kerta++;
       }
       else 
         System.out.println("ERROR: Virheellinen komento!");

     }
  }
}
