package com.mycompany.smartwaste;

public class TempatSampahOrganik extends TempatSampah {
    private String metodePengomposan;

    public TempatSampahOrganik(String idLokasi, int kapasitasMax, int volumeTerisi, String metodePengomposan) {
        super(idLokasi, kapasitasMax, volumeTerisi); // Menggunakan keyword 'super'
        this.metodePengomposan = metodePengomposan;
    }

    public String getMetodePengomposan() { return metodePengomposan; }
    public void setMetodePengomposan(String metodePengomposan) { this.metodePengomposan = metodePengomposan; }

    // Method Overriding
    @Override
    public void tampilkanInfo() {
        System.out.println("[KATEGORI: TEMPAT SAMPAH ORGANIK]");
        super.tampilkanInfo();
        System.out.printf("  - Metode Kompos : %s\n", metodePengomposan);
        System.out.println("--------------------------------------------------");
    }
}