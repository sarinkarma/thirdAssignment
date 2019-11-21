package com.example.thirdassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText username, password;
    Button submit;
    String uname, pword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        uname = username.getText().toString();
        pword = password.getText().toString();

        if(v.getId() == R.id.submit ){
            if(validate()) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }

    }

    private boolean validate(){
        if(TextUtils.isEmpty(uname) || TextUtils.isEmpty(pword)){
            username.setError("Username or password is Empty.");
            username.requestFocus();
            return false;
        }
        if(!uname.equals("softwarica") && !pword.equals("coventry")){
            username.setError("Username or password is incorrect.");
            username.requestFocus();
            return false;
        }
        return true;
    }
}
