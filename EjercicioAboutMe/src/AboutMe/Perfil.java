package AboutMe;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Perfil para representar la información de un perfil de usuario.
 * Un perfil de usuario tiene un nombre, una historia, una lista de hobbies, una lista de comidas favoritas y una lista de datos curiosos.
 */

public class Perfil {
    //Atributos privados de la clase Perfil
    private String name;
    private String story;
    private List<String> hobbies;
    private List<String> foods;
    private List<String> funFacts;

    /**
     * Constructor por defecto de la clase Perfil
     * Inicializa los atributos de la clase Perfil con valores por defecto.
     */

public Perfil() {
    this.name = "";
    this.story = "";
    this.hobbies = new ArrayList<>();
    this.foods = new ArrayList<>();
    this.funFacts = new ArrayList<>();
}

/**
 * Constructor con parámetros de la clase Perfil
 * Inicializa los atributos de la clase Perfil con los valores pasados como parámetros.
 * @param name nombre del perfil
 * @param story historia del perfil
 * @param hobbies lista de hobbies del perfil
 * @param foods lista de comidas favoritas del perfil
 * @param funFacts lista de curiosidades del perfil
 */

public Perfil(String name, String story, List<String> hobbies, List<String> foods, List<String> funFacts) {
    this.name = name;
    this.story = story;

    //Se crea una nueva lista con los valores de la lista pasada como parámetro
    this.hobbies = new ArrayList<>(hobbies);
    this.foods = new ArrayList<>(foods);
    this.funFacts = new ArrayList<>(funFacts);
}

/**
 * Metodo para obtener el nombre del perfil
 * @return nombre del perfil
 */
public String getName() {
    return name;
}

/**
 * Metodo para obtener la historia del perfil
 * @return historia del perfil
 */
public String getStory() {
    return story;
}

    /**
     * Metodo para obtener la lista de hobbies del perfil
     * @return lista de hobbies del perfil
     */
    public List<String> getHobbies() {
        return hobbies;
    }

    /**
     * Metodo para obtener la lista de comidas favoritas del perfil
     * @return lista de comidas favoritas del perfil
     */
    public List<String> getFoods() {
        return foods;
    }

    /**
     * Metodo para obtener la lista de curiosidades del perfil
     * @return lista de curiosidades del perfil
     */
    public List<String> getFunFacts() {
        return funFacts;
    }

    /**
     * Metodo para establecer el nombre del perfil
     * @param name nombre del perfil a asignar
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo para establecer la historia del perfil
     * @param story historia del perfil a asignar
     */
    public void setStory(String story) {
        this.story = story;
    }

    /**
     * Metodo para establecer la lista de hobbies del perfil
     * @param hobbies lista de hobbies del perfil a asignar
     */
    public void setHobbies(List<String> hobbies) {
        this.hobbies = new ArrayList<>(hobbies);
    }

    /**
     * Metodo para establecer la lista de comidas favoritas del perfil
     * @param foods lista de comidas favoritas del perfil a asignar
     */
    public void setFoods(List<String> foods) {
        this.foods = new ArrayList<>(foods);
    }

    /**
     * Metodo para establecer la lista de curiosidades del perfil
     * @param funFacts lista de curiosidades del perfil a asignar
     */
    public void setFunFacts(List<String> funFacts) {
        this.funFacts = new ArrayList<>(funFacts);
    }

    /**
     * Metodo para añadir un hobby a la lista de hobbies del perfil
     * @param hobbie hobby a añadir
     */
    public void addHobbie(String hobbie) {
    this.hobbies.add(hobbie);
}

/**
 * Metodo para añadir una comida a la lista de comidas favoritas del perfil
 * @param food comida a añadir
 */
public void addFood(String food) {
    this.foods.add(food);
}

/**
 * Metodo para añadir un dato curioso a la lista de curiosidades del perfil
 * @param funFact dato curioso a añadir
 */
public void addFunFact(String funFact) {
    this.funFacts.add(funFact);
}

    /**
     * Metodo para obtener una representacion en cadena de perfil incluyendo toda su información
     * @return Cadena con la información del perfil
     */
    @Override
public String toString() {
    String result = "";
    result += "======================================\n";
    result += "       PERFIL DE " + name + "\n";
    result += "======================================\n";

    result += "---- My story ----\n";
    if (story.isBlank()) {
        result += "No hay informacion disponible\n";
    } else {
        result += story + "\n";
    }

    result += "---- My hobbies ----\n";
    result += "Hobbies:\n";
    if (hobbies.isEmpty()) {
        result += "No hay informacion disponible\n";
    } else {
        for (String hobbie : hobbies) {
            result += "- " + hobbie + "\n";
        }
    }

    result += "---- My favorite foods ----\n";
    if (foods.isEmpty()) {
        result += "No hay informacion disponible\n";
    } else {
        for (String food : foods) {
            result += "- " + food + "\n";
        }
    }

    result += "---- Fun facts ----\n";
    if (funFacts.isEmpty()) {
        result += "No hay informacion disponible\n";
    } else {
        for (String funFact : funFacts) {
            result += "- " + funFact + "\n";
        }
    }
    return result;
}
}
