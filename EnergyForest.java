
public class EnergyForest extends Forest {

    /**
     * Default constructor of the EnergyForest class, calls the constructor of the parent class forest
     */
    public EnergyForest(){
        super();
    }

    public EnergyForest(int livingWoodAmount, int harvestedWoodAmount, float harvestedWoodUsagePerYear, int deadWoodAmount, Environment env, Economy eco){
        super(livingWoodAmount, harvestedWoodAmount, harvestedWoodUsagePerYear, deadWoodAmount, env, eco);
        this.relaxationValue = 1;
    }

    /**
     * Returns a copy of the current EnergyForest (it's a copy constructor in method form, because an abstract class can't have a copy constructor)
     *
     * @return (YoungForest)
     */
    public EnergyForest makeCopy(){
        return new EnergyForest(this.livingWoodAmount, this.harvestedWoodAmount, this.harvestedWoodUsagePerYear, this.deadWoodAmount, this.env, this.eco);
    }

    /**
     * Updates the changes in the forest during one time period: calculates the increase/decrease of livingWood, harvestedWood, deadWood
     * as well as the amount of totallyUsedWood and boundCO2
     *
     * @param (e) Variable of Type Environment, used to influence the rate of growth in the forest
     */
    public void updateForest(Environment e){
        if(this.livingWoodAmount == 1) // log(1) = 0 so we have to tweak it a little
            this.livingWoodAmount++;

        float decay = ((float)Math.log((double)this.livingWoodAmount/ 2.0) / 100);
        this.deadWoodAmount += (int)(this.livingWoodAmount * decay);
        this.livingWoodAmount -= (int)(this.livingWoodAmount * decay);

        float multi = e.getHumidity() * e.getSunshine() * e.getPrecipitation() * e.getTemperature();
        this.livingWoodAmount += ((Math.exp((double)multi) /100) * this.livingWoodAmount);

        // high harvest
        float harvest = (float)((Math.log((double)this.livingWoodAmount) / 100) * 2.3);
        this.harvestedWoodAmount += (int)(this.livingWoodAmount * harvest);
        this.livingWoodAmount -= (int)(this.livingWoodAmount * harvest);

        this.totallyUsedWood += (int)(this.harvestedWoodAmount * this.harvestedWoodUsagePerYear);
        this.harvestedWoodAmount -= (int)(this.harvestedWoodAmount * this.harvestedWoodUsagePerYear);
        this.boundCO2 = this.livingWoodAmount + this.harvestedWoodAmount + this.deadWoodAmount;
    }
}
