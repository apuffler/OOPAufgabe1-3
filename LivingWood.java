public class LivingWood extends Wood{
    private int additionPerYear;

    public LivingWood(int amount, int additionPerYear){
        super(amount);
        if(additionPerYear < 0)
            throw new IllegalArgumentException("LivingWood: Addition-per-year must be greater than zero.");
        this.additionPerYear = additionPerYear;
    }

    public int getAdditionPerYear(){
        return this.additionPerYear;
    }

    public void setAdditionPerYear(int additionPerYear){
        this.additionPerYear = additionPerYear;
    }

    public void updateWood(int harvestedAmount){
        this.amount += additionPerYear - harvestedAmount;
    }
}
