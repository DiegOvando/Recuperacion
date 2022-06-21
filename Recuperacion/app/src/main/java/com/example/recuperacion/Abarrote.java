package com.example.recuperacion;

public class Abarrote {
    private float precioVenta, precioCompra, unidad;

    //Constructor vacio
    public Abarrote() {
    }

    //Constructor de parametros
    public Abarrote(float precioVenta, float precioCompra, float unidad) {
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.unidad = unidad;
    }

    //Encapsulamiento
    public float getPrecioVenta() {
        return precioVenta;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public float getUnidad() {
        return unidad;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setUnidad(float unidad) {
        this.unidad = unidad;
    }

    //Metodos
    public float calcularVenta(){
        float resultado = 0.0f;
        resultado = precioVenta * unidad;
        return resultado;
    }

    public float calcularCompra(){
        float resultado = 0.0f;
        resultado = precioCompra * unidad;
        return resultado;
    }

    public float calcularGanancia(){
        float resultado = 0.0f;
        resultado = calcularCompra() - calcularVenta();
        return resultado;
    }
}
