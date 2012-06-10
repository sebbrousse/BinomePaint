

public class Cercle extends Ellipse
{

public Cercle(Point p, int l, float angle)
    {
    	super(p,l,l,angle);
    }

public Cercle(int x1,int y1,int x2, int y2)
    {
	super(x1,y1,x2,y2);
       	if (getLongueur()>getLargeur())
	    setLargeur(getLongueur());
	else setLongueur(getLargeur());
        pos2 = new Point(pos.getX()+getLongueur(),pos.getY()+getLargeur());
    }

public Cercle(Point p1, Point p2)
    {
	super(p1,p2);
        if (getLongueur()>getLargeur())
	    setLargeur(getLongueur());
	else setLongueur(getLargeur());
        pos2 = new Point(pos.getX()+getLongueur(),pos.getY()+getLargeur());
    }
public  Cercle(Cercle cercle)
    {
	super(cercle.pos,cercle.d1,cercle.d2,cercle.alpha);
    }

public void afficher()///on s'en fout
{
    System.out.println("Cercle : ");
    System.out.println("Debut: ("+getDebut().getX()+" , "+getDebut().getY()+") fin : ("+getFin().getX()+" , "+getFin().getY()+")");
    System.out.println("position: ("+getDebut().getX()+" , "+getDebut().getY()+")");
    System.out.println("longueur : "+d1);
    System.out.println("angle : "+alpha);
}

    ///dessine(g) est le meme que ellipse...

}
