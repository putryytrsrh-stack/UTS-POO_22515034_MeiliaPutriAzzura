package akademikmini;

import java.util.ArrayList;

public class Kampus {
    private String namaKampus;
    private String alamat;
    private String kodeKampus;
    private ArrayList<Mahasiswa> daftarMahasiswa;
    private ArrayList<MataKuliah> daftarMataKuliah;

    // Constructor kosong
    public Kampus() {
        this.namaKampus = "";
        this.alamat = "";
        this.kodeKampus = "";
        this.daftarMahasiswa = new ArrayList<>();
        this.daftarMataKuliah = new ArrayList<>();
    }

    // Constructor dengan parameter
    public Kampus(String namaKampus, String alamat, String kodeKampus) {
        this.namaKampus = namaKampus;
        this.alamat = alamat;
        this.kodeKampus = kodeKampus;
        this.daftarMahasiswa = new ArrayList<>();
        this.daftarMataKuliah = new ArrayList<>();
    }

    public String getNamaKampus() {
        return namaKampus;
    }

    public void setNamaKampus(String namaKampus) {
        this.namaKampus = namaKampus;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKodeKampus() {
        return kodeKampus;
    }

    public void setKodeKampus(String kodeKampus) {
        this.kodeKampus = kodeKampus;
    }

    public ArrayList<Mahasiswa> getDaftarMahasiswa() {
        return daftarMahasiswa;
    }

    public ArrayList<MataKuliah> getDaftarMataKuliah() {
        return daftarMataKuliah;
    }

    // Menambahkan mahasiswa
    public void tambahMahasiswa(Mahasiswa mahasiswa) {
        if (mahasiswa != null) {
            daftarMahasiswa.add(mahasiswa);
        }
    }

    // Menambahkan mata kuliah
    public void tambahMataKuliah(MataKuliah mk) {
        if (mk != null) {
            daftarMataKuliah.add(mk);
        }
    }

    // Mencari mahasiswa berdasarkan NIM
    public Mahasiswa cariMahasiswa(String nim) {
        for (Mahasiswa m : daftarMahasiswa) {
            if (m.cekNim(nim)) {
                return m;
            }
        }
        return null;
    }

    // Menampilkan seluruh mahasiswa
    public void tampilkanMahasiswa() {
        for (Mahasiswa m : daftarMahasiswa) {
            m.tampilkanData();
            System.out.println("--------------------");
        }
    }
}