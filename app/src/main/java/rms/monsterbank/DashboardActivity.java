package rms.monsterbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void backLoginEvent (View view){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void startDetailsActivity (View view){
        Intent intent = new Intent(this,AccountDetails.class);
        startActivity(intent);
    }
}
