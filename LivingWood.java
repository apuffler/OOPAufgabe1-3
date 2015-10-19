public class LivingWood extends Wood{
    private int additionPerYear;

    public LivingWood(int amount, int additionPerYear){
        if(amount < 0)
            throw IllegalArgumentException("LivingWood: Addition per year can not be below zero");
        super(amount);
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
