package sample;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Functions {

    private ArrayList<BudgetEntry> funcHold;

    public Functions(){ this.funcHold = storeEntries(); }
    public BudgetEntry getEntry(int i){ return funcHold.get(i); }
    public int getSize(){ return funcHold.size(); }

    public String getTotal(){
        int sum = 0;
        for (int i = 0; i < funcHold.size(); i++){
            sum += (funcHold.get(i)).getAmount();
        }
        return Integer.toString(sum);
    }

    public ArrayList<BudgetEntry> storeEntries(){
        ArrayList<BudgetEntry> funcHold = new ArrayList<>();

        //TODO this area will pull from DB and format into arraylist of budgetentries
        Date d = new Date();
        funcHold.add(new BudgetEntry(d, 300));
        funcHold.add(new BudgetEntry(d, -200));

        return funcHold;
    }
}