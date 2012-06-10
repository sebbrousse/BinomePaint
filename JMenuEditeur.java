import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class JMenuEditeur extends JInternalFrame{

    protected JMenuPanel monjmp;
    
   

    public JMenuEditeur(Editeur ep,JMenuAdapter adapt)
    {
	super("",
          false, //resizable
          false, //closable
          false, //maximizable
          false);//iconifiable
        setFrameIcon(new ImageIcon(ep.cheminDossier+"images/outilico.gif"));
        monjmp = new JMenuPanel(ep,adapt);
	getContentPane().setLayout(new BorderLayout());
        getContentPane().add(monjmp,BorderLayout.CENTER);
        setPreferredSize(new Dimension (70,125));
        setLocation(0,155);
        setVisible(true);
        toFront();
	pack();
        show();
             
    }
    
    public JMenuEditeur(Editeur ep,boolean bool,JMenuAdapter adapt)
    {
	super("",
          false, //resizable
          false, //closable
          false, //maximizable
          false);//iconifiable
        setFrameIcon(new ImageIcon(ep.cheminDossier+"images/dessinico.gif"));
        monjmp = new JMenuPanel(ep,bool,adapt);
	getContentPane().setLayout(new BorderLayout());
        getContentPane().add(monjmp,BorderLayout.CENTER);
        setPreferredSize(new Dimension (70,125));
        setLocation(0,30);
        setVisible(true);
        toFront();
	pack();
        show();
        
    }
    
    public void setEdtp(Composition compo){
        monjmp.setEdtp(compo);
    }
    
   
 
        

}
