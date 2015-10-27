
public class YoungForest extends Forest {

    public YoungForest(){
        super();
    }

    public YoungForest(int livingWoodAmount, int harvestedWoodAmount, float harvestedWoodUsagePerYear, int deadWoodAmount, Environment env, Economy eco){
        super(livingWoodAmount, harvestedWoodAmount, harvestedWoodUsagePerYear, deadWoodAmount, env, eco);
        this.relaxationValue = 0;
        }

    public YoungForest makeCopy(){
        return new YoungForest(this.livingWoodAmount, this.harvestedWoodAmount, this.harvestedWoodUsagePerYear, this.deadWoodAmount, this.env, this.eco);
    }

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
