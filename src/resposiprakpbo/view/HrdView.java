package resposiprakpbo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import resposiprakpbo.ResposiPrakPBO;
import resposiprakpbo.model.PelamarTableModel;

public class HrdView extends JFrame{

    public JPanel northPanel, southPanel, centerPanel, tablePanel;
    public JLabel lTitle, lAuthor, lUsername, lJabatan, lNama, lNamaPelamar, lJenisKelamin, lJenisKelaminPelamar, lPendidikan, lPendidikanPelamar, lPosisi, lPosisiPelamar, lPengalaman, lPengalamanPelamar;
    public JButton btnTerima, btnTolak, btnLogout, btnHapus;
    public JTable tblPelamar;
    public PelamarTableModel pelamarTableModel;
    
    public HrdView() {
        super(ResposiPrakPBO.WINDOW_TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1100, 700);
        this.setLayout(null);
        
        pelamarTableModel = new PelamarTableModel();

        init();
        Container hrdContainer = this.getContentPane();
        hrdContainer.setLayout(new BorderLayout(10, 10));
        
        hrdContainer.add(northPanel, BorderLayout.NORTH);
        hrdContainer.add(centerPanel, BorderLayout.CENTER);
        hrdContainer.add(southPanel, BorderLayout.SOUTH);
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void init() {
        northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lTitle = new JLabel("PT. MAJU MUNDUR");
        lTitle.setFont(new Font("SansSerif", Font.BOLD, 32));
        lTitle.setBorder(null);
        lTitle.setOpaque(false);
        northPanel.add(lTitle, FlowLayout.LEFT);
        
        southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lAuthor = new JLabel("Created by Thalib Abu Qitaal     ");
        lAuthor.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lAuthor.setBorder(null);
        lAuthor.setOpaque(false);
        southPanel.setBackground(Color.WHITE);
        southPanel.add(lAuthor, FlowLayout.LEFT);
        
        
        centerPanel = new JPanel(null);
        tablePanel = new JPanel(new BorderLayout());
        lUsername = new JLabel();
        lJabatan = new JLabel("HRD");
        lNama = new JLabel("Nama Lengkap");
        lNamaPelamar = new JLabel();
        lJenisKelamin = new JLabel("Jenis Kelamin");
        lJenisKelaminPelamar = new JLabel();
        lPendidikan = new JLabel("Pendidikan Terakhir");
        lPendidikanPelamar = new JLabel();
        lPosisi = new JLabel("Posisi");
        lPosisiPelamar = new JLabel();
        lPengalaman = new JLabel("Pengalaman Bekerja");
        lPengalamanPelamar = new JLabel();
        btnTerima = new JButton("TERIMA");
        btnTolak = new JButton("TOLAK");
        btnLogout = new JButton("LOGOUT");
        btnHapus = new JButton("HAPUS");
        tblPelamar = new JTable(pelamarTableModel);
        
        Font labelFont = new Font("SansSerif", Font.PLAIN, 16);
        Font dataFont = new Font("SansSerif", Font.PLAIN, 20);
        lUsername.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lJabatan.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lNama.setFont(labelFont);
        lJenisKelamin.setFont(labelFont);
        lPendidikan.setFont(labelFont);
        lPosisi.setFont(labelFont);
        lPengalaman.setFont(labelFont);
        lNamaPelamar.setFont(dataFont);
        lJenisKelaminPelamar.setFont(dataFont);
        lPendidikanPelamar.setFont(dataFont);
        lPosisiPelamar.setFont(dataFont);
        lPengalamanPelamar.setFont(dataFont);
        btnHapus.setVisible(false);
        tablePanel.add(tblPelamar, BorderLayout.CENTER);
        tablePanel.add(tblPelamar.getTableHeader(), BorderLayout.NORTH);
        tablePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        
        lUsername.setBounds(910, 0, 150, 30);
        lJabatan.setBounds(910, 20, 150, 30);
        lNama.setBounds(90, 50, 200, 30);
        lNamaPelamar.setBounds(90, 80, 200, 30);
        lJenisKelamin.setBounds(90, 130, 200, 30);
        lJenisKelaminPelamar.setBounds(90, 160, 200, 30);
        lPendidikan.setBounds(90, 210, 200, 30);
        lPendidikanPelamar.setBounds(90, 240, 200, 30);
        lPosisi.setBounds(90, 290, 200, 30);
        lPosisiPelamar.setBounds(90, 320, 200, 30);
        lPengalaman.setBounds(90, 370, 200, 30);
        lPengalamanPelamar.setBounds(90, 400, 200, 30);
        btnTerima.setBounds(90, 480, 100, 30);
        btnTolak.setBounds(210, 480, 100, 30);
        btnHapus.setBounds(90, 480, 100, 30);
        tablePanel.setBounds(380, 60, 650, 450);
        tblPelamar.setBounds(0, 60, 650, 450);
        btnLogout.setBounds(30, 0, 100, 30);
        
        centerPanel.add(lUsername);
        centerPanel.add(lJabatan);
        centerPanel.add(lNama);
        centerPanel.add(lNamaPelamar);
        centerPanel.add(lJenisKelamin);
        centerPanel.add(lJenisKelaminPelamar);
        centerPanel.add(lPendidikan);
        centerPanel.add(lPendidikanPelamar);
        centerPanel.add(lPosisi);
        centerPanel.add(lPosisiPelamar);
        centerPanel.add(lPengalaman);
        centerPanel.add(lPengalamanPelamar);
        centerPanel.add(btnTolak);
        centerPanel.add(btnTerima);
        centerPanel.add(tablePanel);
        centerPanel.add(btnLogout);
        centerPanel.add(btnHapus);
    }
    
}
