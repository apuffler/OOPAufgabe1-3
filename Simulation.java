public class Simulation{
	private EconomyModel economyModel;
	private ForestModel forestModel;	

	public Simulation(EconomyModel economyModel, ForestModel forestModel){
		this.economyModel = economyModel;
		this.forestModel = forestModel;
	}

	public Simulation(){
		this.economyModel = null;
		this.forestModel = null;
	}

	public void setEconomyModel(EconomyModel economyModel){
		this.economyModel = economyModel;
	}

	public EconomyModel getEconomyModel(){
		return this.economyModel;
	}

	public void setForestModel(ForestModel forestModel){
		this.forestModel = forestModel;
	}

	public ForestModel getForestModel(){
		return this.forestModel;
	}

	public void runSimulation() {
		
	}
}