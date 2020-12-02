package back.domain.formatters;


public class RlcFormatter {

	public String format(String codificacion, int tasaDeCompresionEntera, double tasaDeCompresion) {
		return getInfoCodificacion(codificacion)+getInfoCompresion(tasaDeCompresionEntera,tasaDeCompresion);
	}
	
	private String getInfoCompresion(int tasaDeCompresion,double tasa) {
		if (tasaDeCompresion>0)
			return "Tasa de compresion: "+tasa+" |\t N:1 =  "+tasaDeCompresion+":"+1;
		else
			return "Tasa de compresion negativa";
	}

	private String getInfoCodificacion(String codificacion) {
		return "Codificacion RLC: \n"+codificacion+"\n\n";
	}
}
