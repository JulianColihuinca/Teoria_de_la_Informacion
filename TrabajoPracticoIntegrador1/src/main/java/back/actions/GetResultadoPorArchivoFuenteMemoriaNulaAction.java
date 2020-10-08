package back.actions;

import back.domain.Fuente;

public class GetResultadoPorArchivoFuenteMemoriaNulaAction implements Actionable {
    private final String nombreArchivo;
    private final Fuente fuente = new Fuente();

    public GetResultadoPorArchivoFuenteMemoriaNulaAction(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String execute() {
        return fuente.calcularEntropia(nombreArchivo);
    }
}
