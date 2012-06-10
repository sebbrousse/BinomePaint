import javax.swing.*;
import java.awt.event.*;

public class PointeurAdapter extends MouseAdapter implements MouseMotionListener
{
    
    protected Figure figure;
    protected Point pt;
    protected Point pt1;
    protected EditeurPanel maZoneEdition;
    protected boolean resize = false;
    protected int coin;
    public PointeurAdapter(EditeurPanel zoneEdition)
    {
	maZoneEdition = zoneEdition;
    }

    public void mousePressed(MouseEvent e)
    {
        maZoneEdition.unSelection();
        pt = new Point(e.getX(),e.getY());
        figure = maZoneEdition.addPointeurSelection(pt);
	coin = figure.checkSelectionPoint(pt);
	if (coin>0)
	    resize = true;
	    
        
    }

    public void mouseDragged(MouseEvent e)
    {
	
	pt1 = new Point(e.getX(),e.getY());
	
	if (figure != null)
	    {
		if (resize)
		    figure.agrandir(pt1,coin);
		else
		    figure.deplacer(new Point(figure.getDebut().getX()+(pt1.getX()-pt.getX()),figure.getDebut().getY()+(pt1.getY()-pt.getY())));
	    }
	pt = pt1;
	maZoneEdition.repaint();
    }


    public void mouseReleased(MouseEvent e)
    {
	resize = false;
    }
    public void mouseMoved(MouseEvent e)
    {
    }	
    
}
