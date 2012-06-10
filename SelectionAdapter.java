import javax.swing.*;
import java.awt.event.*;

public class SelectionAdapter extends RectangleAdapter
{
    
    protected Selection s;

    public SelectionAdapter(EditeurPanel zoneEdition)
    {
	super(zoneEdition);
    }

    public void mouseClicked(MouseEvent e)
    {
        maZoneEdition.unSelection();
    }
    
    public void mouseDragged(MouseEvent e)
    {
        pointFin = new Point(e.getX(),e.getY());
        s = new Selection(pointDebut,pointFin);
        maZoneEdition.addMotionSelection(s);
    }
    
    public void mouseReleased(MouseEvent e)
    {
	pointFin = new Point(e.getX(),e.getY());
	s = new Selection(pointDebut,pointFin);
	maZoneEdition.addSelection(s);
        
    }



}
