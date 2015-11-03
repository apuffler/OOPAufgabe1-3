import java.util.LinkedList;

public class Simulation{
	private EconomyModel economyModel;
	private ClimateModel climateModel;
	private Forest currentForest;	
	private LinkedList<Forest> forestTimeLine; 

	/**
	 *Initializes the member variables with the given Models and the Forest
	 *
	 *@param (economyModel) Used Model for the Economy in the Simulations, has to be != NULL, otherwise the 'runSimulation'-Method doesnt work;
	 *@param (climateModel) Model for managing the climate factors of the Forest, has to be != NULL, otherwise the 'runSimulation'-Method doesnt work;
	 *@param (currentForest) Used Object for managing the Wood-Amount, has to be != NULL
	 */
	public Simulation(EconomyModel economyModel, ClimateModel climateModel, Forest currentForest){
		this.economyModel = economyModel;
		this.climateModel = climateModel;
		this.currentForest = currentForest;
		this.forestTimeLine = new LinkedList<Forest>();
	}

	/**
	 *Standard Constructor used to set the member variables to NULL; If this constructor is used, the application expects the user to call the setter-function for the members;
	 */
	public Simulation(){
		this.economyModel = null;
		this.climateModel = null;
		this.currentForest = null;
		this.forestTimeLine = new LinkedList<Forest>();
	}


	/**
	 *Setter-Method for the Economy-Model
	 *
	 *@param (economyMode) Given Economy-Model is expected to be != NULL, otherwise the runSimulation will cause an exception
	 */
	public void setEconomyModel(EconomyModel economyModel){
		this.economyModel = economyModel;
	}


	public EconomyModel getEconomyModel(){
		return this.economyModel;
	}

	/**
	 *Setter-Method for the Climate-Model
	 *
	 *@param (climateModel) Given Climate-Model is expected to be != NULL, otherwise the runSimulation will cause an exception
	 */
	public void setClimateModel(ClimateModel climateModel){
		this.climateModel = climateModel;
	}

	
	public ClimateModel getClimateModel(){
		return this.climateModel;
	}

	public void runSimulation() {
		this.currentForest.eco = this.economyModel.applyTo(this.currentForest.eco);
		this.currentForest.env = this.climateModel.applyTo(this.currentForest.env);
		this.forestTimeLine.add(this.currentForest.makeCopy());
		
		this.currentForest.updateForest(this.currentForest.env);
	}

	public Forest getCurrentForest(){
		return this.currentForest;
	}
}
