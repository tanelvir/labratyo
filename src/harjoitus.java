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
      Kortti peli = new Kortti();
      Pelaaja pelaaja1;
      Pelaaja pelaaja2;
      Scanner lukija = new Scanner(System.in);
      int vastaus;
      int pelaajamaara = 0;
      boolean mod;

    System.out.print("Tervetuloa muistipeliin!\n" +
       "Valitse kortti antamalla numero 1-16 väliltä\n" +
       "Väärä syöte tukitaan virheeksi! \n" + 
       "Syötä nimesi ja paina enter jatkaaksesi. \n");
      
        
        nimi = lukija.nextLine();
        pelaaja1 = new Pelaaja(nimi);
        
        while (true) {
            System.out.println("Valitse pelaajamäärä: 1 tai 2");
            pelaajamaara = lukija.nextInt();
            if (pelaajamaara==1) {
                  mod=true;
                  break;
            }
            if (pelaajamaara==2) {
                mod=false;
                System.out.println("Pelaajan 2 nimi?");
                nimi = lukija.nextLine();
                lukija.nextLine();
                pelaaja2 = new Pelaaja(nimi);
                break;
            }
            else System.out.println("Valitse 1 tai 2!");
        }
      
      
      peli.sekoitaPakka();
            
      
      if (mod=true){
         while (true) {

            System.out.println("Hei! " + nimi + " \nAnna luku 1-16 väliltä");


            vastaus=lukija.nextInt();

            if (peli.tarkistaNumero(vastaus)==true && pelaaja1.getKerta()==1) {
                    System.out.println("Valitsit ensimmäisen kortin. Se on " + peli.symboli(vastaus) + ".");
                    pelaaja1.ekaKerta(vastaus);

            }
            else if (peli.tarkistaNumero(vastaus)==true && pelaaja1.getKerta()==2) {
                    System.out.println("Valitsit toisen kortin. Se on " + peli.symboli(vastaus) + ".");
                    pelaaja1.tokakerta(vastaus);
                    pelaaja1.arvausKerta();
            }     
            else
                System.out.println("ERROR: Virheellinen komento! Syötä luku 1-16 väliltä!");

            }
        }     
  
  /*  if (mod=false) {
         while (true) {
             
            if (pelaaja1.getVuoro()==true) {
                System.out.println("Pelaajan " + pelaaja + " vuoro.");
             
             
                System.out.println("Hei! " + nimi1 + " \nAnna luku 1-16 väliltä");

                vastaus=lukija.nextInt();

                if (esim.tarkistaNumero(vastaus)==true && esim.getKerta() == 1) {
                        System.out.println("Valitsit ensimmäisen kortin. Se on " + esim.laitaKuva(vastaus) + ".");
                        esim.vaihdaKerta();
                        esim.setVastaus1(vastaus);

                }
                else if (esim.tarkistaNumero(vastaus)==true && esim.getKerta() == 2) {
                        System.out.println("Valitsit toisen kortin. Se on " + esim.laitaKuva(vastaus) + ".");
                        esim.setVastaus2(vastaus);
                        esim.vaihdaKerta();                
                        System.out.println(esim.ilmoitus1(esim.arvausP1(esim.getVastaus1(),esim.getVastaus2())));
                        
                }     
                else
                    System.out.println("ERROR: Virheellinen komento! Syötä luku 1-16 väliltä!");
            }
            
            else {
                System.out.println("Pelaajan " + nimi2 + " vuoro.");
             
             
                System.out.println("Hei! " + nimi2 + " \nAnna luku 1-16 väliltä");

                vastaus=lukija.nextInt();

                if (esim.tarkistaNumero(vastaus)==true && esim.getKerta() == 1) {
                        System.out.println("Valitsit ensimmäisen kortin. Se on " + esim.laitaKuva(vastaus) + ".");
                        esim.vaihdaKerta();
                        esim.setVastaus1(vastaus);

                }
                else if (esim.tarkistaNumero(vastaus)==true && esim.getKerta() == 2) {
                        System.out.println("Valitsit toisen kortin. Se on " + esim.laitaKuva(vastaus) + ".");
                        esim.setVastaus2(vastaus);
                        esim.vaihdaKerta();
                        System.out.println(esim.ilmoitus2(esim.arvausP2(esim.getVastaus1(),esim.getVastaus2())));
                }     
                else
                    System.out.println("ERROR: Virheellinen komento! Syötä luku 1-16 väliltä!");
            }
         } */
  }
}
