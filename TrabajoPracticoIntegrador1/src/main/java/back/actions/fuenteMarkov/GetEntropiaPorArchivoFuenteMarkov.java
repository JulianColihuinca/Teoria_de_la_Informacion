package back.actions.fuenteMarkov;
import back.infrastructure.LectorArchivo;

public class GetEntropiaPorArchivoFuenteMarkov extends GetEntropiaFuenteMarkov {
    public GetEntropiaPorArchivoFuenteMarkov(String direccion) {
        super(new LectorArchivo().leerMatriz(direccion));
    }
}
