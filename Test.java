
import java.util.ArrayList;
/*
Armin Puffler (1225268): Klassendiagramm, Arbeitsaufteilung, Test.java, Refakoring: toString() zu Forest hinzugefügt. Fixed table inconsistency. Added getYear(). (Should we also do a setYear? Emulating a the difference in years in a row)	


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

		ArrayList<LivingWood> lwTests = new ArrayList<LivingWood>();
		for(int i = 0; i< 5; i++)
		{
			for(int j = 0; j< 5; j++)
			{
			lwTests.add(new LivingWood(i,j));
			}
		}
		ArrayList<Forest> forestTests = new ArrayList<Forest>();
		for(int i = 0; i< 5; i++)
		{
			for(int j = 0; j< 5; j++)
			{
			lwTests.add(new LivingWood(i,j));
			}
		}	


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