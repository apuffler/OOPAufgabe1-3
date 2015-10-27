public class MixedForest extends Forest{

    public MixedForest(){
        super();
    }

    public MixedForest(int livingWoodAmount, int harvestedWoodAmount, int harvestedWoodHarvestPerYear, float harvestedWoodUsagePerYear, int deadWoodAmount, int deadWoodAdditionPerYear, float deadWoodDecayPerYear, Environment env, Economy eco){
        super(livingWoodAmount, harvestedWoodAmount, harvestedWoodHarvestPerYear, harvestedWoodUsagePerYear, deadWoodAmount, deadWoodAdditionPerYear, deadWoodDecayPerYear, env, eco);
    }

    public void updateForest(Environment e){
        float multi = e.getHumidity() * e.getSunshine() * e.getPrecipitation() * e.getTemperature();
        this.livingWoodAmount += (((Math.exp(((double)multi / 2)) /100) +1) * this.livingWoodAmount);
        this.boundCO2 = this.livingWoodAmount + this.harvestedWoodAmount + this.deadWoodAmount;
    }
}
