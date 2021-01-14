package resposiprakpbo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import resposiprakpbo.ResposiPrakPBO;

public class LoginView extends JFrame{
    
    public JPanel northPanel, southPanel, centerPanel;
    public JLabel lTitle, lUsername, lPassword, lAuthor, lSignup;
    public JTextField tfUsername;
    public JPasswordField pfPassword;
    public JButton btnLogin, btnSignup;

    public LoginView() {
        super(ResposiPrakPBO.WINDOW_TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1100, 700);
        this.setLayout(null);

        init();
        Container loginContainer = this.getContentPane();
        loginContainer.setLayout(new BorderLayout(10, 10));
        
        loginContainer.add(northPanel, BorderLayout.NORTH);
        loginContainer.add(centerPanel, BorderLayout.CENTER);
        loginContainer.add(southPanel, BorderLayout.SOUTH);
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void init() {
        northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lTitle = new JLabel("LOGIN");
        lTitle.setFont(new Font("SansSerif", Font.BOLD, 32));
        lTitle.setBorder(null);
        lTitle.setOpaque(false);
//        northPanel.setBackground(Color.yellow);
        northPanel.add(lTitle, FlowLayout.LEFT);
        
        
        southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lAuthor = new JLabel("Created by Thalib Abu Qitaal     ");
        lAuthor.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lAuthor.setBorder(null);
        lAuthor.setOpaque(false);
        southPanel.setBackground(Color.WHITE);
        southPanel.add(lAuthor, FlowLayout.LEFT);
        
        
        centerPanel = new JPanel(null);
//        centerPanel.setBackground(Color.CYAN);
        lUsername = new JLabel("Username");
        tfUsername = new JTextField(30);
        lPassword = new JLabel("Password");
        pfPassword = new JPasswordField(30);
        btnLogin = new JButton("LOGIN");
        lSignup = new JLabel("Belum punya akun? klik Sign up");
        btnSignup = new JButton("SIGN UP");
        
        lUsername.setFont(new Font("SansSerif", Font.PLAIN, 24));
        lPassword.setFont(new Font("SansSerif", Font.PLAIN, 24));
        lSignup.setFont(new Font("SansSerif", Font.PLAIN, 18));
        
        lUsername.setBounds(350, 80, 300, 30);
        tfUsername.setBounds(350, 120, 400, 30);
        lPassword.setBounds(350, 180, 300, 30);
        pfPassword.setBounds(350, 220, 400, 30);
        btnLogin.setBounds(500, 300, 100, 30);
        lSignup.setBounds(420, 370, 350, 30);
        btnSignup.setBounds(500, 410, 100, 30);
        
        centerPanel.add(lUsername);
        centerPanel.add(tfUsername);
        centerPanel.add(lPassword);
        centerPanel.add(pfPassword);
        centerPanel.add(btnLogin);
        centerPanel.add(lSignup);
        centerPanel.add(btnSignup);
    }

    public String getUsername() {
        return tfUsername.getText().trim();
    }

    public String getPassword() {
        return pfPassword.getText().trim();
    }
}