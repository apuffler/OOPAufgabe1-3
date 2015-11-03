
public class RelaxationForest extends Forest {

    /**
     * Default constructor of the RelaxationForest class, calls the constructor of the parent class forest
     */
    public RelaxationForest(){
        super();
    }

    public RelaxationForest(int livingWoodAmount, int harvestedWoodAmount, float harvestedWoodUsagePerYear, int deadWoodAmount, Environment env, Economy eco){
        super(livingWoodAmount, harvestedWoodAmount, harvestedWoodUsagePerYear, deadWoodAmount, env, eco);
        this.relaxationValue = 3;
    }

    /**
     * Returns a copy of the current RelaxationForest (it's a copy constructor in method form, because an abstract class can't have a copy constructor)
     *
     * @return (YoungForest)
     */
    public RelaxationForest makeCopy(){
        return new RelaxationForest(this.livingWoodAmount, this.harvestedWoodAmount, this.harvestedWoodUsagePerYear, this.deadWoodAmount, this.env, this.eco);
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

        float decay = ((float)Math.log((double)this.livingWoodAmount/ 5.0) / 100);
        this.deadWoodAmount += (int)(this.livingWoodAmount * decay);
        this.livingWoodAmount -= (int)(this.livingWoodAmount * decay);

        float multi = e.getHumidity() * e.getSunshine() * e.getPrecipitation() * e.getTemperature();
        if(this.livingWoodAmount == 1) // log(1) = 0 so we have to tweak it a little
            this.livingWoodAmount++;
        this.livingWoodAmount += ((((Math.log((double)this.livingWoodAmount * multi)) /100) * 1.5) * this.livingWoodAmount);

        // low harvest
        float harvest = ((float)Math.log((double)this.livingWoodAmount) / 100);
        this.harvestedWoodAmount += (int)(this.livingWoodAmount * harvest);
        this.livingWoodAmount -= (int)(this.livingWoodAmount * harvest);

        this.totallyUsedWood += (int)(this.harvestedWoodAmount * this.harvestedWoodUsagePerYear);
        this.harvestedWoodAmount -= (int)(this.harvestedWoodAmount * this.harvestedWoodUsagePerYear);
        this.boundCO2 = this.livingWoodAmount + this.harvestedWoodAmount + this.deadWoodAmount;
    }
}
