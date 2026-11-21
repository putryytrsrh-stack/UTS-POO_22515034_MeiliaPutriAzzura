package akademikmini;

import java.util.ArrayList;

public class StackRiwayat {
    private ArrayList<String> data;
    private int kapasitas;

    // Constructor kosong
    public StackRiwayat() {
        this.kapasitas = 5;
        this.data = new ArrayList<>();
    }

    // Constructor dengan parameter
    public StackRiwayat(int kapasitas) {
        this.kapasitas = kapasitas;
        this.data = new ArrayList<>();
    }

    // Mengecek apakah Stack kosong
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // Mengecek apakah Stack penuh
    public boolean isFull() {
        return data.size() >= kapasitas;
    }

    // Menambahkan data ke Stack
    public boolean push(String aktivitas) {
        if (isFull()) {
            System.out.println("Stack penuh! Data tidak dapat ditambahkan.");
            return false;
        }

        data.add(aktivitas);
        return true;
    }

    // Mengambil data paling atas
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong! Tidak ada data.");
            return null;
        }

        return data.remove(data.size() - 1);
    }

    // Melihat data paling atas
    public String peek() {
        if (isEmpty()) {
            return null;
        }

        return data.get(data.size() - 1);
    }

    // Menampilkan seluruh riwayat
    public void tampilkanStack() {
        if (isEmpty()) {
            System.out.println("Belum ada riwayat aktivitas.");
            return;
        }

        System.out.println("=== RIWAYAT AKTIVITAS ===");

        for (int i = data.size() - 1; i >= 0; i--) {
            System.out.println(data.get(i));
        }
    }
}