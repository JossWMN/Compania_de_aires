package Paquete;

public class AireAcondicionado extends CatalogoItem {

    public AireAcondicionado(String codigo, String nombre, String descripcion, double precio, int garantiaMeses) {
        super(codigo, nombre, descripcion, precio, garantiaMeses);
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() * 1.07;
    }
}
