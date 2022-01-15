package com.example.warehouserestaurant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.warehouserestaurant.R;
import com.example.warehouserestaurant.activities.empresa.BorrarEmpresa;
import com.example.warehouserestaurant.activities.empresa.InsertarEmpresa;
import com.example.warehouserestaurant.activities.empresa.LeerEmpresa;
import com.example.warehouserestaurant.activities.factura.BorrarFactura;
import com.example.warehouserestaurant.activities.factura.InsertarFactura;
import com.example.warehouserestaurant.activities.factura.LeerFacturas;
import com.example.warehouserestaurant.activities.factura.UpdateFactura;
import com.example.warehouserestaurant.activities.producto.BorrarProducto;
import com.example.warehouserestaurant.activities.producto.InsertarProducto;
import com.example.warehouserestaurant.activities.producto.LeerProducto;
import com.example.warehouserestaurant.activities.producto.UpdateProducto;

public class MenuActivity extends AppCompatActivity {
    private View facturas;
    private View productos;
    private View empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        facturas = findViewById(R.id.facturalayout);
        productos = findViewById(R.id.productolayout);
        empresa = findViewById(R.id.empresalayout);

    }

    public void backActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void insertFactura(View view){
        Intent intent = new Intent(this, InsertarFactura.class);
        startActivity(intent);
    }

    public void buscarFactura(View view){
        Intent intent = new Intent(this, LeerFacturas.class);
        startActivity(intent);
    }

    public void borrarFactura(View view){
        Intent intent = new Intent(this, BorrarFactura.class);
        startActivity(intent);
    }

    public void actualizarFactura(View view){
        Intent intent = new Intent(this, UpdateFactura.class);
        startActivity(intent);
    }

    public void insertarProducto(View view){
        Intent intent = new Intent(this, InsertarProducto.class);
        startActivity(intent);
    }

    public void buscarProducto(View view){
        Intent intent = new Intent(this, LeerProducto.class);
        startActivity(intent);
    }

    public void borrarProducto(View view){
        Intent intent = new Intent(this, BorrarProducto.class);
        startActivity(intent);
    }

    public void actualizarProducto(View view){
        Intent intent = new Intent(this, UpdateProducto.class);
        startActivity(intent);
    }

    public void insertarEmpresa(View view){
        Intent intent = new Intent(this, InsertarEmpresa.class);
        startActivity(intent);
    }

    public void buscarEmpresa(View view){
        Intent intent = new Intent(this, LeerEmpresa.class);
        startActivity(intent);
    }

    public void borrarEmpresa(View view){
        Intent intent = new Intent(this, BorrarEmpresa.class);
        startActivity(intent);
    }

    public void setFacturas(View view){
        if(facturas.getVisibility() == View.GONE)
            facturas.setVisibility(View.VISIBLE);
        else facturas.setVisibility(View.GONE);
    }

    public void setProductos(View view){
        if(productos.getVisibility() == View.GONE)
            productos.setVisibility(View.VISIBLE);
        else productos.setVisibility(View.GONE);
    }

    public void setEmpresas(View view){
        if(empresa.getVisibility() == View.GONE)
            empresa.setVisibility(View.VISIBLE);
        else empresa.setVisibility(View.GONE);
    }
}