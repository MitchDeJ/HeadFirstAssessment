package treinapp;

import java.util.ArrayList;
import java.util.List;

public class Trein {

	private List<Wagon> wagons = new ArrayList<Wagon>();
	private Station locatie;
	
	public Trein(Station locatie) {
		this.locatie = locatie;
	}
	
	public void koppel(Wagon wagon) {
		wagons.add(wagon);
		verdeelReizigers();
	}
	
	public void verdeelReizigers() { //TODO
		//bij een nieuwe wagon moeten tweede klas kaartjes hebbende
		//naar een goede stoel
		
		for (Wagon wagon : wagons) {
			
		}
		
	}
	
	public List<Wagon> getWagons() {
		return this.wagons;
	}

	public void instappen(Reiziger reiziger) {
		KaartjeType type = reiziger.getKaartje().getType();
		for(Wagon wagon : wagons) {
			if (wagon.plekken(type) > 0 ) { //er is een plek vrij
				wagon.instappen(reiziger);
				System.out.println(reiziger.getName() + " is ingestapt");
				return;
			}
		}
		System.out.println("Er is geen plek voor deze reiziger.");
	}
	
	public void uitstappen(Reiziger reiziger) {
		for (Wagon wagon : wagons) {
			if (wagon.heeftReiziger(reiziger)) {
				wagon.uitstappen(reiziger);
				System.out.println(reiziger.getName() + " is uitgestapt");
				return;
			}
		}
	}

	public void rijdNaar(Station station) {
		this.locatie = station;
		System.out.println("Aangekomen in "+locatie.getName());
		//mensen op bestemming stappen uit
		for(Wagon wagon : wagons) {
			wagon.aangekomen();
		}
	}

	public void controleer() {
		for (Wagon wagon : wagons) {
			wagon.controleer();
		}
	}

	public Station getLocatie() {
		return this.locatie;
	}

	public void leeg() {
		for (Wagon wagon : wagons) {
			wagon.leeg();
		}
	}
}
