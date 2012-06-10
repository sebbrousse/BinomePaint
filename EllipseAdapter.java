import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EllipseAdapter extends MouseAdapter implements MouseMotionListener
{
    protected Point pointDebut;
    protected Point pointFin;
    protected Ellipse el;
    protected EditeurPanel maZoneEdition;

    public EllipseAdapter(EditeurPanel  zoneEdition)
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
	el = new Ellipse(pointDebut,pointFin);
	maZoneEdition.addEllipse(el);
    }
   
    public void mouseDragged(MouseEvent e)
    {
        pointFin = new Point(e.getX(),e.getY());
        el = new Ellipse(pointDebut,pointFin);
        maZoneEdition.addMotionEllipse(el);
    }
    
    public void mouseMoved(MouseEvent e) {
    }
    
}
