
public class YoungForest extends Forest {

    /**
     * Default constructor of the YoungForest class, calls the constructor of the parent class forest
     */
    public YoungForest(){
        super();
    }

    public YoungForest(int livingWoodAmount, int harvestedWoodAmount, float harvestedWoodUsagePerYear, int deadWoodAmount, Environment env, Economy eco){
        super(livingWoodAmount, harvestedWoodAmount, harvestedWoodUsagePerYear, deadWoodAmount, env, eco);
        this.relaxationValue = 0;
        }

    /**
     * Returns a copy of the current YoungForest (it's a copy constructor in method form, because an abstract class can't have a copy constructor)
     *
     * @return (YoungForest)
     */
    public YoungForest makeCopy(){
        return new YoungForest(this.livingWoodAmount, this.harvestedWoodAmount, this.harvestedWoodUsagePerYear, this.deadWoodAmount, this.env, this.eco);
    }

    /**
     * Updates the changes in the forest during one time period: calculates the increase/decrease of livingWood, harvestedWood, deadWood
     * as well as the amount of totallyUsedWood and boundCO2
     *
     * @param (e) Variable of Type Environment, used to influence the rate of growth in the forest
     */
    public void updateForest(Environment e){
        float multi = e.getHumidity() * e.getSunshine() * e.getPrecipitation() * e.getTemperature();
        if(this.livingWoodAmount == 1) // log(1) = 0 so we have to tweak it a little
            this.livingWoodAmount++;

        float decay = ((float)Math.log((double)this.livingWoodAmount/ 6.0) / 100);
        this.deadWoodAmount += (int)(this.livingWoodAmount * decay);
        this.livingWoodAmount -= (int)(this.livingWoodAmount * decay);

        this.livingWoodAmount += (((Math.log((double)this.livingWoodAmount * multi)) /100) * this.livingWoodAmount);

        // no harvest in a young forest, so there is also no totallyUsedWood
        this.boundCO2 = this.livingWoodAmount + this.harvestedWoodAmount + this.deadWoodAmount;
    }
}
