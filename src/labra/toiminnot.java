/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labra;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * @author tanelvir
 */
public class toiminnot extends JFrame implements ActionListener {
    
    private JButton click;
    
    public toiminnot(int numero) {
        if (numero==1)
            actionPerformed1(null);
        if (numero==2)
            actionPerformed2(null);
        if (numero==3)
            actionPerformed3(null);
        if (numero==4)
            actionPerformed4(null);
        if (numero==5)
            actionPerformed5(null);
        if (numero==6)
            actionPerformed6(null);
        if (numero==7)
            actionPerformed7(null);
        if (numero==8)
            actionPerformed8(null);
        if (numero==9)
            actionPerformed9(null);
        if (numero==10)
            actionPerformed10(null);
        if (numero==11)
            actionPerformed11(null);
        if (numero==12)
            actionPerformed12(null);
        if (numero==13)
            actionPerformed13(null);
        if (numero==14)
            actionPerformed14(null);
        if (numero==15)
            actionPerformed15(null);
        if (numero==16)
            actionPerformed16(null);
    }
        public void actionPerformed(ActionEvent e) {
            
        }
    
        public void actionPerformed1(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitsit kortin 1");
        }

        public void actionPerformed2(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 2");
        }

        public void actionPerformed3(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 3");
        }

        public void actionPerformed4(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 4");
        }

        public void actionPerformed5(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 5");
        }
        
        public void actionPerformed6(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 6");
        }

        public void actionPerformed7(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 7");
        }

        public void actionPerformed8(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 8");
        }

        public void actionPerformed9(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 9");
        }

        public void actionPerformed10(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 10");
        }
        
        public void actionPerformed11(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 11");
        }

        public void actionPerformed12(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 12");
        }

        public void actionPerformed13(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 13");
        }

        public void actionPerformed14(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 14");
        }

        public void actionPerformed15(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 15");
        }
        
        public void actionPerformed16(ActionEvent e) {
            if (e.getSource()==click)
                JOptionPane.showMessageDialog(null, "Valitisit kortin 16");
        }
}

