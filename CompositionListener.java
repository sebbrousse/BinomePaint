
import javax.swing.event.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;


public class CompositionListener implements InternalFrameListener {
    
    public Composition mycompo;
    public Editeur myed;
    
    public CompositionListener(Composition compo, Editeur ed){
        mycompo = compo;
        myed = ed;
    }
    
    public void internalFrameActivated(InternalFrameEvent e){
        myed.setEdtp(mycompo);
        try{
        mycompo.getBouton().setSelected(true);}
        catch(Exception ex){};
    }
    
    public void internalFrameClosed(InternalFrameEvent e){
    }
    
    public void internalFrameClosing(InternalFrameEvent e) {
	mycompo.seFermer();
    }
    
    public void internalFrameDeactivated(InternalFrameEvent e) {
        try{
        mycompo.getBouton().setSelected(false);}
        catch(Exception ex){};
    }
    
    public void internalFrameDeiconified(InternalFrameEvent e) {
    }
    
    public void internalFrameIconified(InternalFrameEvent e) {
    }
    
    public void internalFrameOpened(InternalFrameEvent e) {
    }
    
}
 
    
    
        
        
