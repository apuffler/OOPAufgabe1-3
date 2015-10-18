public class DeadWood extends Wood{
    private int additionPerYear;
    private float decayPerYear;

    public DeadWood(int amount, int additionPerYear, float decayPerYear){
        super(amount);
        this.additionPerYear = additionPerYear;
        this.decayPerYear = decayPerYear;
    }

    public int getAdditionPerYear(){
        return this.additionPerYear;
    }

    public void setAdditionPerYear(int additionPerYear){
        this.additionPerYear = additionPerYear;
    }

    public float getDecayPerYear(){
        return this.decayPerYear;
    }

    public void setDecayPerYear(float decayPerYear){
        this.decayPerYear = decayPerYear;
    }

    public void updateWood(){
        this.amount *= (1 - this.decayPerYear);
        this.amount += this.additionPerYear;
    }
}