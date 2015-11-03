import java.util.ArrayList;
/*
Erste Überlegungen zur Herangehensweise sowie Diskussion über das Verständnis der Angabe erfolgten als Teamarbeit.
Armin Puffler (1225268): Weitere Planung, Klassendiagramm, Model.java, ClimateModel.java, EconomyModel.java, Environment.java
Jovan Zivanovic (1426514): DigitalesKlassendiagramm, SimulationSupervisor.java, Simulation.java, SimulationGraph.java, LineGraph.java, ScatterGraph.java, GraphVisualizer.java
Stefan Buttenhauser (0926720): Forest.java, YoungForest.java, RelaxationForest.java, EnergyForest.java, MixedForest.java, Test.java

*/


public class Test
{

	public static void main(String[] args)
	{

		boolean passed = true;

		ArrayList<Environment> cliarray = new ArrayList<Environment>();
		for(float f = 1.0f; f < 1.4f; f = f + 0.01f){
			cliarray.add(new Environment(f, f, f, f));
		}
		ClimateModel cliMod = new ClimateModel(cliarray, true);

		ArrayList<Economy> ecoarry = new ArrayList<Economy>();
		for(float i = 1; i < 2050; i = i + 50){
			ecoarry.add(new Economy(i, i, i));
		}
		EconomyModel ecoMod = new EconomyModel(ecoarry, true);

		Environment env = new Environment(1,1,1,1);
		Economy eco = new Economy(0,0,0);

		YoungForest yf = new YoungForest(225, 0, 0, 0, env, eco);
		RelaxationForest rf = new RelaxationForest(225, 0, 0.3f, 0, env, eco);
		EnergyForest ef = new EnergyForest(225, 0, 0.3f, 0, env, eco);
		MixedForest mf = new MixedForest(225, 0, 0.3f, 0, env, eco);

		Simulation yfsimulation = new Simulation(ecoMod, cliMod, yf);
		Simulation rfsimulation = new Simulation(ecoMod, cliMod, rf);
		Simulation efsimulation = new Simulation(ecoMod, cliMod, ef);
		Simulation mfsimulation = new Simulation(ecoMod, cliMod, mf);

		ScatterGraph yfscatter = new ScatterGraph();
		ScatterGraph rfscatter = new ScatterGraph();
		ScatterGraph efscatter = new ScatterGraph();
		ScatterGraph mfscatter = new ScatterGraph();

		for(int i = 0; i <= 41; i++){
			yfsimulation.runSimulation();
			rfsimulation.runSimulation();
			efsimulation.runSimulation();
			mfsimulation.runSimulation();
			//System.out.println("YF: LivingWood: " + yfsimulation.getCurrentForest().livingWoodAmount + ", DeadWood: " + yfsimulation.getCurrentForest().deadWoodAmount);
			//System.out.println("RF: LivingWood: " + rfsimulation.getCurrentForest().livingWoodAmount + ", totallyUsedWood: " + rfsimulation.getCurrentForest().totallyUsedWood);
			//System.out.println("EF: LivingWood: " + efsimulation.getCurrentForest().livingWoodAmount + ", totallyUsedWood: " + efsimulation.getCurrentForest().totallyUsedWood);
			//System.out.println("MF: LivingWood: " + mfsimulation.getCurrentForest().livingWoodAmount + ", totallyUsedWood: " + mfsimulation.getCurrentForest().totallyUsedWood);

			// youngForest and relaxationForest are looking good, energyForest and mixedForest are shrinking (rework formulas)
			// the climateModel never changes the values

			yfscatter.addData((double)yfsimulation.getCurrentForest().livingWoodAmount, (double)yfsimulation.getCurrentForest().deadWoodAmount);
			rfscatter.addData((double)rfsimulation.getCurrentForest().livingWoodAmount, (double)rfsimulation.getCurrentForest().totallyUsedWood);
			efscatter.addData((double)efsimulation.getCurrentForest().livingWoodAmount, (double)efsimulation.getCurrentForest().totallyUsedWood);
			mfscatter.addData((double)mfsimulation.getCurrentForest().livingWoodAmount, (double)mfsimulation.getCurrentForest().totallyUsedWood);
		}

		GraphVisualizer yfv = new GraphVisualizer(yfscatter);
		GraphVisualizer rfv = new GraphVisualizer(yfscatter);
		GraphVisualizer efv = new GraphVisualizer(yfscatter);
		GraphVisualizer mfv = new GraphVisualizer(yfscatter);
	}

}
