package back.presentation;

import back.actions.Actionable;
import back.actions.GetResultadoPorArchivoFuenteMemoriaNulaAction;

public class FuenteDeInformacion implements IFuenteDeInformacion {

    @Override
    public String calcularEntropia(String nombreArchivo) {
        Actionable action = new GetResultadoPorArchivoFuenteMemoriaNulaAction(nombreArchivo);
        return action.execute();
    }
}
