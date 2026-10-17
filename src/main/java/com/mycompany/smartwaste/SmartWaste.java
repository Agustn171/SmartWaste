package com.mycompany.smartwaste;

import java.util.Scanner;

public class SmartWaste {

    public static void cariBin(String keywordLokasi, TempatSampah[] daftarBin, int jumlahData) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Lokasi (Teks): " + keywordLokasi + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahData; i++) {
            if (daftarBin[i].getIdLokasi().equalsIgnoreCase(keywordLokasi)) {
                daftarBin[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Data tidak ditemukan.");
    }

    public static void cariBin(int kapasitasKunci, TempatSampah[] daftarBin, int jumlahData) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Kapasitas Max (Angka): " + kapasitasKunci + " kg ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahData; i++) {
            if (daftarBin[i].getKapasitasMax() == kapasitasKunci) {
                daftarBin[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Data tidak ditemukan.");
    }

    public static void simulasiPengangkutan(TempatSampah item) {
        item.aksiPengangkutan();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            TempatSampah[] daftarBin = new TempatSampah[15];
            int jumlahData = 0;
            boolean isRunning = true;

            // Inisialisasi awal 4 data objek
            daftarBin[jumlahData++] = new TempatSampahOrganik("Zona A - Taman Arboretum", 100, 40, "Kompos Aerob");
            daftarBin[jumlahData++] = new TempatSampahAnorganik("Zona B - Kantin Utama", 150, 120, "Plastik PET");
            daftarBin[jumlahData++] = new TempatSampahB3("Zona C - Lab Kimia", 50, 45, "Toksik / Medis");
            daftarBin[jumlahData++] = new TempatSampahOrganik("Zona D - Hutan Kampus", 80, 20, "Takakura");

            System.out.println("==================================================");
            System.out.println("      SMART WASTE MANAGEMENT SYSTEM - MODUL 7     ");
            System.out.println("==================================================");

            while (isRunning) {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Data Tempat Sampah");
                System.out.println("2. Lihat Daftar Tempat Sampah (Abstract Method, Interface & instanceof)");
                System.out.println("3. Cari Tempat Sampah (Fitur Overloading)");
                System.out.println("4. Keluar");
                System.out.print("Pilih Menu (1-4): ");
                
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        if (jumlahData < daftarBin.length) {
                            System.out.println("\n--- Pilih Jenis Subclass Tempat Sampah ---");
                            System.out.println("1. Organik");
                            System.out.println("2. Anorganik");
                            System.out.println("3. B3 (Berbahaya)");
                            System.out.print("Pilihan (1/2/3): ");
                            int jenis = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Masukkan ID Lokasi         : ");
                            String lokasiBaru = scanner.nextLine();
                            System.out.print("Masukkan Kapasitas Max (kg): ");
                            int kapasitasBaru = scanner.nextInt();
                            System.out.print("Masukkan Volume Terisi (kg): ");
                            int volumeBaru = scanner.nextInt();
                            scanner.nextLine();

                            if (jenis == 1) {
                                System.out.print("Masukkan Metode Pengomposan: ");
                                String metode = scanner.nextLine();
                                daftarBin[jumlahData++] = new TempatSampahOrganik(lokasiBaru, kapasitasBaru, volumeBaru, metode);
                            } else if (jenis == 2) {
                                System.out.print("Masukkan Jenis Daur Ulang  : ");
                                String recycle = scanner.nextLine();
                                daftarBin[jumlahData++] = new TempatSampahAnorganik(lokasiBaru, kapasitasBaru, volumeBaru, recycle);
                            } else if (jenis == 3) {
                                System.out.print("Masukkan Tingkat Bahaya    : ");
                                String bahaya = scanner.nextLine();
                                daftarBin[jumlahData++] = new TempatSampahB3(lokasiBaru, kapasitasBaru, volumeBaru, bahaya);
                            }
                            System.out.println("Sukses! Data tempat sampah berhasil ditambahkan.");
                        } else {
                            System.out.println("Maaf, kapasitas penyimpanan penuh!");
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 2 -> {
                        System.out.println("\n--- Daftar Seluruh Tempat Sampah di Sistem ---");
                        if (jumlahData == 0) {
                            System.out.println("Belum ada data.");
                        } else {
                            for (int i = 0; i < jumlahData; i++) {
                                System.out.print((i + 1) + ". ");
                                daftarBin[i].tampilkanInfo();
                                simulasiPengangkutan(daftarBin[i]);
                                
                                // Pemanggilan Abstract Method
                                daftarBin[i].hitungBiayaPengelolaan();

                                // Pengecekan instanceof untuk Interface DapatDidaurUlang
                                if (daftarBin[i] instanceof DapatDidaurUlang) {
                                    DapatDidaurUlang itemDaurUlang = (DapatDidaurUlang) daftarBin[i];
                                    itemDaurUlang.prosesDaurUlang();
                                }

                                // Pengecekan instanceof untuk Interface DapatLaporSensor
                                if (daftarBin[i] instanceof DapatLaporSensor) {
                                    DapatLaporSensor itemSensor = (DapatLaporSensor) daftarBin[i];
                                    itemSensor.laporStatusSensor();
                                }

                                System.out.println("--------------------------------------------------");
                            }
                        }
                        System.out.println("\n* Total Objek Berhasil Dibuat: " + TempatSampah.totalTempatSampahBerhasilDibuat);
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 3 -> {
                        System.out.println("\n--- Fitur Cari Koleksi (Method Overloading) ---");
                        System.out.println("1. Cari berdasarkan Nama Lokasi (String)");
                        System.out.println("2. Cari berdasarkan Kapasitas Max (Integer)");
                        System.out.print("Pilih (1/2): ");
                        int modeCari = scanner.nextInt();
                        scanner.nextLine();

                        if (modeCari == 1) {
                            System.out.print("Masukkan Kata Kunci Lokasi: ");
                            String kataKunci = scanner.nextLine();
                            cariBin(kataKunci, daftarBin, jumlahData);
                        } else if (modeCari == 2) {
                            System.out.print("Masukkan Angka Kapasitas Max: ");
                            int angkaKunci = scanner.nextInt();
                            scanner.nextLine();
                            cariBin(angkaKunci, daftarBin, jumlahData);
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 4 -> {
                        isRunning = false;
                        System.out.println("Program dihentikan. Terima kasih!");
                    }
                    default -> System.out.println("Pilihan menu tidak valid!");
                }
            }
        }
    }
}