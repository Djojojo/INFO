import java.awt.Image;

import javax.swing.ImageIcon;

public class Case {
	
	static Image mer = new ImageIcon("Images/Mer.jpg").getImage();
	static Image bat = new ImageIcon("Images/Bat.jpg").getImage();    
	static Image croix = new ImageIcon("Images/Croix.png").getImage();
	static Image explosion = new ImageIcon("Images/Explosion.png").getImage();
	
 


	public boolean onADejaClique;  	//if true on ne peut plus cliquer sur cette case
	private Plateau univers;
	private Bateau bateau;
	
	public Case(Plateau p){
		this.univers = p;
		this.onADejaClique = false;
		this.bateau = null;
	}
	
	public Case (Plateau p, Bateau bateau) {
		this.univers = p;
		this.onADejaClique = false;
		this.bateau = bateau;
	}
	
	public Bateau getBateau() {
		return bateau;
	}
	
	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}
	
	public Image getImage(){
		if(this.bateau == null){
			return Case.mer;
		}
		if(this.bateau != null){
		         return Case.bat;
		}
		return null;
	}

	public void tirer(){
		this.onADejaClique = true ;		//On ne pourra plus cliquer sur cette case
		if(this.bateau != null){
			this.bateau.touche(this);	//S'il y a un bateau on effectue dessus l'action touche() 
			if(this.bateau.estCoule()){
				this.univers.listeDesBateaux.remove(this.bateau);	//si le bateau en question est coulé, on l'enlève de la liste des bateaux
			}
		}
		
	}

}
