package rms.monsterbank.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by regga on 08/04/2017.
 */

public class Deposit {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("spurce")
    @Expose
    private String source;
    @SerializedName("amount")
    @Expose
    private String amount;

    public Deposit(String id, String date, String source, String amount) {
        this.id = id;
        this.date = date;
        this.source = source;
        this.amount = amount;
    }
    public  Deposit(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

