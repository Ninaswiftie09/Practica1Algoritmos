
//Nina Nájera
//Práctica 1
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BinarySearchTree<String, Automovil> bst = new BinarySearchTree<>(new Comparador());

        String input;
        do {
            System.out
                    .println("Ingrese los datos del automóvil (Marca, Modelo, Línea, Precio, Placa) o escriba SALIR:");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("SALIR")) {
                String[] datos = input.split(",");
                if (datos.length == 5) {
                    Automovil automovil = new Automovil(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]),
                            datos[4]);
                    bst.insert(datos[4], automovil);
                    System.out.println("Automóvil agregado exitosamente.");
                } else {
                    System.out.println(
                            "Formato de entrada incorrecto. Por favor, ingrese los datos separados por comas.");
                }
            }
        } while (!input.equalsIgnoreCase("SALIR"));

        // Buscamos automóviles por placa
        System.out.println("Ingrese la placa del automóvil que desea buscar:");
        String placaBuscar = scanner.nextLine();
        Automovil automovilEncontrado = bst.find(placaBuscar);
        if (automovilEncontrado != null) {
            System.out.println("Automóvil encontrado:");
            System.out.println("Marca: " + automovilEncontrado.getMarca());
            System.out.println("Modelo: " + automovilEncontrado.getModelo());
            System.out.println("Línea: " + automovilEncontrado.getLinea());
            System.out.println("Precio: " + automovilEncontrado.getPrecio());
            System.out.println("Placa: " + automovilEncontrado.getPlaca());
        } else {
            System.out.println("El automóvil con placa " + placaBuscar + " no existe.");
        }
        scanner.close();
    }

}
