import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Point implements Dessinable,Serializable
{
     
    private int abscisse;
    private int ordonnee;
    
     
    public Point(int x,int y)
    {
	abscisse = x;
	ordonnee = y;
    }
    public Point(Point p)

    {
	abscisse = p.abscisse;
	ordonnee = p.ordonnee;
    }

    public int getX()
    {
	return abscisse;
    }
     public int getY()
    {
	return ordonnee;
    }
     public void setX(int x)
    {
	abscisse = x;
    }
     public void setY(int y)
    {
	ordonnee = y;
    }
     public void afficher()
    {
	System.out.println("Point : ");
	System.out.println("("+abscisse+" ,"+ordonnee+" )");
    }
    public  void deplacer(int x,int y)
    {
	setX(x);
	setY(y);
    }
    public  void deplacer(Point p)
    {
	setX(p.abscisse);
	setY(p.ordonnee);
    }
    
    public void dessine(Graphics g)
    {
	g.drawLine(abscisse,ordonnee,abscisse,ordonnee);
    }
    
    public Point getMinX(Point p)
    {
        if (this.getX()<p.getX())
            return this;     
        else 
            return p;
    }
        
    public Point getMinY(Point p)
    {
        if (this.getY()<p.getY())
            return this;     
        else 
            return p;
    }
     public Point getMaxX(Point p)
    {
        if (this.getX()>p.getX())
            return this;     
        else 
            return p;
    }
        
    public Point getMaxY(Point p)
    {
        if (this.getY()>p.getY())
            return this;     
        else 
            return p;
    }
}
