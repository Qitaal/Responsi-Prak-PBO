package resposiprakpbo.model;

public class Lamaran {
    int id;
    int idUser;
    String namaLengkap;
    String jenisKelamin;
    String pendidikan;
    String posisi;
    String pengalaman;
    String status;

    public Lamaran() {
    }

    public Lamaran(int id, int idUser, String namaLengkap, String jenisKelamin, String pendidikan, String posisi, String pengalaman, String status) {
        this.id = id;
        this.idUser = idUser;
        this.namaLengkap = namaLengkap;
        this.jenisKelamin = jenisKelamin;
        this.pendidikan = pendidikan;
        this.posisi = posisi;
        this.pengalaman = pengalaman;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getPengalaman() {
        return pengalaman;
    }

    public void setPengalaman(String pengalaman) {
        this.pengalaman = pengalaman;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
