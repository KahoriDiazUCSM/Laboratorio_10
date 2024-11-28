package actividad1;

import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.io.File;

public class VentanaMultimedia extends JFrame {
    public VentanaMultimedia() {
        setTitle("Reproductor Multimedia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JButton playButton = new JButton("Reproducir Sonido");
        playButton.addActionListener(e -> reproducirSonido("success.wav"));

        add(playButton, BorderLayout.CENTER);
        setVisible(true);
    }

    private void reproducirSonido(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaMultimedia::new);
    }
}
