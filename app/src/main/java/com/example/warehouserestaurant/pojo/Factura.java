package com.example.warehouserestaurant.pojo;


import java.sql.Date;

public class Factura {
    private String numeroFactura;
    private Date fecha;
    private double total;
    private double igic3;
    private double igic7;
    private double igic15;
    private String nifEmpresa;

    public Factura(String numeroFactura, Date fecha, double total, double igic3, double igic7, double igic15, String nifEmpresa) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.total = total;
        this.igic3 = igic3;
        this.igic7 = igic7;
        this.igic15 = igic15;
        this.nifEmpresa = nifEmpresa;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public double getIgic3() {
        return igic3;
    }

    public void setIgic3(float igic3) {
        this.igic3 = igic3;
    }

    public double getIgic7() {
        return igic7;
    }

    public void setIgic7(float igic7) {
        this.igic7 = igic7;
    }

    public double getIgic15() {
        return igic15;
    }

    public void setIgic15(float igic15) {
        this.igic15 = igic15;
    }

    public String getNifEmpresa() {
        return nifEmpresa;
    }

    public void setNifEmpresa(String nifEmpresa) {
        this.nifEmpresa = nifEmpresa;
    }
}
