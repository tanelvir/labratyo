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
    
    private JButton okButton;
    private JLabel eipasLabel;

    public toiminnot() {
        super();

        okButton = new JButton("Ok!");
        eipasLabel = new JLabel("Eipäs!");
        okButton.addActionListener(this);

        Container container = getContentPane();
        container.add(okButton, BorderLayout.NORTH);
        container.add(eipasLabel, BorderLayout.SOUTH);

        setSize(240, 120);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
  }

    public void actionPerformed(ActionEvent e) {
        eipasLabel.setText("Nappia painettu!");
    }   
}

