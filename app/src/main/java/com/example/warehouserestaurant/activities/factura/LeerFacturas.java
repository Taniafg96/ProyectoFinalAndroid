package com.example.warehouserestaurant.activities.factura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.warehouserestaurant.R;
import com.example.warehouserestaurant.activities.MenuActivity;
import com.example.warehouserestaurant.crud.CRUDFactura;
import com.google.android.material.textfield.TextInputLayout;

public class LeerFacturas extends AppCompatActivity {
    private TextView textView;
    private TextInputLayout numeroFactura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer_facturas);

        textView = findViewById(R.id.textView);
        numeroFactura = findViewById(R.id.numeroFactura);
    }

    public void backActivity(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void buscar(View view){
        CRUDFactura crudFactura = new CRUDFactura();
        String factura = numeroFactura.getEditText().getText().toString();

        textView.setText(crudFactura.read(factura));
    }

}