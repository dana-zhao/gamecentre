package project.csc207.lightsOutGame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import project.csc207.Account;
import project.csc207.R;

public class LightsOutStartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights_out_starting);
        displayAccountName();
    }
    private void displayAccountName() {
        TextView accountNameLightsTextView = findViewById(R.id.AccountNameLights);
        String username = Account.getCurrentAccount().getUserName();
        accountNameLightsTextView.setText(username);
    }

}
