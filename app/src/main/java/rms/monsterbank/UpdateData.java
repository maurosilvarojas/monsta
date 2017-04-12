package rms.monsterbank;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import rms.monsterbank.Model.Customer;
import rms.monsterbank.R;

public class UpdateData extends Activity {

    Customer newCustomer;
    Gson gson = new Gson();
    //UI Instnces


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        SharedPreferences sharedPreferences= getSharedPreferences("customerInfo", Context.MODE_PRIVATE);
        String body = sharedPreferences.getString("customerInfo","");
        newCustomer = gson.fromJson(body,Customer.class);
        Log.d("Debugging", "Shared preferences UpdateData Act: "+ newCustomer.getCustomername());


        EditText mobileNumberText = (EditText)findViewById(R.id.mobileNumberText);
        EditText addressText = (EditText)findViewById(R.id.addressText);
        EditText postcodeText = (EditText)findViewById(R.id.postCodeText);
        EditText cityText = (EditText)findViewById(R.id.cityText);
        mobileNumberText.setText(newCustomer.getMobileNumber());
        addressText.setText(newCustomer.getAddress());
        postcodeText.setText(newCustomer.getPostCode());
        cityText.setText(newCustomer.getCity());

    }

    public void submitEvent (View view){
        //url Sample  http://www.computing.northampton.ac.uk/~16442932/phpFiles/updateDetails.php?idcustomer=%222%22&mobileNumber=%22444%22

        EditText mobileNumberText = (EditText)findViewById(R.id.mobileNumberText);
        EditText addressText = (EditText)findViewById(R.id.addressText);
        EditText postcodeText = (EditText)findViewById(R.id.postCodeText);
        EditText cityText = (EditText)findViewById(R.id.cityText);
        Log.d("Debugging", "New MobileNUmber: "+ mobileNumberText);

        String mobilenumber =mobileNumberText.getText().toString();
        String address =addressText.getText().toString();
        String postcode =postcodeText.getText().toString();
        String city =cityText.getText().toString();



        String idcustomer = newCustomer.getIdcustomer();
        Log.d("Debugging", "ID customer for Update: "+ idcustomer);
        updateFields(idcustomer,mobilenumber,address,postcode,city);
        Toast toast = Toast.makeText(this,"Submitted", Toast.LENGTH_LONG);
        toast.show();

        //SharedPreferences sharedPreferences = getSharedPreferences("customerInfo", Context.MODE_PRIVATE);
        //sharedPreferences.edit().clear().commit();

        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    private void updateFields(String idcustomer,String mobile,String address,String postcode,String city) {

        final String mobileNumber = "\""+mobile+"\"";
        final String customerID = "\""+idcustomer+"\"";
        final String addressQ = "\""+address+"\"";
        final String postcodeQ = "\""+postcode+"\"";
        final String cityQ = "\""+city+"\"";

        post("http://www.computing.northampton.ac.uk/~16442932/phpFiles/updateDetails.php?idcustomer="+customerID+"&mobileNumber="+mobileNumber+"&address="+addressQ+"&postcode="+postcodeQ+"&city="+cityQ, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("PARSE", "Post Failure");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

//                final String body = response.body().string(); //Get API response
//                Gson gson = new Gson();
//                newCustomer = gson.fromJson(body,Customer.class);
//                Log.d("PARSE", "CUSTOMER ID: "+ newCustomer.getBalance());
//                SharedPreferences sharedPreferences = getSharedPreferences("customerInfo", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor=sharedPreferences.edit();
//                editor.putString("customerInfo",body);
//                editor.apply();
//                Log.d("Debugging", "Loaded Shared Preferences :"+ sharedPreferences.toString());
            }
        });


    }

    private Call post(String url, Callback callback){
        OkHttpClient client = new OkHttpClient();

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(url)
                .get()
                .build();
        Log.d("Debugging", "Post URL :" + url);

        Call call = client.newCall(request);
        call.enqueue(callback);

        return call;
    }



    public void cancelEvent (View view){
        Toast toast = Toast.makeText(this,"Cancelled", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this,AccountDetails.class);
        startActivity(intent);
    }

}
