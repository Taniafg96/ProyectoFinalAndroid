package com.example.warehouserestaurant.activities.producto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.warehouserestaurant.R;
import com.example.warehouserestaurant.activities.MenuActivity;
import com.example.warehouserestaurant.crud.CRUDFactura;
import com.example.warehouserestaurant.crud.CRUDProducto;
import com.google.android.material.textfield.TextInputLayout;

public class LeerProducto extends AppCompatActivity {
    private TextView textView;
    private TextInputLayout nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer_producto);

        textView = findViewById(R.id.textView);
        nombre = findViewById(R.id.nombreProducto);
    }

    public void backActivity(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void buscar(View view){
        CRUDProducto crudProducto = new CRUDProducto();
        int nombreProducto = Integer.parseInt(nombre.getEditText().getText().toString());

        textView.setText(crudProducto.read(nombreProducto));
    }
}