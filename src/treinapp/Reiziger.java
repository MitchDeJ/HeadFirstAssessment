package treinapp;

public class Reiziger {
	
	private Station bestemming;
	private Kaartje kaartje;
	private String name;
	
	public Reiziger(String name, Station bestemming, Kaartje kaartje) {
		this.bestemming = bestemming;
		this.kaartje = kaartje;
		this.name = name;
	}
	
	public void instappen(Trein trein) {
		trein.instappen(this);
	}

	public Kaartje getKaartje() {
		return this.kaartje;
	}
	
	public Station getBestemming() {
		return this.bestemming;
	}

	public String getName() {
		return this.name;
	}

}
