package resposiprakpbo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import resposiprakpbo.ResposiPrakPBO;

public class JobseekerView extends JFrame{
    
    public JPanel northPanel, southPanel, centerPanel;
    public JLabel lTitle, lAuthor, lJabatan, lUsername, lPerintah, lNama, lJenisKelamin, lPendidikan, lPosisi, lPengalaman;
    public JTextField tfNama, tfPendidikan;
    public JComboBox cbJenisKelamin, cbPosisi;
    public JTextArea taPengalaman;
    public JButton btnSubmit, btnLogout;
    public final String[] JENIS_KELAMIN = {"Laki-laki", "Perempuan"};
    public final String[] LIST_POSISI = {"Web Developer", "Mobile Developer", "Cloud Engineer", "Design Product", "Operator"};

    public JobseekerView() {
        super(ResposiPrakPBO.WINDOW_TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1100, 700);
        this.setLayout(null);

        init();
        Container jobseekerContainer = this.getContentPane();
        jobseekerContainer.setLayout(new BorderLayout(10, 10));
        
        jobseekerContainer.add(northPanel, BorderLayout.NORTH);
        jobseekerContainer.add(centerPanel, BorderLayout.CENTER);
        jobseekerContainer.add(southPanel, BorderLayout.SOUTH);
        
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
        lUsername = new JLabel("Thalib Abu Qitaal");
        lJabatan = new JLabel("Jobseeker");
        lPerintah = new JLabel("Silahkan mendaftar kerja sesuai dengan posisi yang tersedia");
        lNama = new JLabel("Nama");
        tfNama = new JTextField(30);
        lJenisKelamin = new JLabel("Jenis Kelamin");
        cbJenisKelamin = new JComboBox(JENIS_KELAMIN);
        lPendidikan = new JLabel("Pendidikan Terakhir");
        tfPendidikan = new JTextField(100);
        lPosisi = new JLabel("Posisi yang dilamar");
        cbPosisi = new JComboBox(LIST_POSISI);
        lPengalaman = new JLabel("Pengalaman");
        taPengalaman = new JTextArea(10, 400);
        btnSubmit = new JButton("SUBMIT");
        btnLogout = new JButton("LOGOUT");
        
        Font labelFont = new Font("SansSerif", Font.PLAIN, 24);
        lUsername.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lJabatan.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lPerintah.setFont(labelFont);
        lNama.setFont(labelFont);
        lJenisKelamin.setFont(labelFont);
        lPendidikan.setFont(labelFont);
        lPosisi.setFont(labelFont);
        lPengalaman.setFont(labelFont);
        taPengalaman.setLineWrap(true);
        cbJenisKelamin.setBackground(Color.WHITE);
        cbPosisi.setBackground(Color.WHITE);
        
        lUsername.setBounds(910, 0, 150, 30);
        lJabatan.setBounds(910, 20, 150, 30);
        lPerintah.setBounds(210, 90, 800, 30);
        lNama.setBounds(100, 160, 300, 30);
        tfNama.setBounds(100, 200, 400, 30);
        lJenisKelamin.setBounds(100, 260, 300, 30);
        cbJenisKelamin.setBounds(100, 300, 400, 30);
        lPendidikan.setBounds(100, 360, 300, 30);
        tfPendidikan.setBounds(100, 400, 400, 30);
        lPosisi.setBounds(600, 160, 300, 30);
        cbPosisi.setBounds(600, 200, 400, 30);
        lPengalaman.setBounds(600, 260, 300, 30);
        taPengalaman.setBounds(600, 300, 400, 130);
        btnSubmit.setBounds(500, 470, 100, 30);
        btnLogout.setBounds(30, 0, 100, 30);
        
        centerPanel.add(lUsername);
        centerPanel.add(lJabatan);
        centerPanel.add(lPerintah);
        centerPanel.add(lNama);
        centerPanel.add(tfNama);
        centerPanel.add(lJenisKelamin);
        centerPanel.add(cbJenisKelamin);
        centerPanel.add(lPendidikan);
        centerPanel.add(tfPendidikan);
        centerPanel.add(lPosisi);
        centerPanel.add(cbPosisi);
        centerPanel.add(lPengalaman);
        centerPanel.add(taPengalaman);
        centerPanel.add(btnSubmit);
        centerPanel.add(btnLogout);
    }

    public String getNama() {
        return tfNama.getText().toString().trim();
    }

    public String getPendidikan() {
        return tfPendidikan.getText().toString().trim();
    }

    public String getJenisKelamin() {
        return JENIS_KELAMIN[cbJenisKelamin.getSelectedIndex()];
    }

    public String getPosisi() {
        return LIST_POSISI[cbPosisi.getSelectedIndex()];
    }

    public String getPengalaman() {
        return taPengalaman.getText().toString().trim();
    }
    
}
