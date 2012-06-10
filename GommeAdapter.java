import java.awt.event.*;
import java.awt.*;


public class GommeAdapter extends CrayonAdapter
{
    protected Gomme gom;
    
    public GommeAdapter(EditeurPanel zoneEdition) 
    {
        super(zoneEdition);
    }
    public void mouseDragged(MouseEvent e)
    {
	pt = new Point(e.getX(),e.getY());
	gom.addPoint(pt);
        maZoneEdition.addMotionCrayon(gom);
    }

    public void mouseMoved(MouseEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
	 gom = new Gomme();
    }

    public void mouseReleased(MouseEvent e)
    {
        maZoneEdition.addCrayon(gom);
    }
}
