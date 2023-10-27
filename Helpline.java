import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Helpline {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Helpline Integration");
            frame.setSize(300, 100);

            JPanel panel = new JPanel();
            frame.add(panel);

            JLabel HelplineNo = new JLabel("1800 180 1551");
            JButton callButton = new JButton("Call Helpline");
            panel.add(callButton);
            panel.add(HelplineNo);
            panel.add(new JLabel("Kisan Call Centre"));

            callButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String phoneNumber = "tel:18001801551";

                    try {
                        Desktop.getDesktop().browse(new URI(phoneNumber));
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Dev Mode: Unable to initiate the call because " + ex.getMessage());
                    }
                }
            });
            frame.setVisible(true);
        });
    }
}
