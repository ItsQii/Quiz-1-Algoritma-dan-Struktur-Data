public class Pegawai03 {
    private String nama;
    private int masaKerjaThn;
    private double jamLembur;
    private int gajiPokok;

    public Pegawai03(String nama, int masaKerjaThn, double jamLembur, int gajiPokok) {
        this.nama = nama;
        this.masaKerjaThn = masaKerjaThn;
        this.jamLembur = jamLembur;
        this.gajiPokok = gajiPokok;
    }

    public double hitungGajiLembur() {
        double gajiLemburPerJam;
        if (masaKerjaThn < 5) {
            gajiLemburPerJam = 0.05 * gajiPokok;
        } else {
            gajiLemburPerJam = 0.1 * gajiPokok;
        }
        return jamLembur * gajiLemburPerJam;
    }

    public double hitungTunjangan() {
        double tunjangan;
        if (masaKerjaThn < 5) {
            tunjangan = 0.25 * gajiPokok;
        } else {
            tunjangan = 0.5 * gajiPokok;
        }
        return tunjangan;
    }

    public double hitungGajiTotal() {
        return gajiPokok + hitungGajiLembur() + hitungTunjangan();
    }

    public void printData() {
        System.out.println("Nama: " + nama);
        System.out.println("Masa Kerja (Tahun): " + masaKerjaThn);
        System.out.println("Jam Lembur: " + jamLembur);
        System.out.println("Gaji Pokok: " + gajiPokok);
        System.out.println("Gaji Lembur: " + hitungGajiLembur());
        System.out.println("Tunjangan: " + hitungTunjangan());
        System.out.println("Gaji Total: " + hitungGajiTotal());
    }

    public String getNama() {
        return nama;
    }

    public int getMasaKerjaThn() {
        return masaKerjaThn;
    }

    public double getJamLembur() {
        return jamLembur;
    }

    public int getGajiPokok() {
        return gajiPokok;
    }

    public static void main(String[] args) {
        Pegawai03 pegawai1 = new Pegawai03("Pegawai1", 6, 10, 5000);
        Pegawai03 pegawai2 = new Pegawai03("Pegawai2", 7, 8, 6000);
        Pegawai03 pegawai3 = new Pegawai03("Pegawai3", 4, 5, 4000);
        Pegawai03 pegawai4 = new Pegawai03("Pegawai4", 8, 12, 5000);

        System.out.println("Informasi Pegawai:");
        System.out.println("-------------------");
        pegawai1.printData();
        System.out.println();
        pegawai2.printData();
        System.out.println();
        pegawai3.printData();
        System.out.println();
        pegawai4.printData();
    }
}
