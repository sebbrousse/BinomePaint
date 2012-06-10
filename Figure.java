import java.awt.*;
import java.io.*;
import java.awt.*;

public  class Figure implements Dessinable,Serializable
{
    protected Point pos;  //point de debut de la figure
    protected Point pos2; // point de fin
    protected int d1;
    public boolean dessin = false;
    protected float alpha;   
    protected boolean selected = false; 
    protected boolean contour = false; //si le contour est en pointille ou pas
    protected float epaisseur = 1;  //epaisseur du trait
    protected Color color = Color.black;  //couleur du trait
    protected int pointille = 0;
 
    public Figure()
    {
    }
    public Figure(Point p)
    {   pos = new Point(p);
        setSelected(true);
	
    }
    public Figure(int x,int y)
    {
	this(new Point(x,y));
    }
    public Figure(Point p,int d, float angle)
    {
	this(p);
	d1 = d;
	alpha = angle;
    }
   public Point getPosition() 
   {
	return pos;
   }
    public  Point getDebut(){return pos;}
    public  Point getFin(){return null;}
    
    public void deplacer(int x, int y)
    {   
	pos.deplacer(x,y);
    }
    
    public void deplacer(Point p)
    {
        pos.deplacer(p);
    }
    
    public void agrandir(Point p,int coin)
    {
	
    }
    public int getLongueur()
    {
	return d1;
    }
    public void setLongueur(int longueur)
    {
	d1 = longueur;
    }
    
    public void setTransparence(int remp){
        
    }

    public void setSelected(boolean bool)
    {
	selected = bool;
    }
    
    public boolean getSelected()
    {
	return selected;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void setColor(Color couleur)
    {
        color = couleur;
    }

    public boolean getContour()
    {
        return contour;
    }
    
    public void setContour(boolean bool)
    {
        contour = bool;
    }

    public float getEpaisseur()
    {
        return epaisseur;
    }
    
    public void setEpaisseur(float f)
    {
        epaisseur = f;
    }
    public int getPointille()
    {
        return pointille;
    }
    
    public void setPointille(int f)
    {
        pointille = f;
    }
    public boolean checkPoint(Point p){return false;}
    
    public int checkSelectionPoint(Point p)
    {
	if ((p.getX() >= (getDebut().getX()-5))&& (p.getX() <= (getDebut().getX()+5))&&(p.getY() >= (getDebut().getY()-5))&&(p.getY() <= (getDebut().getY()+5)))
	    return 1;
	if ((p.getX() <= (getFin().getX()+10))&& (p.getX() >= (getFin().getX()-10))&&(p.getY() >= (getDebut().getY()-10))&&(p.getY() <= (getDebut().getY()+10)))
	    return 2;
	if ((p.getX() <= (getDebut().getX()+10))&&(p.getX() >= (getDebut().getX()-10))&&(p.getY() >= (getFin().getY()-10))&&(p.getY() <= (getFin().getY()+10)))
	    return 3;
        if ((p.getX() <= (getFin().getX()+10))&&(p.getX() >= (getFin().getX()-10))&&(p.getY() >= (getFin().getY()-10))&&(p.getY() <= (getFin().getY()+10)))
	    return 4;
	else return 0;
    }
    public void dessine(Graphics g)
    {
    }
}


