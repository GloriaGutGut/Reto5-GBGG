package vista;

import java.util.ArrayList;
import controlador.ControladorRequerimientos;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaRequerimientos extends JFrame{

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();
    private JPanel contentPane;
    private static JTextArea textArea;

    public VistaRequerimientos() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,40,700,600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbltitulo = new JLabel("Ciclo2 Reto5");
        lbltitulo.setBounds(28,20,85,15);
        contentPane.add(lbltitulo);

        JLabel lbltitulo2 = new JLabel("por: Gloria B. Gutiérrez G.");
        lbltitulo2.setBounds(28,40,220,15);
        contentPane.add(lbltitulo2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28,70,630,430);
        contentPane.add(scrollPane);
                
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea); 

        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

        JButton btnRequerimiento1 = new JButton("Salarios");
        btnRequerimiento1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento1();
            }
        });
        btnRequerimiento1.setBounds(28,515,120,30);
        contentPane.add(btnRequerimiento1);

        JButton btnRequerimiento2 = new JButton("Proveedores");
        btnRequerimiento2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento2();
            }
        });
        btnRequerimiento2.setBounds(280,515,120,30);
        contentPane.add(btnRequerimiento2);

        JButton btnRequerimiento3 = new JButton("Materiales");
        btnRequerimiento3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento3();
            }
        });
        btnRequerimiento3.setBounds(538,515,120,30);
        contentPane.add(btnRequerimiento3);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(570,30,85,30);
        contentPane.add(btnLimpiar);
    }

    public static void requerimiento1(){
        try {
            ArrayList<Requerimiento_1Vo> resultado_requerimiento1 = controlador.consultarRequerimiento1();
            String salida = "\tListado promedio de salarios de los líderes por ciudad\n\n \tCIUDAD RESIDENCIA\t PROMEDIO SALARIO\n";
            for (Requerimiento_1Vo requerimiento1 : resultado_requerimiento1) {
                //System.out.printf("%s %d %n", requerimiento_1Vo.getCiudadResidencia(), requerimiento_1Vo.getPromedio());
                salida += "\t";
                salida += requerimiento1.getCiudadResidencia();
                salida += "\t\t";
                salida += requerimiento1.getPromedio();
                salida += "\n";
            }
                textArea.setText(salida);
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void requerimiento2() {
        try {
            ArrayList<Requerimiento_2Vo> resultado_requerimiento2 = controlador.consultarRequerimiento2();
            String salida = "\t Listado proveedores para proyectos Neiva\n\n \t\t ID PROYECTO\t PROVEEDOR\n";
            for (Requerimiento_2Vo requerimiento2 : resultado_requerimiento2) {
                salida += "\t\t";
                salida += requerimiento2.getIdProyecto();
                salida += "\t";
                salida += requerimiento2.getProveedor();
                salida += "\n";
                textArea.setText(salida);
            }
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
        }
    }

    public static void requerimiento3() {
        try {
            ArrayList<Requerimiento_3Vo> resultado_requerimiento3 = controlador.consultarRequerimiento3();
            String salida = "\t Listado de Materiales para los proyectos con ID entre 40 y 55\n\n \t\t ID PROYECTO\t NOMBRE MATERIAL\n\n";
            for (Requerimiento_3Vo requerimiento3 : resultado_requerimiento3) {
                salida += "\t\t";
                salida += requerimiento3.getIdProyecto();
                salida += "\t";
                salida += requerimiento3.getNombreMaterial();
                salida += "\n";
                textArea.setText(salida);
            }
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
