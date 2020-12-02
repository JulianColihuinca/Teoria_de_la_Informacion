package back.domain.formatters;

public class CanalFormatter {

	public String format(double[][] matrizCanal, double[] probabilidadesAPrioriEntrada,
			double[] probabilidadesAPrioriSalida, double[][] probabilidadesAPosteriori,
			double[][] probabilidadesSimultaneas, double entropiaAPrioriEntrada, double entropiaAPrioriSalida,
			double[] entropiasAPosteriori, double equivocacionEntrada, double equivocacionSalida, double entropiaAfin,
			double informacionMutua) {

		return getInfoMatrizCanal(matrizCanal) + getInfoAPrioriEntrada(probabilidadesAPrioriEntrada)
				+ getInfoPbj(probabilidadesAPrioriSalida) + getInfoProbsPosteriori(probabilidadesAPosteriori)
				+ getInfoProbsSimultaneas(probabilidadesSimultaneas) + getInfoEntropiasAPosteriori(entropiasAPosteriori)
				+ getInfoEntropiaAPrioriEntrada(entropiaAPrioriEntrada)
				+ getInfoEntropiaAPrioriSalida(entropiaAPrioriSalida) + getInfoEquivocacionEntrada(equivocacionEntrada)
				+ getInfoEquivocacionSalida(equivocacionSalida) + getInfoMutua(informacionMutua)
				+ getInfoEntropiaAfin(entropiaAfin);
	}

	private String getInfoMutua(double informacionMutua) {
		String cadena = "Informacion mutua I(A,B): Cantidad de informacion sobre A que atraviesa el canal\n\n";
		cadena += "     I(A,B)=I(B,A)= " + String.format("%1.5f", informacionMutua) + "\n";
		return cadena + "\n";
	}

	private String getInfoEntropiaAfin(double entropiaAfin) {
		String cadena = "Entropia afin H(A,B): Incertidumbre del suceso simultaneo (ai,bj)\n\n";
		cadena += "     H(A,B)= " + String.format("%1.5f", entropiaAfin) + "\n";
		return cadena + "\n";
	}

	private String getInfoEquivocacionSalida(double equivocacion) {
		String cadena = "Equivocacion del canal de salida H(B/A) [PERDIDA]: Informacion que llega desde A despues de observar B. Informacion que no se perdio sobre A al atravesar el canal.\n\n";
		cadena += "     H(B/A)= " + String.format("%1.5f", equivocacion) + "\n";
		return cadena + "\n";
	}

	private String getInfoEquivocacionEntrada(double equivocacion) {
		String cadena = "Equivocacion del canal de entrada H(A/B) [RUIDO]: Informacion que queda en A despues de observar B. Perdida de informacion sobre A causada por el canal.\n\n";
		cadena += "     H(A/B)= " + String.format("%1.5f", equivocacion) + "\n";
		return cadena + "\n";
	}

	private String getInfoEntropiasAPosteriori(double[] entropias) {
		String cadena = "Entropias a posteriori H(A/bj): Numero medio de binits necesarios para representar un simbolo de una fuente con las probabilidades a posteriori P(ai/bj)\n\n";
		for (int i = 0; i < entropias.length; i++)
			cadena += "     H(A/b" + i + ")= " + String.format("%1.5f", entropias[i]) + "\n";
		return cadena + "\n";
	}

	private String getInfoEntropiaAPrioriEntrada(double entropiaAPriori) {
		String cadena = "Entropia a priori de entrada H(A): Numero medio de binits necesarios para representar un simbolo de una fuente con las probabilidades a priori P(ai)\n\n";
		cadena += "     H(A)= " + String.format("%1.5f", entropiaAPriori) + "\n";
		return cadena + "\n";
	}

	private String getInfoEntropiaAPrioriSalida(double entropiaAPriori) {
		String cadena = "Entropia a priori de salida H(B): Numero medio de binits necesarios para representar un simbolo de una fuente con las probabilidades a priori P(bi)\n\n";
		cadena += "     H(B)= " + String.format("%1.5f", entropiaAPriori) + "\n";
		return cadena + "\n";
	}

	private String getInfoProbsSimultaneas(double[][] probs) {
		String cadena = "Probabilidades de sucesos simultaneos P(a,b)\n\n";
		for (int i = 0; i < probs.length; i++) {
			for (int j = 0; j < probs[0].length; j++) {
				cadena += "     P(a=" + i + " , b=" + j + ")= " + String.format("%1.5f", probs[i][j]) + " ";
			}
			cadena += "\n";
		}
		return cadena + "\n";
	}

	private String getInfoProbsPosteriori(double[][] probs) {
		String cadena = "Probabilidades a posteriori (ai/bj):  Probabilidad de que haya entrado el símbolo ai sabiendo que en la salida ha aparecido el símbolo bj\n\n";
		for (int i = 0; i < probs.length; i++) {
			for (int j = 0; j < probs[0].length; j++) {
				cadena += "     P(a" + i + "/b" + j + ")= " + String.format("%1.5f", probs[i][j]) + " ";
			}
			cadena += "\n";
		}
		return cadena + "\n";
	}

	private String getInfoPbj(double[] pbj) {
		String cadena = "Probabilidades P(bj): Probabilidad de observar bj sin conocer el simbolo que entro\n\n";
		for (int i = 0; i < pbj.length; i++)
			cadena += "     P(b" + i + ")= " + String.format("%1.5f", pbj[i]) + "\n";
		return cadena + "\n";
	}

	private String getInfoAPrioriEntrada(double[] probs) {
		String cadena = "Probabilidades P(aj): Probabilidad de que entre en el canal el simbolo ai.\n\n";
		for (int i = 0; i < probs.length; i++)
			cadena += "     P(b" + i + ")= " + String.format("%1.5f", probs[i]) + "\n";
		return cadena + "\n";
	}

	private String getInfoMatrizCanal(double[][] mat) {
		String cadena = "Matriz del canal (bi/aj): Probabilidad de observar bj sabiendo que entro ai\n\n";
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				cadena += "     P(b" + i + "/a" + j + ")= " + String.format("%1.5f", mat[i][j]) + " ";
			}
			cadena += "\n";
		}
		return cadena + "\n";
	}

}
