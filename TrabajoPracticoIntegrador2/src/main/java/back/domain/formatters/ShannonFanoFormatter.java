package back.domain.formatters;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShannonFanoFormatter {

	public String format(ArrayList<Character> simbolos, ArrayList<Integer> frecuenciaSimbolos,
			ArrayList<Double> probabilidades, ArrayList<String> codigos, double entropia, double longitudMedia,
			int tasaDeCompresionEntera, double tasaDeCompresion) {
		return getInfoCodigos(simbolos, frecuenciaSimbolos, probabilidades, codigos)
				+ getInfoRendimiento(entropia, longitudMedia) + getInfoCompresion(tasaDeCompresionEntera,tasaDeCompresion);
	}

	private String getInfoCompresion(int tasaDeCompresion,double tasa) {
		return "Tasa de compresion: " +tasa+" |\t N:1 =  "+ tasaDeCompresion + ":" + 1;
	}

	public String getInfoCodigos(ArrayList<Character> simbolos, ArrayList<Integer> frecuencias,
			ArrayList<Double> probabilidades, ArrayList<String> codigos) {

		String cadena = "";
		DecimalFormat dfI = new DecimalFormat("#0000");
		DecimalFormat dfAscii = new DecimalFormat("#000");
		cadena += "   Probabilidad\tFrecuencia\tValor ASCII\tSimbolo\tCodigo Shannon-Fano\n";
		for (int i = 0; i < simbolos.size(); i++) {
			if (simbolos.get(i) == 32)
				cadena += "     " + String.format("%1.7f", probabilidades.get(i)) + "\t      "
						+ dfI.format(frecuencias.get(i)) + "\t            " + dfAscii.format((int) simbolos.get(i))
						+ "\t       " + String.format("%7s", "space") + "\t       "
						+ String.format("%12s", codigos.get(i)) + "\n";
			else if (simbolos.get(i) == 10)
				cadena += "     " + String.format("%1.7f", probabilidades.get(i)) + "\t      "
						+ dfI.format(frecuencias.get(i)) + "\t            " + dfAscii.format((int) simbolos.get(i))
						+ "\t       " + String.format("%7s", "enter") + "\t       "
						+ String.format("%12s", codigos.get(i)) + "\n";
			else
				cadena += "     " + String.format("%1.7f", probabilidades.get(i)) + "\t      "
						+ dfI.format(frecuencias.get(i)) + "\t            " + dfAscii.format((int) simbolos.get(i))
						+ "\t       " + String.format("%7s", simbolos.get(i)) + "\t            "
						+ String.format("%12s", codigos.get(i)) + "\n";
		}
		cadena += "\n";
		return cadena;
	}

	public String getInfoRendimiento(double entropia, double longitudMedia) {
		String cadena = "";
		double rendimiento = entropia / longitudMedia;
		cadena += "H(S) = " + entropia + "\n";
		cadena += "L = " + longitudMedia + "\n";
		cadena += "Rendimiento =  " + String.format("%2.2f", rendimiento * 100) + "%\n";
		cadena += "Redundancia = " + String.format("%2.2f", (1 - rendimiento) * 100) + "%\n";

		return cadena;
	}
}
