import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;

public class Editeur extends Application implements ActionListener{


    public boolean fermer;
    public String cheminDossier="";
    public Composition mycompo;
    public JCheckBoxMenuItem dessin,out,im,color,tex;
    public EditeurListener ferme;
    public JMenuEditeur menu;
    public JMenuEditeur outil;
    public TexteEditeur texte;
    public InserImEditeur image;
    public ColorEditeur couleurs;
    public static JMenuAdapter adapt;
    public JBarEditeur sousbar;
    public JBarMenu bar;
    protected Vector mesCompos = new Vector();
    public JDesktopPane desk;
    public int nbrCompos = 0;
    public boolean bool;
    public Vector buffer = new Vector();

    public Editeur(){
	this("new editor",new Dimension(500,400));
    }
	
    public Editeur(String titre){
	this(titre,new Dimension(500,400));
    }

    public Editeur(String titre,Dimension d)
    {
	super(titre);
        ferme = new EditeurListener(this);
	addWindowListener(ferme);
        dessin = new JCheckBoxMenuItem("Dessin",true);
        dessin.setActionCommand("dessin");
        dessin.addActionListener(this);
        out = new JCheckBoxMenuItem("Outils",true);
        out.setActionCommand("outil");
        out.addActionListener(this);
        im = new JCheckBoxMenuItem("Images",true);
        im.setActionCommand("imag");
        im.addActionListener(this);
        color= new JCheckBoxMenuItem("Couleurs",true);
        color.setActionCommand("color");
        color.addActionListener(this);
        tex = new JCheckBoxMenuItem("Texte",true);
        tex.setActionCommand("texte");
        tex.addActionListener(this);
        desk = new JDesktopPane();
        setContentPane(desk);
        setExtendedState(MAXIMIZED_BOTH);
        Object[] options = {"Windows","Linux"};
        int n = JOptionPane.showOptionDialog(this,"Sous Quel Système d'exploitation êtes vous en train de travailler ?","Bienvenu dans notre BINOMEPAINT",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        if (n == 0){
            try{
            JFileChooser ouvre=new JFileChooser("C:/");
            ouvre.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            ouvre.showOpenDialog(this);
	    cheminDossier = ouvre.getSelectedFile().getAbsolutePath()+"/";}
            catch(Exception exc) {
                JOptionPane.showMessageDialog(this,"Vous venez de cloturer le BinomePaint","Non c'est l'autre bouton",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);}
        }
        bar = new JBarMenu(this);
        setJMenuBar(bar);
        adapt = new JMenuAdapter();
	desk.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
	texte = new TexteEditeur(this,adapt);
        sousbar = new JBarEditeur(this);
        menu = new JMenuEditeur(this,bool,adapt);
        outil = new JMenuEditeur(this,adapt);
        image = new InserImEditeur(this,adapt);
        couleurs = new ColorEditeur(this);
	getContentPane().add(texte);
	getContentPane().add(sousbar);
      	getContentPane().add(menu);
        getContentPane().add(outil);
        getContentPane().add(image);
        getContentPane().add(couleurs);
        mycompo = creerNouvelEdt();
	show();
 
    }

    public Editeur(String titre,int largeur,int hauteur){
	this(titre,new Dimension(largeur,hauteur));
    }
    
    public Composition creerNouvelEdt(){
        Composition compo = new Composition(++nbrCompos,mesCompos.size());
        compo.addInternalFrameListener(new CompositionListener(compo,this));
        mesCompos.add(compo);
        getContentPane().add(compo);
	if (mesCompos.size()>12){
	    try{
		compo.setIcon(true);}
	    catch(Exception exp){
	    System.out.println("Icon");};}
	else
	    compo.activer();
	System.out.println(mesCompos.size());
        bar.addFenetre(compo);
	compo.myed = this;
        setEdtp(compo);
        mycompo.activer();
        return compo;
    }
    
     public Composition creerNouvelEdt(String titre){
        Composition compo = new Composition(titre,mesCompos.size());
        compo.addInternalFrameListener(new CompositionListener(compo,this));
        mesCompos.add(compo);
        getContentPane().add(compo);
	if (mesCompos.size()>12){
	    try{
		compo.setIcon(true);}
	    catch(Exception exp){};}
	else
	    compo.activer();
        bar.addFenetre(compo);
	compo.myed = this;
        setEdtp(compo);
        compo.activer();
        return compo;
    }
    
    
    public void setEdtp(Composition compo){
        mycompo = compo;
        outil.setEdtp(compo);
        menu.setEdtp(compo);
        sousbar.setEdtp(compo);
        bar.setEdtp(compo);
        image.setEdtp(compo);
        couleurs.setEdtp(compo);
        adapt.setEdtp(compo);
    
    }
    
    public void removeCompo(Composition compo){
        
        mesCompos.remove(compo);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("dessin")){
            if (dessin.getState())
                menu.setVisible(true);
            else
                menu.setVisible(false);
        }
        if (e.getActionCommand().equals("outil")){
           if (out.getState())
               outil.setVisible(true);
           else
               outil.setVisible(false);
        }
        if (e.getActionCommand().equals("imag")){
           if (im.getState())
               image.setVisible(true);
           else
               image.setVisible(false);
        }
        if (e.getActionCommand().equals("color")){
           if (color.getState())
               couleurs.setVisible(true);
           else
               couleurs.setVisible(false);
        }
        if (e.getActionCommand().equals("texte")){
           if (tex.getState())
               texte.setVisible(true);
           else
               texte.setVisible(false);
        }
    }
    
    public void copier()
    {
        buffer.removeAllElements();
        for(int i = 0;i< mycompo.getEdt().getVector().size() ;i++)
            if (((Figure)mycompo.getEdt().getVector().elementAt(i)).getSelected())
                buffer.add(mycompo.getEdt().getVector().elementAt(i));
    }

    public void coller()
    {
        for(int i = 0;i<buffer.size();i++)
           mycompo.getEdt().getVector().add(buffer.elementAt(i));
        mycompo.getEdt().repaint();
    }

    public void couper()
    {
        buffer.removeAllElements();
        for(int i = 0;i< mycompo.getEdt().getVector().size() ;i++)
        {   
            if (((Figure)mycompo.getEdt().getVector().elementAt(i)).getSelected())
            {
                buffer.add(mycompo.getEdt().getVector().elementAt(i));
                for(int j = i;j<mycompo.getEdt().getVector().size()-1;j++)
                    mycompo.getEdt().getVector().setElementAt(mycompo.getEdt().getVector().elementAt(j+1), j);
                if (mycompo.getEdt().getVector().size() != 0)
                    mycompo.getEdt().getVector().setSize(mycompo.getEdt().getVector().size() - 1);
            }
            --i;
        }
        mycompo.getEdt().repaint();
   } 

    public void close(){
	fermer = true;

	System.out.println("taille de mes compos====> " + mesCompos.size());
  
	
	for(int k=0;(k<(mesCompos.size()))&&(fermer);){
	try{
	     ((Composition)mesCompos.elementAt(k)).seFermer();
	     System.out.println("fermer composition"+k);
	}
	 catch(Exception ex3){
	 System.out.println("Y a exception");};
	}
	if (fermer){
	    dispose();
	    System.exit(0);}
    }
    
}

