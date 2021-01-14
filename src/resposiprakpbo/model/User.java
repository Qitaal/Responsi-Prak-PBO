package resposiprakpbo.model;

public class User {
    int id;
    String namaLengkap;
    String username;
    String password;
    String jabatan;

    public User() {
    }

    public User(int id, String namaLengkap, String username, String password, String jabatan) {
        this.id = id;
        this.namaLengkap = namaLengkap;
        this.username = username;
        this.password = password;
        this.jabatan = jabatan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    
}
