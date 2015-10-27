import java.util.LinkedList;

abstract class SimulationGraph{
	private LinkedList<Simulation> simulationList;

	public SimulationGraph(){
		this.simulationList = new LinkedList<Simulation>();
	}

	public void addSimulation(Simulation simulation){
		this.simulationList.add(simulation);	//Muss hier geclonet werden?
	}
}