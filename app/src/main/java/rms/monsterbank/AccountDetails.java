package rms.monsterbank;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import rms.monsterbank.Model.Customer;

public class AccountDetails extends Activity {
    Customer newCustomer;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);

        SharedPreferences sharedPreferences= getSharedPreferences("customerInfo", Context.MODE_PRIVATE);
        String body = sharedPreferences.getString("customerInfo","");
        newCustomer = gson.fromJson(body,Customer.class);
        Log.d("Debugging", "Shared preference Details: "+ newCustomer.getCustomername());


        String [] customerDetails={ "Name:"+newCustomer.getCustomername(),
                                    "Surname:"+newCustomer.getCustomerSurname(),
                                    "Acc Numb:"+newCustomer.getAccountNumber(),
                                    "Mobile Number:"+newCustomer.getMobileNumber(),
                                    "Sort Code:"+newCustomer.getSortCode(),
                                    "Address:"+newCustomer.getAddress(),
                                    "Post Code:"+newCustomer.getPostCode(),
                                    "City:"+newCustomer.getCity(),
                                    "Username:"+newCustomer.getUsername() };

        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,customerDetails);
        ListView listView = (ListView)findViewById(R.id.detailsListView);
        listView.setAdapter(listAdapter);
    }

    public void editPersonalInfoEvent (View view){
        Intent intent = new Intent(this,UpdateData.class);
        startActivity(intent);
    }


}
