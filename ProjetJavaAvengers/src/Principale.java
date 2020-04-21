import java.awt.Color;
import java.awt.Font;
import java.io.ObjectInputStream.GetField;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.JMenu;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import Metier.FacadeMetier;
import Presentation.Controleur;

public class Principale {

	public static void main(String[] args) {
		//Installation du Lookandfeel.
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			
			UIManager.put("nimbusBase", new Color(115,164,209));
			UIManager.put("nimbusBlueGrey", new Color(115,164,209));
			UIManager.put("control", new Color(255,255,255));
		} catch(Exception err) {}
		

		FacadeMetier facadeMetier = new FacadeMetier();
		Controleur controleur = new Controleur(facadeMetier);	
	}
}
