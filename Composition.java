
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class Composition extends JInternalFrame implements ActionListener {
    
    static final int xOffset = 30, yOffset = 30;
    public EditeurPanel edp;
    public boolean sauve = false;
    public boolean lastsauve = true;
    public String chemin;
    public JCheckBoxMenuItem bouton;
    public boolean fermer;
    public Editeur myed;
    
   
    
    public Composition(int nbrDoc,int place)
    {
	super("Composition #" + nbrDoc,
          true, //resizable
          true, //closable
          true, //maximizable
          true);//iconifiable
	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        edp = new EditeurPanel(500,400);
        System.out.println("NewDocs");
        setVisible(true);
	getContentPane().setLayout(new BorderLayout());
        getContentPane().add(edp,BorderLayout.CENTER);
        setbouton("Composition #" + nbrDoc);
	if (place>10){
	    setLocation(xOffset,yOffset);
	    try{
	    setIcon(true);}
	    catch(Exception exp){};
	}
	else
        setLocation(xOffset*place+70, yOffset*place+30);
        pack();
	show();
        
    }
    
    public Composition(String titre,int place)
    {
        this(1,place);
        setTitle(titre);
        setbouton(titre);
               
    }
    
    public EditeurPanel getEdt(){
        return edp;
    }
    
    public void setEdt(EditeurPanel e1)
    {
        edp=e1;
    }
    
    public JCheckBoxMenuItem getBouton(){
        return bouton;
    }
   
    public void activer(){
        try{
        setSelected(true);}
        catch(Exception ex){};
    }
    
    public void setbouton(String text){
        bouton = new JCheckBoxMenuItem(text);
        bouton.setActionCommand("activer");
        bouton.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        activer();
    }

    public void seFermer(){
	fermer = true;
	activer();
        if (lastsauve){
            Object[] options = {"Oui","Non","Annuler"};
            int n = JOptionPane.showOptionDialog(myed,"Voulez-vous enregistrer les modifications appoortées à "+ getTitle()+" ?","Fermeture de "+getTitle(),JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,options,options[2]);
            if (n == 0)
                myed.bar.jbma.sauver();
            if (n == 2){
		fermer = false;
        	myed.fermer = false;}
	    System.out.println(fermer);
	    if (fermer){ 
		dispose();
		myed.removeCompo(this);
		myed.bar.removeFenetre(this);}

	
        }
       
    }


}
