import java.lang.Math;
import java.awt.*;

public class DessinImage extends Rectangle
{
    protected MyImage LImage;
    protected EditeurPanel edtp;
    protected String name,monchemin;
    protected InfoImage info;
    
    
    public DessinImage(String filename,String chemin,EditeurPanel ep)
    {   
        LImage = new MyImage(chemin+filename);
        edtp = ep;
        name = filename;
        monchemin = chemin;
        dessin = true;
    }
    
    public DessinImage(String filename,String chemin,EditeurPanel ep,Point p, int longu,int larg, float angle)
    {
    	super(p,longu,larg,angle);
        LImage = new MyImage(chemin+filename,longu,larg);
        edtp = ep;
        name = filename;
        monchemin = chemin;
        dessin = true;
    }
    public DessinImage(String filename,String chemin,EditeurPanel ep,Point p1, Point p2)
    {
        super(p1,p2);
        LImage = new MyImage(chemin+filename,getDebut(),getFin());      
        edtp = ep;
        name = filename;
        monchemin = chemin;
        dessin = true;
        info = new InfoImage(name,monchemin,p1,p2);
    }
    
    public DessinImage(String filename,String chemin,EditeurPanel ep,int x1,int y1,int x2, int y2)
    {
        super(x1,y1,x2,y2);
        LImage = new MyImage(chemin+filename,x1,y1,x2,x2);      
        edtp = ep;
        name = filename;
        monchemin = chemin;
        dessin = true;
    }
    
    public DessinImage(DessinImage desim)
    {
        super(desim.getDebut(),desim.getFin());
        LImage = desim.LImage;
        edtp = desim.getcible();
        d1 = desim.d1;
        d2 = desim.d2;
        alpha = desim.alpha;
        name = desim.name;
        monchemin = desim.monchemin;
        dessin = true;
    }

public Point getDebut()
{   
    return pos;
}

public Point getFin()
{   
    return pos2;
 }

public String getFilename(){
    return name;
}

public InfoImage getInfo(){
    return info;
}

public int  aire()
{
    return (d1*d2);
}

public int perimetre()
{
    return (2*(d1+d2));
}

public EditeurPanel getcible(){
    return edtp;
}

public void agrandir(Point p,int pt){
    super.agrandir(p,pt);
    LImage = new MyImage(monchemin+name,getDebut(),getFin());
}

public void dessine(Graphics g)
{
    Graphics2D g2d;
    g2d = (Graphics2D)g;
    
    
    g2d.drawImage(LImage.getImg(),getDebut().getX(),getDebut().getY(),getcible());
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




