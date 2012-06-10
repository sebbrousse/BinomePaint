import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CrayonAdapter extends MouseAdapter implements MouseMotionListener
{
    protected Point pt;
    protected Crayon cray;
    protected EditeurPanel maZoneEdition;

    public CrayonAdapter(EditeurPanel  zoneEdition)
    {
	super();
	maZoneEdition = zoneEdition;
	
    }
   
    public void mouseDragged(MouseEvent e)
    {
	pt = new Point(e.getX(),e.getY());
	cray.addPoint(pt);
        maZoneEdition.addMotionCrayon(cray);
    }

    public void mouseMoved(MouseEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
	 cray = new Crayon();
    }

    public void mouseReleased(MouseEvent e)
    {
    	maZoneEdition.addCrayon(cray);
    }

    
}
