
public class Forest{
    private LivingWood livingWood;
    private DeadWood deadWood;
    private HarvestedWood harvestedWood;
    private CO2 co2;
    private int totallyUsedWood;
    private int year;
    private String outputTable;

    public Forest(LivingWood livingwood, DeadWood deadWood, HarvestedWood harvestedWood){
        this.livingWood = livingwood;
        this.harvestedWood = harvestedWood;
        this.deadWood = deadWood;
        this.co2 = new CO2();
        this.co2.setBoundCO2(this.livingWood.getAmount() + this.harvestedWood.getAmount() + this.deadWood.getAmount());
        this.year = 0;
        this.outputTable = String.format("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n", "Year", "LivingWood", "DeadWood", "HarvestedWood", "UsedWood", "BoundCO2");
        this.outputTable += String.format("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n", this.year, this.livingWood.getAmount(), this.deadWood.getAmount(), this.harvestedWood.getAmount(), this.totallyUsedWood, this.co2.getBoundCO2());
    }


    public int getYear()
    {
        return this.year;
    }


    /** Getter and Setter for LivingWood*/

    public int getLivingWood(){
        return this.livingWood.getAmount();
    }

    public void setLivingWood(int amount){
        this.livingWood.setAmount(amount);
    }

    /** Getter and Setter for HarvestedWood*/

    public int getHarvestedWood(){
        return this.harvestedWood.getAmount();
    }

    public void setHarvestedWood(int amount){
        this.harvestedWood.setAmount(amount);
    }

    public int getHarvestPerYear(){
        return this.harvestedWood.getHarvestPerYear();
    }

    public void setHarvestPerYear(int harvestPerYear){
        this.harvestedWood.setHarvestPerYear(harvestPerYear);
    }

    public float getHarvestedUsage(){
        return this.harvestedWood.getUsagePerYear();
    }

    public void setHarvestedUsage(float percent){
        this.harvestedWood.setUsagePerYear(percent);
    }

    /** Getter and Setter for DeadWood*/

    public int getDeadWood(){
        return this.deadWood.getAmount();
    }

    public void setDeadWood(int amount){
        this.deadWood.setAmount(amount);
    }

    public int getDeadWoodAddition(){
        return this.deadWood.getAdditionPerYear();
    }

    public void setDeadWoodAddition(int additionPerYear){
        this.deadWood.setAdditionPerYear(additionPerYear);
    }

    public float getDeadDecay(){
        return this.deadWood.getDecayPerYear();
    }

    public void setDeadDecay(float percent){
        this.deadWood.setDecayPerYear(percent);
    }

    public String toString()
    {
        return String.format("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n", this.getYear(),livingWood.getAmount(), deadWood.getAmount(), harvestedWood.getAmount(), totallyUsedWood, co2.getBoundCO2());
    }

    public void updateForest(){
        totallyUsedWood += harvestedWood.getHarvestPerYear();

        deadWood.updateWood();
        harvestedWood.updateWood(deadWood.getAdditionPerYear());
        livingWood.updateWood(harvestedWood.getHarvestPerYear());
        this.year++;
        this.outputTable += this.toString();
    }

    public int getTotallyUsedWood(){
        return this.totallyUsedWood;
    }

    public String getOutputTable(){
        return this.outputTable;
    }
}