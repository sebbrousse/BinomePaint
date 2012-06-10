import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CercleAdapter extends MouseAdapter implements MouseMotionListener
{
    protected Point pointDebut;
    protected Point pointFin;
    protected Cercle cl;
    protected EditeurPanel maZoneEdition;

    public CercleAdapter(EditeurPanel  zoneEdition)
    {
	super();
	maZoneEdition = zoneEdition;
	
    }

    public void mousePressed(MouseEvent e)
    {
	pointDebut = new Point(e.getX(),e.getY());
	System.out.println("Debut : ");
	pointDebut.afficher();
	
    }

    public void mouseReleased(MouseEvent e)
    {
	pointFin = new Point(e.getX(),e.getY());
	System.out.println("Fin : ");
	pointFin.afficher();
	cl = new Cercle(pointDebut,pointFin);
	maZoneEdition.addCercle(cl);
    }
   
    public void mouseDragged(MouseEvent e)
    {
        pointFin = new Point(e.getX(),e.getY());
        cl = new Cercle(pointDebut,pointFin);
        maZoneEdition.addMotionCercle(cl);
    }
    
    public void mouseMoved(MouseEvent e) {
    }
    
}
