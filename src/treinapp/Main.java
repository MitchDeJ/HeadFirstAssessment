package treinapp;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Trein trein = new Trein(Stations.GOES);
		trein.koppel(new Wagon(trein));
		
		List<Reiziger> goesReizigers = new ArrayList<Reiziger>();
		
		//5 reizigers 2e klas
		goesReizigers.add(new Reiziger("Henk", Stations.VLISSINGEN, new Kaartje(KaartjeType.tweedeKlas)));
		goesReizigers.add(new Reiziger("Piet", Stations.VLISSINGEN, new Kaartje(KaartjeType.tweedeKlas)));
		goesReizigers.add(new Reiziger("Klaas", Stations.VLISSINGEN, new Kaartje(KaartjeType.tweedeKlas)));
		goesReizigers.add(new Reiziger("Jan", Stations.VLISSINGEN, new Kaartje(KaartjeType.tweedeKlas)));
		goesReizigers.add(new Reiziger("Dirk", Stations.VLISSINGEN, new Kaartje(KaartjeType.tweedeKlas)));
		
		// 1 1e klas
		goesReizigers.add(new Reiziger("Geff", Stations.VLISSINGEN, new Kaartje(KaartjeType.eersteKlas)));
	
		//zwartrijder
		goesReizigers.add(new Reiziger("Lars", Stations.MIDDELBURG, new Kaartje(KaartjeType.zwartrijder)));
		
		//alle reizigers in goes stappen op
		for (Reiziger r : goesReizigers) 
			trein.instappen(r);
		
		trein.rijdNaar(Stations.ARNEMUIDEN);
		
		trein.koppel(new Wagon(trein));
		
		List<Reiziger> arneReizigers = new ArrayList<Reiziger>();
		
		//2 reizigers 2e klas
		arneReizigers.add(new Reiziger("Mike", Stations.VLISSINGEN_SOUBURG, new Kaartje(KaartjeType.tweedeKlas)));
		arneReizigers.add(new Reiziger("Daan", Stations.VLISSINGEN_SOUBURG, new Kaartje(KaartjeType.tweedeKlas)));
		
		//reizigers uit arnemuiden stappen op
		for (Reiziger r : arneReizigers) {
			r.instappen(trein);
		}
		
		trein.controleer();
		trein.rijdNaar(Stations.MIDDELBURG);
		
		//1 iemand stapt op
		trein.instappen(new Reiziger("Hans", Stations.VLISSINGEN, new Kaartje(KaartjeType.eersteKlas)));
		
		trein.rijdNaar(Stations.VLISSINGEN_SOUBURG);
		
		trein.rijdNaar(Stations.VLISSINGEN);
		trein.leeg();
	}
	
}
