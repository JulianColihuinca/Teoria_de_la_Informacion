package back.domain.calculadoras;

import java.util.ArrayList;

public class CalculadoraEnvioMensaje {

	public double[] getProbabilidadesPbj(double[] v, double[][] m) {
		double[] pbj = new double[m[0].length];
		double acum;
		for (int i=0; i<m[0].length; i++) { 
			acum=0;
			for(int j=0; j<m.length; j++) {
				acum+= v[j]*m[j][i];
			}
			pbj[i]=acum;			
		}
		return pbj;
	}
	
	public double[][] getProbabilidadesAPosteriori(double[] v, double[][] m){
		double[][] probabilidades = new double[v.length][m[0].length];		
		double numerador,denominador;
		for (int i=0; i<v.length; i++) { 
			for(int j=0; j<m[0].length; j++) { 
				
				numerador = v[i]*m[i][j];
				denominador=0;
				
				for (int k=0; k<m.length; k++) {
					denominador += m[k][j] * v[k];
				}
				
				probabilidades[i][j] = numerador / denominador;
			}
		}		
		
		return probabilidades;
	}
	
	public double[][] getProbabilidadesSimultaneas(double[] v, double[][] m){
		double[][] probs = new double[v.length][m[0].length];
		for (int i=0; i<v.length; i++) { 
			for(int j=0; j<m[0].length; j++) { 
				probs[i][j] = v[i]*m[i][j];
			}
		}		
		return probs;		
	}

	public double getEntropiaAPriori(double[] probs) {
		ArrayList<Double> infos = new ArrayList<>();
		ArrayList<Double> entropias = new ArrayList<>();
		for(int i=0; i<probs.length; i++) {
			if (probs[i]!=0)
        		infos.add(Math.abs(-Math.log(probs[i])/Math.log(2)));
        	else
        		infos.add(0.0);
		}
        for (int i=0;i<probs.length;i++) {
            entropias.add(probs[i] * infos.get(i));
        }        
        return entropias.stream().mapToDouble(x -> x).sum();
	}

	public double[] getEntropiasAPosteriori(double[][] probs) {
		double[] entropias = new double[probs[0].length];
		double[][] infos = new double[probs.length][probs[0].length];
		for(int i=0; i<probs.length; i++) {
			for(int j=0; j<probs[0].length; j++) {
				if (probs[i][j]!=0)
	        		infos[i][j]=Math.abs(-Math.log(probs[i][j])/Math.log(2));
	        	else
	        		infos[i][j]=0.0;
			}
		}
		for(int i=0; i<probs[0].length; i++) {
			entropias[i]=0;
			for(int j=0; j<probs.length; j++) {
				entropias[i]+= probs[j][i] * infos[j][i];
			}
		}	
		return entropias;
	}

	
	public double getEquivocacionDelCanal(double[][] simultaneas, double[][] mat) {
		double acum=0;		
		for (int i=0; i<simultaneas.length; i++) {
			for (int j=0; j<simultaneas[0].length; j++) {
				if (mat[i][j]!=0)
	        		acum += simultaneas[i][j] * Math.abs(-Math.log(mat[i][j])/Math.log(2));
			}
		}		
		return acum;
	}
	
	public double getEntropiaAfin(double[][] simultaneas) {
		double acum=0;
		for (int i=0; i<simultaneas.length; i++) {
			for (int j=0; j<simultaneas[0].length; j++) {
				if (simultaneas[i][j]!=0)
	        		acum += simultaneas[i][j] * Math.abs(-Math.log(simultaneas[i][j])/Math.log(2));
			}
		}		
		return acum;
	}
	
	public double getInformacionMutua(double entropiaSalida, double equivocacionSalida) {
		return entropiaSalida - equivocacionSalida;
	}	
	
}
