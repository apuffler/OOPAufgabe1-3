
public class RelaxationForest extends Forest {

    public RelaxationForest(){
        super();
    }

    public RelaxationForest(int livingWoodAmount, int harvestedWoodAmount, int harvestedWoodHarvestPerYear, float harvestedWoodUsagePerYear, int deadWoodAmount, int deadWoodAdditionPerYear, float deadWoodDecayPerYear, Environment env, Economy eco){
        super(livingWoodAmount, harvestedWoodAmount, harvestedWoodHarvestPerYear, harvestedWoodUsagePerYear, deadWoodAmount, deadWoodAdditionPerYear, deadWoodDecayPerYear, env, eco);
    }

    public void updateForest(Environment e){
        float multi = e.getHumidity() * e.getSunshine() * e.getPrecipitation() * e.getTemperature();
        if(this.livingWoodAmount == 1) // log(1) = 0 so we have to tweak it a little
            this.livingWoodAmount++;
        this.livingWoodAmount += (((((Math.log((double)this.livingWoodAmount * multi)) /100) * 1.5) + 1) * this.livingWoodAmount);
        this.boundCO2 = this.livingWoodAmount + this.harvestedWoodAmount + this.deadWoodAmount;
    }
}
