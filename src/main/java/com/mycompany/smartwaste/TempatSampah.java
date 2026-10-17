package com.mycompany.smartwaste;

public abstract class TempatSampah {
    private String idLokasi;
    private int kapasitasMax;
    private int volumeTerisi;
    
    public static int totalTempatSampahBerhasilDibuat = 0;

    public TempatSampah(String idLokasi, int kapasitasMax, int volumeTerisi) {
        this.idLokasi = idLokasi;
        this.kapasitasMax = kapasitasMax;
        this.volumeTerisi = volumeTerisi;
        totalTempatSampahBerhasilDibuat++;
    }

    public String getIdLokasi() { return idLokasi; }
    public void setIdLokasi(String idLokasi) { this.idLokasi = idLokasi; }

    public int getKapasitasMax() { return kapasitasMax; }
    public void setKapasitasMax(int kapasitasMax) { this.kapasitasMax = kapasitasMax; }

    public int getVolumeTerisi() { return volumeTerisi; }
    public void setVolumeTerisi(int volumeTerisi) { this.volumeTerisi = volumeTerisi; }

    public void tampilkanInfo() {
        System.out.printf("  - ID Lokasi     : %s\n", idLokasi);
        System.out.printf("  - Kapasitas Max : %d kg\n", kapasitasMax);
        System.out.printf("  - Volume Terisi : %d kg\n", volumeTerisi);
    }

    public void aksiPengangkutan() {
        System.out.println("-> Info Pengangkutan: Penampungan sampah standar siap diangkut.");
    }

    // Abstract Method (Wajib di-override di semua Subclass)
    public abstract void hitungBiayaPengelolaan();
}