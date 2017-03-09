package rms.monsterbank;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE); // remove tittle bar // samples https://github.com/fmgarcia27/AndroidstudioProjects
        setContentView(R.layout.activity_login);



    }

    public void startRegistrationFormEvent (View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    public void startDashboard (View view){
        Intent intent = new Intent(this,DashboardActivity.class);
        startActivity(intent);
    }
}
