package resposiprakpbo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import resposiprakpbo.db.Database;
import resposiprakpbo.model.User;
import resposiprakpbo.view.LoginView;
import resposiprakpbo.view.SignupView;

public class SignupController implements ActionListener{

    SignupView signupView;
    Database database;
    
    public SignupController(SignupView signupView) {
        this.signupView = signupView;
        this.database = new Database();
        
        signupView.btnSignup.addActionListener(this);
        signupView.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(signupView.btnSignup)){
            if(signupView.getNama().isEmpty() || signupView.getUsername().isEmpty() || signupView.getPassword().isEmpty()){
                JOptionPane.showMessageDialog(signupView,"Mohon ini dengan lengkap!","Alert",JOptionPane.WARNING_MESSAGE); 
            }
            else if(database.insertUser(new User(0, signupView.getNama(), signupView.getUsername(), signupView.getPassword(), signupView.getPosisi())) != 0){
                JOptionPane.showMessageDialog(signupView,"Signup BERHASIL!","Alert",JOptionPane.INFORMATION_MESSAGE);
                new LoginController(new LoginView());
                signupView.dispose();
            } 
            else {
                JOptionPane.showMessageDialog(signupView,"Signup GAGAL!","Alert",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(ae.getSource().equals(signupView.btnLogin)){
            new LoginController(new LoginView());
            signupView.dispose();
        }
    }
    
}
