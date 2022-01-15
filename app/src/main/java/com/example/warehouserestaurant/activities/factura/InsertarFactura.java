package com.example.warehouserestaurant.activities.factura;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.warehouserestaurant.R;
import com.example.warehouserestaurant.activities.MenuActivity;
import com.example.warehouserestaurant.crud.CRUDFactura;
import com.example.warehouserestaurant.pojo.Factura;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertarFactura extends AppCompatActivity {
    private TextInputLayout fecha;
    private TextInputLayout numeroFactura;
    private TextInputLayout total;
    private TextInputLayout igic3;
    private TextInputLayout igic7;
    private TextInputLayout igic15;
    private TextInputLayout empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_factura);

        fecha = findViewById(R.id.fecha);
        numeroFactura = findViewById(R.id.numeroFactura);
        total = findViewById(R.id.total);
        igic3 = findViewById(R.id.igic3);
        igic7 = findViewById(R.id.igic7);
        igic15 = findViewById(R.id.igic15);
        empresa = findViewById(R.id.empresa);
    }

    public void backActivity(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void insertar(View view) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formato.parse(fecha.getEditText().getText().toString());

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String numerofactura = numeroFactura.getEditText().getText().toString();
        Double precioTotal = Double.parseDouble(total.getEditText().getText().toString());
        Double igic_3 = Double.parseDouble(igic3.getEditText().getText().toString());
        Double igic_7 = Double.parseDouble(igic7.getEditText().getText().toString());
        Double igic_15 = Double.parseDouble(igic15.getEditText().getText().toString());
        String nifEmpresa = empresa.getEditText().getText().toString();

        CRUDFactura crudFactura = new CRUDFactura();

        Factura factura = new Factura(numerofactura, sqlDate, precioTotal, igic_3, igic_7, igic_15, nifEmpresa);
        boolean result = crudFactura.create(factura);

        if(result) Toast.makeText(this, "La factura se ha insertado con exito", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "No se ha podido insertar la factura", Toast.LENGTH_SHORT).show();
    }

}