package frenchchic_sprint1.vue;

import frenchchic_sprint1.controleur.Session;
import frenchchic_sprint1.metier.Client;
import java.awt.Color;
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
        setWindow();
    }

    public static void main(String[] args) {
        demarrageApplication();
    }

    public static void demarrageApplication() {

        Session.traiterConnexion();
    }

    private void setWindow() {
        this.setTitle("French Chic | Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(550, 400));
        this.placeComponents();
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void placeComponents() {
        this.setLayout(null);

        lbTitle = new JLabel("<html><span style='font-weight: lighter; font-family: \"MS Sans Serif\"; font-size: 40px; color: #CC00CC;'>French Chic</span></html>", (int) CENTER_ALIGNMENT);
        lbTitle.setBounds(0, 0, 500, 150);
        this.add(lbTitle);

        lbUsername = new JLabel("Pseudo");
        lbUsername.setBounds(155, 150, 80, 30);
        this.add(lbUsername);

        tfUsername = new JTextField(20);
        tfUsername.setBounds(250, 150, 160, 30);
        this.add(tfUsername);

        lbPassword = new JLabel("Password");
        lbPassword.setBounds(150, 190, 80, 30);
        this.add(lbPassword);

        pfPassword = new JPasswordField(20);
        pfPassword.setBounds(250, 190, 160, 30);
        this.add(pfPassword);

        btnLogin = new JButton("S'identifier");
        btnLogin.setBackground(Color.lightGray);
        btnLogin.setBorder(null);
        btnLogin.addActionListener(this);
        btnLogin.setBounds(200, 280, 160, 30);
        this.add(btnLogin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            Session.clientSession = new Client("", "", tfUsername.getText(), String.valueOf(pfPassword.getPassword()));
            session.traiterIdentificatin(Session.clientSession.getPseudo(), Session.clientSession.getMotDePasse());
        }
    }
}
