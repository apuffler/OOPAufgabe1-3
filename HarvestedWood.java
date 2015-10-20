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

    public int usedWood(){
        // This needs to be changed so that amounts can reach zero
        int used = (int)(this.amount * this.usagePerYear);
        this.amount *= (1 - this.usagePerYear);
        return used;
    }

    public void updateWood(int addition){
        this.amount += addition;
    }
}
