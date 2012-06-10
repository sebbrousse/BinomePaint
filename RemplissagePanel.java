
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

public class RemplissagePanel extends JPanel
                         implements ChangeListener {
                             
    protected JSlider remplissage;
    protected Editeur edt;
    protected Composition mycompo;
    protected JColorChooser couleurpanel;
    
       
    protected RemplissagePanel() {
        System.out.println("Remplissage");
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        couleurpanel = new JColorChooser();
        couleurpanel.setPreviewPanel(new JPanel());
        couleurpanel.removeChooserPanel(couleurpanel.getChooserPanels()[2]);
        couleurpanel.removeChooserPanel(couleurpanel.getChooserPanels()[1]);
        couleurpanel.getSelectionModel().addChangeListener(this);
        add(couleurpanel);
        

        JLabel sliderLabel = new JLabel("Remplissage", JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(sliderLabel);

	remplissage = new JSlider(JSlider.HORIZONTAL,0,255,0);
        remplissage.setMajorTickSpacing(64);
        remplissage.setMinorTickSpacing(16);
        Hashtable labelTable = new Hashtable();
        labelTable.put(new Integer( 0 ),
                       new JLabel("Vide") );
        labelTable.put(new Integer( 255 ),
                       new JLabel("Rempli") );
        remplissage.setLabelTable(labelTable);
        remplissage.setPaintLabels(true);
        remplissage.setPaintTicks(true);
        remplissage.addChangeListener(this);
        add(remplissage);

        }


    public void setEdtp(Composition compo){
        mycompo = compo;
    }
    public String getDisplayName() {
        return "Remplissage";
    }

        
    public void stateChanged(ChangeEvent e) {
        int remp = 0;
        if (e.getSource().equals(remplissage))
        {
            remp = remplissage.getValue();
            for(int i = 0;i<mycompo.getEdt().getVector().size();i++)
                if (((Figure)mycompo.getEdt().getVector().elementAt(i)).getSelected())
                     ((Figure)(mycompo.getEdt().getVector().elementAt(i))).setTransparence(remp);
        }
        else
        {
            for(int i = 0;i<mycompo.getEdt().getVector().size();i++)
               if (((Figure)mycompo.getEdt().getVector().elementAt(i)).getSelected()){           
                ((Figure2D)(mycompo.getEdt().getVector().elementAt(i))).setBackColor(couleurpanel.getColor());
                }
        }
        mycompo.getEdt().repaint();
        System.out.println("remplissage = "+remp);
    }
  
    
}
