import javax.swing.event.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;


public class EditeurListener implements WindowListener {
    

    public Editeur myed;

    
    public EditeurListener(Editeur ed){
        myed = ed;
    }
    
    public void windowActivated(WindowEvent e){

    }
    
    public void windowClosed(WindowEvent e){
    }
    
    public void windowClosing(WindowEvent e) {
        
	myed.close();
    }
    
    public void windowDeactivated(WindowEvent e) {
   }
    
    public void windowDeiconified(WindowEvent e) {
    }
    
    public void windowIconified(WindowEvent e) {
    }
    
    public void windowOpened(WindowEvent e) {
    }
    
}
 
