
import java.lang.Math;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.Image;
import java.lang.Object;

public class MyImage  implements Serializable
{   
    protected Image LImage;
    protected int largeur;
    protected int hauteur;
    
    public MyImage(String filename)
    {   
        LImage = Toolkit.getDefaultToolkit().getImage(filename);
    }
    
    public MyImage(String filename, int longu,int larg)
    {   
        this(filename);
        largeur = longu;
        hauteur = larg;
        LImage = LImage.getScaledInstance(largeur,hauteur,LImage.SCALE_DEFAULT);
    }
    
    public MyImage(String filename,Point p1, Point p2)
    {       
        this(filename,p2.getX()-p1.getX(), p2.getY()-p1.getY());
        largeur = p2.getX()-p1.getX();
        hauteur = p2.getY()-p1.getY();
    }
    
    public MyImage(String filename,int x1,int y1,int x2, int y2)
    {
	this(filename,x2-x1, y2-y1);
        largeur = x2-x1;
        hauteur = y2-y1;
    }
    
    public MyImage(MyImage im)
    {
        LImage = im.getImg();
        largeur = im.getWidth();
        hauteur = im.getHeight();
    }

public int getHeight() {
    return hauteur;
}

public int getWidth() {
    return largeur;
}


public Image getImg(){
   return LImage;
}

}



