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


    public Fuente(String direccion) {
        this.setFuentes(direccion);
        this.calculaInformacionIndividual();
        this.calculaEntropiaIndividual();
        this.calculaEntropia();
    }

    public int getCantidadDeFuentes() {
        return cantidadDeFuentes;
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

    public void muestraProbabilidades() {
        int i=0;
        System.out.println("P(Si)");
        for (Double x: probabilidades) {
            System.out.println("P(S"+ ++i +") = "+x);
        }
        System.out.println();
    }

    private void calculaInformacionIndividual() {
        for (Double x: probabilidades) {
            this.informacionIndividual.add(-Math.log(x)/Math.log(2));
        }
    }

    public void muestraInformacionIndividual() {
        int i=0;
        System.out.println("I(Si)");
        for (Double x: informacionIndividual) {
            System.out.println("I(S"+ ++i +") = "+x);
        }
        System.out.println();
    }

    private void calculaEntropiaIndividual() {
        for (int i=0;i<this.probabilidades.size();i++) {
            this.entropiaIndividual.add(this.probabilidades.get(i)*this.informacionIndividual.get(i));
        }
    }

    public void muestraEntropiaIndividual() {
        int i=0;
        System.out.println("H(Si)");
        for (Double x: entropiaIndividual) {
            System.out.println("H(S"+ ++i +") = "+x);
        }
        System.out.println();
    }

    private void calculaEntropia() {
        this.entropia=0;
        for (Double x: entropiaIndividual) {
            this.entropia+=x;
        }
    }

    public void muestraEntropia() {
        System.out.println("H(S) = "+this.entropia);
        System.out.println();
    }

}