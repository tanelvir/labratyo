/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labra;

/**
 *
 * @author taneli
 */
import javax.swing.*;
import java.awt.*;

public class testiIkoni {



  public static void main(String[] args){
    JFrame frame = new JFrame("Icon on button");
    JButton button = new JButton("Roseindia.net");
    Icon imgicon = new ImageIcon("hellpari.jpg");
    JPanel panel = new JPanel();
    button.setIcon(imgicon);
    button.setSize(800, 800);
    panel.add(button);
    frame.add(panel, BorderLayout.CENTER);
    frame.setSize(2000, 2000);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}

