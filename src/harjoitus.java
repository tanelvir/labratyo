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

  public static void main(String[] args) {
      String nimi;
      Peli esim = new Peli();
      Scanner lukija = new Scanner(System.in);
      int vastaus;

    System.out.print("Tervetuloa muistipeliin!\n" +
       "Valitse kortti antamalla numero 1-16 väliltä\n" +
       "Väärä syöte tukitaan virheeksi! \n" + 
       "Syötä nimesi ja paina enter jatkaaksesi. \n");
      
        
        nimi = lukija.nextLine();
        esim.setPelaaja1nimi(nimi);
        esim.sekoitaPakka();
      
      
      
      while (true) {
          
       System.out.println("Hei! " + nimi + " \nAnna luku 1-16 väliltä");
       
       
       vastaus=lukija.nextInt();
       
       if (esim.tarkistaNumero(vastaus)==true && esim.getKerta() == 1) {
              System.out.println("Valitsit ensimmäisen kortin. Se on " + esim.laitaKuva(vastaus) + ".");
              esim.setVastaus1(vastaus);
       }
       else if (esim.tarkistaNumero(vastaus)==true && esim.getKerta() == 2) {
              System.out.println("Valitsit toisen kortin. Se on " + esim.laitaKuva(vastaus) + ".");
              esim.setVastaus2(vastaus);
              esim.ilmoitus1(esim.arvaus1(esim.getVastaus1(),esim.getVastaus2()));
       }     
       else
         System.out.println("ERROR: Virheellinen komento! Syötä luku 1-16 väliltä!");

     }
  }
}
