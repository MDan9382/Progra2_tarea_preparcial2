package uni.prog2;

import uni.prog2.Model.ModelDatos;
import uni.prog2.Service.SeriviceDatos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formulario {
    private JPanel formulario;
    private JLabel lbej1;
    private JPanel pnlej1;
    private JPanel pnlusuarios;
    private JLabel lblUsuarios;
    private JLabel lblp1Codigo;
    private JTextField textFieldp1Codigo;
    private JLabel lblp1Nombre;
    private JLabel lblp1Apellido;
    private JLabel lblp1Departamento;
    private JLabel lblp1FechaNacimento;
    private JTextField textFieldp1Nombre;
    private JTextField textFieldp1Apellido;
    private JTextField textFieldp1Departamento;
    private JButton buttonp1Insertar;
    private JButton buttonp1Actualizar;
    private JButton buttonp1Borrar;
    private JButton buttonp1Buscar;

    public formulario() {
        buttonp1Insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ModelDatos datos = new ModelDatos();
                datos.setNombre(textFieldp1Nombre.getText());
                datos.setApellido(textFieldp1Apellido.getText());
                datos.setDepartamento(textFieldp1Departamento.getText());

                try {
                    SeriviceDatos seriviceDatos = new SeriviceDatos();
                    seriviceDatos.addDatos(datos);
                    JOptionPane.showMessageDialog(formulario, "Datos guardado exitosamente");
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(formulario, ex.getMessage());
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("formulario");
        frame.setContentPane(new formulario().formulario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


