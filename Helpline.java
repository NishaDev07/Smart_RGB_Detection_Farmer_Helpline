import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Helpline implements ActionListener {

     JButton callButton = new JButton("Call Helpline");
     JButton portalButton = new JButton("Farmer Portal");
     JButton scheButton = new JButton("Programmes and Schemes");
     JButton guiButton = new JButton("Guidelines");
     JFrame frame = new JFrame("Helpline & Guidelines Integration");
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Helpline H = new Helpline();

            H.frame.setSize(300, 300);

            JPanel panel = new JPanel();
            H.frame.add(panel);

            panel.add(H.callButton);
            JLabel HelplineNo = new JLabel("1800 180 1551");
            panel.add(HelplineNo);
            panel.add(new JLabel("Kisan Call Centre"));
            panel.add(new JLabel("Farmer Programmes and Schemes"));
            
            H.callButton.addActionListener(H);
            H.portalButton.addActionListener(H);
            H.scheButton.addActionListener(H);
            H.guiButton.addActionListener(H);
            
            panel.add(H.portalButton);
            panel.add(H.scheButton);
            panel.add(H.guiButton);            
            H.frame.setVisible(true);
        });
    }

    @Override
        public void actionPerformed(ActionEvent e) {
            String phoneNumber = "tel:18001801551";
            String farmerPortal = "https://www.farmer.gov.in/";
            String progandSchemes = "https://agricoop.gov.in/en/FarmWelfare";
            String guidelines = "https://agricoop.gov.in/en/Guide";
            String To_Be_Executed = "";

            if(e.getSource()== callButton){
                To_Be_Executed = phoneNumber;
            }else if(e.getSource() == portalButton){
                To_Be_Executed = farmerPortal;
            }else if(e.getSource() == scheButton){
                To_Be_Executed = progandSchemes;
            }else if(e.getSource() == guiButton){
                To_Be_Executed = guidelines;
            }else{
            }

            try {
                Desktop.getDesktop().browse(new URI(To_Be_Executed));
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Unable to initiate request to third party browser because: "+ ex.getMessage());
            }
        }

}
