public class DeadWood extends Wood{
    private int additionPerYear;
    private float decayPerYear;

    public DeadWood(int amount, int additionPerYear, float decayPerYear){
        super(amount);
        if(additionPerYear < 0)
            throw new IllegalArgumentException("DeadWood: Addition per year can't be below zero");
        if(decayPerYear < 0.0 || decayPerYear > 1.0)
            throw new IllegalArgumentException("DeadWood: Decay per year has to be between 0.0 and 1.0");
        this.additionPerYear = additionPerYear;
        this.decayPerYear = decayPerYear;
    }

    public int getAdditionPerYear(){
        return this.additionPerYear;
    }

    public void setAdditionPerYear(int additionPerYear){
        if(additionPerYear < 0)
            throw new IllegalArgumentException("DeadWood: Addition per year can't be below zero");
        this.additionPerYear = additionPerYear;
    }

    public float getDecayPerYear(){
        return this.decayPerYear;
    }

    public void setDecayPerYear(float decayPerYear){
        if(decayPerYear < 0.0 || decayPerYear > 1.0)
            throw new IllegalArgumentException("DeadWood: Decay per year has to be between 0.0 and 1.0");
        this.decayPerYear = decayPerYear;
    }

    public void decayWood(){
        // This needs to be changed so that amounts can reach zero
        this.amount *= (1 - this.decayPerYear);
    }

    public void updateWood(int addition){
        this.amount += addition;
    }
}
