package back.domain.calculadoras;

import java.util.ArrayList;

public class CalculadoraEntropia {
    public double calculaEntropia(ArrayList<Double> entropiaIndividual) {
        return entropiaIndividual.stream().mapToDouble(x -> x).sum();
    }

    public ArrayList<Double> calculaEntropiaIndividual(ArrayList<Double> probabilidades, ArrayList<Double> infoIndividual) {
        ArrayList<Double> entropiaIndividual = new ArrayList<>();
        for (int i=0;i<probabilidades.size();i++) {
            entropiaIndividual.add(probabilidades.get(i) * infoIndividual.get(i));
        }
        return entropiaIndividual;
    }
}
