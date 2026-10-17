package com.mycompany.smartwaste;

public class TempatSampahOrganik extends TempatSampah implements DapatDidaurUlang {
    private String metodePengomposan;

    public TempatSampahOrganik(String idLokasi, int kapasitasMax, int volumeTerisi, String metodePengomposan) {
        super(idLokasi, kapasitasMax, volumeTerisi);
        this.metodePengomposan = metodePengomposan;
    }

    public String getMetodePengomposan() { return metodePengomposan; }

    @Override
    public void tampilkanInfo() {
        System.out.print("[KATEGORI: ORGANIK] ");
        super.tampilkanInfo();
        System.out.printf("  - Metode Kompos : %s\n", metodePengomposan);
    }

    @Override
    public void aksiPengangkutan() {
        System.out.println("-> Info Pengangkutan: Sampah organik diproses cepat untuk dijadikan pupuk kompos.");
    }

    // Implementation of Abstract Method from TempatSampah
    @Override
    public void hitungBiayaPengelolaan() {
        int biaya = getVolumeTerisi() * 1000;
        System.out.println("-> [BIAYA] Estimasi biaya pengolahan kompos organik: Rp " + biaya);
    }

    // Implementation of Interface DapatDidaurUlang
    @Override
    public void prosesDaurUlang() {
        System.out.println("-> [DAUR ULANG] Sampah organik dicacah dan dimasukkan ke wadah komposter (" + metodePengomposan + ").");
    }
}