package com.example.warehouserestaurant.pojo;

public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private int stock;

    public Producto(String nombre, String categoria, int stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
