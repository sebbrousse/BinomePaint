import javax.swing.*;
import java.awt.event.*;

public class TexteAdapter extends MouseAdapter
{
    protected Point pointDebut;
    protected Point pointFin;
    protected Texte t;
    protected EditeurPanel maZoneEdition;
    protected String texte;

    public TexteAdapter(String letexte,EditeurPanel  zoneEdition)
    {
	super();
	maZoneEdition = zoneEdition;
	System.out.println(letexte);
	texte=letexte;
	
    }

    public void mousePressed(MouseEvent e)
    {
	System.out.println("Mousepressed text======> "+texte);
	pointDebut = new Point(e.getX(),e.getY());
	
    }

    public void mouseReleased(MouseEvent e)
    {

	pointFin = new Point(pointDebut.getX()+texte.length()*10,pointDebut.getY()+20);
	System.out.println("Fin : ");
	pointFin.afficher();
	t = new Texte(texte,pointDebut,pointFin);
	maZoneEdition.addTexte(t);

    }

    
}
