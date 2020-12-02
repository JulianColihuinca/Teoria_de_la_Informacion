package front.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import front.views.interfaces.IVistaCodificaciones;

public class VistaCodificaciones extends JFrame implements IVistaCodificaciones{

	private static final long serialVersionUID = 5039098172923390597L;
	private JPanel panelGeneral;
	@SuppressWarnings("unused")
	private ActionListener aL;
	private JScrollPane scrollPane;
	private JTextArea areaTextoACodificar;
	private JScrollPane scrollPane_2;
	private JTextArea areaInfo;
	private JPanel panelBotones;
	private JButton btnCodificarHuffman;
	private JButton btnCodificarShannonFano;
	private JButton btnCodificarRLC;

	public VistaCodificaciones() {
		setTitle("Codificaciones");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		panelGeneral = new JPanel();
		panelGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelGeneral);
		panelGeneral.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBorder(new TitledBorder(null, "Ingrese el texto a codificar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGeneral.add(panelSuperior);
		panelSuperior.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panelSuperior.add(scrollPane, BorderLayout.CENTER);
		
		areaTextoACodificar = new JTextArea();
		areaTextoACodificar.setLineWrap(true);
		scrollPane.setViewportView(areaTextoACodificar);
		
		JPanel panelCentral = new JPanel();
		panelGeneral.add(panelCentral);
		panelCentral.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelDeDatos = new JPanel();
		panelDeDatos.setBorder(new TitledBorder(null, "Datos de la codificacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCentral.add(panelDeDatos);
		panelDeDatos.setLayout(new BorderLayout(0, 0));
		
		scrollPane_2 = new JScrollPane();
		panelDeDatos.add(scrollPane_2, BorderLayout.CENTER);
		
		areaInfo = new JTextArea();
		areaInfo.setLineWrap(true);
		scrollPane_2.setViewportView(areaInfo);
		
		panelBotones = new JPanel();
		panelCentral.add(panelBotones);
		panelBotones.setLayout(new GridLayout(3, 1, 0, 0));
		
		btnCodificarHuffman = new JButton("Codificar Huffman");
		btnCodificarHuffman.setActionCommand("Codificar Huffman");
		panelBotones.add(btnCodificarHuffman);
		
		btnCodificarShannonFano = new JButton("Codificar Shannon-Fano");
		btnCodificarShannonFano.setActionCommand("Codificar Shannon-Fano");
		panelBotones.add(btnCodificarShannonFano);
		
		btnCodificarRLC = new JButton("Codificar RLC");
		btnCodificarRLC.setActionCommand("Codificar RLC");
		panelBotones.add(btnCodificarRLC);
		
		
		
	}

	@Override
	public void setActionlistener(ActionListener controlador) {
		this.btnCodificarHuffman.addActionListener(controlador);
		this.btnCodificarShannonFano.addActionListener(controlador);
		this.btnCodificarRLC.addActionListener(controlador);
		this.aL=controlador;
	}

	@Override
	public void setAreaInfo(String info) {
		this.areaInfo.setText(info);
	}

	@Override
	public String getTextoACodificar() {
		return this.areaTextoACodificar.getText();
	}
	
	@Override
    public void abrir() {
        setVisible(true);
    }

}
