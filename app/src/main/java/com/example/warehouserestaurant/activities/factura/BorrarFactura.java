package com.example.warehouserestaurant.activities.factura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.warehouserestaurant.R;
import com.example.warehouserestaurant.activities.MenuActivity;
import com.example.warehouserestaurant.crud.CRUDFactura;
import com.google.android.material.textfield.TextInputLayout;

public class BorrarFactura extends AppCompatActivity {
    private TextInputLayout numeroFactura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_factura);

        numeroFactura = findViewById(R.id.numeroFactura);
    }

    public void backActivity(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void borrar(View view){
        CRUDFactura crudFactura = new CRUDFactura();
        String factura = numeroFactura.getEditText().getText().toString();

        Boolean result = crudFactura.delete(factura);
        if(result) Toast.makeText(this, "La factura se ha borrado con exito", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "No se ha podido borrar la factura", Toast.LENGTH_SHORT).show();
    }
}