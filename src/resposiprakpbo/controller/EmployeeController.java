package resposiprakpbo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import resposiprakpbo.db.Database;
import resposiprakpbo.model.User;
import resposiprakpbo.view.EmployeeView;
import resposiprakpbo.view.LoginView;

public class EmployeeController implements ActionListener{
    
    User user;
    EmployeeView employeeView;
    Database database;

    public EmployeeController(User user, EmployeeView employeeView) {
        this.user = user;
        this.employeeView = employeeView;
        this.database = new Database();
        
        employeeView.lUsername.setText(user.getUsername());
        employeeView.lInformation.setText("Anda adalah " + user.getJabatan() + " PT.MAJU MUNDUR");
        employeeView.btnLogout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(employeeView.btnLogout)){
            new LoginController(new LoginView());
            employeeView.dispose();
        }
    }
}
