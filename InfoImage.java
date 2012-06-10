
public class InfoImage extends Figure
{
    public String name,monchemin;
    public Point ptDeb;
    public Point ptFin;
    
    
    public InfoImage(String filename,String chemin,Point deb,Point fin){
        name = filename;
        monchemin = chemin;
        ptDeb = deb;
        ptFin = fin;
        dessin = true;
        
    }
    
    public String getFilename(){
        return name;
    }
    public Point getDebut(){
        return ptDeb;
    }
    public Point getFin(){
        return ptFin;
    }
    
    public boolean checkPoint(Point p) {
        return false;
    }
    
}