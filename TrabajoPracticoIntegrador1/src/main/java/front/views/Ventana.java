package front.views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Ventana extends JFrame implements IVentana, KeyListener, MouseListener  {

    private JPanel contentPane;
    private JTextField[][] matrizTextField; // Usado para Fuente de Markov
    private JTextField[] vTextField; // Usado para Fuente de memoria nula
    private JTextField direccionTextField; // Direccion del archivo de texto
    private JTextField fuentesTextField; // Cantidad de fuentes.
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JPanel panelC3 ; // Lugar donde se dibuja los TextField para ingresar datos por teclado
    private ActionListener actionlistener;
    private JTextArea areaInformacion; // Area de texto donde se muestran los resultados.
    private Choice fuenteEleccion; // Se elige la opcion
    private JRadioButton tecladoSeleccion; // Eleccion por teclado
    private JRadioButton archivoSeleccion ; // Eleccion por archivo
    private JButton confirmarButton ; // Boton para confirmar la cantidad de fuentes
    private JButton resultadoBoton ; // Boton para ver resultados con los datos.


    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1075, 561);
        this.setMinimumSize(new Dimension(1075,560));
        this.setTitle("TP Integrador 1");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        Panel panelEste = new Panel();
        contentPane.add(panelEste, BorderLayout.EAST);

        JScrollPane scrollPane = new JScrollPane();
        panelEste.add(scrollPane);

        areaInformacion = new JTextArea();
        areaInformacion.setRows(27);
        areaInformacion.setColumns(50);
        scrollPane.setViewportView(areaInformacion);

        JPanel panelCentral = new JPanel();
        contentPane.add(panelCentral, BorderLayout.CENTER);
        panelCentral.setLayout(new GridLayout(5, 1, 0, 0));

        JPanel panelC1 = new JPanel();
        panelCentral.add(panelC1);
        panelC1.setLayout(new GridLayout(1, 2, 0, 0));

        JPanel panel = new JPanel();
        panelC1.add(panel);

        JLabel seleccionLabel = new JLabel("Seleccione tipo de Fuente:");
        panel.add(seleccionLabel);

        JPanel panel_1 = new JPanel();
        panelC1.add(panel_1);

        fuenteEleccion = new Choice();
        panel_1.add(fuenteEleccion);

        Panel panelC2 = new Panel();
        panelCentral.add(panelC2);
        panelC2.setLayout(new GridLayout(3, 1, 0, 0));

        Panel panel_2 = new Panel();
        panelC2.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_5 = new JPanel();
        panel_2.add(panel_5);

        JLabel entradaLabel = new JLabel("Seleccione tipo de Entrada:");
        panel_5.add(entradaLabel);

        Panel panel_3 = new Panel();
        panelC2.add(panel_3);
        panel_3.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_6 = new JPanel();
        panel_3.add(panel_6);

        archivoSeleccion = new JRadioButton("Archivo");
        buttonGroup.add(archivoSeleccion);
        panel_6.add(archivoSeleccion);

        JPanel panel_7 = new JPanel();
        panel_3.add(panel_7);

        JLabel direccionLabel = new JLabel("Direccion:");
        panel_7.add(direccionLabel);

        direccionTextField = new JTextField();
        direccionTextField.setEnabled(false);
        panel_7.add(direccionTextField);
        direccionTextField.setColumns(15);

        Panel panel_4 = new Panel();
        panelC2.add(panel_4);
        panel_4.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_8 = new JPanel();
        panel_4.add(panel_8);

        tecladoSeleccion = new JRadioButton("Teclado");
        buttonGroup.add(tecladoSeleccion);
        panel_8.add(tecladoSeleccion);

        JPanel panel_9 = new JPanel();
        panel_4.add(panel_9);

        JLabel lblNewLabel = new JLabel("Fuentes:");
        panel_9.add(lblNewLabel);

        fuentesTextField = new JTextField();
        fuentesTextField.setEnabled(false);
        panel_9.add(fuentesTextField);
        fuentesTextField.setColumns(4);

        confirmarButton = new JButton("Ok!");
        confirmarButton.setEnabled(false);
        panel_9.add(confirmarButton);

        panelC3 = new JPanel();
        panelCentral.add(panelC3);

        JPanel panelC4 = new JPanel();
        panelCentral.add(panelC4);

        resultadoBoton = new JButton("Ver Resultados");
        panelC4.add(resultadoBoton);
        this.resultadoBoton.setEnabled(false);

        this.archivoSeleccion.addMouseListener(this);
        this.tecladoSeleccion.addMouseListener(this);
        this.fuenteEleccion.add("Fuente con memoria nula");
        this.fuenteEleccion.add("Fuente de Markov");
        this.fuenteEleccion.add("Codigo con Probabilidades");
        this.direccionTextField.addKeyListener(this);
        this.fuentesTextField.addKeyListener(this);
        this.confirmarButton.setActionCommand("INGRESO FUENTE");
        this.resultadoBoton.setActionCommand("VER RESULTADOS");
    }
    
    @Override
    public void abrir() {
        setVisible(true);
    }

    /**
     * Setea el controlador y los asocia con los botones.
     */
    @Override
    public void setActionlistener(ActionListener controlador) {
        this.resultadoBoton.addActionListener(controlador);
        this.confirmarButton.addActionListener(controlador);
        this.actionlistener = controlador;
    }
    
    /**
     * Esta funcion, devuelve true si los datos se leen por archivo sino false.
     */
    @Override
    public boolean porArchivo() {
    	return this.archivoSeleccion.isSelected();
    }

    /**
     * Este metodo setea el area de informacion, donde se veran los resultados.
     */
    @Override
    public void setAreaInformacion(String ver_resultados) {
        this.areaInformacion.setText(ver_resultados);
    }

    /**
     * Esta funcion devuelve la fuente seleccionada.
     */
    @Override
    public String getFuenteSeleccionada() {
        return this.fuenteEleccion.getSelectedItem();
    }

    /**
     * Este metodo dibuja la matriz para ingresar por teclado.
     */
    @Override
    public void dibujaMatriz(int cant) {
        this.panelC3.removeAll();
        this.setSize(new Dimension(1075,560));
        this.panelC3.setLayout(new GridLayout(cant,cant));
        this.matrizTextField= new JTextField[cant][cant];
        for (int i=0;i<cant;i++)
            for (int j=0;j<cant;j++) {
                JPanel panel= new JPanel();
                panel.setLayout(new FlowLayout());
                panel.add(new JLabel("P" + (i+1) + (j+1) + ":"));
                this.matrizTextField[i][j]= new JTextField();
                this.matrizTextField[i][j].setColumns(7);
                this.matrizTextField[i][j].addKeyListener(this);
                panel.add(this.matrizTextField[i][j]);
                this.panelC3.add(panel);
            }
        this.setSize(new Dimension(1300,700));
        this.repaint();
    }

    /**
     * Este metodo dibuja el vector para ingresar por teclado.
     */
    @Override
    public void dibujaVector(int cant) {
        this.panelC3.removeAll();
        this.setSize(new Dimension(1075,560));
        this.panelC3.setLayout(new GridLayout(cant,0));
        this.vTextField= new JTextField[cant];
        for (int i=0;i<cant;i++) {
            JPanel panel= new JPanel();
            panel.setLayout(new FlowLayout());
            panel.add(new JLabel("P" + (i+1) + ":"));
            this.vTextField[i]= new JTextField();
            this.vTextField[i].setColumns(7);
            this.vTextField[i].addKeyListener(this);
            panel.add(this.vTextField[i]);
            this.panelC3.add(panel);
        }
        this.setSize(new Dimension(1200,700));
        this.repaint();
    }
    
     

    /**
     * Esta funcion devuelve la direccion del archivo.
     */
    @Override
    public String getDireccion() {
        return this.direccionTextField.getText();
    }

    @Override
    public int getCantFuentes() {
        return Integer.parseInt(this.fuentesTextField.getText());
    }

    /**
     * Esta funcion devuelve la matriz en formato double ingresada por teclado.
     */
    @Override
    public double[][] getMatriz(){
        double[][] matriz= new double[this.matrizTextField.length][this.matrizTextField.length];
        for (int i=0;i<this.matrizTextField.length;i++)
            for (int j=0;j<this.matrizTextField.length;j++)
                matriz[i][j]= numero(this.matrizTextField[i][j].getText());
        return matriz;
    }

    /**
     * Esta funcion devuelve el arraylist en formato double ingresada por teclado.
     */
    @Override
    public ArrayList<Double> getArray() {
        ArrayList<Double> array= new ArrayList<Double>();
        for (int i=0;i<this.vTextField.length;i++)
            array.add( numero(this.vTextField[i].getText()));
        return array;
    }
    
    /**
     * Esta funcion calcula el numero segun la cadena.
     */
    
    private double numero(String numero) {
    	double numeroFinal;	
    	try {
	    	if (numero.contains("/")) {
	    		Double numerador= Double.parseDouble(numero.substring(0, numero.indexOf('/')));
	    		Double denominador= Double.parseDouble(numero.substring(numero.indexOf('/')+1,numero.length()));
	    		numeroFinal= numerador/denominador;
	    	}
	    	else 
	    			numeroFinal= Double.parseDouble(numero);
    	}
    	catch(NumberFormatException e) {
			return 0;
		}	
	    return numeroFinal;
    }


    @Override
    public void mouseClicked(MouseEvent arg0) {
        if (arg0.getSource()== this.archivoSeleccion) {
            this.direccionTextField.setEnabled(this.archivoSeleccion.isSelected());
            this.fuentesTextField.setEnabled(this.tecladoSeleccion.isSelected());
            this.confirmarButton.setEnabled(this.tecladoSeleccion.isSelected());
        }
        else if (arg0.getSource()==this.tecladoSeleccion) {
            this.direccionTextField.setEnabled(this.archivoSeleccion.isSelected());
            this.fuentesTextField.setEnabled(this.tecladoSeleccion.isSelected());
            this.confirmarButton.setEnabled(this.tecladoSeleccion.isSelected());
        }
    }
    @Override
    public void mouseEntered(MouseEvent arg0) {}
    @Override
    public void mouseExited(MouseEvent arg0) {}
    @Override
    public void mousePressed(MouseEvent arg0) {}
    @Override
    public void mouseReleased(MouseEvent arg0) {}


    @Override
    public void keyPressed(KeyEvent arg0) {}
    @Override
    public void keyReleased(KeyEvent arg0) {
        boolean condicion;
        if (arg0.getSource()==this.fuentesTextField) {
            condicion=this.fuentesTextField.getText()!=null && !this.fuentesTextField.getText().equalsIgnoreCase("") ;
            this.confirmarButton.setEnabled(condicion);
        }
        else if (arg0.getSource()==this.direccionTextField) {
            condicion= this.direccionTextField.getText()!=null && !this.direccionTextField.getText().equalsIgnoreCase("") ;
            this.resultadoBoton.setEnabled(condicion);
        }
        else if (this.vTextField!=null || this.matrizTextField!=null) {
            condicion=true;
            if (this.vTextField!=null) {
                for (int i=0;i<this.vTextField.length && condicion;i++)
                    condicion= this.vTextField[i].getText()!=null && !this.vTextField[i].getText().equalsIgnoreCase("");
            }
            else {
                for (int i=0;i<this.matrizTextField.length && condicion;i++)
                    for (int j=0;j<this.matrizTextField.length && condicion;j++)
                        condicion=  this.matrizTextField[i][j].getText()!=null && !this.matrizTextField[i][j].getText().equalsIgnoreCase("");
            }
            this.resultadoBoton.setEnabled(condicion);
        }


    }
    @Override
    public void keyTyped(KeyEvent arg0) {}


}
