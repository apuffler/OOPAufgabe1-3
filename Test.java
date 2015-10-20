import java.util.ArrayList;
/*
Erste Überlegungen zur Herangehensweise sowie Diskussion über das Verständnis der Angabe erfolgten als Teamarbeit.
Armin Puffler (1225268): Klassendiagramm, Arbeitsaufteilung, Test.java, Refakoring: toString() zu Forest hinzugefügt. Fixed table inconsistency. Added getYear(). More tests ( I know, could be more elegant.)	
Jovan Zivanovic (1426514): Wood.java, LivingWood.java, CO2.java, DeadWood.java. 
Stefan Buttenhauser (0926720): Forest.java, HarvestedWood.java, Exceptions hinzugefügt, Bugfixes zur Verhinderung von Negativwerten

*/


public class Test
{
	


	public static boolean  zeroSumTest(Forest f)
	{
		int co2zero = f.getBoundCO2() - (f.getHarvestedWood() + f.getLivingWood() + f.getDeadWood());  
		return co2zero == 0;
	}

	public static boolean nonNegativeTest(Forest f)
	{
		return f.getLivingWood() >= 0 && f.getDeadWood() >= 0 && f.getHarvestedWood() >= 0 && f.getTotallyUsedWood() >= 0;  
	}



	public static void main(String[] args)
	{


		boolean passed = true;


		System.out.println("Testing negative parameters.");
		{
			LivingWood l = null;
			DeadWood d = null;
			HarvestedWood h = null;
			Forest f = null;
		try
		{
		 l = new LivingWood(-1,-1);
		}
		catch (Exception ex)
		{
			System.out.println(ex);
			passed = false;
		}	

		try
		{
		  d = new DeadWood(-1,-1,-1F); 
		}
		catch (Exception ex)
		{
			System.out.println(ex);
			passed = false;
		}	

		try
		{
		  h = new HarvestedWood(-1,-1,-1F);
		}
		catch (Exception ex)
		{
			System.out.println(ex);
			passed = false;
		}		


		try
		{
		  if(l != null && d != null && h != null)
		  {	
		  		f = new Forest(l,d,h);
		  		for(int i = 0; i<10; i++)
				{
					f.updateForest();
					passed = passed && zeroSumTest(f);
					passed = passed && nonNegativeTest(f);
				}
		  }
		}
		catch (Exception ex)
		{
			System.out.println(ex);
			passed = false;
		}	
		if(!passed)
		{
			System.out.println("TEST NOT PASSED!");
			return;
		}
		
		
		System.out.println(f.getOutputTable());
		}

		


		System.exit(0);

		System.out.println("Testing Harvestedwood: amount=1,harvest=1,usage=1F");
		
		{
		
		LivingWood l = new LivingWood(0,0);
		DeadWood d = new DeadWood(0,0,0F); 
		HarvestedWood h = new HarvestedWood(1,1,1F);
		Forest f = new Forest(l,d,h);
		for(int i = 0; i<10; i++)
		{
			f.updateForest();
			passed = passed && zeroSumTest(f);
			System.out.println(passed);
			passed = passed && nonNegativeTest(f);
			System.out.println(passed);

		}
		System.out.println(f.getOutputTable());
		}

		if(!passed)
		{
			System.out.println("TEST NOT PASSED!");
			return;
		}



		System.out.println("Testing Harvestedwood: amount=1,addition=1,decay=1F");
		
		{
		//If decay per year is 100%, why is there still deadWood left? Revisit order of operation, eg. decay or addition first?
		//Also, HarvestedWood goes negative!
		LivingWood l = new LivingWood(0,0);
		DeadWood d = new DeadWood(1,1,1F); 
		HarvestedWood h = new HarvestedWood(0,0,0F);
		Forest f = new Forest(l,d,h);
		for(int i = 0; i<10; i++)
		{
			f.updateForest();
			passed = passed && zeroSumTest(f);
			passed = passed && nonNegativeTest(f);

		}
		System.out.println(f.getOutputTable());
		}
		if(!passed)
		{
			System.out.println("TEST NOT PASSED!");
			return;
		}


		System.out.println("Testing: all parameters are 0");
		{
		//All 0 Edge Case
		LivingWood l = new LivingWood(0,0);
		DeadWood d = new DeadWood(0,0,0.0F);
		HarvestedWood h = new HarvestedWood(0,0,0F);
		Forest f = new Forest(l,d,h);
		for(int i = 0; i<10; i++)
		{
			f.updateForest();
			passed = passed && zeroSumTest(f);
			passed = passed && nonNegativeTest(f);
		}
		System.out.println(f.getOutputTable());
		}
		if(!passed)
		{
			System.out.println("TEST NOT PASSED!");
			return;
		}



		System.out.println("Testing: all parameters are 1");
		{
		//All 1 Edge Case
		LivingWood l = new LivingWood(1,1);
		DeadWood d = new DeadWood(1,1,1F);
		HarvestedWood h = new HarvestedWood(1,1,1F);
		Forest f = new Forest(l,d,h);
		for(int i = 0; i<10; i++)
		{
			f.updateForest();
			passed = passed && zeroSumTest(f);
			passed = passed && nonNegativeTest(f);
		}
		System.out.println(f.getOutputTable());
		}
		if(!passed)
		{
			System.out.println("TEST NOT PASSED!");
			return;
		}



		//Tests below this point reveal bugs!
		//=====================================================


		System.out.println("Testing: Changing parameters between two simulation runs.");
		//Changing Parameters between two updates
		{
		LivingWood l = new LivingWood(10,2);
		DeadWood d = new DeadWood(1,1,1F);
		HarvestedWood h = new HarvestedWood(1,1,1F);
		Forest f = new Forest(l,d,h);
		for(int i = 0; i<=5; i++)
		{
			f.updateForest();
			passed = passed && zeroSumTest(f);
			passed = passed && nonNegativeTest(f);
		}
		f.setHarvestPerYear(1000);
		for(int i = 0; i<=5; i++)
		{
			f.updateForest();
			passed = passed && zeroSumTest(f);
			passed = passed && nonNegativeTest(f);
		}
		System.out.println(f.getOutputTable());
		}
		if(!passed)
		{
			System.out.println("TEST NOT PASSED!");
			return;
		}


		System.out.println("Testing Harvestedwood: amount=1,addition=1,decay=0F");
		{
		//Negative values still appear in LivingWood
		LivingWood l = new LivingWood(0,0);
		DeadWood d = new DeadWood(0,0,0.0F);
		HarvestedWood h = new HarvestedWood(1,1,0F);
		Forest f = new Forest(l,d,h);
		for(int i = 0; i<10; i++)
		{
			f.updateForest();
			passed = passed && zeroSumTest(f);
			passed = passed && nonNegativeTest(f);
		}
		System.out.println(f.getOutputTable());
		}
		if(!passed)
		{
			System.out.println("TEST NOT PASSED!");
			return;
		}

		System.out.println("Testing mixed parameters.");
		{
		//Harvestedwood is decreasing (since it's been used) but never releasing CO2.
		LivingWood l = new LivingWood(1,0);
		DeadWood d = new DeadWood(0,0,0.0F);
		HarvestedWood h = new HarvestedWood(1,0,0.5F);
		Forest f = new Forest(l,d,h);
		for(int i = 0; i<10; i++)
		{
			f.updateForest();
			passed = passed && zeroSumTest(f);
			passed = passed && nonNegativeTest(f);
		}
		System.out.println(f.getOutputTable());
		}
		if(!passed)
		{
			System.out.println("TEST NOT PASSED!");
			return;
		}


		System.out.println("Testing Deadwood: amount=2,addition=0,decay=0.1F. Relevant for proper decay testing.");
		{
		//Deadwood is decreasing (since it's decaying) but never releasing CO2.
		LivingWood l = new LivingWood(0,0);
		DeadWood d = new DeadWood(2,0,0.1F);
		HarvestedWood h = new HarvestedWood(0,0,0.0F);
		Forest f = new Forest(l,d,h);
		for(int i = 0; i<10; i++)
		{
			f.updateForest();
			passed = passed && zeroSumTest(f);
			passed = passed && nonNegativeTest(f);
		}
		System.out.println(f.getOutputTable());
		}
		if(!passed)
		{
			System.out.println("TEST NOT PASSED!");
			return;
		}

		System.out.println("Testing Deadwood: amount=0,addition=2,decay=0.0F. Relevant for Livingwood decease testing.");
		{
		//Livingwood never gets decreased even though DeadWood is gaining amount.
		LivingWood l = new LivingWood(10,0);
		DeadWood d = new DeadWood(0,2,0.0F);
		HarvestedWood h = new HarvestedWood(0,0,0.0F);
		Forest f = new Forest(l,d,h);
		for(int i = 0; i<10; i++)
		{
			f.updateForest();
			passed = passed && zeroSumTest(f);
			passed = passed && nonNegativeTest(f);
		}
		System.out.println(f.getOutputTable());
		}
		if(!passed)
		{
			System.out.println("TEST NOT PASSED!");
			return;
		}

		if(passed)
		{
			System.out.println("PASSED ALL TESTS!");
			return;
		}

		
	
		


		//Mass Testing
		boolean mass_testing = false;
		if (mass_testing)
		{
			int testSize = 4;

			ArrayList<LivingWood> lwTests = new ArrayList<LivingWood>();
			for(int amount = 0; amount < testSize; amount++)
			{
				for(int addition = 0; addition < testSize; addition++)
				{
				lwTests.add(new LivingWood(amount*100,addition*3));
				}
			}

			ArrayList<DeadWood> dwTests = new ArrayList<DeadWood>();
			for(int amount = 0; amount < testSize; amount++)
			{
				for(int addition = 0; addition < testSize; addition++)
				{
					for(float decay = 0F; decay <= 1; decay = decay + 0.1F)
					{
					dwTests.add(new DeadWood(amount,addition,decay*0));
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
					hwTests.add(new HarvestedWood(amount,harvest,usage*0));
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

			int updates = 2;
			int sub = 0;
			int progress = 1;

			try
			{
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
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

			
		}

				




		
	}

}
