package rms.monsterbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); // remove tittle bar
        setContentView(R.layout.activity_register);
        Log.d("Debugging", "Starting Registration Form");
    }

    public void backLoginEvent (View view){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        Log.d("Debugging", "Starting Back to login intent");

    }

    public void submitInfo (View view){
        checking();
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        Log.d("Debugging", "Starting Login after submit");

    }

    private void checking() {

        //Ui instances
        EditText username =(EditText)findViewById(R.id.usernameField);
        EditText password =(EditText)findViewById(R.id.passwordField);
        EditText confirmation =(EditText)findViewById(R.id.confField);
        EditText accountNumber =(EditText)findViewById(R.id.accField);
        EditText email =(EditText)findViewById(R.id.emailField);
        CheckBox checkTC = (CheckBox)findViewById(R.id.checkTC);
        Button sendButton = (Button)findViewById(R.id.sendButton);

        //Format Form registration fields
        final String usernameQ = "\""+username.getText().toString()+"\"";
        final String passwordQ = "\""+password.getText().toString()+"\"";
        final String emailQ = "\""+email.getText().toString()+"\"";
        final String accountNumberQ = "\""+accountNumber.getText().toString()+"\"";

        //verify password and check T&C
        Log.d("Debugging", "Compare :"+password.getText().toString() +" , with : "+ confirmation.getText().toString());
        if (password.getText().toString().equals(confirmation.getText().toString()))
        {
            Log.d("Debugging", "password Confirmitaion Succeed");
            Log.d("Debugging", "Sending data");
            post("http://www.computing.northampton.ac.uk/~16442932/phpFiles/registrationForm.php?username="+usernameQ+"&password="+passwordQ+"&email="+emailQ+"&accNo="+accountNumberQ, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.d("PARSE", "Post Failure");
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                }

            });
        }
        else
        {
            Log.d("Debugging", "password failure Failure");
        }
    }

    private Call post(String url, Callback callback){
        Log.d("Debugging", "Starting :Request to the server ");
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
}
