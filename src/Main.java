import Paquete.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import Paquete.*;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<CatalogoItem> catalogo = new ArrayList<>();
        int opcion = -1;

        try {
            while (opcion != 0) {
                String[] opciones = {"0. Salir", "1. Registrar aire acondicionado", "2. Registrar servicio", "3. Mostrar catálogo"};

                String seleccion = (String) JOptionPane.showInputDialog(
                        null,
                        "Seleccione una opción:",
                        "Menú Aires Olimpo",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]);

                if (seleccion == null) {
                    // Si el usuario cierra o cancela, salir
                    opcion = 0;
                } else {
                    opcion = Integer.parseInt(seleccion.split("\\.")[0]);
                }

                switch (opcion) {
                    case 1: {
                        String cod = JOptionPane.showInputDialog("Ingrese el código:");
                        if (cod == null) break;

                        String nom = JOptionPane.showInputDialog("Ingrese el nombre:");
                        if (nom == null) break;

                        String desc = JOptionPane.showInputDialog("Ingrese la descripción:");
                        if (desc == null) break;

                        double precio;
                        try {
                            precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio:"));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Precio inválido");
                            break;
                        }

                        int garantia;
                        try {
                            garantia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la garantía (meses):"));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Garantía inválida");
                            break;
                        }

                        AireAcondicionado aire = new AireAcondicionado(cod, nom, desc, precio, garantia);
                        catalogo.add(aire);
                        JOptionPane.showMessageDialog(null, "Aire acondicionado registrado correctamente");
                        break;
                    }

                    case 2: {
                        String cod = JOptionPane.showInputDialog("Ingrese el código:");
                        if (cod == null) break;

                        String nom = JOptionPane.showInputDialog("Ingrese el nombre:");
                        if (nom == null) break;

                        String desc = JOptionPane.showInputDialog("Ingrese la descripción:");
                        if (desc == null) break;

                        double precio;
                        try {
                            precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio:"));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Precio inválido");
                            break;
                        }

                        int garantia;
                        try {
                            garantia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la garantía (meses):"));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Garantía inválida");
                            break;
                        }

                        String[] tiposServicio = {"instalación", "mantenimiento"};
                        String tipo = (String) JOptionPane.showInputDialog(
                                null,
                                "Seleccione el tipo de servicio:",
                                "Tipo de servicio",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                tiposServicio,
                                tiposServicio[0]);

                        if (tipo == null) {
                            JOptionPane.showMessageDialog(null, "No seleccionó un tipo válido.");
                            break;
                        }

                        Servicio serv = new Servicio(cod, nom, desc, precio, garantia, tipo);
                        catalogo.add(serv);
                        JOptionPane.showMessageDialog(null, "Servicio registrado correctamente");
                        break;
                    }

                    case 3: {
                        if (catalogo.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No hay elementos en el catálogo.");
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("CATÁLOGO DE PRODUCTOS Y SERVICIOS:\n\n");
                            for (CatalogoItem item : catalogo) {
                                sb.append("----------------------------\n");
                                sb.append("Código: ").append(item.getCodigo()).append("\n");
                                sb.append("Nombre: ").append(item.getNombre()).append("\n");
                                sb.append("Descripción: ").append(item.getDescripcion()).append("\n");
                                sb.append("Precio base: $").append(item.getPrecio()).append("\n");
                                sb.append("Garantía: ").append(item.getGarantiaMeses()).append(" meses\n");
                                if (item instanceof Servicio) {
                                    sb.append("Tipo de servicio: ").append(((Servicio) item).getTipoServicio()).append("\n");
                                }
                                sb.append(String.format("Precio final: $%.2f\n", item.calcularPrecioFinal()));
                                sb.append("\n");
                            }
                            JOptionPane.showMessageDialog(null, sb.toString(), "Catálogo", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    }

                    case 0:
                        JOptionPane.showMessageDialog(null, "Programa finalizado.");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida.");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage());
        }
    }
}
