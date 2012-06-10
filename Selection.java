import java.awt.*;


public class Selection extends Rectangle
{

   
 public Selection(Point p, int longu,int larg, float angle)
    {
    	super(p,longu,larg,angle);
    }
    public Selection(Point p1, Point p2)
    {
        super(p1,p2);
        setColor(Color.blue);
        setContour(true); //mettre contour en pointille
        setPointille(4);
    }
    public Selection(int x1,int y1,int x2, int y2)
    {
	super(x1,y1,x2,y2);
    }       
    public Selection(Selection selection)
    {
        super(selection);
    }

    public boolean selectionne(Figure figure)
    {
        if ((figure.getDebut().getX() > getDebut().getX()) && (figure.getFin().getX() < getFin().getX()) && (figure.getDebut().getY() > getDebut().getY()) && (figure.getFin().getY() < getFin().getY()))
        return true;
        else return false;
    }
}
