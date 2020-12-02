package front.views;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import front.views.interfaces.IVistaCanales;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BorderFactory;

public class VistaCanales extends JFrame implements IVistaCanales{

	private static final long serialVersionUID = 5039098172923390597L;
	private JPanel panelGeneral;
	@SuppressWarnings("unused")
	private ActionListener aL;
	private JPanel panelDatos;
	private JPanel panelInfo;
	private JPanel panelEntrada;
	private JPanel panelSalida;
	private JLabel lblAi;
	private JLabel lblPAi;
	private JLabel[] lblA = new JLabel[5];
	private JTextField[] vectorTextField = new JTextField[5];
	private JLabel lble;
	private JLabel[] lblJ = new JLabel[5];
	private JLabel[] lblI = new JLabel[5];
	private JTextField[][] matrizTextField = new JTextField[5][5];
	private Border border = BorderFactory.createLineBorder(Color.black,1);
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnComenzar;

	
	public VistaCanales() {
		setTitle("Canales para transmisi\u00F3n de informaci\u00F3n\r\n");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		panelGeneral = new JPanel();
		panelGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelGeneral);
		panelGeneral.setLayout(new GridLayout(2, 0, 0, 0));
		
		panelDatos = new JPanel();
		panelGeneral.add(panelDatos);
		panelDatos.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelEntrada = new JPanel();
		panelEntrada.setBorder(new TitledBorder(null, "Probabilidades a priori", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatos.add(panelEntrada);
		panelEntrada.setLayout(new GridLayout(6, 2, 0, 0));
		
		lblAi = new JLabel("Ai");
		lblAi.setHorizontalAlignment(SwingConstants.CENTER);
		lblAi.setBorder(border);
		panelEntrada.add(lblAi);
		
		lblPAi = new JLabel("P(Ai)");
		lblPAi.setHorizontalAlignment(SwingConstants.CENTER);
		lblPAi.setBorder(border);
		panelEntrada.add(lblPAi);
		
		for(int i=0; i<5; i++) {
			lblA[i] = new JLabel("a"+i);
			lblA[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblA[i].setBorder(border);
			panelEntrada.add(lblA[i]);
			vectorTextField[i] = new JTextField();
			vectorTextField[i].setHorizontalAlignment(SwingConstants.CENTER);
			vectorTextField[i].setColumns(10);
			panelEntrada.add(vectorTextField[i]);
		}
		
		panelSalida = new JPanel();
		panelSalida.setBorder(new TitledBorder(null, "Matriz del canal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatos.add(panelSalida);
		panelSalida.setLayout(new GridLayout(6, 6, 0, 0));
		
		lble = new JLabel("P(bj/ai)");
		lble.setHorizontalAlignment(SwingConstants.CENTER);
		lble.setBorder(this.border);
		panelSalida.add(lble);
		
		for (int i=0; i<5; i++) {
			this.lblJ[i] = new JLabel("b"+i);
			this.lblJ[i].setHorizontalAlignment(SwingConstants.CENTER);
			this.lblJ[i].setBorder(border);
			panelSalida.add(lblJ[i]);
		}
		
		for (int i=0; i<5; i++) {
			this.lblI[i] = new JLabel("a"+i);
			this.lblI[i].setHorizontalAlignment(SwingConstants.CENTER);		
			this.lblI[i].setBorder(border);
		}		
		
		for (int i=0; i<5; i++) {
			panelSalida.add(this.lblI[i]);
			for (int j=0; j<5; j++) {
				this.matrizTextField[i][j] = new JTextField();
				this.matrizTextField[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				this.matrizTextField[i][j].setColumns(10);
				panelSalida.add(this.matrizTextField[i][j]);
			}
		}		
		
		panelInfo = new JPanel();
		panelGeneral.add(panelInfo);
		panelInfo.setLayout(new GridLayout(0, 2, 0, 0));
		
		scrollPane = new JScrollPane();
		panelInfo.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnComenzar = new JButton("Enviar Mensaje");
		btnComenzar.setActionCommand("Enviar mensaje");
		panelInfo.add(btnComenzar);
		
		
		
	}

	@Override
	public void setActionlistener(ActionListener controlador) {
		this.aL=controlador;
		this.btnComenzar.addActionListener(controlador);
	}
	
	@Override
    public void abrir() {
        setVisible(true);
    }
	
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
	public double[] getProbabilidadesAPriori() {
		int i=0;
		while ( i<5 && !this.vectorTextField[i].getText().isEmpty() )
			i++;	
		double[] probs = new double[i];
		for (int j=0; j<i; j++) {
			probs[j] = numero(this.vectorTextField[j].getText());
		}
		return probs;
	}

	@Override
	public double[][] getMatrizCanal() {
		int x=0;
		int y=0;
		while ( x<5 && !this.matrizTextField[0][x].getText().isEmpty())
			x++;
		while ( y<5 && !this.matrizTextField[y][0].getText().isEmpty())
			y++;
		double[][] mat = new double[y][x];
		
		for (int i=0; i<y; i++)
			for (int j=0; j<x; j++)
				mat[i][j] = numero(this.matrizTextField[i][j].getText());
		
		return mat;
	}

	@Override
	public void setAreaInfo(String info) {
		this.textArea.setText(info);
	}

}
