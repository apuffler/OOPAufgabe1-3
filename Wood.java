abstract class Wood{
    protected int amount;

    public Wood(){
        this.amount = 0;
    }

    public Wood(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return this.amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }
}