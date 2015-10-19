public class HarvestedWood extends Wood{
    private int harvestPerYear;
    private float usagePerYear;

    public HarvestedWood(int amount, int harvestPerYear, float usagePerYear){
        super(amount);
        if(harvestPerYear < 0)
            throw new IllegalArgumentException("HarvestedWood: Harvest per year can't be below zero");
        if(usagePerYear < 0.0 || usagePerYear > 1.0)
            throw new IllegalArgumentException("HarvestedWood: Usage per year has to be between 0.0 and 1.0");
        this.harvestPerYear = harvestPerYear;
        this.usagePerYear = usagePerYear;
    }

    public int getHarvestPerYear(){
        return this.harvestPerYear;
    }

    public void setHarvestPerYear(int harvestPerYear){
        if(harvestPerYear < 0)
            throw new IllegalArgumentException("HarvestedWood: Harvest per year can't be below zero");
        this.harvestPerYear = harvestPerYear;
    }

    public float getUsagePerYear(){
        return this.usagePerYear;
    }

    public void setUsagePerYear(float usagePerYear){
        if(usagePerYear < 0.0 || usagePerYear > 1.0)
            throw new IllegalArgumentException("HarvestedWood: Usage per year has to be between 0.0 and 1.0");
        this.usagePerYear = usagePerYear;
    }

    public void updateWood(int decayedWood){
        this.amount *= (1 - this.usagePerYear);
        this.amount += this.harvestPerYear - decayedWood;
    }
}
