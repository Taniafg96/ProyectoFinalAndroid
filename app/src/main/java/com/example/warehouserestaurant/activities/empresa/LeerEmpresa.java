package com.example.warehouserestaurant.activities.empresa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.warehouserestaurant.R;
import com.example.warehouserestaurant.activities.MenuActivity;
import com.example.warehouserestaurant.crud.CRUDEmpresa;
import com.example.warehouserestaurant.crud.CRUDFactura;
import com.google.android.material.textfield.TextInputLayout;

public class LeerEmpresa extends AppCompatActivity {
    private TextView textView;
    private TextInputLayout nifEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer_empresa);

        textView = findViewById(R.id.textView);
        nifEmpresa = findViewById(R.id.nifEmpresa);
    }

    public void backActivity(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void buscar(View view){
        CRUDEmpresa crudEmpresa = new CRUDEmpresa();
        String nif = nifEmpresa.getEditText().getText().toString();

        textView.setText(crudEmpresa.read(nif));
    }
}