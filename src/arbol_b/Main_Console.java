package arbol_b;

import java.util.Scanner;

/**
 *
 * @author cesar
 */
public class Main_Console {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el grado del árbol B: ");
        int grado = scanner.nextInt();
        Arbol_B arbolB = new Arbol_B(grado);
        char seguir = 'S';
        int opcion = 0;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Insertar clave");
            System.out.println("2. Eliminar clave");
            System.out.println("3. Buscar clave");
            System.out.println("4. Mostrar árbol B");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    while (seguir == 'S' || seguir == 's') {

                        scanner.nextLine(); // Consume la nueva línea
                        System.out.print("Ingrese la lista de claves separadas por comas: ");
                        String listaClaves = scanner.nextLine().replaceAll("\\s+", ""); //introduce las lista de claves y elimina 
                        //los espacios en blanco utilizando replaceAll("\\s+", "")
                        String[] clavesArray = listaClaves.split(","); //divide la lista de datos en un array para separarlo por comas
                        for (String claveStr : clavesArray) { //recorre el array para hacer lo de las comas en todo
                            int claveInsertar = Integer.parseInt(claveStr);//convierte las claves de string a int
                            arbolB.insertar(claveInsertar); //inserta cada clave al arbol con ayuda del metodo claveInsertar
                        }
                        System.out.println("Claves insertadas correctamente.");
                        System.out.println("Desea insertar mas claves?");   //Pregunta por si el usuario se olvido de poner todas las claves para añadir mas
                        seguir = scanner.next().charAt(0);
                    }

                    break;

                case 2:
                    System.out.print("\nIngrese la clave a eliminar: ");
                    int claveEliminar = scanner.nextInt();
                    arbolB.eliminar(claveEliminar);
                    System.out.println("Clave eliminada correctamente.");
                    break;
                case 3:
                    System.out.print("\nIngrese la clave a buscar: ");
                    int claveBuscar = scanner.nextInt();
                    arbolB.buscarNodoPorClave(claveBuscar);
                    break;
                case 4:
                    System.out.println("\nÁrbol B:");
                    arbolB.showBTree();
                    break;
                case 5:
                    System.out.println("\nSaliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
//hola
        } while (opcion
                != 5);

        scanner.close();
    }
}
