package resposiprakpbo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import resposiprakpbo.db.Database;
import resposiprakpbo.model.Lamaran;
import resposiprakpbo.model.User;
import resposiprakpbo.view.JobseekerView;
import resposiprakpbo.view.LoginView;

public class JobseekerController implements ActionListener{
    
    User user;
    JobseekerView jobseekerView;
    Database database;

    public JobseekerController(User user, JobseekerView jobseekerView) {
        this.user = user;
        this.jobseekerView = jobseekerView;
        this.database = new Database();
        
        jobseekerView.btnSubmit.addActionListener(this);
        jobseekerView.btnLogout.addActionListener(this);
        jobseekerView.lUsername.setText(user.getUsername());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(jobseekerView.btnSubmit)){
            if(jobseekerView.getNama().isEmpty() || jobseekerView.getPendidikan().isEmpty() || jobseekerView.getPengalaman().isEmpty()){
                JOptionPane.showMessageDialog(jobseekerView,"Mohon ini dengan lengkap!","Alert",JOptionPane.WARNING_MESSAGE); 
            }
            else if(database.insertLamaran(new Lamaran(0, user.getId(), jobseekerView.getNama(), jobseekerView.getJenisKelamin(), jobseekerView.getPendidikan(), jobseekerView.getPosisi(), jobseekerView.getPengalaman(), "")) != 0){
                JOptionPane.showMessageDialog(jobseekerView,"Lamaran BERHASIL dikirim!","Alert",JOptionPane.INFORMATION_MESSAGE);
                clearView();
            }
            else {
                JOptionPane.showMessageDialog(jobseekerView,"Lamaran GAGAL dikirim!","Alert",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(ae.getSource().equals(jobseekerView.btnLogout)){
            new LoginController(new LoginView());
            jobseekerView.dispose();
        }
    }
    
    public void clearView(){
        jobseekerView.tfNama.setText("");
        jobseekerView.cbJenisKelamin.setSelectedIndex(0);
        jobseekerView.tfPendidikan.setText("");
        jobseekerView.cbPosisi.setSelectedIndex(0);
        jobseekerView.taPengalaman.setText("");
    }
}
