
public class Carre extends Rectangle
{

    public Carre(Point p, int l, float angle)
    {
    	super(p,l,l,angle);
    }

    public Carre(int x1, int y1, int x2, int y2)
    {
	super(x1,y1,x2,y2);
	if (getLongueur()>getLargeur())
	    setLargeur(getLongueur());
	else setLongueur(getLargeur());
        pos2 = new Point(pos.getX()+getLongueur(),pos.getY()+getLargeur());
    }

    public Carre(Point p1, Point p2)
    {
	super(p1,p2);
     	if (getLongueur()>getLargeur())
	    setLargeur(getLongueur());
	else setLongueur(getLargeur());
        pos2 = new Point(pos.getX()+getLongueur(),pos.getY()+getLargeur());
        
    }

    public Carre(Carre carre)
    {
    this(carre.pos,carre.d1,carre.alpha);
    }   

public void afficher()
{
    System.out.println("Carré : ");
    System.out.println("Debut: ("+getDebut().getX()+" , "+getDebut().getY()+") fin : ("+getFin().getX()+" , "+getFin().getY()+")");
    System.out.println("position: ("+getDebut().getX()+" , "+getDebut().getY()+")");
    System.out.println("longueur : "+d1);
    System.out.println("angle : "+alpha);
}


}

//public void dessine(Graphics g)
//gerer le point de depart icic!!!!!
