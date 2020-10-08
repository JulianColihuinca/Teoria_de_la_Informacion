package front.controlador;

import back.presentation.FuenteDeInformacion;
import back.presentation.IFuenteDeInformacion;
import front.views.IVentana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private IVentana ventana;
    private IFuenteDeInformacion fuenteDeInformacion;

    public Controlador(IVentana ventana) {
        this.ventana = ventana;
        fuenteDeInformacion = new FuenteDeInformacion();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        String commando= arg0.getActionCommand();
        if (commando.equalsIgnoreCase("INGRESO FUENTE")) {
            if (this.ventana.getFuenteSeleccionada().equalsIgnoreCase("Fuente con memoria nula")) {
                System.out.println(this.ventana.getCantFuentes() + "  DIBUJA VEctor");
                this.ventana.dibujaVector(this.ventana.getCantFuentes());
                System.out.println("Vector dibujado");
            }
            else if (this.ventana.getFuenteSeleccionada().equalsIgnoreCase("Fuente de Markov")) {
                System.out.println(this.ventana.getCantFuentes()+ "  DIBUJA Matriz");
                this.ventana.dibujaMatriz(this.ventana.getCantFuentes());
                System.out.println("Matriz dibujada");
            }
        }
        else if (commando.equalsIgnoreCase("VER RESULTADOS")) {
            String resultado = fuenteDeInformacion.calcularEntropia(ventana.getDireccion());
            this.ventana.setAreaInformacion(resultado);
        }

    }

}
