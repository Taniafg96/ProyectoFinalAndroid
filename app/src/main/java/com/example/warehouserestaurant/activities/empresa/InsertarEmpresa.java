package com.example.warehouserestaurant.activities.empresa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.warehouserestaurant.R;
import com.example.warehouserestaurant.activities.MenuActivity;
import com.example.warehouserestaurant.crud.CRUDEmpresa;
import com.example.warehouserestaurant.crud.CRUDProducto;
import com.example.warehouserestaurant.pojo.Empresa;
import com.example.warehouserestaurant.pojo.Producto;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;

public class InsertarEmpresa extends AppCompatActivity {
    private TextInputLayout nif;
    private TextInputLayout nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_empresa);

        nif = findViewById(R.id.nifEmpresa);
        nombre = findViewById(R.id.nombreEmpresa);
    }

    public void backActivity(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void insertar(View view) throws ParseException {
        CRUDEmpresa crudEmpresa = new CRUDEmpresa();
        String inombre = nombre.getEditText().getText().toString();
        String inif = nif.getEditText().getText().toString();

        Empresa empresa = new Empresa(inif, inombre);
        boolean result = crudEmpresa.create(empresa);

        if(result) Toast.makeText(this, "El producto se ha insertado con exito", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "No se ha podido insertar el producto", Toast.LENGTH_SHORT).show();
    }
}