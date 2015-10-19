abstract class Wood{
    protected int amount;

    public Wood(){
        this.amount = 0;
    }

    public Wood(int amount){
        if(amount < 0)
            throw new IllegalArgumentException("Wood: Amount-Value must be greater than zero.");
        this.amount = amount;
    }

    public int getAmount(){
        return this.amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }
}
