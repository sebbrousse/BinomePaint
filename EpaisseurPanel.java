

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

public class EpaisseurPanel extends JPanel
                         implements ChangeListener {
                             
    protected JSlider epaisseur,pointille;
    protected Editeur edt;
    protected Composition mycompo;
    protected JColorChooser couleurpanel;
    
       
    protected EpaisseurPanel() {
        System.out.println("Epaisseur");
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        couleurpanel = new JColorChooser();
        couleurpanel.setPreviewPanel(new JPanel());
        couleurpanel.removeChooserPanel(couleurpanel.getChooserPanels()[2]);
        couleurpanel.removeChooserPanel(couleurpanel.getChooserPanels()[1]);
        couleurpanel.getSelectionModel().addChangeListener(this);
        add(couleurpanel);
        

        JLabel sliderLabel = new JLabel("Epaisseur", JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(sliderLabel);

        epaisseur = new JSlider(JSlider.HORIZONTAL,0,20,0);
        epaisseur.setMajorTickSpacing(10);
        epaisseur.setMinorTickSpacing(1);
        Hashtable labelTable = new Hashtable();
        labelTable.put(new Integer( 0 ),
                       new JLabel("fin") );
        labelTable.put(new Integer( 20 ),
                       new JLabel("�pais") );
        epaisseur.setLabelTable(labelTable);
        epaisseur.setPaintTicks(true);
        epaisseur.setPaintLabels(true);
        epaisseur.addChangeListener(this);
        add(epaisseur);
        
        JLabel sliderLabel2 = new JLabel("Pointillé", JLabel.CENTER);
        sliderLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(sliderLabel2);

        pointille = new JSlider(JSlider.HORIZONTAL,0,20,0);
	System.out.println("pointille "+pointille);
        pointille.setMajorTickSpacing(10);
        pointille.setMinorTickSpacing(1);
        Hashtable labelTable2 = new Hashtable();
        labelTable2.put(new Integer( 0 ),
                       new JLabel("continu") );
        labelTable2.put(new Integer( 20 ),
                       new JLabel("pointill�") );
        pointille.setLabelTable(labelTable2);
        pointille.setPaintTicks(true);
        pointille.setPaintLabels(true);
        pointille.addChangeListener(this);
        add(pointille);

        }


    public void setEdtp(Composition compo){
        mycompo = compo;
    }
    
    public String getDisplayName() {
        return "Epaisseur";
    }

        
    public void stateChanged(ChangeEvent e) {
        int epp = 0;
        if (e.getSource().equals(epaisseur))
        {
            epp = epaisseur.getValue();
            for(int i = 0;i<mycompo.getEdt().getVector().size();i++)
             if (((Figure)mycompo.getEdt().getVector().elementAt(i)).getSelected())
                ((Figure)(mycompo.getEdt().getVector().elementAt(i))).setEpaisseur(epp);
            
        }
        else if (e.getSource().equals(pointille))
        {
            int pointi= pointille.getValue();
            for(int i = 0;i<mycompo.getEdt().getVector().size();i++)
              if (((Figure)mycompo.getEdt().getVector().elementAt(i)).getSelected())
                  ((Figure)(mycompo.getEdt().getVector().elementAt(i))).setPointille(pointi);
        }
        else
        {
            for(int i = 0;i<mycompo.getEdt().getVector().size();i++)
               if (((Figure)mycompo.getEdt().getVector().elementAt(i)).getSelected())
                   ((Figure)(mycompo.getEdt().getVector().elementAt(i))).setColor(couleurpanel.getColor());
        }        
        mycompo.getEdt().repaint();
       
    }
  
    
}
