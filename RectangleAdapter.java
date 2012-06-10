import javax.swing.*;
import java.awt.event.*;

public class RectangleAdapter extends MouseAdapter implements MouseMotionListener
{
    protected Point pointDebut;
    protected Point pointFin;
    protected Rectangle r;
    protected EditeurPanel maZoneEdition;

    public RectangleAdapter(EditeurPanel  zoneEdition)
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
	r = new Rectangle(pointDebut,pointFin);
	maZoneEdition.addRectangle(r);
    }
   
    public void mouseDragged(MouseEvent e)
    {
        pointFin = new Point(e.getX(),e.getY());
        r = new Rectangle(pointDebut,pointFin);
        maZoneEdition.addMotionRectangle(r);
    }
    
    public void mouseMoved(MouseEvent e)
    {
    }
    
}
