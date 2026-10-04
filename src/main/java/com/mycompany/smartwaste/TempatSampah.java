package com.mycompany.smartwaste;

public class TempatSampah {
    // Encapsulation: Atribut private
    private String idLokasi;
    private int kapasitasMax;
    private int volumeTerisi;

    // Static variable untuk menghitung total objek
    public static int totalTempatSampahDibuat = 0;

    // Constructor menggunakan keyword 'this'
    public TempatSampah(String idLokasi, int kapasitasMax, int volumeTerisi) {
        this.idLokasi = idLokasi;
        this.kapasitasMax = kapasitasMax;
        this.volumeTerisi = volumeTerisi;
        totalTempatSampahDibuat++;
    }

    // Getter dan Setter
    public String getIdLokasi() { return idLokasi; }
    public void setIdLokasi(String idLokasi) { this.idLokasi = idLokasi; }

    public int getKapasitasMax() { return kapasitasMax; }
    public void setKapasitasMax(int kapasitasMax) { this.kapasitasMax = kapasitasMax; }

    public int getVolumeTerisi() { return volumeTerisi; }
    public void setVolumeTerisi(int volumeTerisi) { this.volumeTerisi = volumeTerisi; }

    // Method dasar untuk di-override di Subclass
    public void tampilkanInfo() {
        System.out.printf("  - ID Lokasi     : %s\n", idLokasi);
        System.out.printf("  - Kapasitas Max : %d kg\n", kapasitasMax);
        System.out.printf("  - Volume Terisi : %d kg\n", volumeTerisi);
    }
}