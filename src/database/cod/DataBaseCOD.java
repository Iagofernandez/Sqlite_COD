package database.cod;

public class DataBaseCOD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Clase main, aqui se irian creando diversos obejtos para cada clase
        y se interactuarian con los metodos de cada clase
        */
   CrearNuebaBase obx1= new CrearNuebaBase();
   obx1.createNewDatabase("testeo.db");

    }

}
