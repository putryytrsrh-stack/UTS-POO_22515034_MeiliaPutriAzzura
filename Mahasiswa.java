package akademikmini;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String jurusan;
    private String kelas;
    private double ipk;

    // Constructor kosong
    public Mahasiswa() {
        this.nim = "";
        this.nama = "";
        this.jurusan = "";
        this.kelas = "";
        this.ipk = 0.0;
    }

    // Constructor dengan parameter
    public Mahasiswa(String nim, String nama, String jurusan,
                     String kelas, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.kelas = kelas;
        setIpk(ipk);
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        if (ipk >= 0.0 && ipk <= 4.0) {
            this.ipk = ipk;
        } else {
            throw new IllegalArgumentException("IPK harus antara 0 sampai 4.");
        }
    }

    public void tampilkanData() {
        System.out.println("NIM     : " + nim);
        System.out.println("Nama    : " + nama);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("Kelas   : " + kelas);
        System.out.println("IPK     : " + ipk);
    }

    public boolean cekNim(String nim) {
        return this.nim.equals(nim);
    }

    public void ubahKelas(String kelasBaru) {
        this.kelas = kelasBaru;
    }
}