
public abstract class Forest{
    protected int livingWoodAmount;
    protected int harvestedWoodAmount;
    protected int harvestedWoodHarvestPerYear;
    protected float harvestedWoodUsagePerYear;
    protected int deadWoodAmount;
    protected int deadWoodAdditionPerYear;
    protected float deadWoodDecayPerYear;
    protected int totallyUsedWood;
    protected int boundCO2;
    protected Environment env;
    protected Economy eco;

    public Forest(){
        this.livingWoodAmount = 0;
        this.harvestedWoodAmount = 0;
        this.harvestedWoodHarvestPerYear = 0;
        this.harvestedWoodUsagePerYear = 0;
        this.deadWoodAmount = 0;
        this.deadWoodAdditionPerYear = 0;
        this.deadWoodDecayPerYear  = 0;
        this.totallyUsedWood = 0;
        this.env = new Environment(0,0,0,0);
        this.eco = new Economy(0,0,0);
    }

    public Forest(int livingWoodAmount, int harvestedWoodAmount, int harvestedWoodHarvestPerYear, float harvestedWoodUsagePerYear, int deadWoodAmount, int deadWoodAdditionPerYear, float deadWoodDecayPerYear, Environment env, Economy eco){

        // LivingWood
        if(this.livingWoodAmount < 0)
            throw new IllegalArgumentException("LivingWood: Amount can't be below zero.");
        this.livingWoodAmount = livingWoodAmount;

        // HarvestedWood
        if(this.harvestedWoodAmount < 0)
            throw new IllegalArgumentException("HarvestedWood: Amount can't be below zero.");
        this.harvestedWoodAmount = harvestedWoodAmount;
        if(this.harvestedWoodHarvestPerYear < 0)
            throw new IllegalArgumentException("HarvestedWood: Harvest per year can't be below zero.");
        this.harvestedWoodHarvestPerYear = harvestedWoodHarvestPerYear;
        if(this.harvestedWoodUsagePerYear < 0.0 || this.harvestedWoodUsagePerYear > 1.0)
            throw new IllegalArgumentException("HarvestedWood: Usage per year can't be below zero or above one.");
        this.harvestedWoodUsagePerYear = harvestedWoodUsagePerYear;

        // DeadWood
        if(this.deadWoodAmount < 0)
            throw new IllegalArgumentException("DeadWood: Amount can't be below zero.");
        this.deadWoodAmount = deadWoodAmount;
        if(this.deadWoodAdditionPerYear < 0)
            throw new IllegalArgumentException("DeadWood: Addition per year can't be below zero.");
        this.deadWoodAdditionPerYear = deadWoodAdditionPerYear;
        if(this.deadWoodDecayPerYear < 0.0 || this.deadWoodDecayPerYear > 1.0)
            throw new IllegalArgumentException("DeadWood: Decay per year can't be below zero or above one.");
        this.deadWoodDecayPerYear  = deadWoodDecayPerYear;

        this.env = env;
        this.eco = eco;
    }

    public void setLivingWoodAmount(int amount){
        this.livingWoodAmount = amount;
    }

    public int getLivingWoodAmount(){
        return this.livingWoodAmount;
    }

    public void setHarvestedWoodAmount(int amount){
        this.harvestedWoodAmount = amount;
    }

    public int getHarvestedWoodAmount(){
        return this.harvestedWoodAmount;
    }

    public void setHarvestedWoodHarvestPerYear(int harvest){
        this.harvestedWoodHarvestPerYear = harvest;
    }

    public int getHarvestedWoodHarvestPerYear(){
        return this.harvestedWoodHarvestPerYear;
    }

    public void setHarvestedWoodUsagePerYear(float usage){
        this.harvestedWoodUsagePerYear = usage;
    }

    public float getHarvestedWoodUsagePerYear(){
        return this.harvestedWoodUsagePerYear;
    }

    public void setDeadWoodAmount(int amount){
        this.deadWoodAmount = amount;
    }

    public int getDeadWoodAmount(){
        return this.deadWoodAmount;
    }

    public void setDeadWoodAdditionPerYear(int addition){
        this.deadWoodAdditionPerYear = addition;
    }

    public int getDeadWoodAdditionPerYear(){
        return this.deadWoodAdditionPerYear;
    }

    public void setDeadWoodDecayPerYear(float decay){
        this.deadWoodDecayPerYear = decay;
    }

    public float getDeadWoodDecayPerYear(){
        return this.deadWoodDecayPerYear;
    }

    public void setTotallyUsedWood(int amount){
        this.totallyUsedWood = amount;
    }

    public int getTotallyUsedWood(){
        return this.totallyUsedWood;
    }

    public abstract void updateForest(Environment e);

}
