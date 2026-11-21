
package akademikmini;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static Kampus kampus = new Kampus(
            "Kampus Akademik Mini",
            "Kendari",
            "KMP001"
    );
    static StackRiwayat riwayat = new StackRiwayat(5);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n===== SISTEM AKADEMIK MINI =====");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Tambah Mata Kuliah");
            System.out.println("4. Tampilkan Mata Kuliah");
            System.out.println("5. Buat KRS Mahasiswa");
            System.out.println("6. Cari Mahasiswa");
            System.out.println("7. Operasi Stack Riwayat");
            System.out.println("8. Tampilkan Ringkasan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = bacaAngka();

            switch (pilihan) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    kampus.tampilkanMahasiswa();
                    break;
                case 3:
                    tambahMataKuliah();
                    break;
                case 4:
                    tampilkanMataKuliah();
                    break;
                case 5:
                    buatKRS();
                    break;
                case 6:
                    cariMahasiswa();
                    break;
                case 7:
                    menuStack();
                    break;
                case 8:
                    tampilkanRingkasan();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan program.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    static int bacaAngka() {
        try {
            int angka = Integer.parseInt(input.nextLine());
            return angka;
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
            return -1;
        }
    }

    static void tambahMahasiswa() {
        System.out.println("\n--- TAMBAH MAHASISWA ---");

        System.out.print("NIM: ");
        String nim = input.nextLine();

        if (nim.trim().isEmpty() || kampus.cariMahasiswa(nim) != null) {
            System.out.println("NIM kosong atau sudah terdaftar!");
            return;
        }

        System.out.print("Nama: ");
        String nama = input.nextLine();

        System.out.print("Jurusan: ");
        String jurusan = input.nextLine();

        System.out.print("Kelas: ");
        String kelas = input.nextLine();

        System.out.print("IPK: ");

        double ipk;
        try {
            ipk = Double.parseDouble(input.nextLine());
            if (ipk < 0 || ipk > 4) {
                System.out.println("IPK harus antara 0 sampai 4.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("IPK harus berupa angka.");
            return;
        }

        Mahasiswa m = new Mahasiswa(nim, nama, jurusan, kelas, ipk);
        kampus.tambahMahasiswa(m);
        riwayat.push("Menambahkan mahasiswa: " + nama);

        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    static void tambahMataKuliah() {
        System.out.println("\n--- TAMBAH MATA KULIAH ---");

        System.out.print("Kode Mata Kuliah: ");
        String kode = input.nextLine();

        System.out.print("Nama Mata Kuliah: ");
        String nama = input.nextLine();

        System.out.print("Jumlah SKS: ");
        int sks = bacaAngka();

        System.out.print("Kapasitas: ");
        int kapasitas = bacaAngka();

        if (kode.trim().isEmpty() || nama.trim().isEmpty()
                || sks <= 0 || kapasitas <= 0) {
            System.out.println("Data mata kuliah tidak valid.");
            return;
        }

        for (MataKuliah mk : kampus.getDaftarMataKuliah()) {
            if (mk.getKodeMK().equalsIgnoreCase(kode)) {
                System.out.println("Kode mata kuliah sudah digunakan.");
                return;
            }
        }

        MataKuliah mk = new MataKuliah(kode, nama, sks, kapasitas);
        kampus.tambahMataKuliah(mk);
        riwayat.push("Menambahkan mata kuliah: " + nama);

        System.out.println("Mata kuliah berhasil ditambahkan!");
    }

    static void tampilkanMataKuliah() {
        System.out.println("\n--- DAFTAR MATA KULIAH ---");

        if (kampus.getDaftarMataKuliah().isEmpty()) {
            System.out.println("Belum ada mata kuliah.");
            return;
        }

        for (MataKuliah mk : kampus.getDaftarMataKuliah()) {
            mk.tampilkanData();
            System.out.println("--------------------");
        }
    }

    static void buatKRS() {
        System.out.println("\n--- MEMBUAT KRS ---");

        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = input.nextLine();

        Mahasiswa mahasiswa = kampus.cariMahasiswa(nim);

        if (mahasiswa == null) {
            System.out.println("Mahasiswa tidak ditemukan.");
            return;
        }

        if (kampus.getDaftarMataKuliah().isEmpty()) {
            System.out.println("Belum ada mata kuliah yang tersedia.");
            return;
        }

        KRS krs = new KRS(
                "KRS" + nim,
                mahasiswa,
                "Semester Ganjil 2026"
        );

        System.out.println("Daftar mata kuliah:");
        tampilkanMataKuliah();

        System.out.print("Masukkan kode mata kuliah: ");
        String kode = input.nextLine();

        for (MataKuliah mk : kampus.getDaftarMataKuliah()) {
            if (mk.getKodeMK().equalsIgnoreCase(kode)) {
                if (krs.tambahMataKuliah(mk)) {
                    System.out.println("KRS berhasil dibuat!");
                    krs.tampilkanKRS();
                    riwayat.push("Membuat KRS untuk: " + mahasiswa.getNama());
                }
                return;
            }
        }

        System.out.println("Kode mata kuliah tidak ditemukan.");
    }

    static void cariMahasiswa() {
        System.out.print("\nMasukkan NIM yang dicari: ");
        String nim = input.nextLine();

        Mahasiswa m = kampus.cariMahasiswa(nim);

        if (m != null) {
            System.out.println("Mahasiswa ditemukan:");
            m.tampilkanData();
        } else {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
    }

    static void menuStack() {
        int pilihan;

        do {
            System.out.println("\n--- MENU STACK RIWAYAT ---");
            System.out.println("1. Push (Tambah Riwayat)");
            System.out.println("2. Pop (Ambil Riwayat)");
            System.out.println("3. Peek (Lihat Riwayat Teratas)");
            System.out.println("4. Tampilkan Semua Riwayat");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");

            pilihan = bacaAngka();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan aktivitas: ");
                    String aktivitas = input.nextLine();
                    if (riwayat.push(aktivitas)) {
                        System.out.println("Riwayat berhasil ditambahkan.");
                    }
                    break;
                case 2:
                    String hasil = riwayat.pop();
                    if (hasil != null) {
                        System.out.println("Riwayat diambil: " + hasil);
                    }
                    break;
                case 3:
                    String atas = riwayat.peek();
                    System.out.println(atas == null
                            ? "Stack kosong."
                            : "Riwayat teratas: " + atas);
                    break;
                case 4:
                    riwayat.tampilkanStack();
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    static void tampilkanRingkasan() {
        System.out.println("\n===== RINGKASAN AKADEMIK =====");
        System.out.println("Nama Kampus: " + kampus.getNamaKampus());
        System.out.println("Alamat: " + kampus.getAlamat());
        System.out.println("Jumlah Mahasiswa: "
                + kampus.getDaftarMahasiswa().size());
        System.out.println("Jumlah Mata Kuliah: "
                + kampus.getDaftarMataKuliah().size());
        System.out.println("Riwayat Stack kosong: " + riwayat.isEmpty());
        riwayat.tampilkanStack();
    }
}