package treinapp;

public class Kaartje {
	
	private KaartjeType type;

	public Kaartje(KaartjeType type) {
		this.setType(type);
	}

	public KaartjeType getType() {
		return type;
	}

	public void setType(KaartjeType type) {
		this.type = type;
	}

}
