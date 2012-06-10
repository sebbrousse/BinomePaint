import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class TexteEditeur extends JInternalFrame {

    protected TextePanel montp;
    protected Editeur edt;
    

    public TexteEditeur(Editeur ep,JMenuAdapter adapt)
    {
	super("Texte",
          false, //resizable
          false, //closable
          false, //maximizable
          true);//iconifiable
        edt=ep;
        setFrameIcon(new ImageIcon(edt.cheminDossier+"images/texteico.gif"));
        montp = new TextePanel(edt,adapt);
	getContentPane().setLayout(new BorderLayout());
        getContentPane().add(montp,BorderLayout.CENTER);
        setPreferredSize(new Dimension (160,80));
        setLocation(703,30);
        setVisible(true);
        toFront();
	pack();
        show();
        
    }
    
    public void setEdtp(Composition compo){
        montp.setEdtp(compo);
    }

}
