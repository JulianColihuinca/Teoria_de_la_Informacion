package front.views;

import front.views.interfaces.IVistaGeneral;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaGeneral extends JFrame implements IVistaGeneral {
    private JPanel contentPane;
    private JButton codificacionesButton = new JButton("Codificaciones");
    private JButton canalesButton = new JButton("Canales");
    private ActionListener actionListener;


    public VistaGeneral() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        this.setMinimumSize(new Dimension(300,300));
        this.setTitle("");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout());

        codificacionesButton.setActionCommand(CODIFICACIONES);
        canalesButton.setActionCommand(CANALES);
        contentPane.add(codificacionesButton);
        contentPane.add(canalesButton);


    }

    public void abrir() {
        setVisible(true);
    }

    public void setControlador(ActionListener actionListener) {
        codificacionesButton.addActionListener(actionListener);
        canalesButton.addActionListener(actionListener);
        this.actionListener = actionListener;
    }
}
