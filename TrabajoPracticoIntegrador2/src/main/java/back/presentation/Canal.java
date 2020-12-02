package back.presentation;

import back.actions.Actionable;
import back.actions.canalDeComunicacion.GetCanalDeComunicacion;

public class Canal implements ICanal{

	@Override
	public String enviarMensaje(double[] v, double[][] m) {
		Actionable action = new GetCanalDeComunicacion(v,m);
		return action.execute();
	}

}
