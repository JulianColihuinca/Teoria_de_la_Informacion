package back.domain.calculadoras;

import java.util.ArrayList;

public class CalculadoraCantInformacion {
    public ArrayList<Double> invoke(ArrayList<Double> probabilidades) {
        ArrayList<Double> infoIndividuales = new ArrayList<>();
        for (Double x: probabilidades) {
            infoIndividuales.add(-Math.log(x)/Math.log(2));
        }
        return infoIndividuales;
    }
}
