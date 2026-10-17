package com.mycompany.smartwaste;

public class TempatSampahAnorganik extends TempatSampah implements DapatDidaurUlang, DapatLaporSensor {
    private String jenisDaurUlang;

    public TempatSampahAnorganik(String idLokasi, int kapasitasMax, int volumeTerisi, String jenisDaurUlang) {
        super(idLokasi, kapasitasMax, volumeTerisi);
        this.jenisDaurUlang = jenisDaurUlang;
    }

    public String getJenisDaurUlang() { return jenisDaurUlang; }

    @Override
    public void tampilkanInfo() {
        System.out.print("[KATEGORI: ANORGANIK] ");
        super.tampilkanInfo();
        System.out.printf("  - Jenis Daur    : %s\n", jenisDaurUlang);
    }

    @Override
    public void aksiPengangkutan() {
        System.out.println("-> Info Pengangkutan: Sampah anorganik dikirim ke fasilitas pusat daur ulang.");
    }

    // Implementation of Abstract Method from TempatSampah
    @Override
    public void hitungBiayaPengelolaan() {
        int biaya = getVolumeTerisi() * 2000;
        System.out.println("-> [BIAYA] Estimasi biaya pemilahan daur ulang anorganik: Rp " + biaya);
    }

    // Implementation of Interface DapatDidaurUlang
    @Override
    public void prosesDaurUlang() {
        System.out.println("-> [DAUR ULANG] Material " + jenisDaurUlang + " dipress dan dikirim ke pabrik daur ulang.");
    }

    // Implementation of Interface DapatLaporSensor
    @Override
    public void laporStatusSensor() {
        double persentase = ((double) getVolumeTerisi() / getKapasitasMax()) * 100;
        System.out.printf("-> [SENSOR IoT] Kapasitas terisi: %.1f%% (%d/%d kg)\n", persentase, getVolumeTerisi(), getKapasitasMax());
    }
}