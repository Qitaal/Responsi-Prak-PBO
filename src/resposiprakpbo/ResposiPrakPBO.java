package resposiprakpbo;

import resposiprakpbo.controller.LoginController;
import resposiprakpbo.db.ConnectionHelper;
import resposiprakpbo.view.EmployeeView;
import resposiprakpbo.view.HrdView;
import resposiprakpbo.view.JobseekerView;
import resposiprakpbo.view.LoginView;
import resposiprakpbo.view.SignupView;

public class ResposiPrakPBO {
    
    public static final String WINDOW_TITLE = "RESPONSI PRAKTIKUM PBO | PT MAJU MUNDUR";
    
    public static void main(String[] args) {
        new LoginController(new LoginView());
    }
}