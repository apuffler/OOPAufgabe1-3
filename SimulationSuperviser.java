import java.util.LinkedList;

public class SimulationSuperviser{
	private LinkedList<Simulation> simulations;

	public SimulationSuperviser(){
		this.simulations = new LinkedList<Simulation>();
	}

	public void addSimulation(Simulation simulation){
		this.simulations.add(simulation);
	}
	
	public void runSimulations(){
		for(Simulation simulation : this.simulations){
			simulation.runSimulation();
		}
	}
}