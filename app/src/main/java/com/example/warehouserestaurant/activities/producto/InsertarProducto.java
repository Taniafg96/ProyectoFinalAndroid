package com.example.warehouserestaurant.activities.producto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.warehouserestaurant.R;
import com.example.warehouserestaurant.activities.MenuActivity;
import com.example.warehouserestaurant.crud.CRUDProducto;
import com.example.warehouserestaurant.pojo.Producto;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;


public class InsertarProducto extends AppCompatActivity {
    private TextInputLayout nombre;
    private TextInputLayout stock;
    private RadioButton b1;
    private RadioButton b2;
    private RadioButton b3;
    private RadioButton d;
    private RadioButton a;
    private RadioButton l;
    private RadioButton o;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_producto);


        nombre = findViewById(R.id.nombre);
        stock = findViewById(R.id.stock);
        b1 = findViewById(R.id.radioButton);
        b2 = findViewById(R.id.radioButton2);
        b3 = findViewById(R.id.radioButton3);
        d = findViewById(R.id.radioButton4);
        a = findViewById(R.id.radioButton5);
        l = findViewById(R.id.radioButton6);
        o = findViewById(R.id.radioButton7);
    }

    public void backActivity(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void insertar(View view) throws ParseException {
        String categoria = "";
        String inombre = nombre.getEditText().getText().toString();
        int istock = Integer.parseInt(stock.getEditText().getText().toString());

        if(b1.isChecked()) categoria = b1.getText().toString();
        else if(b2.isChecked()) categoria = b2.getText().toString();
        else if(b3.isChecked()) categoria = b3.getText().toString();
        else if(d.isChecked()) categoria = d.getText().toString();
        else if(a.isChecked()) categoria = a.getText().toString();
        else if(l.isChecked()) categoria = l.getText().toString();
        else if(o.isChecked()) categoria = o.getText().toString();

        CRUDProducto crudProducto = new CRUDProducto();

        Producto producto = new Producto(inombre, categoria, istock);
        boolean result = crudProducto.create(producto);

        if(result) Toast.makeText(this, "El producto se ha insertado con exito", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "No se ha podido insertar el producto", Toast.LENGTH_SHORT).show();
    }
}