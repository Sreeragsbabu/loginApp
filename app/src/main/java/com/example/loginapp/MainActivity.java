package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private  static  final Pattern PASSWORD_PATTERN=
            Pattern.compile("^"+"(?=.*[0-9])"+"(?=.*[a-z])"+"(?=.*[A-Z])"+"(?=.*[@#$%^&+=])"+"(?=\\S+$)"+".{4,}"+"$");
    private EditText email,password;

    String emailString, passString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email= (EditText)findViewById(R.id.email);
        password= (EditText)findViewById(R.id.password);

    }

    private boolean validateemail(){

        emailString = email.getText().toString().trim();

        if(emailString.isEmpty()){
            email.setError("Field can't be empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailString).matches()) {
            email.setError("please enter valid email address");
            return false;
        }
        else {
            return true;
        }
    }

    private boolean validatepassword(){

        passString = password.getText().toString().trim();

        if(passString.isEmpty()){
            password.setError("Field can't be empty");
            return false;
        }
        else if (passString.length() < 5 ) {
            password.setError("password is too weak");
            return false;
        }
        else {
            return true;
        }
    }

    public void confirm(View view) {

        if (!validateemail() | !validatepassword()) {
            return;
        }

        String input = "Email:"+ emailString;
        input+="\n";
        input+="Password:"+ passString;
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }
}
