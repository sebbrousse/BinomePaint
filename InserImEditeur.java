
import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class InserImEditeur extends JInternalFrame {

    protected InserImPanel moniip;
    protected Editeur edt;
    

    public InserImEditeur(Editeur ep,JMenuAdapter adapt)
    {
	super("Images",
          false, //resizable
          false, //closable
          false, //maximizable
          true);//iconifiable
        edt=ep;
        setFrameIcon(new ImageIcon(edt.cheminDossier+"images/imageico.gif"));
        moniip = new InserImPanel(edt,adapt);
	getContentPane().setLayout(new BorderLayout());
        getContentPane().add(moniip,BorderLayout.CENTER);
        setPreferredSize(new Dimension (160,310));
        setLocation(863,30);
        setVisible(true);
        toFront();
	pack();
        show();
        
    }
    
    public void setEdtp(Composition compo){
        moniip.setEdtp(compo);
    }

}
