package ejemplos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de Binding de Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);

        // Modelo de datos
        Persona persona = new Persona("John Doe", 30, "Masculino");

        // Componentes de interfaz para cada atributo
        JTextField nombreField = new JTextField(persona.getNombre(), 15);
        JTextField edadField = new JTextField(String.valueOf(persona.getEdad()), 15);
        JTextField sexoField = new JTextField(persona.getSexo(), 15);
        JButton button = new JButton("Actualizar Modelo");

        // Listener para actualizar el modelo cuando el botón es presionado
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                persona.setNombre(nombreField.getText());
                try {
                    int edad = Integer.parseInt(edadField.getText());
                    persona.setEdad(edad);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un número válido para la edad.");
                }
                persona.setSexo(sexoField.getText());

                // Mostrar los valores actualizados en consola
                System.out.println("Modelo actualizado:");
                System.out.println("Nombre: " + persona.getNombre());
                System.out.println("Edad: " + persona.getEdad());
                System.out.println("Sexo: " + persona.getSexo());
            }
        });

        // Configuración de layout y adición de componentes
        frame.setLayout(new java.awt.FlowLayout());
        frame.add(new JLabel("Nombre:"));
        frame.add(nombreField);
        frame.add(new JLabel("Edad:"));
        frame.add(edadField);
        frame.add(new JLabel("Sexo:"));
        frame.add(sexoField);
        frame.add(button);

        frame.setVisible(true);
    }
}

// Modelo de datos actualizado con nombre, edad y sexo
class Persona {
    private String nombre;
    private int edad;
    private String sexo;

    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
