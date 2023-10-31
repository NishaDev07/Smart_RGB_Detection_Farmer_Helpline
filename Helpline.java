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
     JLabel Label1 = new JLabel("Call Kisan Helpline");
     JLabel Label2 = new JLabel("Extended Support");
     JFrame frame = new JFrame("Helpline & Guidelines Integration");
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Helpline H = new Helpline();
            
            Color basecolor  = new Color(87,81, 150);
            Color fontColor = new Color(147,140,228);

            H.frame.getContentPane().setBackground(basecolor);
            H.callButton.setBackground(Color.white);
            H.portalButton.setBackground(Color.white);
            H.scheButton.setBackground(Color.white);
            H.guiButton.setBackground(Color.white);

            H.callButton.setForeground(fontColor);
            H.portalButton.setForeground(fontColor);
            H.scheButton.setForeground(fontColor);
            H.guiButton.setForeground(fontColor);
            H.Label1.setForeground(Color.white);
            H.Label2.setForeground(Color.white);

            H.frame.setSize(300, 500);
            
            H.Label1.setFont(new Font("Roboto",Font.PLAIN,18));
            H.Label2.setFont(new Font("Roboto",Font.PLAIN,18));
            H.Label1.setBounds(60, 10, 200, 50);
            H.Label2.setBounds(60,160,200,50);
            H.callButton.setBounds(40,70,200,50);
            H.portalButton.setBounds(40,220,200,50);
            H.scheButton.setBounds(40,280,200,50);
            H.guiButton.setBounds(40,340,200,50);

        

            H.frame.add(H.Label1);
            H.frame.add(H.Label2);
            H.frame.add(H.callButton);
            H.frame.add(H.portalButton);
            H.frame.add(H.scheButton);
            H.frame.add(H.guiButton);
           
            
            H.callButton.addActionListener(H);
            H.portalButton.addActionListener(H);
            H.scheButton.addActionListener(H);
            H.guiButton.addActionListener(H);

            H.frame.add(H.callButton);
            
            H.frame.setLayout(null);
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
