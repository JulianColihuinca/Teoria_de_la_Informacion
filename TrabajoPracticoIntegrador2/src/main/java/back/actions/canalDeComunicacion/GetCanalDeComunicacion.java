package back.actions.canalDeComunicacion;

import back.actions.Actionable;
import back.domain.calculadoras.CalculadoraEnvioMensaje;
import back.domain.formatters.CanalFormatter;

public class GetCanalDeComunicacion implements Actionable {

	private double[][] matrizCanal;
	private double[] probabilidadesAPrioriEntrada;
	private double[] probabilidadesAPrioriSalida;
	private double[][] probabilidadesAPosterioriEntrada;
	private double[][] probabilidadesSimultaneas;
	private double[] entropiasAPosterioriEntrada;
	private double entropiaAPrioriEntrada;
	private double entropiaAPrioriSalida;
	private double equivocacionEntrada;
	private double equivocacionSalida;
	private double entropiaAfin;
	private double informacionMutua;

	private CalculadoraEnvioMensaje calculadora = new CalculadoraEnvioMensaje();
	private CanalFormatter formatter = new CanalFormatter();

	public GetCanalDeComunicacion(double[] vector, double[][] matriz) {
		this.probabilidadesAPrioriEntrada = vector;
		this.matrizCanal = matriz;
	}

	@Override
	public String execute() {

		this.probabilidadesAPrioriSalida = calculadora.getProbabilidadesPbj(this.probabilidadesAPrioriEntrada,
				this.matrizCanal);

		this.probabilidadesAPosterioriEntrada = calculadora
				.getProbabilidadesAPosteriori(this.probabilidadesAPrioriEntrada, this.matrizCanal);

		this.probabilidadesSimultaneas = calculadora.getProbabilidadesSimultaneas(this.probabilidadesAPrioriEntrada,
				this.matrizCanal);

		this.entropiasAPosterioriEntrada = calculadora.getEntropiasAPosteriori(probabilidadesAPosterioriEntrada);
		
		this.entropiaAPrioriEntrada = calculadora.getEntropiaAPriori(this.probabilidadesAPrioriEntrada);

		this.entropiaAPrioriSalida = calculadora.getEntropiaAPriori(this.probabilidadesAPrioriSalida);
		
		this.equivocacionEntrada = calculadora.getEquivocacionDelCanal(probabilidadesSimultaneas, probabilidadesAPosterioriEntrada);
		
		this.equivocacionSalida = calculadora.getEquivocacionDelCanal(probabilidadesSimultaneas, matrizCanal);

		this.entropiaAfin = calculadora.getEntropiaAfin(probabilidadesSimultaneas);
		
		this.informacionMutua = calculadora.getInformacionMutua(entropiaAPrioriSalida, equivocacionSalida);
		
		return formatter.format(matrizCanal, probabilidadesAPrioriEntrada, probabilidadesAPrioriSalida,
				probabilidadesAPosterioriEntrada, probabilidadesSimultaneas, entropiaAPrioriEntrada, entropiaAPrioriSalida, entropiasAPosterioriEntrada,
				equivocacionEntrada, equivocacionSalida,entropiaAfin,informacionMutua);
	}

}
