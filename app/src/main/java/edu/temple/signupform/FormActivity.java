package edu.temple.signupform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    Button saveButton;
    EditText theName;
    EditText theEmail;
    EditText thePass;
    EditText thePass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        this.setTitle("Sign Up Form");

        saveButton = findViewById(R.id.saveButton);
        theName = findViewById(R.id.enterName);
        theEmail = findViewById(R.id.enterEmail);
        thePass = findViewById(R.id.enterPass);
        thePass2 = findViewById(R.id.enterPass2);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!verify()) {
                    signupFail();
                    return;
                } else {
                    signupSuccess();
                }
            }
        });
    }

    public void signupSuccess() {
        Intent launchActivityIntent = new Intent(FormActivity.this, WelcomeActivity.class);
        String yourName = theName.getText().toString();
        launchActivityIntent.putExtra("nameID", yourName);
        startActivity(launchActivityIntent);
    }

    public void signupFail() {
        Toast.makeText(getBaseContext(), "Sign Up Failed", Toast.LENGTH_LONG).show();
    }

    public boolean verify() {
        boolean valid = true;

        String vName = theName.getText().toString();
        String vEmail = theEmail.getText().toString();
        String vPass = thePass.getText().toString();
        String vPass2 = thePass2.getText().toString();

        if (vName.isEmpty()) {
            Toast.makeText(getBaseContext(), "Enter your name", Toast.LENGTH_SHORT).show();
            theName.setError("");
            valid = false;
        }

        if (vEmail.isEmpty()) {
            Toast.makeText(getBaseContext(), "Enter an email", Toast.LENGTH_SHORT).show();
            theEmail.setError("");
            valid = false;
        }

        if (vPass.isEmpty()) {
            Toast.makeText(getBaseContext(), "Enter a password", Toast.LENGTH_SHORT).show();
            thePass.setError("");
            valid = false;
        }

        if (vPass2.isEmpty()) {
            Toast.makeText(getBaseContext(), "Confirm your password", Toast.LENGTH_SHORT).show();
            thePass2.setError("");
            valid = false;
        }

        if (!(vPass.equals(vPass2))) {
            Toast.makeText(getBaseContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        return valid;
    }
}