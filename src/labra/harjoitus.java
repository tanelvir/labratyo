package labra;

import labra.Kortti;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * Tämä on harjoituskehys, jossa testaan luokkien toimivuutta.
 * Selkeät ohjeet näytöllä kertovat mitä pelaajan tulee tehdä.
 *
 * @author taneli
 */
import java.util.*;

public class harjoitus  {
    
    /*
     * tämä on maini, jossa testataan näin aluksi yksinpeliä. Intin parse täytyy hoitaa kuntoon, jotta ei ohjelma kaadu.
     * @return
     */
    
    private static Scanner lukija = new Scanner(System.in);

    public static boolean pelaajamaaranValinta(Pelaaja pelaaja1) {
        int pelaajamaara = 0;
        
        while (true) {
            System.out.println("Valitse pelaajamäärä: 1 tai 2");
            pelaajamaara = lukija.nextInt();
            if (pelaajamaara==1) {
                  return true;
            }
            /**if (pelaajamaara==2) {
                System.out.println("Pelaajan 2 nimi?");
                nimi = lukija.nextLine();
                lukija.nextLine();
                pelaaja2 = new Pelaaja(nimi);
                return false;
            }**/
            else System.out.println("Valitse 1 tai 2!");
        }
    }
    
    public static void yhdenPelaajanpeli(Pelaaja pelaaja, Kortti peli) {
        int vastaus;
        while (peli.korttejaYhteensa()>0) {

            System.out.println("Hei! " + pelaaja.getNimi() + " \nAnna luku 1-16 väliltä");


            vastaus=lukija.nextInt();

            if (peli.tarkistaNumero(vastaus)==true && pelaaja.getKerta()==1) {
                    System.out.println("Valitsit ensimmäisen kortin. Se on " + peli.symboli(vastaus) + ".");
                    pelaaja.ekaKerta(vastaus);

            }
            else if (peli.tarkistaNumero(vastaus)==true && pelaaja.getKerta()==2) {
                    System.out.println("Valitsit toisen kortin. Se on " + peli.symboli(vastaus) + ".");
                    pelaaja.tokakerta(vastaus);
                    pelaaja.arvausKerta(pelaaja.getValinta1(), pelaaja.getValinta2(), peli);
            }     
            else
                System.out.println("ERROR: Virheellinen komento! Syötä luku 1-16 väliltä!");

            }
        System.out.println("Peli päättyi " + pelaaja.getNimi() + "! Sait pisteitä: " + pelaaja.getPisteet());
    }
    
    public static void kahdenPelaajanpeli(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        int vastaus;
        
    }
    
    
    
    public static void main(String[] args) {
      boolean mod;
      String nimi;
      Pelaaja pelaaja1;
      Pelaaja pelaaja2;
      Kortti peli;

    System.out.print("Tervetuloa muistipeliin!\n" +
       "Valitse kortti antamalla numero 1-16 väliltä\n" +
       "Väärä syöte tukitaan virheeksi! \n" + 
       "Syötä nimesi ja paina enter jatkaaksesi. \n");
        
        
        nimi = lukija.nextLine();
        pelaaja1 = new Pelaaja(nimi);
        
        mod = pelaajamaaranValinta(pelaaja1);
        peli = new Kortti();
        peli.sekoitaPakka();
            
      
      if (mod=true){
         yhdenPelaajanpeli(pelaaja1, peli);
        }     
  
    /** if (mod=false) {
         while (true) {
             
            if (pelaaja1.getVuoro()>3) {
                System.out.println("Pelaajan " + pelaaja1.getNimi() + " vuoro.");
             
             
                System.out.println("Hei! " +pelaaja1.getNimi() + " \nAnna luku 1-16 väliltä");

                vastaus=lukija.nextInt();

                if (peli.tarkistaNumero(vastaus)==true && pelaaja1.getKerta() == 1) {
                        System.out.println("Valitsit ensimmäisen kortin. Se on " + esim.laitaKuva(vastaus) + ".");
                        pelaaja1.vaihdaKerta();
                        pelaaja1.ekaKerta(vastaus);

                }
                else if (peli.tarkistaNumero(vastaus)==true && esim.getKerta() == 2) {
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
         } **/
  }
}
