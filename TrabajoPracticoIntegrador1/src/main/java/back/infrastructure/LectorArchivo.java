package back.infrastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LectorArchivo {
    public ArrayList<Double> leer(String direccion) {
        ArrayList<Double> resultado = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(direccion));
            while (input.hasNextLine()) {
                resultado.add(input.nextDouble());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo leer el archivo.");
        }
        return resultado;
    }
}
