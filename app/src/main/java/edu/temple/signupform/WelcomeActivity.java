package edu.temple.signupform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        this.setTitle("SignUpForm welcomes you!");

        String yourName = getIntent().getStringExtra("nameID");
        TextView myText = findViewById(R.id.welcomeName);
        myText.setText("Welcome, " + yourName.toString() + ", to the SignUpForm App!");
    }
}
