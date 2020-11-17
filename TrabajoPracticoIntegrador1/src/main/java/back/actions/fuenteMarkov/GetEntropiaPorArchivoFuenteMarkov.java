package back.actions.fuenteMarkov;
import back.infrastructure.LectorArchivo;

public class GetEntropiaPorArchivoFuenteMarkov extends GetEntropiaFuenteMarkov {
    public GetEntropiaPorArchivoFuenteMarkov(String direccion,int cantidad) {
        super(new LectorArchivo().leerMatriz(direccion),cantidad);
    }
}
