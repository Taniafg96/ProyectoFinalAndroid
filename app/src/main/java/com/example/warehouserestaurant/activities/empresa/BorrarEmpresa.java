package com.example.warehouserestaurant.activities.empresa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.warehouserestaurant.R;
import com.example.warehouserestaurant.activities.MenuActivity;
import com.example.warehouserestaurant.crud.CRUDEmpresa;
import com.example.warehouserestaurant.crud.CRUDFactura;
import com.google.android.material.textfield.TextInputLayout;

public class BorrarEmpresa extends AppCompatActivity {
    private TextInputLayout nifEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_empresa);
    }

    public void backActivity(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void borrar(View view){
        CRUDEmpresa crudEmpresa = new CRUDEmpresa();
        String nif = nifEmpresa.getEditText().getText().toString();

        Boolean result = crudEmpresa.delete(nif);
        if(result) Toast.makeText(this, "La factura se ha borrado con exito", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "No se ha podido borrar la factura", Toast.LENGTH_SHORT).show();
    }
}