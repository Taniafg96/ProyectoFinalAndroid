package com.example.warehouserestaurant.activities.factura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.warehouserestaurant.R;
import com.example.warehouserestaurant.activities.MenuActivity;
import com.example.warehouserestaurant.crud.CRUDFactura;
import com.google.android.material.textfield.TextInputLayout;

public class UpdateFactura extends AppCompatActivity {
    private TextInputLayout numeroFactura;
    private TextInputLayout total;
    private TextInputLayout igic3;
    private TextInputLayout igic7;
    private TextInputLayout igic15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_factura);

        numeroFactura = findViewById(R.id.numeroFactura);
        total = findViewById(R.id.total);
        igic3 = findViewById(R.id.igic3);
        igic7 = findViewById(R.id.igic7);
        igic15 = findViewById(R.id.igic15);
    }

    public void backActivity(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void actualizar(View view){
        CRUDFactura crudFactura = new CRUDFactura();

        String result = "";
        String factura = numeroFactura.getEditText().getText().toString();
        String precio = total.getEditText().getText().toString();
        String igic_3 = igic3.getEditText().getText().toString();
        String igic_7 = igic7.getEditText().getText().toString();
        String igic_15 = igic15.getEditText().getText().toString();

        if(!precio.isEmpty()) result += "set precio_total = '"+ precio +"',";
        if(!igic_3.isEmpty()) result += "set igic_3 = '"+ igic_3 +"',";
        if(!igic_7.isEmpty()) result += "set igic_7 = '"+ igic_7 +"',";
        if(!igic_15.isEmpty()) result += "set igic_15 = '"+ igic_15 +"',";

        result = result.substring(0, result.length()-1);

        Boolean resultBoolean = crudFactura.update(factura, result);
        if(resultBoolean) Toast.makeText(this, "La factura se ha actualizado con exito", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "No se ha podido actualizar la factura", Toast.LENGTH_SHORT).show();
    }
}