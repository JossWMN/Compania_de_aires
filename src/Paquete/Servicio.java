package Paquete;

public class Servicio extends CatalogoItem {
    private String tipoServicio;

    public Servicio(String codigo, String nombre, String descripcion, double precio, int garantiaMeses, String tipoServicio) {
        super(codigo, nombre, descripcion, precio, garantiaMeses);
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() * 1.10;
    }
}

