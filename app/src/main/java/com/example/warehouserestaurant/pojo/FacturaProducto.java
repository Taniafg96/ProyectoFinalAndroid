package com.example.warehouserestaurant.pojo;

public class FacturaProducto {
    private String numeroFactura;
    private int idProducto;
    private int cantidadProducto;
    private float precioUnidad;

    public FacturaProducto(String numeroFactura, int idProducto, int cantidadProducto, float precioUnidad) {
        this.numeroFactura = numeroFactura;
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioUnidad = precioUnidad;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }
}
