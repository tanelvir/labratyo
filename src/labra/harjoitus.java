package labra;

import labra.*;
import java.util.*;

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

public class harjoitus  {
    
    /*
     * tämä on maini, jossa testataan näin aluksi yksinpeliä. Intin parse täytyy hoitaa kuntoon, jotta ei ohjelma kaadu.
     * @return
     */
    
    private static Scanner lukija = new Scanner(System.in);
    
    public static int parseInt(String sana) {
        int luku;
        try {
            return luku = Integer.parseInt(sana);
       } catch (Exception e) {
            System.out.println("Syötä numero!");
        }
        return -1;
    }

    public static boolean pelaajamaaranValinta(Pelaaja pelaaja1) {
        int pelaajamaara = 0;       
        while (true) {
            System.out.println(pelaaja1.getNimi() + " Valitse pelaajamäärä: 1 tai 2");
            pelaajamaara = parseInt(lukija.nextLine());
            if (pelaajamaara==1) {
                  return true;
            }
            else if (pelaajamaara==2) {
                return false;
            }
            else System.out.println("Valitse 1 tai 2!");
        }
    }
    
    public static boolean tarkastusMetodi(Pelaaja pelaaja, KorttiPakka peli) {
        if (peli.etsiKortti(pelaaja.getValinta1())==false || peli.etsiKortti(pelaaja.getValinta2())==false) {
            System.out.println("Korttiasi ei löydy!");
            return false;
        }
        else if (pelaaja.getValinta1()==pelaaja.getValinta2()) {
            System.out.println("Ei samoja kortteja!");
            return false;
        }
        else {
            return true;
        }
    }
    
    public static KorttiPakka peliMetodi(Pelaaja pelaaja, KorttiPakka peli) {
      int vastaus;
        while (true) {
          vastaus = parseInt(lukija.nextLine());
            if (vastaus>16 || vastaus<1) {
                System.out.println("Luku 1-16 väliltä!");
            }
            else if (peli.etsiKortti(vastaus)==true && pelaaja.getKerta()==1) {
                        System.out.println("Valitsit ensimmäisen kortin. Se on " + peli.getKortti(vastaus) + ".");
                        pelaaja.ekaKerta(vastaus);
                        return peli;
            }
            else if (peli.etsiKortti(vastaus)==true && pelaaja.getKerta()==2) {
                        System.out.println("Valitsit toisen kortin. Se on " + peli.getKortti(vastaus) + ".");
                        pelaaja.tokakerta(vastaus);
                        if (tarkastusMetodi(pelaaja, peli)==false) {
                            return peli;
                        }
                        else {
                            pelaaja.arvausKerta(pelaaja.getValinta1(), pelaaja.getValinta2(), peli);
                            return peli;
                        }
            }     
            else {
                System.out.println("Ei ole enää kyseistä korttia");
            }
      }
    }
    
    public static void yhdenPelaajanpeli(Pelaaja pelaaja, KorttiPakka peli) {
        while (peli.korttejaYhteensa()>0) {
            System.out.println(pelaaja.getNimi() + ": " + pelaaja.getPisteet() + "\nAnna luku 1-16 väliltä");
            peliMetodi(pelaaja, peli);
        }
        System.out.println("Peli päättyi " + pelaaja.getNimi() + "! Sait pisteitä: " + pelaaja.getPisteet());
    }
    
    public static void kahdenPelaajanpeli(Pelaaja pelaaja1, Pelaaja pelaaja2, KorttiPakka peli) {
        boolean vuoro=true;
        while (peli.korttejaYhteensa()>0) {
            System.out.println(pelaaja1.getNimi() + " pisteitä: " + pelaaja1.getPisteet() + "\n"
                    + pelaaja2.getNimi() + " pisteitä: " + pelaaja2.getPisteet());
            if (vuoro==true) {
                System.out.println("Hei! " + pelaaja1.getNimi() + " \nAnna luku 1-16 väliltä");
                peliMetodi(pelaaja1, peli);
                peliMetodi(pelaaja1, peli);
                vuoro = false;
            }
            else if (vuoro==false) {
                System.out.println("Hei! " + pelaaja2.getNimi() + " \nAnna luku 1-16 väliltä");
                peliMetodi(pelaaja2, peli);
                peliMetodi(pelaaja2, peli);
                vuoro = true;
            }
        }   
        
        System.out.println("Peli päättyi " + pelaaja1.getNimi() + "! Sait pisteitä: " + pelaaja1.getPisteet());
        System.out.println(pelaaja2.getNimi() + "! Sait pisteitä: " + pelaaja2.getPisteet());
        if (pelaaja1.getPisteet()>pelaaja2.getPisteet())
            System.out.println(pelaaja1.getNimi() + " voitti!");
        else if (pelaaja1.getPisteet()<pelaaja2.getPisteet())
            System.out.println(pelaaja2.getNimi() + " voitti!");
        else System.out.println("Tasapeli!");
    }
    
    
    
    public static void main(String[] args) {
      boolean mod;
      String nimi;
      Pelaaja pelaaja1;
      Pelaaja pelaaja2;
      KorttiPakka peli;

    System.out.print("Tervetuloa muistipeliin!\n" +
       "Syötä nimesi ja paina enter jatkaaksesi. \n");
        
        
        nimi = lukija.nextLine();
        pelaaja1 = new Pelaaja(nimi);
        
        mod = pelaajamaaranValinta(pelaaja1);
        
        peli = new KorttiPakka();
        peli.sekoitusArvottu();
      if (mod==false) {
          System.out.println("Pelaajan 2 nimi?");
          nimi = lukija.nextLine();
          pelaaja2 = new Pelaaja(nimi);
          kahdenPelaajanpeli(pelaaja1, pelaaja2, peli);
      }     
      else {
          yhdenPelaajanpeli(pelaaja1, peli);
      }
  }
}