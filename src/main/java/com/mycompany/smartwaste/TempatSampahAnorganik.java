package com.mycompany.smartwaste;

public class TempatSampahAnorganik extends TempatSampah {
    private String jenisDaurUlang;

    public TempatSampahAnorganik(String idLokasi, int kapasitasMax, int volumeTerisi, String jenisDaurUlang) {
        super(idLokasi, kapasitasMax, volumeTerisi); // Menggunakan keyword 'super'
        this.jenisDaurUlang = jenisDaurUlang;
    }

    public String getJenisDaurUlang() { return jenisDaurUlang; }
    public void setJenisDaurUlang(String jenisDaurUlang) { this.jenisDaurUlang = jenisDaurUlang; }

    // Method Overriding
    @Override
    public void tampilkanInfo() {
        System.out.println("[KATEGORI: TEMPAT SAMPAH ANORGANIK]");
        super.tampilkanInfo();
        System.out.printf("  - Jenis Daur    : %s\n", jenisDaurUlang);
        System.out.println("--------------------------------------------------");
    }
}