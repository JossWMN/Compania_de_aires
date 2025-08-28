import Paquete.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<CatalogoItem> catalogo = new ArrayList<>();
        int opcion = -1;

        try {
            while (opcion != 0) {
                System.out.println("\n--- MENÚ EMPRESA AIRES ---");
                System.out.println("1. Registrar aire acondicionado");
                System.out.println("2. Registrar servicio (instalación o mantenimiento)");
                System.out.println("3. Mostrar catálogo");
                System.out.println("0. Salir");
                System.out.print("Opción: ");
                opcion = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 1: {
                        System.out.print("Código: ");
                        String cod = br.readLine();
                        System.out.print("Nombre: ");
                        String nom = br.readLine();
                        System.out.print("Descripción: ");
                        String desc = br.readLine();
                        System.out.print("Precio: ");
                        double precio = Double.parseDouble(br.readLine());
                        System.out.print("Garantía (meses): ");
                        int garantia = Integer.parseInt(br.readLine());

                        AireAcondicionado aire = new AireAcondicionado(cod, nom, desc, precio, garantia);
                        catalogo.add(aire);
                        System.out.println(" Aire acondicionado registrado.");
                        break;
                    }

                    case 2: {
                        System.out.print("Código: ");
                        String cod = br.readLine();
                        System.out.print("Nombre: ");
                        String nom = br.readLine();
                        System.out.print("Descripción: ");
                        String desc = br.readLine();
                        System.out.print("Precio: ");
                        double precio = Double.parseDouble(br.readLine());
                        System.out.print("Garantía (meses): ");
                        int garantia = Integer.parseInt(br.readLine());
                        System.out.print("Tipo de servicio (instalación/mantenimiento): ");
                        String tipo = br.readLine().toLowerCase();

                        if (!tipo.equals("instalación") && !tipo.equals("mantenimiento")) {
                            System.out.println("️ Tipo de servicio no válido.");
                            break;
                        }

                        Servicio serv = new Servicio(cod, nom, desc, precio, garantia, tipo);
                        catalogo.add(serv);
                        System.out.println(" Servicio registrado.");
                        break;
                    }

                    case 3: {
                        if (catalogo.isEmpty()) {
                            System.out.println(" No hay elementos en el catálogo.");
                        } else {
                            System.out.println("CATÁLOGO DE PRODUCTOS Y SERVICIOS:");
                            for (CatalogoItem item : catalogo) {
                                System.out.println("--------------------");
                                System.out.println("Código: " + item.getCodigo());
                                System.out.println("Nombre: " + item.getNombre());
                                System.out.println("Descripción: " + item.getDescripcion());
                                System.out.println("Precio base: $" + item.getPrecio());
                                System.out.println("Garantía: " + item.getGarantiaMeses() + " meses");
                                if (item instanceof Servicio) {
                                    System.out.println("Tipo de servicio: " + ((Servicio) item).getTipoServicio());
                                }
                                System.out.printf("Precio final: $%.2f\n", item.calcularPrecioFinal());
                            }
                        }
                        break;
                    }

                    case 0:
                        System.out.println(" Programa finalizado.");
                        break;

                    default:
                        System.out.println(" Opción inválida.");
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(" Error: Entrada no válida.");
        }
    }
}