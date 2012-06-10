import java.lang.Math;
import java.awt.*;

public class Texte extends Rectangle
{
    public String texte;


    public Texte(String letexte,Point p1, Point p2)
    {
        super(p1,p2);
	texte = letexte;
    }

    public Texte(Texte text)
    {
	this(text.getTexte(),text.getDebut(),text.getFin());
    }

    public void dessine(Graphics g)
    {
	Graphics2D g2d;
	g2d = (Graphics2D)g;
    
    
        g2d.setColor(getColor());
        g2d.drawString(texte,getDebut().getX()+7,getDebut().getY()+15);
	
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

public String getTexte(){
    return texte;
}


}
