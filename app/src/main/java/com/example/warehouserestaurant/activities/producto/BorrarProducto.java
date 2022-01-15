package com.example.warehouserestaurant.activities.producto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.warehouserestaurant.R;
import com.example.warehouserestaurant.activities.MenuActivity;
import com.example.warehouserestaurant.crud.CRUDFactura;
import com.example.warehouserestaurant.crud.CRUDProducto;
import com.google.android.material.textfield.TextInputLayout;

public class BorrarProducto extends AppCompatActivity {
    private TextInputLayout id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_producto);

        id = findViewById(R.id.nombreProducto);
    }

    public void backActivity(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void borrar(View view){
        CRUDProducto crudProducto = new CRUDProducto();
        int idProducto = Integer.parseInt(id.getEditText().getText().toString());

        Boolean result = crudProducto.delete(idProducto);
        if(result) Toast.makeText(this, "El producto se ha borrado con exito", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "No se ha podido borrar el producto", Toast.LENGTH_SHORT).show();
    }
}