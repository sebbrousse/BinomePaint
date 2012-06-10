

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import javax.imageio.stream.*;



public class InserImPanel extends JPanel implements ActionListener,ListSelectionListener,FilenameFilter {

    protected JLabel apercu;
    protected Composition mycompo;
    protected JMenuAdapter adap;
    public Editeur edt;
    public JButton inserer;
    public JButton folder;
    public String filename;
    public JList liste;
    public File directo;
    public String[] ima;
    public File outputFile;
    
    public InserImPanel(Editeur ep,JMenuAdapter adapt){

        edt=ep;
        directo = new File(edt.cheminDossier+"pictures");
        ima = directo.list(this);
        adap = adapt;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(100,50));
        
        
        folder = new JButton("Dossier : "+directo.getName());
        folder.setActionCommand("folder");
        folder.addActionListener(this);
        JPanel foldpanel = new JPanel();
        foldpanel.setLayout(new FlowLayout());
        foldpanel.add(folder);
        add(foldpanel);

        
        liste = new JList(ima);
        liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	liste.setSelectedIndex(1);
        liste.addListSelectionListener(this);
        JScrollPane listScroller = new JScrollPane(liste);
        listScroller.setPreferredSize(new Dimension(140,80));
        listScroller.setAlignmentX(LEFT_ALIGNMENT);
        JPanel listpanel = new JPanel();
        listpanel.setLayout(new FlowLayout());
        listpanel.add(listScroller);
        add(listpanel);
        
        try{
            File maImage = new File(directo.getPath()+"/"+liste.getSelectedValue());
            outputFile = new File(edt.cheminDossier+"sauve/Temp/"+liste.getSelectedValue());
            
            FileInputStream in = new FileInputStream(maImage);
            FileOutputStream out = new FileOutputStream(outputFile);
            int c;
            
            while ((c = in.read()) != -1)
            out.write(c);
            
            in.close();
            out.close();
        }
        catch(Exception ec3){};
        filename = outputFile.getName();
        adap.setFilename(filename,edt.cheminDossier);
       
        System.out.println(filename);
        MyImage aper = new MyImage(filename,130,100);
        ImageIcon apericon = new ImageIcon(aper.getImg());
        apercu = new JLabel(apericon,JLabel.CENTER);
        apercu.setPreferredSize(new Dimension(130,100));
        JPanel apanel = new JPanel();
        apanel.setLayout(new FlowLayout());
        apanel.add(apercu);
        add(apanel);

        
        inserer = new JButton("Insérer");
        inserer.setActionCommand("inserer");
	inserer.addActionListener(adap);
        JPanel bpanel = new JPanel();
        bpanel.setLayout(new FlowLayout());
        bpanel.add(inserer);
        add(bpanel);


  	
}
        public void actionPerformed(ActionEvent e){

	System.out.println("actionPerformed");

       
	if (e.getActionCommand().equals("folder")){
	    System.out.println("action folder");
            try{
            System.out.println("action ouvrir imagedossier");
            JFileChooser ouvre=new JFileChooser(directo);
            ouvre.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            ouvre.showOpenDialog(edt);
	    directo=ouvre.getSelectedFile();
            folder.setText("Dossier : "+directo.getName());
	    System.out.println(directo.getPath());
            ima = directo.list(this);
            liste.setListData(ima);
            }
            catch (Exception exc){
                System.out.println("y a une exception");
             }
        }

 
    }

    public void setEdtp(Composition compo){
        mycompo = compo;
    }
    
    public void valueChanged(ListSelectionEvent e) {
        try{
            File maImage = new File(directo.getPath()+"/"+liste.getSelectedValue());
            outputFile = new File(edt.cheminDossier+"sauve/Temp/"+liste.getSelectedValue());
            
            FileInputStream in = new FileInputStream(maImage);
            FileOutputStream out = new FileOutputStream(outputFile);
            int c;
            
            while ((c = in.read()) != -1)
            out.write(c);
            
            in.close();
            out.close();
        }
        catch(Exception ec3){};
        filename = outputFile.getName();
        adap.setFilename(filename,edt.cheminDossier+"sauve/Temp/");
        MyImage aper = new MyImage(edt.cheminDossier+"sauve/Temp/"+filename,130,100);
        ImageIcon apericon = new ImageIcon(aper.getImg());
        apercu.setIcon(apericon);
    }
    
    public boolean accept(File dir, String name) {
        if (name.endsWith(".gif")||name.endsWith(".jpeg")||name.endsWith(".jpg"))
            return true;
        else
            return false;
    }
    
}
   
