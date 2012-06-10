import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import java.util.*;

public class JMenuAdapter implements ActionListener
{
    
    public Composition mycompo;
    public TexteAdapter tex;
    public InserImAdapter ima;
    public SegmentAdapter seg;
    public CrayonAdapter cray;
    public RectangleAdapter rect;
    public CarreAdapter car;
    public EllipseAdapter ell;
    public CercleAdapter cer;
    public String filename,monchemin;
    protected SelectionAdapter selbox;
    protected GommeAdapter gom;
    protected PointeurAdapter pointeur;
    
    public JMenuAdapter() {
        
    }
    
    public EditeurPanel getcible(){
	return mycompo.getEdt();
    }
    
    public void setEdtp(Composition compo){
        mycompo = compo;
    }
    
    public void removeAllListener(EditeurPanel ep){
	ep.removeMouseListener(tex);
	ep.removeMouseListener(ima);
        ep.removeMouseMotionListener(ima);
        ep.removeMouseListener(seg);
	ep.removeMouseMotionListener(cray);
	ep.removeMouseListener(cray);
	ep.removeMouseListener(rect);
	ep.removeMouseListener(car);
	ep.removeMouseListener(ell);
	ep.removeMouseListener(cer);
        ep.removeMouseListener(selbox);
        ep.removeMouseListener(pointeur);
	ep.removeMouseMotionListener(pointeur);
        ep.removeMouseMotionListener(selbox);
        ep.removeMouseMotionListener(seg);
	ep.removeMouseMotionListener(rect);
	ep.removeMouseMotionListener(car);
	ep.removeMouseMotionListener(ell);
	ep.removeMouseMotionListener(cer);
        ep.removeMouseListener(gom);
	ep.removeMouseMotionListener(gom);
    }
	

    public void actionPerformed(ActionEvent e){

	System.out.println("actionPerformed");
	removeAllListener(getcible());
        
        if (e.getActionCommand().equals("segment")){
	    System.out.println("action segment");
	    seg = new SegmentAdapter(getcible());
	    getcible().addMouseListener(seg);
            getcible().addMouseMotionListener(seg);
            getcible().unSelection();
        }

	if (e.getActionCommand().equals("crayon")){
	    System.out.println("action crayon");
	    cray = new CrayonAdapter(getcible());
	    getcible().addMouseMotionListener(cray);
	    getcible().addMouseListener(cray);
            getcible().unSelection();
        }

       if (e.getActionCommand().equals("rectangle")){
	    System.out.println("action rectangle");
	    rect = new RectangleAdapter(getcible());
	    getcible().addMouseListener(rect);
            getcible().addMouseMotionListener(rect);
            getcible().unSelection();
       }

       if (e.getActionCommand().equals("carre")){
	    System.out.println("action carre");
	    car = new CarreAdapter(getcible());
	    getcible().addMouseListener(car);
            getcible().addMouseMotionListener(car);
            getcible().unSelection();
       }

       if (e.getActionCommand().equals("ellipse")){
	    System.out.println("action ellipse");
	    ell = new EllipseAdapter(getcible());
	    getcible().addMouseListener(ell);
            getcible().addMouseMotionListener(ell);
            getcible().unSelection();
       }

       if (e.getActionCommand().equals("cercle")){
	    System.out.println("action cercle");
	    cer = new CercleAdapter(getcible());
	    getcible().addMouseListener(cer);
            getcible().addMouseMotionListener(cer);
            getcible().unSelection();
       }
        
        if (e.getActionCommand().equals("select")){
	    System.out.println("action select");
	    }
        if (e.getActionCommand().equals("selectbox")){
	    System.out.println("action select");
	    selbox = new SelectionAdapter(getcible());
            getcible().addMouseMotionListener(selbox);
            getcible().addMouseListener(selbox);
            }
        if (e.getActionCommand().equals("gomme")){
	    System.out.println("action gomme");
            gom = new GommeAdapter(getcible());
            getcible().addMouseMotionListener(gom);
            getcible().addMouseListener(gom);
            getcible().unSelection();            
	    }
        
        if (e.getActionCommand().equals("attente")){
	    System.out.println("action attente");
            getcible().unSelection();
	    }
        if (e.getActionCommand().equals("pointeur")){
	    System.out.println("action pointeur");
            pointeur = new PointeurAdapter(getcible());
            getcible().addMouseListener(pointeur);
	    getcible().addMouseMotionListener(pointeur);
	    }
        if (e.getActionCommand().equals("abaisser")){
	    System.out.println("action abaisser");
            getcible().abaisser();
	    }
        if (e.getActionCommand().equals("surelever")){
	    System.out.println("action surelever");
            getcible().surelever();
	    }
        if (e.getActionCommand().equals("inserer")){
	    System.out.println("action inserer");
            ima = new InserImAdapter(filename,monchemin,getcible());
	    getcible().addMouseListener(ima);
            getcible().addMouseMotionListener(ima);
	}

        
        
    }

    public void setFilename(String name,String chemin){
            filename = name;
            monchemin = chemin;
        }

    public void setTexte(String text){
	System.out.println(text);
	removeAllListener(getcible());
	tex = new TexteAdapter(text,getcible());
	getcible().addMouseListener(tex);

    }
}
