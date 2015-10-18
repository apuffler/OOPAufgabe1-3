public class HarvestedWood extends Wood{
    private int harvestPerYear;
    private float usagePerYear;

    public HarvestedWood(int amount, int harvestPerYear, float usagePerYear){
        super(amount);
        this.harvestPerYear = harvestPerYear;
        this.usagePerYear = usagePerYear;
    }

    public int getHarvestPerYear(){
        return this.harvestPerYear;
    }

    public void setHarvestPerYear(int harvestPerYear){
        this.harvestPerYear = harvestPerYear;
    }

    public float getUsagePerYear(){
        return this.usagePerYear;
    }

    public void setUsagePerYear(float usagePerYear){
        this.usagePerYear = usagePerYear;
    }

    public void updateWood(int decayedWood){
        this.amount *= (1 - this.usagePerYear);
        this.amount += this.harvestPerYear - decayedWood;
    }
}