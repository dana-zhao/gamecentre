package project.csc207;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import project.csc207.slidingtiles.BoardManager;

public class RegisterActivity extends AppCompatActivity {
    /**
     * The main save file.
     */

    /**
     * A temporary save file.
     */

    /**
     * The account manager.
     */
    private AccountManager accountManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadFromFile(LauncherActivity.SAVE_FILENAME);
        if (accountManager.getAllAccount() == null){
            accountManager.setAllAccount(new HashMap());
        }

        setContentView(R.layout.activity_register);


        final EditText userName = findViewById(R.id.userRegister);
        final EditText password = findViewById(R.id.passRegister);

        Button bRegister = findViewById(R.id.buttonRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newUser = userName.getText().toString();
                String newPassword = password.getText().toString();

                Boolean isNewUer = !accountManager.notNewUser(newUser);

                if (isNewUer) {
                    accountManager.signUp(newUser, newPassword);
                    saveToFile(LauncherActivity.SAVE_FILENAME);
                    Intent logInScreen = new Intent(RegisterActivity.this, LauncherActivity.class);
                    startActivity(logInScreen);
                } else {
                    Toast.makeText(getApplicationContext(), "Username Already In Use!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadFromFile(String fileName) {

        try {
            InputStream inputStream = this.openFileInput(fileName);
            if (inputStream != null) {
                ObjectInputStream input = new ObjectInputStream(inputStream);
                accountManager = (AccountManager) input.readObject();
                inputStream.close();
            }
        } catch (Exception e) {
            accountManager = new AccountManager();
            System.out.println("not read ");
        }
    }

    /**
     * Save the board manager to fileName.
     *
     * @param fileName the name of the file
     */
    public void saveToFile(String fileName) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    this.openFileOutput(fileName, MODE_PRIVATE));
            outputStream.writeObject(accountManager);
            outputStream.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
