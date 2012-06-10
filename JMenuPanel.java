
import javax.swing.*;
import java.awt.*;
import java.lang.*;


public class JMenuPanel extends JPanel {


    protected Composition mycompo;
    protected JButton segment,crayon,rectangle,carre,ellipse,cercle;
    protected JButton selectbox,gomme,rotat,pointeur,abaisser,surelever;
    
    public JMenuPanel(Editeur ep,boolean bool,JMenuAdapter adapt){

        Dimension dim = new Dimension(50,50);
	setLayout(new GridLayout(3,2));
                
	segment = new JButton(new ImageIcon(ep.cheminDossier+"images/segment.gif"));
        segment.setActionCommand("segment");
	segment.addActionListener(adapt);
        segment.setToolTipText("Créer un segment");
	segment.setPreferredSize(dim); 
        add(segment);  

  	crayon = new JButton(new ImageIcon(ep.cheminDossier+"images/crayon.gif"));
        crayon.setActionCommand("crayon");
	crayon.addActionListener(adapt);
        crayon.setToolTipText("Créer une courbe");
	crayon.setPreferredSize(dim); 
        add(crayon);  
        

	rectangle = new JButton(new ImageIcon(ep.cheminDossier+"images/rectangle.gif"));
        rectangle.setActionCommand("rectangle");
	rectangle.addActionListener(adapt);
        rectangle.setToolTipText("Créer une rectangle");
        rectangle.setPreferredSize(dim); 
        add(rectangle);
    
     	carre = new JButton(new ImageIcon(ep.cheminDossier+"images/carre.gif"));
        carre.setActionCommand("carre");
	carre.addActionListener(adapt);
        carre.setToolTipText("Créer un carre");
	carre.setPreferredSize(dim); 
        add(carre);  
     
   	ellipse = new JButton(new ImageIcon(ep.cheminDossier+"images/ellipse.gif"));
        ellipse.setActionCommand("ellipse");
	ellipse.addActionListener(adapt);
        ellipse.setToolTipText("Créer une ellipse");
	ellipse.setPreferredSize(dim); 
        add(ellipse);
 
     	cercle = new JButton(new ImageIcon(ep.cheminDossier+"images/cercle.gif"));
        cercle.setActionCommand("cercle");
	cercle.addActionListener(adapt);
        cercle.setToolTipText("Créer un cercle");
	cercle.setPreferredSize(dim); 
        add(cercle);
        
       
        
}

public JMenuPanel(Editeur ep,JMenuAdapter adapt)
{

        Dimension dim = new Dimension(50,50);
	setLayout(new GridLayout(3,2));
        
        
	
  	selectbox = new JButton(new ImageIcon(ep.cheminDossier+"images/select.gif"));
        selectbox.setActionCommand("selectbox");
	selectbox.addActionListener(adapt);
        selectbox.setToolTipText("Sélection");
	selectbox.setPreferredSize(dim); 
        add(selectbox);  

	gomme = new JButton(new ImageIcon(ep.cheminDossier+"images/gomme.gif"));
        gomme.setActionCommand("gomme");
	gomme.addActionListener(adapt);
        gomme.setToolTipText("Gomme");
        gomme.setPreferredSize(dim); 
        add(gomme);
    
   	rotat = new JButton();
        rotat.setActionCommand("attente");
	rotat.addActionListener(adapt);
        rotat.setToolTipText("Désactivation de toute fonction sur le panel");
	rotat.setPreferredSize(dim); 
        add(rotat);
 
     	pointeur = new JButton(new ImageIcon(ep.cheminDossier+"images/pointeur.gif"));
        pointeur.setActionCommand("pointeur");
	pointeur.addActionListener(adapt);
	pointeur.setPreferredSize(dim); 
        add(pointeur);  
        
     	abaisser = new JButton(new ImageIcon(ep.cheminDossier+"images/abaisser.gif"));
        abaisser.setActionCommand("abaisser");
	abaisser.addActionListener(adapt);
        abaisser.setToolTipText("Abaisser");
        abaisser.setPreferredSize(dim); 
        add(abaisser);  
        
     	surelever = new JButton(new ImageIcon(ep.cheminDossier+"images/surelever.gif"));
        surelever.setActionCommand("surelever");
	surelever.addActionListener(adapt);
        surelever.setToolTipText("Surelever");
        surelever.setPreferredSize(dim); 
        add(surelever);  
}
    public void setEdtp(Composition compo){
        mycompo = compo;
        }
}
   
