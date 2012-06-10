import javax.swing.*;
import java.awt.Dimension;

    public class Application extends JFrame {

	public Application(String titre){
	    super(titre);
	    setVisible(true);
	    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	public void afficher(){
	    System.out.println("Application :");
	    System.out.println("     titre : "+getTitle());
	    System.out.println("     largeur de la fenetre : "+getWidth());
	    System.out.println("     hauteur de la fenetre : "+getHeight());
	}
	

    }
