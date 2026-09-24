import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolInventario inventario = new ArbolInventario();
        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE INVENTARIO TREE-STOCK =====");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario (ordenado)");
            System.out.println("3. Buscar Producto por ID");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del producto: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = sc.nextLine();
                    inventario.insertar(id, nombre);
                    System.out.println("✔ Producto registrado correctamente.");
                    break;

                case 2:
                    System.out.println("\n--- Inventario ordenado por ID ---");
                    inventario.inorden();
                    break;

                case 3:
                    System.out.print("Ingrese el ID a buscar: ");
                    int idBuscar = sc.nextInt();
                    if (inventario.buscar(idBuscar)) {
                        System.out.println("✔ El producto con ID " + idBuscar + " SÍ existe.");
                    } else {
                        System.out.println("✘ El producto con ID " + idBuscar + " NO existe.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}