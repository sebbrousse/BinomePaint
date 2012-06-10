import javax.swing.*;
import java.awt.event.*;

public class InserImAdapter extends MouseAdapter implements MouseMotionListener
{
    protected Point pointDebut;
    protected Point pointFin;
    protected DessinImage r;
    protected EditeurPanel maZoneEdition;
    protected String filename,monchemin;

    public InserImAdapter(String name,String chemin,EditeurPanel  zoneEdition)
    {
	super();
	maZoneEdition = zoneEdition;
        filename = name;
        monchemin = chemin;
	
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
        System.out.println(monchemin+filename);
	r = new DessinImage(filename,monchemin,maZoneEdition,pointDebut,pointFin);
	maZoneEdition.addDessinImage(r);
    }
   
    public void mouseDragged(MouseEvent e)
    {
        if ((Math.abs(e.getX()-pointDebut.getX())>1)&&(Math.abs(e.getY()-pointDebut.getY())>1)){
            pointFin = new Point(e.getX(),e.getY());
            r = new DessinImage(filename,monchemin,maZoneEdition,pointDebut,pointFin);
            maZoneEdition.addMotionDessinImage(r);
        }
    }
    
    public void mouseMoved(MouseEvent e)
    {
    }
    
}

