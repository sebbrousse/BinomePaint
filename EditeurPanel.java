import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.util.*;

public class EditeurPanel extends JPanel
{   
   
    protected Vector mesFigures = new Vector();
    protected Vector maMotion = new Vector();
    protected Vector buffer = new Vector();
    protected Vector mesActions = new Vector();
    protected Vector bufferActions = new Vector();
    protected int count;
    protected Vector places = new Vector();
    protected int taille;
    
    
    
    public EditeurPanel(){
	this(new Dimension(10,10));
    }

    public EditeurPanel(int largeur, int hauteur){
	this(new Dimension(largeur,hauteur));
    }

    public EditeurPanel(Dimension dim){
	setPreferredSize(dim);
        count = 0;
        taille = 0;
    }

    public Vector getVector()
    {
	return mesFigures;
    }

    public void setVector(Vector vect)
    {
	mesFigures = vect;
    }

public void addMotionSegment(Segment segment)
{   
    maMotion.add(segment);
    repaint();
}
public void addSegment(Segment segment)
    {
        mesFigures.add(segment);
        places.add(taille-count,new Integer(mesFigures.size()-1));
	mesActions.add((taille++)-count,"figure");
        repaint();
       
    }

public void addRectangle(Rectangle rectangle)
    {
	mesFigures.add(rectangle);
        places.add(taille-count,new Integer(mesFigures.size()-1));
	mesActions.add((taille++)-count,"figure");
	repaint();
       
    }

public void addMotionRectangle(Rectangle rectangle)
{   
    maMotion.add(rectangle);
    repaint();
}

public void addEllipse(Ellipse ellipse)
    {
	mesFigures.add(ellipse);
        places.add(taille-count,new Integer(mesFigures.size()-1));
	mesActions.add((taille++)-count,"figure");
        repaint();
    }

public void addMotionEllipse(Ellipse ellipse)
{   
    maMotion.add(ellipse);
    repaint();
}
public void addCercle(Cercle cercle)
    {
	mesFigures.add(cercle);
        places.add(taille-count,new Integer(mesFigures.size()-1));
	mesActions.add((taille++)-count,"figure");
        repaint();
    }

public void addMotionCercle(Cercle cercle)
{   
    maMotion.add(cercle);
    repaint();
}

public void addCarre(Carre carre)
    {
	mesFigures.add(carre);
        places.add(taille-count,new Integer(mesFigures.size()-1));
	mesActions.add((taille++)-count,"figure");
        repaint();
    }

public void addMotionCarre(Carre carre)
{   
    maMotion.add(carre);
    repaint();
}

public void addMotionCrayon(Crayon crayon)
    {   
       maMotion.add(crayon);
       repaint();
    }
public void addCrayon(Crayon crayon)
    {
	mesFigures.add(crayon);
        places.add(taille-count,new Integer(mesFigures.size()-1));
	mesActions.add((taille++)-count,"figure");
        repaint();
    }

public void addMotionSelection(Selection selection)
    {
	maMotion.add(selection);
	repaint();
    }

public void addTexte(Texte text){
    mesFigures.add(text);
        places.add(taille-count,new Integer(mesFigures.size()-1));
	mesActions.add((taille++)-count,"figure");
    repaint();
}

public void addDessinImage(DessinImage desim)
    {
	mesFigures.add(desim);
        places.add(taille-count,new Integer(mesFigures.size()-1));
	mesActions.add((taille++)-count,"figure");
        repaint();
       
    }

public void addMotionDessinImage(DessinImage desim)
    {   
        maMotion.add(desim);
        repaint();
    }


public void addSelection(Selection selection)
    {
	setSelection(selection);  
	repaint();
    }

public void setSelection(Selection sel)
    {
       
        for(int i=0;i<mesFigures.size();i++)
        {
            
	    if (sel.selectionne((Figure)mesFigures.elementAt(i)))
		{
		    
                    ((Figure)mesFigures.elementAt(i)).setSelected(true);
		}
        }
    }

public void unSelection()
{
    for(int i=0;i<mesFigures.size();i++)
        {
	    ((Figure)mesFigures.elementAt(i)).setSelected(false);
        }
    repaint();
}



public void abaisser()
{
    int j=0;
    for(int i=0;i<mesFigures.size();i++)
        {
	    
            if(((Figure)mesFigures.elementAt(i)).getSelected())
            {
                 
                mesFigures.add(j,mesFigures.elementAt(i));
                j++;
                mesFigures.remove(i+1);
            }
        }
    mesActions.add("abaisser");
        places.add((taille++)-count,new Integer(0));
    repaint();
}

public Figure addPointeurSelection(Point point)
{
    Figure figure = null;   
    boolean bool = true;
        for(int i=mesFigures.size()-1;i>=0;i--)
        {
            if (bool)
            {
	    if (((Figure)mesFigures.elementAt(i)).checkPoint(point))
		{   
		    ((Figure)mesFigures.elementAt(i)).setSelected(true);
                    figure = ((Figure)mesFigures.elementAt(i));
		    bool = false;
                }
            }
        }
	repaint();
	return  figure;
	
}

public void addMotionFigure(Figure figure)
{
    maMotion.add(figure);
    repaint();
}

public void addFigure(Figure figure)
{
    mesFigures.add(figure);
    repaint();
}

public void surelever()
{
    int j=mesFigures.size();
    for(int i=mesFigures.size()-1;i>=0;i--)
        {
	     
            if(((Figure)mesFigures.elementAt(i)).getSelected())
            {
               mesFigures.add(j,mesFigures.elementAt(i));
               j--;
               mesFigures.remove(i);
            }
        }
    mesActions.add("surelever");
    places.add((taille++)-count,new Integer(0));
    repaint();
}

public void undo()
{
        if ((taille-count)>0){
            if (mesActions.elementAt(taille-count-1) == "figure"){
                System.out.println(((Integer)places.elementAt(taille-count-1)).intValue());
                bufferActions.add(mesFigures.elementAt(((Integer)places.elementAt(taille-count-1)).intValue()));}
                mesFigures.remove(((Integer)places.elementAt(taille-count-1)).intValue());
             if (mesActions.elementAt(taille-count-1)== "abaisser"){
                bufferActions.add("abaisser");
                surelever();}
            if (mesActions.elementAt(taille-count-1)== "surelever"){
                bufferActions.add("surelever");
                abaisser();}
         count++;
        }
        else 
            JOptionPane.showMessageDialog(null,"Vous n'avez plus aucune action à annuler.","ANNULER",JOptionPane.ERROR_MESSAGE);
        repaint();
}

public void redo()
{
       
        if (count>0)
        {  
            if (mesActions.elementAt(taille-count) == "figure")
                mesFigures.add((Figure)bufferActions.lastElement());
                bufferActions.remove(bufferActions.lastElement());
            if (mesActions.elementAt(taille-count)== "abaisser"){
                bufferActions.add("abaisser");
                surelever();}
            if (mesActions.elementAt(taille-count)== "surelever"){
                bufferActions.add("surelever");
                abaisser();}
        count--;
        }
        else
             JOptionPane.showMessageDialog(null,"Vous n'avez plus aucune action � restaurer.","RESTAURER",JOptionPane.ERROR_MESSAGE);

        repaint();
        
}

public void effacer()
{
    for(int i=mesFigures.size()-1;i>=0;i--)
        {
	     
            if(((Figure)mesFigures.elementAt(i)).getSelected())
            {
                mesFigures.removeElementAt(i);
            }
    }
    repaint();
}

public void effacerTout()
{
    mesFigures.removeAllElements();
    repaint();
}
                
                
public void afficher()
    {
	 System.out.println("EditeurPanel :");
	 System.out.println("     largeur du panneau d'�dition : "+getWidth());
	 System.out.println("     hauteur du panneau d'�dition : "+getHeight());
    }
    
   

public void paint(Graphics g)
{
    g.setColor(Color.white);
    g.fillRect(0,0,this.getWidth(),this.getHeight());
    g.setColor(Color.black);
     System.out.println("====> m" + mesFigures);
    for(int i=0;i<mesFigures.size();i++)
    {
    	((Figure)mesFigures.elementAt(i)).dessine(g);
    }
    
    
    if (maMotion.size()>0)
	{
    for(int i=0;i<1;i++)
    {
    	((Figure)maMotion.elementAt(i)).dessine(g);
	maMotion.removeAllElements();
    }
	}
    
}


}
