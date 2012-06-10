import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JPanel.*;
import java.awt.*;
import java.lang.*;

public class JBarEditeur extends JInternalFrame{

    protected Editeur edt;
    protected Composition mycompo;
    protected JBarPanel menupanel;

    public JBarEditeur(Editeur ep)
    {
	super();
        edt=ep;
        getContentPane().setLayout(new BorderLayout());
        menupanel = new JBarPanel(edt);
        getContentPane().add(menupanel,BorderLayout.WEST);
	setPreferredSize(new Dimension(1033,60));
        setLocation(-5,-30);
        setVisible(true);
        toFront();
	pack();
        show();
        
    }
    
    public void setEdtp(Composition compo){
        mycompo = compo;
        menupanel.setEdtp(compo);
    }
    
    public Composition getcible(){
        return mycompo;
    }

}
