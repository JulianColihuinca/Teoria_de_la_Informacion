package back.domain.calculadoras;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import back.domain.interfaces.ICalculadoraHuffman;

class nodoHuffman {

	Integer frecuencia;
	Character simbolo;

	nodoHuffman izquierda;
	nodoHuffman derecha;
}

class Comparador implements Comparator<nodoHuffman> {
	public int compare(nodoHuffman x, nodoHuffman y) {

		return x.frecuencia - y.frecuencia;
	}
}

public class CalculadoraHuffman implements ICalculadoraHuffman {

	@Override
	public void analizarTexto(String cadena, ArrayList<Character> simbolos, ArrayList<Integer> frecuencias,
			ArrayList<Double> probabilidades, ArrayList<String> codigos) throws IOException {

		int pos;
		Character auxChar;
		int longitud = cadena.length();

		for (int i = 0; i < longitud; i++) {
			pos = 0;
			auxChar = cadena.charAt(i);
			int indice = simbolos.indexOf(auxChar);
			if (indice!=-1) {
				frecuencias.set(indice, frecuencias.get(indice)+1);
			}
			else {
				frecuencias.add(1);
				simbolos.add(auxChar);
			}
		}

		for (int i = 0; i < simbolos.size(); i++)
			probabilidades.add(frecuencias.get(i) / (double) longitud);

		ordenaDecreciente(simbolos, frecuencias, probabilidades);
		generaCodigos(simbolos, frecuencias, simbolos.size(), codigos);

	}

	@Override
	public double calculaEntropia(ArrayList<Double> probabilidades) {
		ArrayList<Double> infos = new ArrayList<>();
		ArrayList<Double> entropias = new ArrayList<>();
		
        for (Double x: probabilidades) {
        	if (x!=0)
        		infos.add(Math.abs(-Math.log(x)/Math.log(2)));
        	else
        		infos.add(0.0);
        }
        for (int i=0;i<probabilidades.size();i++) {
            entropias.add(probabilidades.get(i) * infos.get(i));
        }
        return entropias.stream().mapToDouble(x -> x).sum();
	}
	
	public double calculaLongitudMedia(ArrayList<String> codigos, ArrayList<Double> probabilidades) {
		ArrayList<Integer> longitudes = new ArrayList<Integer>();
		double acum = 0;
		
		for (int i=0; i<codigos.size();i++) {
			longitudes.add(codigos.get(i).length());
		}		
		for (int i = 0; i < probabilidades.size(); i++) {
			acum += probabilidades.get(i) * longitudes.get(i);
		}
		
		return acum;
	}
	
	@Override
	public int tasaDeCompresionEntera(String textoIngresado, ArrayList<Character> simbolos, ArrayList<Integer> frecuencias,
			ArrayList<String> codigos) {
		int acum=0;
		for (int i=0; i<simbolos.size(); i++) {
			acum += frecuencias.get(i) * codigos.get(i).length();
		}
		return (int) ((double)textoIngresado.length()*8/(double)acum);
	}
	
	@Override
	public double tasaDeCompresion(String textoIngresado, ArrayList<Character> simbolos, ArrayList<Integer> frecuencias,
			ArrayList<String> codigos) {
		int acum=0;
		for (int i=0; i<simbolos.size(); i++) {
			acum += frecuencias.get(i) * codigos.get(i).length();
		}
		return ((double)textoIngresado.length()*8/(double)acum);
	}
	
	private void generaCodigos(ArrayList<Character> simbolos, ArrayList<Integer> frecuencias, int n,
			ArrayList<String> codigos) {

		PriorityQueue<nodoHuffman> q = new PriorityQueue<nodoHuffman>(n, new Comparador());

		for (int i = 0; i < n; i++) {
			nodoHuffman nodo = new nodoHuffman();

			nodo.simbolo = simbolos.get(i);
			nodo.frecuencia = frecuencias.get(i);
			nodo.izquierda = null;
			nodo.derecha = null;
			q.add(nodo);
		}

		nodoHuffman raiz = q.peek();

		while (q.size() > 1) { // Genero el arbol de huffman

			nodoHuffman nuevoNodo = new nodoHuffman();

			nodoHuffman x = q.peek();
			q.poll();
			nodoHuffman y = q.peek();
			q.poll();

			nuevoNodo.frecuencia = x.frecuencia + y.frecuencia;
			nuevoNodo.simbolo = '|';
			nuevoNodo.izquierda = x;
			nuevoNodo.derecha = y;
			raiz = nuevoNodo;
			q.add(nuevoNodo);
		}

		guardarCodigo(raiz, "", codigos, simbolos);
	}

	private void guardarCodigo(nodoHuffman raiz, String codigo, ArrayList<String> codigos,
			ArrayList<Character> simbolos) {

		int i = 0;
		if (raiz.izquierda == null && raiz.derecha == null) {

			while (i < simbolos.size() && simbolos.get(i) != raiz.simbolo)
				i++;
			while (i>=codigos.size())
				codigos.add("");
			codigos.set(i, codigo);

			return;
		}
		
		guardarCodigo(raiz.izquierda, codigo + "0", codigos, simbolos);
		guardarCodigo(raiz.derecha, codigo + "1", codigos, simbolos);
	}

	private void ordenaDecreciente(ArrayList<Character> simbolos, ArrayList<Integer> frecuencias,
			ArrayList<Double> probabilidades) {
		Double auxP;
		Integer auxF;
		Character auxS;
		for (int i = 0; i < simbolos.size() - 1; i++) {
			for (int j = 0; j < simbolos.size() - i - 1; j++) {
				if (probabilidades.get(j) < probabilidades.get(j + 1)) {
					auxP = probabilidades.get(j);
					probabilidades.set(j, probabilidades.get(j + 1));
					probabilidades.set(j + 1, auxP);
					auxF = frecuencias.get(j);
					frecuencias.set(j, frecuencias.get(j + 1));
					frecuencias.set(j + 1, auxF);
					auxS = simbolos.get(j);
					simbolos.set(j, simbolos.get(j + 1));
					simbolos.set(j + 1, auxS);
				}
			}
		}
	}

	

	
	
}
