package back.domain.formatters;

import java.util.ArrayList;

public class CodigosInstantaneosFormatter {

	public String format(ArrayList<Double> probabilidades, ArrayList<Double> infoIndividual,
			ArrayList<Double> entropiaIndividual, double entropia, ArrayList<Integer> longitudesIndividuales,
			double longitudMedia,String kraft,String compacto) {
		return getInfoProbabilidades(probabilidades) + getInformacionIndividual(infoIndividual)
				+ getInfoEntropiaIndividual(entropiaIndividual) + getInfoEntropia(entropia)
				+ getInfoLongitudes(longitudesIndividuales, longitudMedia)+getInfoKraft(kraft)+getInfoCompacto(compacto);
	}

	private String getInfoProbabilidades(ArrayList<Double> probabilidades) {
		String infoProbabilidades = "Probabilidades P(Si)";
		int i = 0;
		for (Double x : probabilidades) {
			infoProbabilidades += "\nP(S" + ++i + ") = " + x;
		}
		return infoProbabilidades + "\n\n";
	}

	private String getInformacionIndividual(ArrayList<Double> informacionesIndividuales) {
		int i = 0;
		String infoIndividual = "Informacion I(Si)";
		for (Double x : informacionesIndividuales) {
			infoIndividual += "\nI(S" + ++i + ") real = " + x + " binits | I(S" + i + ") = " + Math.ceil(x) + " binits";
		}
		return infoIndividual + "\n\n";
	}

	private String getInfoEntropiaIndividual(ArrayList<Double> entropiaIndividual) {
		int i = 0;
		String infoEntropia = "Entropias H(Si)";
		for (Double x : entropiaIndividual) {
			infoEntropia += "\nH(S" + ++i + ") = " + x + "binits/simbolo";
		}
		return infoEntropia + "\n";
	}

	private String getInfoEntropia(double entropia) {
		return "\nEntropia H(S) = " + entropia + " binits/simbolo\n\n";
	}

	private String getInfoLongitudes(ArrayList<Integer> longitudes, double longitudMedia) {
		int i = 0;
		String infoLongitudes = "Longitudes l(Si)";
		for (Integer x : longitudes) {
			infoLongitudes += "\nl(S" + ++i + ") = " + x;
		}
		infoLongitudes += "\n Longitud Media: " + longitudMedia;
		return infoLongitudes + "\n";
	}
	
	private String getInfoKraft(String kraft) {
		return "\n"+kraft+"\n";
	}
	
	private String getInfoCompacto(String compacto) {
		return "\n"+compacto+"\n";
	}

}
