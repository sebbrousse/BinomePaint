import java.util.*;
import java.awt.*;

public class Gomme  extends Crayon
{
    
    
    public Gomme() 
    {
        super();
        setColor(Color.white); //gerer avce la couleur de fond
        setEpaisseur(15);    //gerer l'epaisseur
    }
    
    public void dessine(Graphics g)
    {
        Graphics2D g2d;
        g2d = (Graphics2D)g;
        
        for(int i=0;i<(mesPoints.size()-1);i++)
        {                                                     Segment seg = new Segment(((Point)mesPoints.elementAt(i)),((Point)mesPoints.elementAt(i+1)));
            seg.setColor(Color.white);
            seg.setEpaisseur(getEpaisseur());
            seg.setSelected(getSelected());
            seg.dessine(g2d);
        }
    }
}
