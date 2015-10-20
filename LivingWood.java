public class LivingWood extends Wood{
    private int additionPerYear;

    public LivingWood(int amount, int additionPerYear){
        super(amount);
        if(additionPerYear < 0)
            throw new IllegalArgumentException("LivingWood: Addition-per-year must be greater than zero.");
        if(amount < 0)
            throw new IllegalArgumentException("LivingWood: Addition per year can not be below zero");
        this.additionPerYear = additionPerYear;
    }

    public int getAdditionPerYear(){
        return this.additionPerYear;
    }

    public void setAdditionPerYear(int additionPerYear){
        if(additionPerYear < 0)
            throw new IllegalArgumentException("LivingWood: Addition-per-year must be greater than zero.");
        this.additionPerYear = additionPerYear;
    }

    public void yearlyAddition(){
        this.amount += this.additionPerYear;
    }

    public int updateWood(int reduceAmount){
        if(this.amount >= reduceAmount){
            this.amount -= reduceAmount;
            return reduceAmount;
        }else{
            reduceAmount = this.amount;
            this.amount = 0;
            return reduceAmount;
        }
    }
}
