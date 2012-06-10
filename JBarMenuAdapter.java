import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import java.util.*;
import java.io.*;


public class JBarMenuAdapter implements ActionListener {
    
    public Composition mycompo;
    public Editeur edt;
  
    

    public JBarMenuAdapter(Editeur ep) {
        edt=ep;
        
    }

    public Composition getcible(){
	return mycompo;
    }
    
    public void setEdtp(Composition compo){
        mycompo=compo;
    }

    private void ouvrir (){
	try{
            System.out.println("action ouvrir");
            JFileChooser ouvre=new JFileChooser(edt.cheminDossier+"sauve");
            FichiersFilter filter = new FichiersFilter("sbp", "SBP Compositions");
            ouvre.addChoosableFileFilter(filter);
            ouvre.showOpenDialog(edt);
	    File leFichier=ouvre.getSelectedFile();
	    String fileName=leFichier.getName();
	    System.out.println("On tente d'ouvrir " + fileName);
            
            mycompo = edt.creerNouvelEdt(fileName);


            getcible().setTitle(fileName);
            getcible().sauve = true;
            getcible().chemin = ouvre.getSelectedFile().getAbsolutePath(); 
            ObjectInputStream sauvegarde = new ObjectInputStream(new FileInputStream(leFichier));
            int vsize=sauvegarde.readInt();
            for(int i=0;i<vsize;i++){
            getcible().getEdt().getVector().add(sauvegarde.readObject());}
            for(int i=0;i<vsize;i++){
                  if (((Figure)getcible().getEdt().getVector().elementAt(i)).dessin){
                    InfoImage info = (InfoImage)getcible().getEdt().getVector().elementAt(i);
                    DessinImage r  = new DessinImage(info.getFilename(),edt.cheminDossier+"sauve/Temp/",getcible().getEdt(),info.getDebut(),info.getFin());
                    getcible().getEdt().getVector().set(i,r);}
                  }
		sauvegarde.close();
        }
	    
    	catch (Exception exc){
	    System.out.println("y a une exception");
	    System.out.println(exc);
	    exc.printStackTrace();
        }
    }
    public void sauversous (){
	try{
            System.out.println("action sauversous");
            JFileChooser sauve=new JFileChooser(edt.cheminDossier+"sauve");
            FichiersFilter filter2 = new FichiersFilter("sbp", "SBP Compositions");
            sauve.addChoosableFileFilter(filter2);
            sauve.showSaveDialog(edt);
	    String fileName=(sauve.getSelectedFile().getName()+".sbp");
	    System.out.println("On tente de sauver sous" + fileName);
            getcible().setTitle(fileName);
            getcible().sauve = true;
            getcible().chemin = sauve.getSelectedFile().getAbsolutePath()+".sbp"; 
	           

            ObjectOutputStream sauvegarde = new ObjectOutputStream(new FileOutputStream(sauve.getSelectedFile().getAbsolutePath()+".sbp"));
            sauvegarde.writeInt(getcible().getEdt().getVector().size());
            for(int i=0;i<getcible().getEdt().getVector().size();i++){
               	if (((Figure)getcible().getEdt().getVector().elementAt(i)).dessin)
                    sauvegarde.writeObject(((DessinImage)getcible().getEdt().getVector().elementAt(i)).getInfo());
                else
                    sauvegarde.writeObject(getcible().getEdt().getVector().elementAt(i));}
            sauvegarde.close();
	    edt.bar.removeFenetre(getcible());
	    getcible().setbouton(fileName);
	    edt.bar.addFenetre(getcible());
	}

    	catch (Exception exc){
	    System.out.println("y a une exception");
        }
    }
    
    public void sauver(){
        if (getcible().sauve){
            try{
                ObjectOutputStream sauvegarde2 = new ObjectOutputStream(new FileOutputStream(getcible().chemin));
                sauvegarde2.writeInt(getcible().getEdt().getVector().size());
                for(int i=0;i<getcible().getEdt().getVector().size();i++){
               	if (((Figure)getcible().getEdt().getVector().elementAt(i)).dessin)
                    sauvegarde2.writeObject(((DessinImage)getcible().getEdt().getVector().elementAt(i)).getInfo());
                else
                    sauvegarde2.writeObject(getcible().getEdt().getVector().elementAt(i));}
                sauvegarde2.close();
                JOptionPane.showMessageDialog(null,getcible().getTitle()+" a bien été sauvegardé","Sauvegarde",JOptionPane.INFORMATION_MESSAGE);
                }

            catch (Exception exc2){
                System.out.println("y a une exception");
                System.out.println(exc2);
                exc2.printStackTrace();
            }
            }
            else sauversous();
    }


    
   
	public void actionPerformed(ActionEvent e){

	System.out.println("actionPerformed");


        if (e.getActionCommand().equals("nouveau")){
	    System.out.println("action nouveau");
            edt.creerNouvelEdt();
          }
        
        if (e.getActionCommand().equals("ouvrir")) ouvrir();
        
        if (e.getActionCommand().equals("imprime")){
	    System.out.println("action imprimer");
        }
        
        if (e.getActionCommand().equals("sauve")) sauver();
        
        if (e.getActionCommand().equals("sauvesous")) sauversous();

        
        if (e.getActionCommand().equals("quitter")){
	    System.out.println("action quitter");
            for(int i=0;i<edt.mesCompos.size();i++){
                try{
                ((Composition)edt.mesCompos.elementAt(i)).setClosed(true);
                }
                catch(Exception ex3){};}
	    System.exit(0);
        }
        
        if (e.getActionCommand().equals("annuler")){
	    System.out.println("action annuler");
            getcible().getEdt().undo();
        }
        
        if (e.getActionCommand().equals("restaurer")){
	    System.out.println("action restaurer");
            getcible().getEdt().redo();
        }
        
        if (e.getActionCommand().equals("select")){
	    System.out.println("action select");
            for(int i=0;i<getcible().getEdt().getVector().size();i++)
                ((Figure)getcible().getEdt().getVector().elementAt(i)).setSelected(true);
            getcible().getEdt().repaint();
        }
        
        if (e.getActionCommand().equals("couper")){
	    System.out.println("action couper");
            edt.couper();
        }
        
        if (e.getActionCommand().equals("copier")){
	    System.out.println("action copier");
            edt.copier();
        }
        
        if (e.getActionCommand().equals("coller")){
	    System.out.println("action coller");
            edt.coller();
        }
        
        if (e.getActionCommand().equals("effacer")){
	    System.out.println("action effacer");
            getcible().getEdt().effacer();
        }
        
        if (e.getActionCommand().equals("effacerTout")){
	    System.out.println("action effacerTout");
            getcible().getEdt().effacerTout();
        }
        
      }
}
