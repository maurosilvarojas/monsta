package rms.monsterbank.Model;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by s16442932 on 15/03/2017.
 */

public class Customer  {


    @SerializedName("idcustomer")
    @Expose
    private String idcustomer;
    @SerializedName("customername")
    @Expose
    private String customername;
    @SerializedName("customerSurname")
    @Expose
    private String customerSurname;
    @SerializedName("accountNumber")
    @Expose
    private String accountNumber;
    @SerializedName("sortCode")
    @Expose
    private String sortCode;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("postCode")
    @Expose
    private String postCode;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("balance")
    @Expose
    private String balance;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;

    public Customer(String idcustomer, String customername, String customerSurname, String accountNumber, String sortCode, String mobileNumber, String address, String postCode, String city, String balance, String username, String password) {
        this.idcustomer = idcustomer;
        this.customername = customername;
        this.customerSurname = customerSurname;
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.postCode = postCode;
        this.city = city;
        this.balance = balance;
        this.username = username;
        this.password = password;
    }

    public String getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(String idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


