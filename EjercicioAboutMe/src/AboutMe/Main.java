package AboutMe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase Main para ejecutar el programa de creación de perfiles.
 * El programa solicita al usuario información personal y muestra un perfil con los datos introducidos.
 */
public class Main {

    //Escáner para introducir datos por consola
    private Scanner sc = new Scanner(System.in);

    /**
     * Metodo principal que inicia el programa
     * @param args argumentos de la línea de comandos no utilizados
     */
    public static void main(String[] args) {
        Main program = new Main();
        program.start();
    }

    /**
     * Metodo que inicia el programa
     * 1. Solicita al usuario información personal
     * 2. Muestra el perfil con los datos introducidos
     * 3. Muestra un menú con opciones para ver la historia, los favoritos o una curiosidad al azar
     */
    public void start(){
        //Comienzo del programa y interacion con el usuario y el asistente virtual
        Perfil myProfile = new Perfil();
        System.out.println("¡Hola! Soy Marvin tu asistente virutal que te ayudará a crear tu perfil. Vamos a empezar con algunas preguntas.\n");

        //Solicito el nombre del usuario y valido que no sea un nombre vacío
        String nombre;
        do{ //Bucle para solicitar el nombre hasta que se introduzca un nombre válido
            System.out.println("¿Cómo te llamas?");
            nombre = leerNombre();
            if (nombre.isBlank()){
                System.out.println("Por favor, introduce un nombre válido");
            }
        }while(nombre.isBlank()); //Se repite mientras el nombre esté vacío
        myProfile.setName(nombre); //Asigno el nombre al perfil

        System.out.println();
        System.out.println("¡Hola " + myProfile.getName() + "! ¿Podrías contarme un poco sobre ti?"); //Solicito la historia del usuario
        myProfile.setStory(leerHistoria());

        System.out.println();
        System.out.println("¡Gracias por compartir tu historia! Ahora, ¿cuáles son tus hobbies?"); //Solicito los hobbies del usuario
        myProfile.setHobbies(leerLista("Introduce tus hobbies uno a uno y presiona Enter para añadir uno nuevo. Presiona Enter sin escribir nada para terminar.\n"));

        System.out.println();
        System.out.println("¡Entendido! ¿Cuáles son tus comidas favoritas?"); //Solicito las comidas favoritas del usuario
        myProfile.setFoods(leerLista("Introduce tus comidas favoritas una a una y presiona Enter para añadir una nueva. Presiona Enter sin escribir nada para terminar.\n"));

        System.out.println();
        System.out.println("¡Genial! Por ultimo, ¿podrias decirme algunas curiosidades sobre ti?"); //Solicito las curiosidades del usuario
        myProfile.setFunFacts(leerLista("Introduce tus curiosidades una a una y presiona Enter para añadir una nueva. Presiona Enter sin escribir nada para terminar.\n"));

        System.out.println("¡Gracias por compartir tu informacion! Aquí tienes tu perfil:\n");
        System.out.println(myProfile); //Muestro el perfil del usuario

        mostrarMenu(myProfile); //Muestro el menú de opciones
        System.out.println("Terminando programa... ¡Hasta luego!"); //Mensaje de despedida al finalizar el programa

    }

    /**
     * Metodo para leer el nombre introducido por el usuario
     * @return nombre introducido por el usuario
     */
    private String leerNombre(){
        return sc.nextLine();
    }

    /**
     * Metodo para leer la historia introducida por el usuario
     * @return historia introducida por el usuario
     */
    private String leerHistoria(){
        return sc.nextLine();
    }

    /**
     * Metodo para leer una lista de elementos introducida por el usuario
     * @param mensaje mensaje a mostrar al usuario
     * @return lista de elementos introducida por el usuario
     */
    private List<String> leerLista(String mensaje){
        System.out.println(mensaje);
        List<String> lista = new ArrayList<>();
        while (true){
            String info = sc.nextLine();
            if (info.isBlank()){
                break;
            }
            lista.add(info);
        }
        return lista;
    }

    /**
     * Metodo para mostrar el menú de opciones al usuario
     * Repetir menu hasta que el usuario decida salir mediante la opción 4
     * @param perfil perfil del usuario
     */
    private void mostrarMenu(Perfil perfil){
        boolean exit = false;
        while (!exit) {
            System.out.println("¡Hola " + perfil.getName() + "! ¿Qué te gustaría hacer?\n");
            System.out.println("[1] Ver mi historia");
            System.out.println("[2] Ver mis favoritos");
            System.out.println("[3] Ver una de mis curiosidades al azar");
            System.out.println("[4] Salir del programa");
            System.out.println();
            System.out.print("Opción: ");

            //Validar que la opción introducida sea un número
            if (!sc.hasNextInt()){
                System.out.println("Por favor, introduce un número");
                sc.nextLine();
                continue;
            }
            int opcion = sc.nextInt();
            sc.nextLine(); //Limpiar el buffer

            //Ejecutar la opción seleccionada por el usuario
            switch (opcion){
                case 1:
                    mostrarHistoria(perfil);
                    break;
                case 2:
                    mostrarFavoritos(perfil);
                    break;
                case 3:
                    mostrarCuriosidad(perfil);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    /**
     * Metodo para mostrar la historia del perfil
     * @param perfil perfil del usuario
     */
    private void mostrarHistoria(Perfil perfil){
        System.out.println();
        System.out.println("Historia de " + perfil.getName() + ":");
        if (perfil.getStory().isBlank()){
            System.out.println("No hay historia disponible");
        }else{
            System.out.println(perfil.getStory());
        }
        System.out.println();
    }

    /**
     * Metodo para mostrar los hobbies y comidas favoritas del perfil
     * @param perfil perfil del usuario
     */
    private void mostrarFavoritos(Perfil perfil){
        System.out.println();
        System.out.println("Hobbies:\n");
        if (perfil.getHobbies().isEmpty()){ //Comprobar si la lista de hobbies está vacía
            System.out.println("No hay hobbies disponibles");
        }else{
            for (String hobbie : perfil.getHobbies()){
                System.out.println("- " + hobbie);
            }
        }
        System.out.println();
        if (perfil.getFoods().isEmpty()){ //Comprobar si la lista de comidas favoritas está vacía
            System.out.println("No hay comidas favoritas disponibles");
        }else{
            System.out.println("Comidas favoritas:\n");
            for (String comida : perfil.getFoods()){
                System.out.println("- " + comida);
            }
        }
        System.out.println();
    }

    /**
     * Metodo para mostrar una curiosidad aleatoria del perfil
     * @param perfil perfil del usuario
     */
    private void mostrarCuriosidad(Perfil perfil){
        System.out.println();
        if (perfil.getFunFacts().isEmpty()){
            System.out.println("No hay curiosidades disponibles");
        }else{
            Random random = new Random();
            int index = random.nextInt(perfil.getFunFacts().size());
            System.out.println("Curiosidad al azar: " + perfil.getFunFacts().get(index));
        }
        System.out.println();

    }
}
