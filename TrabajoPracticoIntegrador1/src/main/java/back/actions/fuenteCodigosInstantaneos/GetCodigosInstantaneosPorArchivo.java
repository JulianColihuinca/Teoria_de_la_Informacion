package back.actions.fuenteCodigosInstantaneos;

import back.infrastructure.LectorArchivo;

public class GetCodigosInstantaneosPorArchivo extends GetCodigosInstantaneos {

	public GetCodigosInstantaneosPorArchivo(String direccion) {
		super(new LectorArchivo().leerVector(direccion));
	}

}
