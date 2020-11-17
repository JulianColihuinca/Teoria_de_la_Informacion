package back.actions.fuenteMemoriaNula;
import back.infrastructure.LectorArchivo;

public class GetEntropiaPorArchivoFuenteMemoriaNulaAction extends GetEntropiaFuenteMemoriaNula {
    public GetEntropiaPorArchivoFuenteMemoriaNulaAction(String direccion,int cantidad) {
        super(new LectorArchivo().leerVector(direccion),cantidad);
    }
}
