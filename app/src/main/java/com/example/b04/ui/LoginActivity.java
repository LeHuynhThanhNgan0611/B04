package com.example.b04.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.b04.MainActivity;
import com.example.b04.R;

public class LoginActivity extends AppCompatActivity {
    Button btLogin, btRegister;
    EditText edUserNameC, edPasswordC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
        // Ánh xạ
        btLogin = findViewById(R.id.btlogin);
        btRegister = findViewById(R.id.btregister);
        edUserNameC = findViewById(R.id.etusername);
        edPasswordC = findViewById(R.id.etpassword);
        //
        btLogin.setOnClickListener(nhanlogin());
        btRegister.setOnClickListener(nhanregister());
    }

    @NonNull
    private View.OnClickListener nhanlogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUserNameC.getText().toString().trim();
                String password = edPasswordC.getText().toString().trim();

                if(checkUserName(username) && checkPassword(password))
                {
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        };
    }

    @NonNull
    private View.OnClickListener nhanregister() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUserNameC.getText().toString().trim();
                String password = edPasswordC.getText().toString().trim();

                if(checkUserName(username) && checkPassword(password))
                {
                    Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(i);
                }
            }
        };
    }


    boolean checkUserName(String username){
        if(username.isEmpty()) {
            edUserNameC.setError("Vui lòng nhập");
            return false;
        }
        return true;
    }
    boolean checkPassword(String password){
        if(password.isEmpty()) {
            edUserNameC.setError("Vui lòng nhập");
            return false;
        }
        return true;
    }
}