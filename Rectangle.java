import java.lang.Math;
import java.awt.*;

public class Rectangle extends Figure2D
{
    public Rectangle()
    {
    }
    public Rectangle(Point p, int longu,int larg, float angle)
    {
    	super(p,longu,larg,angle);
    }
    public Rectangle(Point p1, Point p2)
    {
        this(p1.getX(),p1.getY(),p2.getX(), p2.getY());
        setEpaisseur(1);
        ajuster(p1, p2);                
    }
    public Rectangle(int x1,int y1,int x2, int y2)
    {
	super(x1,y1);
        pos2 = new Point(x2, y2);
	d1 = (int)Math.abs(x2-x1);
      	d2 = (int)Math.abs(y2-y1);
	alpha = (float)Math.toDegrees(Math.atan2(y2-y1,x2-x1));
        

    }
    public Rectangle(Rectangle rectangle)
    {
    super(rectangle.pos);
    d1 = rectangle.d1;
    d2 = rectangle.d2;
    alpha = rectangle.alpha;
   
    }

public Point getDebut()
{   
    return pos;
}

public Point getFin()
{   
    return pos2;
}

public int  aire()
{
    return (d1*d2);
}

public int perimetre()
{
    return (2*(d1+d2));
}

public boolean checkPoint(Point p)
{
    if ((p.getX() >= getDebut().getX()-5) && (p.getX() <= getFin().getX()+5) && (p.getY() >= getDebut().getY()-5) && (p.getY() <= getFin().getY()+5))
        return true;
    else return false;
}

public void agrandir(Point p,int coin)
{
    if (coin == 1)
	{
	    deplacer(p.getX(),p.getY());
	    ajuster(getDebut(),getFin());
	}
if (coin == 2)
	{
	    if ((p.getY()<getFin().getY())&&(p.getX()>getDebut().getX()))
	    {
	    getDebut().setY(p.getY());
	    getFin().setX(p.getX());
	    }
	    ajuster(getDebut(),getFin());
	}
if (coin == 3)
	{
	    if ((p.getY()>getDebut().getY())&&(p.getX()<getFin().getX()))
		{
		getDebut().setX(p.getX());
	        getFin().setY(p.getY());
		}
	    ajuster(getDebut(),getFin());
     	}
if (coin == 4)
	{
	    if ((p.getX()>getDebut().getX())&&(p.getY()>getDebut().getY()))
		pos2.deplacer(p);
	    ajuster(getDebut(),getFin());
	}
setLongueur(Math.abs(getFin().getX()-getDebut().getX()));
setLargeur(Math.abs(getFin().getY()-getDebut().getY()));
    
}

public void deplacer(Point p)  //gerer par rapport au d�placement et non le nouveau point 
{
    deplacer(p.getX(),p.getY());
    getFin().deplacer(p.getX()+getLongueur(),p.getY()+getLargeur());
    afficher();
}

public void afficher()///on s'en fout
{
    System.out.println("Rectangle : ");
    System.out.println("Debut: ("+getDebut().getX()+" , "+getDebut().getY()+") fin : ("+getFin().getX()+" , "+getFin().getY()+")");
    System.out.println("position: ("+getDebut().getX()+" , "+getDebut().getY()+")");
    System.out.println("longueur : "+d1);
    System.out.println("angle : "+alpha);
    System.out.println("selection : "+selected);
}

public void dessine(Graphics g)
{
    Graphics2D g2d;
    g2d = (Graphics2D)g;
    
    if(getPointille()>0)
	  {
    	float brisure[]={getPointille()+0.0f};
    	g2d.setStroke(new BasicStroke(getEpaisseur(),BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f,brisure,0.0f));
          }
    else g2d.setStroke(new BasicStroke(getEpaisseur()));
      
    g2d.setColor(getBackColor());
    g2d.fillRect(getDebut().getX(),getDebut().getY(),getLongueur(),getLargeur());
    g2d.setColor(getColor());
    g2d.drawRect(getDebut().getX(),getDebut().getY(),getLongueur(),getLargeur());
   
    
    if (selected) 
    {
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.black);
        g2d.drawRect((getDebut().getX()-5),(getDebut().getY()-5),10,10);
        g2d.drawRect((getFin().getX()-5),(getDebut().getY()-5),10,10);
        g2d.drawRect((getDebut().getX()-5),(getFin().getY()-5),10,10);
        g2d.drawRect((getFin().getX()-5),(getFin().getY()-5),10,10);
        g2d.setColor(Color.white);
        g2d.fillRect((getDebut().getX()-5),(getDebut().getY()-5),10,10);
        g2d.fillRect((getFin().getX()-5),(getDebut().getY()-5),10,10);
        g2d.fillRect((getDebut().getX()-5),(getFin().getY()-5),10,10);
        g2d.fillRect((getFin().getX()-5),(getFin().getY()-5),10,10);
        
    } 
}


}



