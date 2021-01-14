package resposiprakpbo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import resposiprakpbo.db.Database;
import resposiprakpbo.model.Lamaran;
import resposiprakpbo.model.User;
import resposiprakpbo.view.HrdView;
import resposiprakpbo.view.LoginView;

public class HrdController implements ActionListener{
    
    User user;
    HrdView hrdView;
    Database database;
    Lamaran lamaran;

    public HrdController(User user, HrdView hrdView) {
        this.user = user;
        this.hrdView = hrdView;
        this.database = new Database();
        
        hrdView.btnLogout.addActionListener(this);
        hrdView.btnTerima.addActionListener(this);
        hrdView.btnTolak.addActionListener(this);
        hrdView.btnHapus.addActionListener(this);
        hrdView.lUsername.setText(user.getUsername());
        
        hrdView.pelamarTableModel.resetData(database.getListLamaran());
        
        clearView();
        
        hrdView.tblPelamar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                updateView(hrdView.pelamarTableModel.getLamaran(hrdView.tblPelamar.rowAtPoint(me.getPoint())));
                lamaran  = hrdView.pelamarTableModel.getLamaran(hrdView.tblPelamar.rowAtPoint(me.getPoint()));
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(hrdView.btnTerima)){
            lamaran.setStatus("DITERIMA");
            database.updateStatusLamaran(lamaran);
            database.updateJabatanUser(lamaran.getPosisi(), lamaran.getIdUser());
            hrdView.pelamarTableModel.resetData(database.getListLamaran());
            
            updateView(lamaran);
        }
        else if(ae.getSource().equals(hrdView.btnTolak)){
            lamaran.setStatus("DITOLAK");
            database.updateStatusLamaran(lamaran);
            hrdView.pelamarTableModel.resetData(database.getListLamaran());
            
            updateView(lamaran);
        }
        else if(ae.getSource().equals(hrdView.btnHapus)){
            database.deleteLamaran(lamaran);
            hrdView.pelamarTableModel.resetData(database.getListLamaran());
            
            clearView();
        }
        else if(ae.getSource().equals(hrdView.btnLogout)){
            new LoginController(new LoginView());
            hrdView.dispose();
        }
    }
    
    public void updateView(Lamaran lamaran){
        hrdView.lNama.setVisible(true);
        hrdView.lNamaPelamar.setVisible(true);
        hrdView.lJenisKelamin.setVisible(true);
        hrdView.lJenisKelaminPelamar.setVisible(true);
        hrdView.lPendidikan.setVisible(true);
        hrdView.lPendidikanPelamar.setVisible(true);
        hrdView.lPosisi.setVisible(true);
        hrdView.lPosisiPelamar.setVisible(true);
        hrdView.lPengalaman.setVisible(true);
        hrdView.lPengalamanPelamar.setVisible(true);
                
        hrdView.lNamaPelamar.setText(lamaran.getNamaLengkap());
        hrdView.lJenisKelaminPelamar.setText(lamaran.getJenisKelamin());
        hrdView.lPendidikanPelamar.setText(lamaran.getPendidikan());
        hrdView.lPosisiPelamar.setText(lamaran.getPosisi());
        hrdView.lPengalamanPelamar.setText(lamaran.getPengalaman());
        
        if(lamaran.getStatus().isEmpty()){
            hrdView.btnTolak.setVisible(true);
            hrdView.btnTerima.setVisible(true);
            hrdView.btnHapus.setVisible(false);
        }
        else {
            hrdView.btnTolak.setVisible(false);
            hrdView.btnTerima.setVisible(false);
            hrdView.btnHapus.setVisible(true);
        }
    }
    
    public void clearView(){
        hrdView.lNama.setVisible(false);
        hrdView.lNamaPelamar.setVisible(false);
        hrdView.lJenisKelamin.setVisible(false);
        hrdView.lJenisKelaminPelamar.setVisible(false);
        hrdView.lPendidikan.setVisible(false);
        hrdView.lPendidikanPelamar.setVisible(false);
        hrdView.lPosisi.setVisible(false);
        hrdView.lPosisiPelamar.setVisible(false);
        hrdView.lPengalaman.setVisible(false);
        hrdView.lPengalamanPelamar.setVisible(false);
        hrdView.btnTerima.setVisible(false);
        hrdView.btnTolak.setVisible(false);
        hrdView.btnHapus.setVisible(false);
    }
    
}
