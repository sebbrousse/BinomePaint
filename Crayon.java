import java.util.*;
import java.awt.*;

public class Crayon extends Figure
{
    protected Vector mesPoints = new Vector();
    
    
    public Crayon()
    {selected = false;
    }
    
    public Crayon(Point p1) 
    {   
        mesPoints.add(p1);
        selected = false;
    }
    
    public void addPoint(Point point)
    {
        
        mesPoints.add(point);
    }
    
    public void dessine(Graphics g)
    {
        Graphics2D g2d;
        g2d = (Graphics2D)g;
        for(int i=0;i<(mesPoints.size()-1);i++)
        {
            Segment seg = new Segment(((Point)mesPoints.elementAt(i)),((Point)mesPoints.elementAt(i+1)));
            seg.selected = false;
            seg.setPointille(getPointille());
	    seg.setColor(getColor());
	    seg.setEpaisseur(getEpaisseur()); 
            seg.dessine(g);
        }
	if (getSelected())
	    {
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(Color.black);
		g2d.drawRect((getDebut().getX()-5),(getDebut().getY()-5),10,10);
		g2d.drawRect((getFin().getX()-5),(getFin().getY()-5),10,10);
		g2d.setColor(Color.white);
		g2d.fillRect((getDebut().getX()-5),(getDebut().getY()-5),10,10);
		g2d.fillRect((getFin().getX()-5),(getFin().getY()-5),10,10);
	    }
    }
    public boolean checkPoint(Point p)
    {   
        boolean bool =false;
        for(int i=0;i<(mesPoints.size()-1);i++)
        {
            if (bool==false)
            {
            Segment seg = new Segment(((Point)mesPoints.elementAt(i)),((Point)mesPoints.elementAt(i+1)));
            bool = seg.checkPoint(p);
            }
        }
        return bool;
    }
    
    public Point getDebut() 
    {
        return pos = new Point((Point)mesPoints.firstElement());
    }
    
    public Point getFin() 
    {
        return (Point)mesPoints.lastElement();  
    }
    
    public void deplacer(Point p)
    {
      p.deplacer(p.getX()-getDebut().getX(),p.getY()-getDebut().getY());
      for(int i=0;i<=mesPoints.size()-1;i++)
        {
            ((Point)mesPoints.elementAt(i)).setX(p.getX()+((Point)mesPoints.elementAt(i)).getX());
            ((Point)mesPoints.elementAt(i)).setY(p.getY()+((Point)mesPoints.elementAt(i)).getY());
    }
    }
}
