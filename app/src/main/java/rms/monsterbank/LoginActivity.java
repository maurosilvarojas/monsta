package rms.monsterbank;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;


import com.google.gson.Gson;
import org.json.JSONException;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import rms.monsterbank.Model.Customer;



public class LoginActivity extends Activity {


    public LoginActivity() throws JSONException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE); // remove tittle bar // samples https://github.com/fmgarcia27/AndroidstudioProjects
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(// hide keyboard
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
        Log.d("Debugging", "Starting Login Activity");
    }

    public void startRegistrationFormEvent (View view){

        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
        Log.d("Debugging", "Starting intent Registration Activity");
    }

    public void startDashboard (View view){
        getData();
        Intent intent = new Intent(this,DashboardActivity.class);
        startActivity(intent);
        Log.d("Debugging", "Starting Dashboard Activity");
    }

    //JSON FOMAT ONLINE TOOL http://jsonviewer.stack.hu/ , http://www.jsonschema2pojo.org/
    public  void getData( ){

        //ui instances
//        EditText username = (EditText)findViewById(R.id.usernameField);
//        EditText pass = (EditText)findViewById(R.id.passwordField);

        //default values ** debuging purposes
//        username.setText("qwe123@some.com");
//        pass.setText("1234");

//        Log.d("Debugging", "Gathering data: username , password"+ username.getText().toString() +","+pass.getText().toString()  );

        final String customername = "\"qwe123@some.com\"";
        final String password = "\"1234\"";

        //request main method php url
        get("http://www.computing.northampton.ac.uk/~16442932/phpFiles/fulldetails.php?username="+customername+"&password="+password, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Log.d("Debugging", "call Back OnResponse:");
                Customer newCustomer;
                final String body = response.body().string(); //Get API response
                Log.d("PARSE", "body String: "+ body);
                Gson gson = new Gson();
                newCustomer = gson.fromJson(body,Customer.class);
                Log.d("PARSE", "CUSTOMER ID: "+ newCustomer.getMobileNumber() + "SortCode"+ newCustomer.getPostCode());
                SharedPreferences sharedPreferences = getSharedPreferences("customerInfo", Context.MODE_PRIVATE);
                //sharedPreferences.edit().clear().commit();
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("customerInfo",body);
                editor.apply();
                Log.d("Debugging", "Loaded Shared Preferences :"+ sharedPreferences.toString());
            }
        });

    }

    /**
     *   OKHttp GET helper function (You should probably put this in a Request Utils class)
     *
     */

    public Call get(String url, Callback callback) {

        OkHttpClient client = new OkHttpClient();

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(url)
                .get()
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

        return call;
    }


}