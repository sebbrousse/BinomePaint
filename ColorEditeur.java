

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JPanel.*;
import java.awt.*;
import java.lang.*;

public class ColorEditeur extends JInternalFrame implements ChangeListener{

    protected JColorChooser couleurpanel;
    protected Editeur edt;
    protected Composition mycompo;
    protected RemplissagePanel remplissage;
    protected EpaisseurPanel epaisseur;

    public ColorEditeur(Editeur ep)
    {
	super("Couleur",
          false, //resizable
          false, //closable
          false, //maximizable
          true);//iconifiable
        edt=ep;
        setFrameIcon(new ImageIcon(edt.cheminDossier+"images/couleurico.gif"));
        getContentPane().setLayout(new BorderLayout());
        JTabbedPane groPanel = new JTabbedPane();
        remplissage =  new RemplissagePanel();
        epaisseur =  new EpaisseurPanel();
        groPanel.addTab("Remplissage",remplissage);
        groPanel.addTab("Trait", epaisseur);
        groPanel.addChangeListener(this);
        getContentPane().add(groPanel);
        setLocation(583,340);
        setVisible(true);
        toFront();
	pack();
        show();
        
    }
    
    public void setEdtp(Composition compo){
        mycompo = compo;
        remplissage.setEdtp(compo);
        epaisseur.setEdtp(compo);
    }
    
    public Composition getcible(){
        return mycompo;
    }

    public void stateChanged(ChangeEvent e) {
        if (e.getSource().equals(epaisseur))
            epaisseur.repaint();
        if (e.getSource().equals(remplissage))
            remplissage.repaint();
        
    }    

    
}
