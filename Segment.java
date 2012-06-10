import java.lang.Math;
import java.awt.*;

public class Segment extends Figure
{
    public Segment(Point p, int l, float angle)
    {
	super(p,l,angle);
    }
    public Segment(Point p1, Point p2)
    {
	this(p1.getX(),p1.getY(),p2.getX(),p2.getY());
	

    }
    public Segment(int x1,int y1,int x2, int y2)
    {
	super(x1,y1);
	d1 = (int)Math.round(Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2)));
      	alpha = (float)Math.toDegrees(Math.atan2(y2-y1,x2-x1));
        

    }
    public Segment(Segment segment)
    {
    super(segment.pos);
    d1 = segment.d1;
    alpha = segment.alpha;
   
    }
    public Point getDebut()
    {
    return pos;
    }
    
    public Point getFin()
    {   
    Point p1;
    return  p1 = new Point((int)Math.round(pos.getX()+Math.cos(Math.toRadians(alpha))*d1),(int)Math.round(pos.getY()+Math.sin(Math.toRadians(alpha))*d1));
    }

    
    public boolean checkPoint(Point p)
    {
        float coef = ((float)(getFin().getY()- getDebut().getY())/(float)(getFin().getX()- getDebut().getX()));
        boolean b1,b2,b3,b4;
        b1=((p.getY() - getDebut().getY())>=(coef*(p.getX()-getDebut().getX())-5));
        b2=((p.getY()-getDebut().getY())<=(coef*(p.getX()-getDebut().getX()))+5);
        b3=((p.getX() <= getDebut().getMaxX(getFin()).getX()));
        b4=((p.getX() >= getDebut().getMinX(getFin()).getX()));
       
        if (b1&&b2&&b3&&b4)
            return true;
        else return false;
    }
    
    public void afficher()
    {
    System.out.println("Segment : ");
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
        
    g.setColor(getColor());
    g.drawLine(getDebut().getX(),getDebut().getY(),getFin().getX(),getFin().getY());
    if (selected) 
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
    
    
}




