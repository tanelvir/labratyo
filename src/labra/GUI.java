/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labra;

/**
 *
 * @author taneli
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

public class GUI extends JFrame {
    
  private JTextArea tapahtuma = new JTextArea(7,7);
  private JLabel otsikko = new JLabel("Pelaajanvuoro");

  private JButton kortti1 = new JButton("1");
  private JButton kortti2 = new JButton("2");
  private JButton kortti3 = new JButton("3");
  private JButton kortti4 = new JButton("4");
  private JButton kortti5 = new JButton("5");
  private JButton kortti6 = new JButton("6");
  private JButton kortti7 = new JButton("7");
  private JButton kortti8 = new JButton("8");
  private JButton kortti9 = new JButton("9");
  private JButton kortti10 = new JButton("10");
  private JButton kortti11 = new JButton("11");
  private JButton kortti12 = new JButton("12");
  private JButton kortti13 = new JButton("13");
  private JButton kortti14 = new JButton("14");
  private JButton kortti15 = new JButton("15");
  private JButton kortti16 = new JButton("16");

  public GUI() {

    JPanel painikkeet = new JPanel(new GridLayout(4,4));
    painikkeet.add(kortti1); painikkeet.add(kortti2); painikkeet.add(kortti3); painikkeet.add(kortti4);
    painikkeet.add(kortti5); painikkeet.add(kortti6); painikkeet.add(kortti7); painikkeet.add(kortti8);
    painikkeet.add(kortti9); painikkeet.add(kortti10); painikkeet.add(kortti11); painikkeet.add(kortti12);
    painikkeet.add(kortti13); painikkeet.add(kortti14); painikkeet.add(kortti15); painikkeet.add(kortti16);
    
    JPanel teksti = new JPanel(new BorderLayout());
    teksti.add("North", otsikko);
    teksti.add("Center", tapahtuma);
    
    JPanel ilmoitus = new JPanel(new FlowLayout());
    ilmoitus.add(teksti);
    
    JPanel kortit = new JPanel(new BorderLayout());
    kortit.add("South", painikkeet);

    this.setLayout(new BorderLayout());
    this.add("South", kortit);
    this.add("North", teksti);
  }

  public static void main(String args[]) {
    GUI ikkuna = new GUI();
    ikkuna.setTitle("Muistipeli");
    ikkuna.pack();
    ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ikkuna.setVisible(true);
  }
}
    