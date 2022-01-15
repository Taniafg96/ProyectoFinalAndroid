package com.example.warehouserestaurant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.warehouserestaurant.R;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout user;
    private TextInputLayout password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (TextInputLayout) findViewById(R.id.user);
        password = (TextInputLayout) findViewById(R.id.password);
    }

    public void login(View view){
        String name = user.getEditText().getText().toString();
        String userPassword = password.getEditText().getText().toString();

        try {
            if (name.equals("admin") && userPassword.equals("1234"))
            startActivity(new Intent(this, MenuActivity.class));
            else if(name.equals("map") && userPassword.equals("1234"))
            startActivity(new Intent(this, MapsActivity.class));
            else
            Toast.makeText(this, "El usuario o la contraseña con erroneos", Toast.LENGTH_SHORT).show();

        }catch(Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}