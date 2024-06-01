//Nombre: Giovanny Padilla
//Materia: Programacion
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un objeto de tipo Parqueadero
        Parqueadero parqueadero = new Parqueadero();

        System.out.println("¡Bienvenido al sistema de gestión de parqueadero!");

        // Ciclo principal del programa
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); //salto de linea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del carro que desea ingresar: ");
                    String placaIngreso = scanner.nextLine();
                    int resultadoIngreso = parqueadero.entrarCarro(placaIngreso);
                    imprimirResultadoIngreso(resultadoIngreso);
                    break;
                case 2:
                    System.out.print("Ingrese la placa del carro que desea sacar: ");
                    String placaSalida = scanner.nextLine();
                    int valorPagar = parqueadero.sacarCarro(placaSalida);
                    imprimirResultadoSalida(valorPagar);
                    break;
                case 3:
                    imprimirEstadoParqueadero(parqueadero);
                    break;
                case 4:
                    // Salir del programa
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor ingrese una opción válida.");
            }
        }
    }

    //  imprimir mensajes al usuario
    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Ingresar carro");
        System.out.println("2. Sacar carro");
        System.out.println("3. Ver estado del parqueadero");
        System.out.println("4. Salir");
        System.out.print("Ingrese el número de la opción que desea realizar: ");
    }

    private static void imprimirResultadoIngreso(int resultado) {
        switch (resultado) {
            case Parqueadero.NO_HAY_PUESTO:
                System.out.println("El parqueadero está lleno, no hay puesto disponible.");
                break;
            case Parqueadero.PARQUEADERO_CERRADO:
                System.out.println("El parqueadero está cerrado en este momento.");
                break;
            case Parqueadero.CARRO_YA_EXISTE:
                System.out.println("Ya hay un carro con la misma placa en el parqueadero.");
                break;
            default:
                System.out.println("Carro ingresado al parqueadero correctamente.");
                break;
        }
    }

    private static void imprimirResultadoSalida(int valorPagar) {
        switch (valorPagar) {
            case Parqueadero.CARRO_NO_EXISTE:
                System.out.println("El carro no está en el parqueadero.");
                break;
            case Parqueadero.PARQUEADERO_CERRADO:
                System.out.println("El parqueadero está cerrado en este momento.");
                break;
            default:
                System.out.println("El carro ha salido del parqueadero. Valor a pagar: $" + valorPagar);
                break;
        }
    }

    private static void imprimirEstadoParqueadero(Parqueadero parqueadero) {
        System.out.println("Estado del parqueadero:");
        System.out.println("Hora actual: " + parqueadero.darHoraActual());
        System.out.println("Parqueadero abierto: " + (parqueadero.estaAbierto() ? "Sí" : "No"));
        System.out.println("Tarifa por hora: $" + parqueadero.darTarifa());
        System.out.println("Monto en caja: $" + parqueadero.darMontoCaja());
        System.out.println("Puestos libres: " + parqueadero.calcularPuestosLibres());
    }
}
