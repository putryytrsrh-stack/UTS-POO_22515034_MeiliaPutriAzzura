package akademikmini;

import java.util.ArrayList;

public class KRS {
    private String kodeKRS;
    private Mahasiswa mahasiswa;
    private ArrayList<MataKuliah> daftarMataKuliah;
    private int totalSKS;
    private String semester;

    // Constructor kosong
    public KRS() {
        this.kodeKRS = "";
        this.mahasiswa = null;
        this.daftarMataKuliah = new ArrayList<>();
        this.totalSKS = 0;
        this.semester = "";
    }

    // Constructor dengan parameter
    public KRS(String kodeKRS, Mahasiswa mahasiswa, String semester) {
        this.kodeKRS = kodeKRS;
        this.mahasiswa = mahasiswa;
        this.daftarMataKuliah = new ArrayList<>();
        this.totalSKS = 0;
        this.semester = semester;
    }

    public String getKodeKRS() {
        return kodeKRS;
    }

    public void setKodeKRS(String kodeKRS) {
        this.kodeKRS = kodeKRS;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public ArrayList<MataKuliah> getDaftarMataKuliah() {
        return daftarMataKuliah;
    }

    public int getTotalSKS() {
        return totalSKS;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    // Menambahkan mata kuliah ke KRS
    public boolean tambahMataKuliah(MataKuliah mk) {
        if (mk == null) {
            return false;
        }

        if (totalSKS + mk.getSks() > 24) {
            System.out.println("Gagal! Total SKS tidak boleh lebih dari 24.");
            return false;
        }

        if (!mk.tambahPeserta()) {
            System.out.println("Gagal! Kapasitas mata kuliah sudah penuh.");
            return false;
        }

        daftarMataKuliah.add(mk);
        totalSKS += mk.getSks();

        return true;
    }

    // Menghitung jumlah mata kuliah
    public int hitungJumlahMataKuliah() {
        return daftarMataKuliah.size();
    }

    // Menampilkan data KRS
    public void tampilkanKRS() {
        System.out.println("Kode KRS : " + kodeKRS);
        System.out.println("Mahasiswa: " +
                (mahasiswa != null ? mahasiswa.getNama() : "Belum ada"));
        System.out.println("Semester : " + semester);
        System.out.println("Total SKS: " + totalSKS);

        System.out.println("Daftar Mata Kuliah:");
        for (MataKuliah mk : daftarMataKuliah) {
            System.out.println("- " + mk.getNamaMK());
        }
    }
}
