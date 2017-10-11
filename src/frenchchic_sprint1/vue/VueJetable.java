package frenchchic_sprint1.vue;

import frenchchic_sprint1.controleur.Session;
import frenchchic_sprint1.metier.Client;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// vue jetable
public class VueJetable extends JFrame implements ActionListener {
    public static Session session = new Session();
    private JLabel lbTitle;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;

    public VueJetable() {
        this.setTitle("French Chic");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 400));
        this.setLocation(200, 200);
        this.placeComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
    }

    public static void main(String[] args) {

        demarrageApplication();
    }

    public static void demarrageApplication() {
        
        session.traiterConnexion();
    }

    private void placeComponents() {
        this.setLayout(null);

        JLabel appTitle = new JLabel("French Chic");
        appTitle.setBounds(300, 10, 360, 25);
        this.add(appTitle);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10, 10, 80, 25);
        this.add(userLabel);

        tfUsername = new JTextField(20);
        tfUsername.setBounds(100, 10, 160, 25);
        this.add(tfUsername);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        this.add(passwordLabel);

        pfPassword = new JPasswordField(20);
        pfPassword.setBounds(100, 40, 160, 25);
        this.add(pfPassword);

        btnLogin = new JButton("S'identifier");
        btnLogin.addActionListener(this);
        btnLogin.setBounds(10, 80, 160, 25);
        this.add(btnLogin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnLogin){
            Session.clientSession = new Client("", "", tfUsername.getText(), String.valueOf(pfPassword.getPassword()));
            System.out.println(Session.clientSession.getPseudo() + " / " + Session.clientSession.getMotDePasse());
            session.traiterIdentificatin(Session.clientSession.getPseudo(), Session.clientSession.getMotDePasse());
        }
    }
}
