package back.domain.formatters;

import java.util.ArrayList;

public class CodigosInstantaneosFormatter {

	public String format(ArrayList<String> codigos, ArrayList<Double> probabilidades, ArrayList<Double> infoIndividual,
			ArrayList<Double> entropiaIndividual, double entropia, ArrayList<Integer> longitudesIndividuales,
			double longitudMedia,String kraft,String compacto) {
		return getInfoProbabilidadesYCodigos(probabilidades,codigos) + getInformacionIndividual(infoIndividual)
				+ getInfoEntropiaIndividual(entropiaIndividual) + getInfoEntropia(entropia)
				+ getInfoLongitudes(longitudesIndividuales, longitudMedia)+getInfoKraft(kraft)+getInfoCompacto(compacto);
	}

	private String getInfoProbabilidadesYCodigos(ArrayList<Double> probabilidades,ArrayList<String> codigos) {
		String infoBloque = "Codigo Bloque";
		for (int i=0; i< probabilidades.size(); i++) {
			infoBloque += "\nP(S"+ (i+1) + ") = "+ String.format("%1.5f",probabilidades.get(i)) + " | "+codigos.get(i);
		}
		
		return infoBloque + "\n\n";
	}

	private String getInformacionIndividual(ArrayList<Double> informacionesIndividuales) {
		int i = 0;
		String infoIndividual = "Informacion I(Si)";
		for (Double x : informacionesIndividuales) {
			infoIndividual += "\nI(S" + ++i + ") real = " + String.format("%1.7f", x) + " binits | I(S" + i + ") = " + Math.ceil(x) + " binits";
		}
		return infoIndividual + "\n\n";
	}

	private String getInfoEntropiaIndividual(ArrayList<Double> entropiaIndividual) {
		int i = 0;
		String infoEntropia = "Entropias H(Si)";
		for (Double x : entropiaIndividual) {
			infoEntropia += "\nH(S" + ++i + ") = " + String.format("%1.7f", x) + " binits/simbolo ";
		}
		return infoEntropia + "\n";
	}

	private String getInfoEntropia(double entropia) {
		return "\nEntropia H(S) = " + String.format("%1.7f", entropia) + " binits/simbolo\n\n";
	}

	private String getInfoLongitudes(ArrayList<Integer> longitudes, double longitudMedia) {
		int i = 0;
		String infoLongitudes = "Longitudes l(Si)";
		for (Integer x : longitudes) {
			infoLongitudes += "\nl(S" + ++i + ") = " + x;
		}
		infoLongitudes += "\n\nLongitud Media: " + longitudMedia;
		return infoLongitudes + "\n";
	}
	
	private String getInfoKraft(String kraft) {
		return "\n"+kraft+"\n";
	}
	
	private String getInfoCompacto(String compacto) {
		return "\n"+compacto+"\n";
	}

}
