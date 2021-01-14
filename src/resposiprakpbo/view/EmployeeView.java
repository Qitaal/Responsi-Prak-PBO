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
import resposiprakpbo.ResposiPrakPBO;

public class EmployeeView extends JFrame{
    
    public JPanel northPanel, southPanel, centerPanel;
    public JLabel lTitle, lAuthor, lJabatan, lUsername, lInformation;
    public JButton btnLogout;
    
    public EmployeeView() {
        super(ResposiPrakPBO.WINDOW_TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1100, 700);
        this.setLayout(null);

        init();
        Container employeeContainer = this.getContentPane();
        employeeContainer.setLayout(new BorderLayout(10, 10));
        
        employeeContainer.add(northPanel, BorderLayout.NORTH);
        employeeContainer.add(centerPanel, BorderLayout.CENTER);
        employeeContainer.add(southPanel, BorderLayout.SOUTH);
        
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
        lInformation = new JLabel("Anda adalah Karyawan PT. MAJU MUNDUR");
        btnLogout = new JButton("LOGOUT");
        
        lUsername.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lJabatan.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lInformation.setFont(new Font("SansSerif", Font.PLAIN, 24));
        
        lUsername.setBounds(910, 0, 150, 30);
        lJabatan.setBounds(910, 20, 150, 30);
        lInformation.setBounds(300, 200, 800, 30);
        btnLogout.setBounds(30, 0, 100, 30);
        
        centerPanel.add(lUsername);
        centerPanel.add(lJabatan);
        centerPanel.add(lInformation);
        centerPanel.add(btnLogout);
    }
}