package project.csc207;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText userName = findViewById(R.id.userRegister);
        final EditText password = findViewById(R.id.passRegister);

        Button bRegister = findViewById(R.id.buttonRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newUser = userName.getText().toString();
                String newPassword = password.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                Boolean existsUser = preferences.contains(newUser);

                if (!existsUser) {
                    editor.putString(newUser, newPassword);
                    editor.commit();
                    Intent logInScreen = new Intent(RegisterActivity.this, LauncherActivity.class);
                    startActivity(logInScreen);
                } else {
                    Toast.makeText(getApplicationContext(), "Username Already In Use!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
