// Demostracion de la clase JTextField
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class CampoTextoMarco extends JFrame {
    private JTextField campoTexto1; 
    private JTextField campoTexto2; 
    private JTextField campoTexto3;
    private JPasswordField campoContrasenia;

    // El constructor de CampoTextoMarco agrega objetos JTextField a JFrame
    public CampoTextoMarco() {
        super("Prueba de JTextField y JPasswordField");
        setLayout(new FlowLayout());

        // Construye campo de texto con 10 columnas
        campoTexto1 = new JTextField(10);
        add(campoTexto1); 

        // Construye campo de texto con texto predeterminado
        campoTexto2 = new JTextField("Escriba el texto aqui");
        add(campoTexto2);

        // Construye campo de texto con texto predeterminado y 21 columnas
        campoTexto3 = new JTextField("Campo de texto no editable", 21);
        campoTexto3.setEditable(false); 
        add(campoTexto3); 

        // Construye campo de contrasena con texto predeterminado
        campoContrasenia = new JPasswordField("Texto oculto");
        add(campoContrasenia);

        // Registra los manejadores de eventos[cite: 7]
        ManejadorCampoTexto manejador = new ManejadorCampoTexto();
        campoTexto1.addActionListener(manejador);
        campoTexto2.addActionListener(manejador);
        campoTexto3.addActionListener(manejador);
        campoContrasenia.addActionListener(manejador);
    }

    // Clase interna privada para el manejo de eventos
    private class ManejadorCampoTexto implements ActionListener {
        // Procesa los eventos de campo de texto
        @Override
        public void actionPerformed(ActionEvent evento) {
            String cadena = "";

            // El usuario oprimio Intro en el objeto JTextField campoTexto1
            if (evento.getSource() == campoTexto1) {
                cadena = String.format("campoTexto1: %s", evento.getActionCommand());
            }
            // El usuario oprimio Intro en el objeto JTextField campoTexto2
            else if (evento.getSource() == campoTexto2) {
                cadena = String.format("campoTexto2: %s", evento.getActionCommand());
            }
            // El usuario oprimio Intro en el objeto JTextField campoTexto3
            else if (evento.getSource() == campoTexto3) {
                cadena = String.format("campoTexto3: %s", evento.getActionCommand());
            }
            // El usuario oprimio Intro en el objeto JPasswordField campoContrasenia
            else if (evento.getSource() == campoContrasenia) {
                cadena = String.format("campoContrasenia: %s",
                        new String(campoContrasenia.getPassword()));
            }

            // Muestra el contenido del objeto JTextField
            JOptionPane.showMessageDialog(null, cadena);
        } 
    } 
} 
