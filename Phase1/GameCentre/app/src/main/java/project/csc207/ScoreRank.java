package project.csc207;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Map;

public class ScoreRank extends AppCompatActivity {
    /*
    the account from current user
    * */
    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorerank);

        SharedPreferences preferences = getSharedPreferences("SCORES", MODE_PRIVATE);
        Map<String, ?> allScores = preferences.getAll();
        ArrayList<Map.Entry<String, ?>> hiScores = new ArrayList();
        for (Map.Entry<String, ?> entry : allScores.entrySet()) {
            hiScores.add(entry);
        }
    }
}

