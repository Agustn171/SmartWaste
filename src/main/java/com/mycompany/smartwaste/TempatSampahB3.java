package com.mycompany.smartwaste;

public class TempatSampahB3 extends TempatSampah implements DapatLaporSensor {
    private String tingkatBahaya;

    public TempatSampahB3(String idLokasi, int kapasitasMax, int volumeTerisi, String tingkatBahaya) {
        super(idLokasi, kapasitasMax, volumeTerisi);
        this.tingkatBahaya = tingkatBahaya;
    }

    public String getTingkatBahaya() { return tingkatBahaya; }

    @Override
    public void tampilkanInfo() {
        System.out.print("[KATEGORI: B3 BERBAHAYA] ");
        super.tampilkanInfo();
        System.out.printf("  - Tingkat Bahaya: %s\n", tingkatBahaya);
    }

    @Override
    public void aksiPengangkutan() {
        System.out.println("-> Info Pengangkutan: PERINGATAN! Limbah B3 memerlukan penanganan khusus & alat pelindung.");
    }

    // Implementation of Abstract Method from TempatSampah
    @Override
    public void hitungBiayaPengelolaan() {
        int biaya = getVolumeTerisi() * 5000;
        System.out.println("-> [BIAYA] Estimasi biaya penanganan limbah berbahaya B3: Rp " + biaya);
    }

    // Implementation of Interface DapatLaporSensor
    @Override
    public void laporStatusSensor() {
        double persentase = ((double) getVolumeTerisi() / getKapasitasMax()) * 100;
        System.out.printf("-> [SENSOR IoT - WARNING B3] Status %s: Terisi %.1f%%\n", tingkatBahaya, persentase);
    }
}