package rms.monsterbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); // remove tittle bar
        setContentView(R.layout.activity_register);
    }

    public void backLoginEvent (View view){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }


}
