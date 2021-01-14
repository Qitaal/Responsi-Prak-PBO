package resposiprakpbo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import resposiprakpbo.model.Lamaran;
import resposiprakpbo.model.User;

public class Database {
    private Connection connection;
    
    public final String COLUMN_ID = "id";
    public final String COLUMN_NAMA = "nama_lengkap";
    public final String COLUMN_USERNAME = "username";
    public final String COLUMN_PASSWORD = "password";
    public final String COLUMN_JABATAN = "jabatan";
    
    public final String COLUMN_ID_USER = "id_user";
    public final String COLUMN_JENIS_KELAMIN = "jenis_kelamin";
    public final String COLUMN_PENDIDIKAN = "pendidikan_terakhir";
    public final String COLUMN_POSISI = "posisi";
    public final String COLUMN_PENGALAMAN = "pengalaman";
    public final String COLUMN_STATUS = "status";
    

    public Database() {
        this.connection = ConnectionHelper.getInstance();
    }
    
    public User getUser(String username, String password){
        User user = new User();
        String query = "SELECT * FROM user WHERE " + COLUMN_USERNAME + " = '" + username + "' AND " + COLUMN_PASSWORD + " = '" + password + "'";
        
        try {
            user.setId(-2);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                user.setId(resultSet.getInt(COLUMN_ID));
                user.setUsername(username);
                user.setPassword(password);
                user.setNamaLengkap(resultSet.getString(COLUMN_NAMA));
                user.setJabatan(resultSet.getString(COLUMN_JABATAN));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            user.setId(-1);
        }
        return user;
    }

    public int insertUser(User user) {
        String query = "INSERT INTO user (" + COLUMN_NAMA + ", " + COLUMN_USERNAME + ", " + COLUMN_PASSWORD + ", "+ COLUMN_JABATAN + ") VALUES('" + user.getNamaLengkap() + "', '" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getJabatan() + "')";
        
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int insertLamaran(Lamaran lamaran) {
        String query = "INSERT INTO lamaran (" + COLUMN_ID_USER + ", " + COLUMN_NAMA + ", " + COLUMN_JENIS_KELAMIN + ", " + COLUMN_PENDIDIKAN + ", " + COLUMN_POSISI + ", " + COLUMN_PENGALAMAN + ", " + COLUMN_STATUS + ") VALUES('" + lamaran.getIdUser() + "', '" + lamaran.getNamaLengkap() + "', '" + lamaran.getJenisKelamin() + "', '" + lamaran.getPendidikan() + "', '" + lamaran.getPosisi() + "', '" + lamaran.getPengalaman() + "', '" + lamaran.getStatus() + "')";
        
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int deleteLamaran(Lamaran lamaran){
        String query = "DELETE FROM lamaran WHERE " + COLUMN_ID + " = " + lamaran.getId();
        
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int updateStatusLamaran(Lamaran lamaran){
        String query = "UPDATE lamaran SET " + COLUMN_STATUS + " = '" + lamaran.getStatus() + "' WHERE " + COLUMN_ID + " = " + lamaran.getId();
        
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int updateJabatanUser(String jabatan, int id){
        String query = "UPDATE user SET " + COLUMN_JABATAN + " = '" + jabatan + "' WHERE " + COLUMN_ID + " = " + id;
        
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public List<Lamaran> getListLamaran(){
        ArrayList<Lamaran> listLamaran = new ArrayList<>();
        String query = "SELECT * FROM lamaran";
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                listLamaran.add(new Lamaran(
                        resultSet.getInt(COLUMN_ID),
                        resultSet.getInt(COLUMN_ID_USER),
                        resultSet.getString(COLUMN_NAMA),
                        resultSet.getString(COLUMN_JENIS_KELAMIN),
                        resultSet.getString(COLUMN_PENDIDIKAN),
                        resultSet.getString(COLUMN_POSISI),
                        resultSet.getString(COLUMN_PENGALAMAN), 
                        resultSet.getString(COLUMN_STATUS))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLamaran;
    }
}
