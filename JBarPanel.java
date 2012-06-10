

import javax.swing.*;
import java.awt.*;
import java.lang.*;


public class JBarPanel extends JPanel {


    protected JBarMenuAdapter adapt;
    protected Composition mycompo;
    protected JButton nouveau,ouvrir,sauver,annuler,restaurer,couper,copier,coller;
    
    public JBarPanel(Editeur ep){

        adapt = new JBarMenuAdapter(ep);
        Dimension dim = new Dimension(20,20);
        setPreferredSize(new Dimension(1023,30));
	setLayout(new FlowLayout(FlowLayout.LEFT));
        
	
        
	nouveau = new JButton(new ImageIcon(ep.cheminDossier+"images/nouveauico.gif"));
        nouveau.setActionCommand("nouveau");
	nouveau.addActionListener(adapt);
        nouveau.setToolTipText("Nouveau");
        nouveau.setPreferredSize(dim); 
        add(nouveau);  

  	ouvrir = new JButton(new ImageIcon(ep.cheminDossier+"images/ouvririco.gif"));
        ouvrir.setActionCommand("ouvrir");
	ouvrir.addActionListener(adapt);
        ouvrir.setToolTipText("Ouvrir");
        ouvrir.setPreferredSize(dim); 
        add(ouvrir);  
        

	sauver = new JButton(new ImageIcon(ep.cheminDossier+"images/sauverico.gif"));
        sauver.setActionCommand("sauve");
	sauver.addActionListener(adapt);
        sauver.setToolTipText("Sauvegarder");
        sauver.setPreferredSize(dim); 
        add(sauver);
    
     	annuler = new JButton(new ImageIcon(ep.cheminDossier+"images/annulerico.gif"));
        annuler.setActionCommand("annuler");
	annuler.addActionListener(adapt);
        annuler.setToolTipText("Annuler");
        annuler.setPreferredSize(dim); 
        add(annuler);  
     
   	restaurer = new JButton(new ImageIcon(ep.cheminDossier+"images/restaurerico.gif"));
        restaurer.setActionCommand("restaurer");
	restaurer.addActionListener(adapt);
        restaurer.setToolTipText("Restaurer");
        restaurer.setPreferredSize(dim); 
        add(restaurer);
 
     	couper = new JButton(new ImageIcon(ep.cheminDossier+"images/couperico.gif"));
        couper.setActionCommand("couper");
	couper.addActionListener(adapt);
        couper.setToolTipText("Couper");
        couper.setPreferredSize(dim); 
        add(couper);  
        
     	copier = new JButton(new ImageIcon(ep.cheminDossier+"images/copierico.gif"));
        copier.setActionCommand("copier");
	copier.addActionListener(adapt);
        copier.setToolTipText("Copier");
        copier.setPreferredSize(dim); 
        add(copier);  
        
     	coller = new JButton(new ImageIcon(ep.cheminDossier+"images/collerico.gif"));
        coller.setActionCommand("coller");
	coller.addActionListener(adapt);
        coller.setToolTipText("Coller");
        coller.setPreferredSize(dim); 
        add(coller);  
        
        setVisible(true);
}
    public void setEdtp(Composition compo){
        mycompo = compo;
        adapt.setEdtp(compo);
    }


}
   
