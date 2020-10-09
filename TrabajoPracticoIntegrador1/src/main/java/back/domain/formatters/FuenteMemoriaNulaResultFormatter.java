package back.domain.formatters;

import java.util.ArrayList;

public class FuenteMemoriaNulaResultFormatter {
    public String format(ArrayList<Double> probabilidades, ArrayList<Double> infoIndividual,
                         ArrayList<Double> entropiaIndividual, double entropia) {
        return getInfoProbabilidades(probabilidades) + getInformacionIndividual(infoIndividual) +
                getInfoEntropiaIndividual(entropiaIndividual) + getInfoEntropia(entropia);
    }

    private String getInfoProbabilidades(ArrayList<Double> probabilidades) {
        String infoProbabilidades = "P(Si)";
        int i = 0;
        for (Double x: probabilidades) {
            infoProbabilidades += "\nP(S"+ ++i +") = " + x;
        }
        return infoProbabilidades + "\n\n";
    }

    private String getInformacionIndividual(ArrayList<Double> informacionesIndividuales) {
        int i=0;
        String infoIndividual = "I(Si)";
        for (Double x: informacionesIndividuales) {
            infoIndividual += "\nI(S"+ ++i +") = "+x;
        }
        return infoIndividual + "\n\n";
    }

    private String getInfoEntropiaIndividual(ArrayList<Double> entropiaIndividual) {
        int i=0;
        String infoEntropia = "H(Si)";
        for (Double x: entropiaIndividual) {
            infoEntropia += "\nH(S"+ ++i +") = "+x;
        }
        return infoEntropia + "\n";
    }

    private String getInfoEntropia(double entropia) {
        return "\nH(S) = "+ entropia + "\n\n";
    }
}
