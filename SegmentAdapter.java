
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SegmentAdapter extends MouseAdapter implements MouseMotionListener
{
    protected Point pointDebut;
    protected Point pointFin;
    protected Segment s;
    protected EditeurPanel maZoneEdition;

    public SegmentAdapter()
    {
        super();
    }
    
    public SegmentAdapter(EditeurPanel  zoneEdition)
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
	s = new Segment(pointDebut,pointFin);
	maZoneEdition.addSegment(s);
    }
   
    public void mouseDragged(MouseEvent e)
    {
	pointFin = new Point(e.getX(),e.getY());
        pointDebut.afficher();
 	s= new Segment(pointDebut,pointFin);
        s.afficher();
        maZoneEdition.addMotionSegment(s);
    }
    
    public void mouseMoved(MouseEvent e) {
    }
    
}
