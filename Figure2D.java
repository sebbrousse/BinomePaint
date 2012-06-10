import java.awt.*;

public abstract class Figure2D extends Figure
{
    protected int d2;
    protected Color backcolor = Color.white; //couleur de fond de la figure
    protected int transparence = Color.TRANSLUCENT;
    
    
    public Figure2D()
    {
    }

    public Figure2D(Point p)
    {   
        super(p);	
    }
 
    public Figure2D(int x,int y)
    {
	super(new Point(x,y));
    }
 
    public Figure2D(Point p,int d,int dd, float angle)
    {
	super(p);
	d1 = d;
	d2 = dd;
	alpha = angle;
    }
   
    public int aire()
    { 
	return 0;
    }
    
    public int perimetre()
    { 
	return 0;
    }

    public int getLongueur()
    {
	return d1;
    }
    public void setLongueur(int longueur)
    {
	d1 = longueur;
    }

    public int getLargeur()
    {
	return d2;
    }
    public void setLargeur(int largeur)
    {
	d2 = largeur;
    }
    
    public Color getBackColor()
    {
        Color col = new Color(backcolor.getRed(),backcolor.getGreen(),backcolor.getBlue(),transparence);
        return col;
    }
    
    public void setBackColor(Color couleur)
    {
        backcolor = couleur;
    }
    
  
    public int getTransparence()
    {
        return transparence;
    }
    
    public void setTransparence(int trans)
    {
        transparence = trans;
    }
    public void ajuster(Point p1, Point p2)
    {
        pos.setX((p1.getMinX(p2)).getX());
        pos.setY((p1.getMinY(p2)).getY());
        pos2.setX((p1.getMaxX(p2)).getX());
        pos2.setY((p1.getMaxY(p2)).getY());
	System.out.println("debut : "+pos.getX()+" fin "+pos2.getX());
        System.out.println("debut : "+pos.getY()+" fin "+pos2.getY());
    }
    
   
}
