package resposiprakpbo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import resposiprakpbo.db.Database;
import resposiprakpbo.model.User;
import resposiprakpbo.view.EmployeeView;
import resposiprakpbo.view.HrdView;
import resposiprakpbo.view.JobseekerView;
import resposiprakpbo.view.LoginView;
import resposiprakpbo.view.SignupView;

public class LoginController implements ActionListener{
    
    LoginView loginView;
    Database database;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.database = new Database();
        
        loginView.btnLogin.addActionListener(this);
        loginView.btnSignup.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(loginView.btnLogin)){
            User user = database.getUser(loginView.getUsername(), loginView.getPassword());
            if(user.getId() == -1 || user.getId() == -2){
                JOptionPane.showMessageDialog(loginView,"Username atau Password salah!","Alert",JOptionPane.WARNING_MESSAGE); 
            }
            else {
                switch (user.getJabatan()){
                    case "Jobseeker":
                        new JobseekerController(user, new JobseekerView());
                        loginView.dispose();
                        break;
                    case "HRD":
                        new HrdController(user, new HrdView());
                        loginView.dispose();
                        break;
                    default:
                        new EmployeeController(user, new EmployeeView());
                        loginView.dispose();
                }
            }
        }
        else if (ae.getSource().equals(loginView.btnSignup)){
            new SignupController(new SignupView());
            loginView.dispose();
        }
    }
    
}
