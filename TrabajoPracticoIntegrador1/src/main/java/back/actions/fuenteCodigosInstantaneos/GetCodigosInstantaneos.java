package back.actions.fuenteCodigosInstantaneos;

import java.util.ArrayList;

import back.actions.Actionable;
import back.domain.calculadoras.CalculadoraCantInformacion;
import back.domain.calculadoras.CalculadoraCodigosInstantaneos;
import back.domain.calculadoras.CalculadoraEntropia;
import back.domain.calculadoras.CalculadoraLongitudCodigos;
import back.domain.calculadoras.CalculadoraPropiedades;
import back.domain.formatters.CodigosInstantaneosFormatter;

public class GetCodigosInstantaneos implements Actionable{

	private final ArrayList<Double> probabilidades;
    private final CalculadoraCantInformacion calculadoraCantInformacion = new CalculadoraCantInformacion();
    private final CalculadoraEntropia calculadoraEntropia = new CalculadoraEntropia();
    private final CalculadoraCodigosInstantaneos calculadoraCodigos = new CalculadoraCodigosInstantaneos();
    private final CalculadoraLongitudCodigos calculadoraLongitud = new CalculadoraLongitudCodigos();
    private final CalculadoraPropiedades calculadoraPropiedades = new CalculadoraPropiedades();
    private final CodigosInstantaneosFormatter formatter = new CodigosInstantaneosFormatter();

    public GetCodigosInstantaneos(ArrayList<Double> probabilidades) {
        this.probabilidades = probabilidades;
    }

    @Override
    public String execute() {
        ArrayList<Double> infosIndividuales = calculadoraCantInformacion.invoke(probabilidades);
        ArrayList<Double> entropiasIndividuales = calculadoraEntropia.calculaEntropiaIndividual(probabilidades, infosIndividuales);
        double entropia = calculadoraEntropia.calculaEntropia(entropiasIndividuales);
        ArrayList<String> codigos = calculadoraCodigos.invoke(probabilidades);
        ArrayList<Integer> longitudesIndividuales = calculadoraLongitud.invoke(codigos);
        double longitudMedia = calculadoraLongitud.invoke(longitudesIndividuales, probabilidades);
        String kraft = calculadoraPropiedades.invoke(longitudesIndividuales);
        String compacto = calculadoraPropiedades.invoke(infosIndividuales, longitudesIndividuales);
        return formatter.format(probabilidades,infosIndividuales,entropiasIndividuales,entropia,longitudesIndividuales,longitudMedia,kraft,compacto);
    }
}
