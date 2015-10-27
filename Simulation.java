public class Simulation{
	private EconomyModel economyModel;
	private ClimateModel climateModel;
	private Forest currentForest;	
	private LinkedList<Forest> forestTimeLine; 

	public Simulation(EconomyModel economyModel, ClimateModel climateModel, Forest currentForest){
		this.economyModel = economyModel;
		this.climateModel = climateModel;
		this.currentForest = currentForest;
		this.forestTimeLine = new LinkedList<Forest>();
	}

	public Simulation(){
		this.economyModel = null;
		this.climateModel = null;
		this.currentForest = null;
		this.forestTimeLine = new LinkedList<Forest>();
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
		//TODO: Take economy from forest and apply
		//this.forest = this.economyModel.applyTo(this.forest);
		this.forest = this.climateModel.applyTo(this.forest.env);
		this.forestTimeLine.add(this.currentForest.clone());
		

		this.currentForest.updateForest();
	}
}
