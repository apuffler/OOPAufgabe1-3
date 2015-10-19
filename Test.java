
import java.util.ArrayList;
/*
Erste Überlegungen zur Herangehensweise sowie Diskussion über das Verständnis der Angabe erfolgten als Teamarbeit.
Armin Puffler (1225268): Klassendiagramm, Arbeitsaufteilung, Test.java, Refakoring: toString() zu Forest hinzugefügt. Fixed table inconsistency. Added getYear(). (Should we also do a setYear? Emulating a the difference in years in a row)	
Jovan Zivanovic (1426514): Wood.java, LivingWood.java, CO2.java, DeadWood.java. 
Stefan Buttenhauser (0926720): Forest.java, HarvestedWood.java, Exceptions hinzugefügt

*/

/*
TODO:



BUGS:
Limit decay to 0-1, (e.g) if parameter is 1.1F negative values can appear.
Alternatively, never allow parameters to go below 0.



*/



public class Test
{
	/*

	public class LivingWoodTest
	{


		public boolean test()
		{
			boolean passed = False;
			try
			{


				ArrayList<LivingWood> lwTests = new ArrayList<LivingWood>();
				for(int i = 0; i< 5; i++)
				{
					for(int j = 0; j< 5; j++)
					{
					lwTests.add(new LivingWood(i,j));
					}
				}


				for (int i = 0; i < lwTests.length; i++)
				{


				}

			}
			catch(Exception ex)
			{
				return False;
			}

		}			



	}*/


	public static void main(String[] args)
	{

		//CO2 c = new CO2();
		//System.out.println(c);
		int testSize = 2;

		//Testing normal cases (and 0, 1 and 100% edge cases).


		ArrayList<LivingWood> lwTests = new ArrayList<LivingWood>();
		for(int amount = 0; amount < testSize; amount++)
		{
			for(int addition = 0; addition < testSize; addition++)
			{
			lwTests.add(new LivingWood(amount,addition));
			}
		}

		ArrayList<DeadWood> dwTests = new ArrayList<DeadWood>();
		for(int amount = 0; amount < testSize; amount++)
		{
			for(int addition = 0; addition < testSize; addition++)
			{
				for(float decay = 0F; decay <= 1; decay = decay + 0.1F)
				{
				dwTests.add(new DeadWood(amount,addition,decay));
				}
			}
		}

		ArrayList<HarvestedWood> hwTests = new ArrayList<HarvestedWood>();
		for(int amount = 0; amount < testSize; amount++)
		{
			for(int harvest = 0; harvest < testSize; harvest++)
			{
				for(float usage = 0F; usage <= 1; usage = usage + 0.1F)
				{
				hwTests.add(new HarvestedWood(amount,harvest,usage));
				}
			}
		}

		


		ArrayList<Forest> forestTests = new ArrayList<Forest>();
		
		int lwIndex = 0;
		int dwIndex = 0;
		int hwIndex = 0;
		
		for(int forests = 0; forests < lwTests.size()*dwTests.size(); forests++) //*hwTests.size()
		{

			forestTests.add(new Forest(lwTests.get(lwIndex), dwTests.get(dwIndex), hwTests.get(hwIndex)));
			lwIndex = (lwIndex+1 > lwTests.size() ? 0 : lwIndex);
			dwIndex = (dwIndex+1 > dwTests.size() ? 0 : dwIndex);
			hwIndex = (hwIndex+1 > hwTests.size() ? 0 : dwIndex);
		}

		System.out.println("Finished generating.");

		int updates = 3;
		int sub = 100;
		int progress = 0;

		for (Forest f : forestTests)
		{
			System.out.println("normal: " + progress + "/" + forestTests.size());
			for (int i = 0; i<= updates; i++)
			{
				f.updateForest();
			}
			progress++;
		}
		System.out.println("Finished normal update.");


		progress = 0;
		//Changing parameters while Emulation is running
		for (Forest f : forestTests)
		{
			System.out.println("change: " + progress);
			f.setHarvestedWood(f.getHarvestedWood() - sub);	
			for (int i = 0; i<= updates; i++)
			{
				f.updateForest();
			}
			progress++;
		}


		System.out.println("Finished change harvest.");
		progress = 0;
		for (Forest f : forestTests)
		{
			System.out.println("decay: " + progress);
			f.setDeadDecay(f.getDeadDecay()- sub);	
			for (int i = 0; i<= updates; i++)
			{
				f.updateForest();
			}
			progress++;
		}
		System.out.println("Finished change decay.");


		System.out.println(lwTests.size());
		System.out.println(dwTests.size());
		System.out.println(hwTests.size());
		System.out.println(forestTests.size());

		System.out.println(forestTests.get(0).getOutputTable());



		




		/*

		LivingWood lw = new LivingWood(0,0); 
		DeadWood dw = new DeadWood(10,0,1.1F);
		HarvestedWood hw = new HarvestedWood(0,0,0);
		Forest f = new Forest(lw, dw, hw);
		
		for( int i = 0; i < 10; i++)
		{
		f.updateForest();
		}
		System.out.println(f.getOutputTable());
		*/
	}

}
