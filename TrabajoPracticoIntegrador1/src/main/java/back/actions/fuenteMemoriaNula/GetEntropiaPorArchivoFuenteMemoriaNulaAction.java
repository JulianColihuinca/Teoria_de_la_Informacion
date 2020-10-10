package back.actions.fuenteMemoriaNula;
import back.infrastructure.LectorArchivo;

public class GetEntropiaPorArchivoFuenteMemoriaNulaAction extends GetEntropiaFuenteMemoriaNula {
    public GetEntropiaPorArchivoFuenteMemoriaNulaAction(String direccion) {
        super(new LectorArchivo().leerVector(direccion));
    }
}
