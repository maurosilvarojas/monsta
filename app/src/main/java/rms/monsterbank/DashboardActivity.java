package rms.monsterbank;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;



import rms.monsterbank.Model.Customer;
import rms.monsterbank.Model.Deposit;

public class DashboardActivity extends Activity {
    Customer newCustomer;
    Gson gson = new Gson();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Serializable extras = getIntent().getSerializableExtra("newCustomer");

        SharedPreferences sharedPreferences= getSharedPreferences("customerInfo", Context.MODE_PRIVATE);
        String body = sharedPreferences.getString("customerInfo","");
        newCustomer = gson.fromJson(body,Customer.class);
        Log.d("Debugging", "Shared preference: "+ newCustomer.getCustomername());


        //UI instances
        TextView accNumber = (TextView)findViewById(R.id.accNumberLabel);
        TextView balanceLabel = (TextView)findViewById(R.id.balanceLabel);

        accNumber.setText(newCustomer.getAccountNumber());
        balanceLabel.setText(newCustomer.getBalance());


    }
    public void backLoginEvent (View view){
        SharedPreferences sharedPreferences= getSharedPreferences("customerInfo", Context.MODE_PRIVATE);
        sharedPreferences.edit().remove("customerInfo");
        Log.d("Debugging", "Loading Login activity");

        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void startDetailsActivity (View view){
        Intent intent = new Intent(this,AccountDetails.class);
        startActivity(intent);
    }

    public void startPaymentsActivity (View view){
        Intent intent = new Intent(this,Deposit.class);
        startActivity(intent);
    }

    public void startAllInOutActivity (View view){
        Intent intent = new Intent(this,AllInOut.class);
        startActivity(intent);
    }

    public void startBrachFinder (View view){
        Intent intent = new Intent(this,BranchFinder.class);
        startActivity(intent);
    }

    public void startChatSupport (View view){
        Intent intent = new Intent(this,ChatActivity.class);
        startActivity(intent);
    }


}
