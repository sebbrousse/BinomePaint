import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JBarMenu extends JMenuBar {
    
     public JBarMenuAdapter jbma;
     public JMenu fichier;
     public JMenuItem nouveau,ouvrir,imprimer,sauvegarder,sauvegarderSous,quitter;
     public JMenu edition;
     public JMenuItem annuler,restaurer,selectionnerTout,couper,copier,coller,effacer,effacerTout;
     public JMenu affichage;
     public JMenu fenetres,outils;
     public JCheckBoxMenuItem dessin,out,im,color;

public JBarMenu(Editeur ep){
    
    jbma = new JBarMenuAdapter(ep);
  
    
    fichier = new JMenu("Fichier");
    fichier.setMnemonic('F');
    
        nouveau = new JMenuItem("Nouveau",new ImageIcon(ep.cheminDossier+"images/nouveauico.gif"));
        nouveau.setMnemonic('N');
	nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));  //Touche de raccourci
	nouveau.setActionCommand("nouveau");
	nouveau.addActionListener(jbma);
	fichier.add(nouveau);
        
        ouvrir = new JMenuItem("Ouvrir",new ImageIcon(ep.cheminDossier+"images/ouvririco.gif"));
        ouvrir.setMnemonic('O');
	ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3,0));
	ouvrir.setActionCommand("ouvrir");
	ouvrir.addActionListener(jbma);
	fichier.add(ouvrir);
        
        fichier.addSeparator();
        
        imprimer = new JMenuItem("Imprimer",new ImageIcon(ep.cheminDossier+"images/imprimer.gif"));
        imprimer.setMnemonic('I');
	imprimer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,0));
	imprimer.setActionCommand("imprime");
	imprimer.addActionListener(jbma);
	fichier.add(imprimer);
        
        fichier.addSeparator();
        
        sauvegarder = new JMenuItem("Sauvegarder...",new ImageIcon(ep.cheminDossier+"images/sauverico.gif"));
        sauvegarder.setMnemonic('S');
	sauvegarder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	sauvegarder.setActionCommand("sauve");
	sauvegarder.addActionListener(jbma);
	fichier.add(sauvegarder);
        
        sauvegarderSous = new JMenuItem("Sauvegarder sous...",new ImageIcon(ep.cheminDossier+"images/sauversousico.gif"));
        sauvegarderSous.setMnemonic('v');
	sauvegarderSous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,0));
	sauvegarderSous.setActionCommand("sauvesous");
	sauvegarderSous.addActionListener(jbma);
	fichier.add(sauvegarderSous);
        
        fichier.addSeparator();
        
        quitter = new JMenuItem("Quitter",new ImageIcon(ep.cheminDossier+"images/quitterico.gif"));
        quitter.setMnemonic('Q');
	quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
	quitter.setActionCommand("quitter");
	quitter.addActionListener(jbma);
	fichier.add(quitter);

    edition = new JMenu("Edition");
    edition.setMnemonic('E');
    
        annuler = new JMenuItem("Annuler",new ImageIcon(ep.cheminDossier+"images/annulerico.gif"));
        annuler.setMnemonic('A');
	annuler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6,0));
	annuler.setActionCommand("annuler");
	annuler.addActionListener(jbma);
	edition.add(annuler);
        
        restaurer = new JMenuItem("Restaurer",new ImageIcon(ep.cheminDossier+"images/restaurerico.gif"));
        restaurer.setMnemonic('R');
	restaurer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7,0));
	restaurer.setActionCommand("restaurer");
	restaurer.addActionListener(jbma);
	edition.add(restaurer);
        
        edition.addSeparator();
        
        selectionnerTout = new JMenuItem("Sélectionner Tout",new ImageIcon(ep.cheminDossier+"images/selectico.gif"));
        selectionnerTout.setMnemonic('l');
	selectionnerTout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
	selectionnerTout.setActionCommand("select");
	selectionnerTout.addActionListener(jbma);
	edition.add(selectionnerTout);
        
        edition.addSeparator();
        
        couper = new JMenuItem("Couper",new ImageIcon(ep.cheminDossier+"images/couperico.gif"));
        couper.setMnemonic('C');
	couper.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
	couper.setActionCommand("couper");
	couper.addActionListener(jbma);
	edition.add(couper);
        
        copier = new JMenuItem("Copier",new ImageIcon(ep.cheminDossier+"images/copierico.gif"));
        copier.setMnemonic('o');
	copier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
	copier.setActionCommand("copier");
	copier.addActionListener(jbma);
	edition.add(copier);
        
        coller = new JMenuItem("Coller",new ImageIcon(ep.cheminDossier+"images/collerico.gif"));
        coller.setMnemonic('r');
	coller.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
	coller.setActionCommand("coller");
	coller.addActionListener(jbma);
	edition.add(coller);
        
        edition.addSeparator();
       
        effacer = new JMenuItem("Effacer",new ImageIcon(ep.cheminDossier+"images/effacerico.gif"));
        effacer.setMnemonic('E');
	effacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8,0));
	effacer.setActionCommand("effacer");
	effacer.addActionListener(jbma);
	edition.add(effacer);
        
        effacerTout = new JMenuItem("Effacer Tout",new ImageIcon(ep.cheminDossier+"images/effacerToutico.gif"));
        effacerTout.setMnemonic('T');
	effacerTout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9,0));
	effacerTout.setActionCommand("effacerTout");
	effacerTout.addActionListener(jbma);
	edition.add(effacerTout);
        
    affichage = new JMenu("Affichage");
    affichage.setMnemonic('A');
        fenetres = new JMenu("Fenêtres");
        for(int i=0;i<ep.mesCompos.size();i++)
            fenetres.add(((Composition)ep.mesCompos.elementAt(i)).getBouton());
        affichage.add(fenetres);
        
        outils = new JMenu("Barres d'Outils");
        outils.add(ep.dessin);
        outils.add(ep.out);
        outils.add(ep.im);
        outils.add(ep.color);
        outils.add(ep.tex);
        affichage.add(outils);
       
    
    add(fichier);
    add(edition);
    add(affichage);
    
}
 public void setEdtp(Composition compo){
         jbma.setEdtp(compo);
    }
 
 public void addFenetre(Composition comp){
     fenetres.add(comp.getBouton());
 }
 
 public void removeFenetre(Composition comp){
     fenetres.remove(comp.getBouton());
 }
}



