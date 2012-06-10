import javax.swing.*;
import java.awt.event.*;

public class CarreAdapter extends MouseAdapter implements MouseMotionListener
{
    protected Point pointDebut;
    protected Point pointFin;
    protected Carre c;
    protected EditeurPanel maZoneEdition;

    public CarreAdapter(EditeurPanel zoneEdition)
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
	c = new Carre(pointDebut,pointFin);
	maZoneEdition.addCarre(c);
    }
   
    public void mouseDragged(MouseEvent e) 
    {
        pointFin = new Point(e.getX(),e.getY());
	if (pointDebut.getX()<pointFin.getX())
	    {
	    if (pointDebut.getY()<pointFin.getY())
		c = new Carre(pointDebut,pointFin);
	    else c = new Carre(pointDebut.getX(),pointFin.getY(),pointFin.getX(),pointDebut.getY());
	    }
	        else {
	  if (pointDebut.getY()<pointFin.getY())
		c = new Carre(pointFin.getX(),pointDebut.getY(),pointDebut.getX(),pointFin.getY());
	  else c = new Carre(pointFin,pointDebut);
	    }
        maZoneEdition.addMotionCarre(c);
    }
    
    public void mouseMoved(MouseEvent e) {
    }
    
}
