package akademikmini;

public class MataKuliah {
    private String kodeMK;
    private String namaMK;
    private int sks;
    private int kapasitas;
    private int jumlahPeserta;

    // Constructor kosong
    public MataKuliah() {
        this.kodeMK = "";
        this.namaMK = "";
        this.sks = 0;
        this.kapasitas = 0;
        this.jumlahPeserta = 0;
    }

    // Constructor dengan parameter
    public MataKuliah(String kodeMK, String namaMK, int sks, int kapasitas) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
        this.kapasitas = kapasitas;
        this.jumlahPeserta = 0;
    }

    public String getKodeMK() {
        return kodeMK;
    }

    public void setKodeMK(String kodeMK) {
        this.kodeMK = kodeMK;
    }

    public String getNamaMK() {
        return namaMK;
    }

    public void setNamaMK(String namaMK) {
        this.namaMK = namaMK;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        if (sks > 0) {
            this.sks = sks;
        } else {
            throw new IllegalArgumentException("SKS harus lebih dari 0.");
        }
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        if (kapasitas > 0) {
            this.kapasitas = kapasitas;
        } else {
            throw new IllegalArgumentException("Kapasitas harus lebih dari 0.");
        }
    }

    public int getJumlahPeserta() {
        return jumlahPeserta;
    }

    public boolean tambahPeserta() {
        if (jumlahPeserta < kapasitas) {
            jumlahPeserta++;
            return true;
        }
        return false;
    }

    public void kurangiPeserta() {
        if (jumlahPeserta > 0) {
            jumlahPeserta--;
        }
    }

    public void tampilkanData() {
        System.out.println("Kode MK       : " + kodeMK);
        System.out.println("Nama MK       : " + namaMK);
        System.out.println("SKS           : " + sks);
        System.out.println("Kapasitas     : " + kapasitas);
        System.out.println("Jumlah Peserta: " + jumlahPeserta);
    }
}
