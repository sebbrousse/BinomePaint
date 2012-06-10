import java.lang.Math;
import java.awt.*;

public class Ellipse extends Rectangle
{
     public Ellipse(Point p, int longu,int larg, float angle)
    {
    	super(p,longu,larg,angle);
    }
    public Ellipse(Point p1, Point p2)
    {
	super(p1,p2);
        
    }
public Ellipse(int x1,int y1,int x2, int y2)
{
	super(x1,y1,x2,y2);
}

public Ellipse(Ellipse ellipse)
{
	super(ellipse.pos,ellipse.d1,ellipse.d2,ellipse.alpha);
}

public int  aire()
{
    return (d1*d2);///pas bon calcul d'aire
}

public int perimetre()
{
    return (2*(d1+d2)); //pas bon calcul de perimetre
}

public void afficher()///on s'en fout
{
    System.out.println("Ellipse : ");
    System.out.println("Debut: ("+getDebut().getX()+" , "+getDebut().getY()+") fin : ("+getFin().getX()+" , "+getFin().getY()+")");
    System.out.println("position: ("+getDebut().getX()+" , "+getDebut().getY()+")");
    System.out.println("longueur : "+d1);
    System.out.println("angle : "+alpha);
}

public void dessine(Graphics g)
{
    Graphics2D g2d;
    g2d = (Graphics2D)g;
    if(getPointille()>0)
        {
    	float brisure[]={getPointille()+1.0f};
    	g2d.setStroke(new BasicStroke(getEpaisseur(),BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f,brisure,0.0f));
        }
    else g2d.setStroke(new BasicStroke(getEpaisseur()));
    
    g2d.setColor(getBackColor());  
    g2d.fillOval(getDebut().getX(),getDebut().getY(),getLongueur(),getLargeur());
    g2d.setColor(getColor());
    g2d.drawOval(getDebut().getX(),getDebut().getY(),getLongueur(),getLargeur());
    
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


