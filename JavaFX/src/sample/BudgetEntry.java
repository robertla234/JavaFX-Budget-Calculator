package sample;

import java.util.Date;

public class BudgetEntry {

    private Date date;
    private int amount;

    public BudgetEntry(Date date, int amount){
        this.date = date;
        this.amount = amount;
    }

    public Date getDate(){ return date; }
    public void setDate(Date date){ this.date = date; }
    public int getAmount(){ return amount; }
    public void setAmount(int amount){ this.amount = amount; }
}