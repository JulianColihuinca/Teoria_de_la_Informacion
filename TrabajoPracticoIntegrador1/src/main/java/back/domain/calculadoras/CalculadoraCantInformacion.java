package back.domain.calculadoras;

import java.util.ArrayList;

public class CalculadoraCantInformacion {
	
    public ArrayList<Double> invoke(ArrayList<Double> probabilidades) {
        ArrayList<Double> infoIndividuales = new ArrayList<>();
        for (Double x: probabilidades) {
        	if (x!=0)
        		infoIndividuales.add(Math.abs(-Math.log(x)/Math.log(2)));
        	else
        		infoIndividuales.add(0.0);
        }
        return infoIndividuales;
    }
}
