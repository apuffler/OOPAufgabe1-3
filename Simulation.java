public class Simulation{
	private EconomyModel economyModel;
	private ClimateModel climateModel;
	private Forest forest;	

	public Simulation(EconomyModel economyModel, ClimateModel climateModel, Forest forest){
		this.economyModel = economyModel;
		this.climateModel = climateModel;
		this.forest = forest;
	}

	public Simulation(){
		this.economyModel = null;
		this.climateModel = null;
		this.forest = null;
	}

	public void setEconomyModel(EconomyModel economyModel){
		this.economyModel = economyModel;
	}

	public EconomyModel getEconomyModel(){
		return this.economyModel;
	}

	public void setClimateModel(ClimateModel climateModel){
		this.ClimateModel = climateModel;
	}

	public ClimateModel getClimateModel(){
		return this.climateModel;
	}

	public void runSimulation() {
		this.forest = this.economyModel.applyTo(this.forest);
		this.forest = this.climateModel.applyTo(this.forest);

		forest.updateForest();
	}
}