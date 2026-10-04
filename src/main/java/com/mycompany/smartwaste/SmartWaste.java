package com.mycompany.smartwaste;

import java.util.Scanner;

public class SmartWaste {

    // Method Overloading 1: Pencarian berdasarkan String (Lokasi)
    public static void cariBin(String keywordLokasi, TempatSampah[] daftarBin, int jumlahData) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Lokasi: " + keywordLokasi + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahData; i++) {
            if (daftarBin[i].getIdLokasi().equalsIgnoreCase(keywordLokasi)) {
                daftarBin[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Data tidak ditemukan.");
    }

    // Method Overloading 2: Pencarian berdasarkan Integer (Kapasitas Maksimal)
    public static void cariBin(int kapasitasKunci, TempatSampah[] daftarBin, int jumlahData) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Kapasitas Max: " + kapasitasKunci + " kg ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahData; i++) {
            if (daftarBin[i].getKapasitasMax() == kapasitasKunci) {
                daftarBin[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Data tidak ditemukan.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TempatSampah[] daftarBin = new TempatSampah[15]; // Array penyimpan objek
        int jumlahData = 0;
        boolean isRunning = true;

        // Inisialisasi data awal (3-5 objek sesuai syarat modul)
        daftarBin[jumlahData++] = new TempatSampahOrganik("Zona A - Gedung Rektorat", 120, 40, "Kompos Aerob");
        daftarBin[jumlahData++] = new TempatSampahAnorganik("Zona B - Kantin Fakultas", 150, 120, "Plastik PET");
        daftarBin[jumlahData++] = new TempatSampahOrganik("Zona C - Taman Arboretum", 80, 20, "Takakura");
        daftarBin[jumlahData++] = new TempatSampahAnorganik("Zona D - Area Parkir Utama", 200, 180, "Kardus/Kertas");

        while (isRunning) {
            System.out.println("\n==================================================");
            System.out.println("       SMART WASTE MANAGEMENT SYSTEM (LKP 2-5)");
            System.out.println("==================================================");
            System.out.println("1. Tambah Data Tempat Sampah Baru");
            System.out.println("2. Tampilkan Seluruh Data Tempat Sampah");
            System.out.println("3. Cari Tempat Sampah (Method Overloading)");
            System.out.println("4. Keluar Aplikasi");
            System.out.print("Pilih Menu (1-4): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.println("\nPilih Tipe Subclass Tempat Sampah:");
                    System.out.println("1. Organik");
                    System.out.println("2. Anorganik");
                    System.out.print("Pilihan tipe (1/2): ");
                    int jenis = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukkan ID Lokasi         : ");
                    String lokasi = scanner.nextLine();
                    System.out.print("Masukkan Kapasitas Max (kg): ");
                    int kapasitas = scanner.nextInt();
                    System.out.print("Masukkan Volume Terisi (kg): ");
                    int volume = scanner.nextInt();
                    scanner.nextLine();

                    if (jenis == 1) {
                        System.out.print("Masukkan Metode Pengomposan: ");
                        String metode = scanner.nextLine();
                        daftarBin[jumlahData++] = new TempatSampahOrganik(lokasi, kapasitas, volume, metode);
                    } else {
                        System.out.print("Masukkan Jenis Daur Ulang  : ");
                        String recycle = scanner.nextLine();
                        daftarBin[jumlahData++] = new TempatSampahAnorganik(lokasi, kapasitas, volume, recycle);
                    }
                    System.out.println("--> Data Tempat Sampah Berhasil Ditambahkan!");
                    break;

                case 2:
                    System.out.println("\n--- DAFTAR KESELURUHAN TEMPAT SAMPAH ---");
                    System.out.println("Total Objek Tercipta (Static Counter): " + TempatSampah.totalTempatSampahDibuat);
                    for (int i = 0; i < jumlahData; i++) {
                        daftarBin[i].tampilkanInfo(); // Polymorphism & Overriding
                    }
                    break;

                case 3:
                    System.out.println("\nPilih Metode Pencarian (Method Overloading):");
                    System.out.println("1. Berdasarkan Nama Lokasi (String)");
                    System.out.println("2. Berdasarkan Kapasitas Maksimal (Integer)");
                    System.out.print("Pilih metode (1/2): ");
                    int tipeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (tipeCari == 1) {
                        System.out.print("Masukkan Keyword Lokasi: ");
                        String cariLoc = scanner.nextLine();
                        cariBin(cariLoc, daftarBin, jumlahData);
                    } else {
                        System.out.print("Masukkan Angka Kapasitas Max: ");
                        int cariCap = scanner.nextInt();
                        cariBin(cariCap, daftarBin, jumlahData);
                    }
                    break;

                case 4:
                    isRunning = false;
                    System.out.println("Program dihentikan. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
        }
        scanner.close();
    }
}