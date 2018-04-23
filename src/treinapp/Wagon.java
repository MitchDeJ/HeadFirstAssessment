package treinapp;

import java.util.ArrayList;
import java.util.List;

public class Wagon {
	
	private List<Reiziger> eersteKlas = new ArrayList<Reiziger>();
	private List<Reiziger> tweedeKlas = new ArrayList<Reiziger>();
	private Trein trein;
	
	public Wagon(Trein trein) {
		this.trein = trein;
	}
	
	public void leeg() {
		leegEersteKlas();
		leegTweedeKlas();
	}
	
	private void leegEersteKlas() {
		eersteKlas.clear();
	}
	
	private void leegTweedeKlas() {
		tweedeKlas.clear();
	}
	
	//check het aantal plekken in de wagon voor een kaartje type
	public int plekken(KaartjeType type) {
		
		int eersteKlasPlekken =
				Constants.EERSTE_KLAS_MAX - eersteKlas.size();
		
		int tweedeKlasPlekken =
				Constants.TWEEDE_KLAS_MAX - tweedeKlas.size();
		
		//de wagon is vol
		if (tweedeKlasPlekken == 0 && eersteKlasPlekken == 0)
			return 0;
		
		switch(type) {
		
		case eersteKlas:
		case zwartrijder:
			if (eersteKlasPlekken == 0)
				return tweedeKlasPlekken;
			
			return eersteKlasPlekken;
			
		case tweedeKlas:
			if (tweedeKlasPlekken == 0)
				return eersteKlasPlekken;
			
			return tweedeKlasPlekken;
		}
		
		return 0;
	}
	
	public void instappen(Reiziger reiziger) {
		
		KaartjeType type = reiziger.getKaartje().getType();
		
		if (plekken(type) == 0) {
			System.out.println("Kan niet instappen, er is geen plek voor deze reiziger.");
			return;
		}
		
		getListForKaartje(type).add(reiziger);
	}
	
	public void uitstappen(Reiziger reiziger) {
		uitstappen(eersteKlas, reiziger);
		uitstappen(tweedeKlas, reiziger);
	}
	
	public void uitstappen(List<Reiziger> klasse, Reiziger reiziger) {
		if (klasse.contains(reiziger))
		klasse.remove(reiziger);
	}

	private List<Reiziger> getListForKaartje(KaartjeType type) {
		
		int eersteKlasPlekken =
				Constants.EERSTE_KLAS_MAX - eersteKlas.size();
		
		int tweedeKlasPlekken =
				Constants.TWEEDE_KLAS_MAX - tweedeKlas.size();
		
		//de wagon is vol
		if (tweedeKlasPlekken == 0 && eersteKlasPlekken == 0)
			return null;
		
		switch(type) {
		case eersteKlas:
		case zwartrijder:
			if (eersteKlasPlekken > 0)
			return eersteKlas;
			
			return tweedeKlas;
		case tweedeKlas:
			if (tweedeKlasPlekken > 0)
			return tweedeKlas;
			
			return eersteKlas;	
		}
		
		return null;
	}
	
	public boolean heeftReiziger(Reiziger reiziger) {
		return (tweedeKlas.contains(reiziger) || eersteKlas.contains(reiziger));
	}
	
	public List<Reiziger> alleReizigers() {
		List<Reiziger> reizigers = new ArrayList<Reiziger>();
		
		for (Reiziger r : eersteKlas)
			reizigers.add(r);
		
		for (Reiziger r : tweedeKlas)
			reizigers.add(r);
		
		return reizigers;
	}
	
	public void controleer() {
		List<Reiziger> reizigers = alleReizigers();
		
		for (Reiziger r : reizigers) {
			if (r.getKaartje().getType() == KaartjeType.zwartrijder) {
				uitstappen(r);
				System.out.println(r.getName() + "is uit de trein geschopt.");
			}
		}
	}

	public void aangekomen() {
		for (Reiziger r : alleReizigers()) {
			if (trein.getLocatie() == r.getBestemming()) {
				trein.uitstappen(r);
			}
		}
	}

}
