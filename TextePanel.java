

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;


public class TextePanel extends JPanel implements ActionListener {

    protected Composition mycompo;
    public Editeur edt;
    public JTextField zonetexte;
    public JButton insertext;
    public JMenuAdapter adapt;
    
    public TextePanel(Editeur ep,JMenuAdapter theadapt){

	adapt=theadapt;
        edt=ep;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(150,40));
        
        
        zonetexte = new JTextField(20);
	zonetexte.setActionCommand("Texte");
       	zonetexte.addActionListener(this);
	add(zonetexte);

	insertext = new JButton("Insérer");
	insertext.setActionCommand("inser");
	insertext.addActionListener(this);
	add(insertext);
        
    }

    public void actionPerformed(ActionEvent e){

	System.out.println("actionTextPerformed");

       
	if (e.getActionCommand().equals("inser")){
	    adapt.setTexte(zonetexte.getText());
	    System.out.println(zonetexte.getText());
        }

 
    }





    public void setEdtp(Composition compo){
        mycompo = compo;
    }
    
}
   
