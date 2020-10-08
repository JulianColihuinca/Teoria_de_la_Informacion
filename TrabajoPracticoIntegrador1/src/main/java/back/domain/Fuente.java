package back.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fuente {
    private ArrayList<Double> probabilidades = new ArrayList<Double>();
    private ArrayList<Double> informacionIndividual = new ArrayList<Double>();
    private ArrayList<Double> entropiaIndividual = new ArrayList<Double>();

    private int cantidadDeFuentes=0;
    private double entropia;

    public String calcularEntropia(String nombreArchivo) {
        setFuentes(nombreArchivo);
        this.calculaInformacionIndividual();
        this.calculaEntropiaIndividual();
        this.calculaEntropia();
        return getResultado();
    }

    private String getResultado() {
        return getInfoProbabilidades() + getInformacionIndividual() + getInfoEntropiaIndividual() + getInfoEntropia();
    }

    private void setFuentes(String direccion) { //"C:\\Lucho\\Programas Java\\TeoriaInfoG02E20\\fuentes.txt"
        try {
            Scanner input = new Scanner(new File(direccion));
            while (input.hasNextLine()) {
                this.probabilidades.add(Double.parseDouble(input.nextLine()));
                this.cantidadDeFuentes+=1;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo leer el archivo.");
        }
    }

    public String getInfoProbabilidades() {
        String infoProbabilidades = "P(Si)";
        int i = 0;
        for (Double x: probabilidades) {
            infoProbabilidades += "\nP(S"+ ++i +") = " + x;
        }
        return infoProbabilidades + "\n\n";
    }

    private void calculaInformacionIndividual() {
        for (Double x: probabilidades) {
            this.informacionIndividual.add(-Math.log(x)/Math.log(2));
        }
    }

    public String getInformacionIndividual() {
        int i=0;
        String infoIndividual = "I(Si)";
        for (Double x: informacionIndividual) {
            infoIndividual += "\nI(S"+ ++i +") = "+x;
        }
        return infoIndividual + "\n\n";
    }

    private void calculaEntropiaIndividual() {
        for (int i=0;i<this.probabilidades.size();i++) {
            this.entropiaIndividual.add(this.probabilidades.get(i)*this.informacionIndividual.get(i));
        }
    }

    public String getInfoEntropiaIndividual() {
        int i=0;
        String infoEntropia = "H(Si)";
        for (Double x: entropiaIndividual) {
            infoEntropia += "\nH(S"+ ++i +") = "+x;
        }
        return infoEntropia + "\n";
    }

    private void calculaEntropia() {
        this.entropia=0;
        for (Double x: entropiaIndividual) {
            this.entropia+=x;
        }
    }

    public String getInfoEntropia() {
        return "\nH(S) = "+this.entropia + "\n\n";
    }

}