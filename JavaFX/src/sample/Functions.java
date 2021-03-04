package sample;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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

    public boolean signIn(){
        //TODO check with DB and return if exists
        boolean signIn = true;
        try {
            URL url = new URL("http://localhost:8080/api/v1/user");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            int responseCode = con.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                String in = "";
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    in += scanner.nextLine();
                }
                scanner.close();

                System.out.println(in);
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }

        this.funcHold = storeEntries();

        return signIn;
    }

    public void registerNew(String uname, String pword, String email, String name, String initAmt){
        //TODO check with DB and return if exists
        try {
            URL url = new URL("http://localhost:8080/api/v1/user");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            String inString = "{\"username\": \""+uname+"\",\"password\": \""+pword+"\", \"email\": \""+email+"\", \"name\": \""+name+"\", \"initialAmount\": "+initAmt+"}";

            OutputStream os = con.getOutputStream();
            byte[] input = inString.getBytes("utf-8");
            os.write(input, 0, input.length);

            int responseCode = con.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
                StringBuilder response = new StringBuilder();
                String outLine;
                while((outLine = br.readLine()) != null){
                    response.append(outLine.trim());
                }

                System.out.println(response.toString());
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
