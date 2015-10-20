
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
        this.outputTable += this.toString();
    }


    public int getYear()
    {
        return this.year;
    }

    /*Getter for CO2*/
    public int getBoundCO2()
    {
        return this.co2.getBoundCO2();
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
        //int currentlyBoundCO2 = (co2.getBoundCO2()-co2.getReleasedCO2() < 0 ? 0 : co2.getBoundCO2()-co2.getReleasedCO2());
        return String.format("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n", this.getYear(), livingWood.getAmount(), deadWood.getAmount(), harvestedWood.getAmount(), totallyUsedWood, this.co2.getBoundCO2());
    }

    public void updateForest(){
        this.year++;
        this.totallyUsedWood += this.harvestedWood.usedWood();
        this.deadWood.decayWood();
        this.livingWood.yearlyAddition();
        // increase deadWood by addition per year or amount of livingWood if not enough remaining & reduces livingWood by corresponding amount
        this.deadWood.updateWood(this.livingWood.updateWood(this.deadWood.getAdditionPerYear()));
        // increase harvestedWood by addition per year or amount of livingWood if not enough remaining & reduces livingWood by corresponding amount
        this.harvestedWood.updateWood(this.livingWood.updateWood(this.harvestedWood.getHarvestPerYear()));


        this.co2.setBoundCO2(this.harvestedWood.getAmount() + this.livingWood.getAmount() + this.deadWood.getAmount());
        /*
            !add livingwood addition per year
            !reduce livingwood by new deadwood - check amount
            !update amount of deadwood
            !reduce livingwood by harvest - check amount
            !reduce harvestedwood by usage - check amount
            !increase totallyUsedWood
            !update amount of harvestedWood

            !set amount of bound co2



        totallyUsedWood += harvestedWood.getHarvestPerYear();
        
        deadWood.updateWood();
        harvestedWood.updateWood(deadWood.getAdditionPerYear());
        livingWood.updateWood(harvestedWood.getHarvestPerYear());
        */
        this.outputTable += this.toString();
    }
    
    public void updateForest(int simulatedTimeSpan){
        for(int i = 0; i < simulatedTimeSpan; ++i){
           this.updateForest();
        }
    }

    public int getTotallyUsedWood(){
        return this.totallyUsedWood;
    }

    public String getOutputTable(){
        return this.outputTable;
    }
}
