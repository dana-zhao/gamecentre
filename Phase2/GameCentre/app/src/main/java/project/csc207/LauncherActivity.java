package project.csc207;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LauncherActivity extends AppCompatActivity {

    /*
    The input username field.
     */
    private EditText usernameBox;

    /*
    The input password field.
     */
    private EditText passwordBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        addLogInButtonListener();
        addSignUpButtonListener();
    }

    /*
    Activate the log in button.
     */
    private void addLogInButtonListener() {
        Button btnLogin = findViewById(R.id.LogInButton);
        final EditText etUserName = findViewById(R.id.UsernameBox);
        final EditText etPassword = findViewById(R.id.PasswordBox);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameBox = findViewById(R.id.UsernameBox);
                passwordBox = findViewById(R.id.PasswordBox);
                Account.currentAccount = new Account(usernameBox.getText().toString(), passwordBox.getText().toString());

                String user = etUserName.getText().toString();
                String password = etPassword.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                String userAuthenticate = preferences.getString(user, "");
                if (userAuthenticate.length() != 0 && userAuthenticate.equals(password)) {
                    Intent accountActivity = new Intent(LauncherActivity.this, AccountActivity.class);
                    startActivity(accountActivity);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*
    Activate the sign up button.
     */
    private void addSignUpButtonListener() {
        Button btnRegister = findViewById(R.id.SignUpButton);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerActivity = new Intent(LauncherActivity.this, RegisterActivity.class);
                startActivity(registerActivity);
            }
        });
    }
}