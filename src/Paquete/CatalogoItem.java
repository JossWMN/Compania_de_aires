package Paquete;

public class CatalogoItem {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int garantiaMeses;

    public CatalogoItem(String codigo, String nombre, String descripcion, double precio, int garantiaMeses) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.garantiaMeses = garantiaMeses;
    }

    public abstract double calcularPrecioFinal();

    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public int getGarantiaMeses() {
        return garantiaMeses;
    }
}
