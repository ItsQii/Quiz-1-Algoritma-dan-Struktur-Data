import java.util.ArrayList;

public class Pegawai {
    private String nama;
    private int masaKerjaThn;
    private double jamLembur;
    private int gajiPokok;

    public Pegawai(String nama, int masaKerjaThn, double jamLembur, int gajiPokok) {
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

    public static void main(String[] args) {
        // Membuat objek Pegawai
        Pegawai pegawai1 = new Pegawai("Pegawai1", 6, 10, 5000);
        Pegawai pegawai2 = new Pegawai("Pegawai2", 7, 8, 6000);
        Pegawai pegawai3 = new Pegawai("Pegawai3", 4, 5, 4500);
        Pegawai pegawai4 = new Pegawai("Pegawai4", 8, 12, 5500);


        double gajiLemburTerbesar = Double.MIN_VALUE;
        Pegawai pegawaiGajiLemburTerkecil = null;


        double gajiLemburTerkecil = Double.MAX_VALUE;


        Pegawai pegawaiGajiLemburTerbesar = null;

        int jumlahPegawai = 0;
        int totalGaji = 0;

        ArrayList<Pegawai> pegawaiList = new ArrayList<>();
        pegawaiList.add(pegawai1);
        pegawaiList.add(pegawai2);
        pegawaiList.add(pegawai3);
        pegawaiList.add(pegawai4);


        for (Pegawai pegawai : pegawaiList) {

            if (pegawai.getMasaKerjaThn() > 5) {
                jumlahPegawai++;
                totalGaji += pegawai.hitungGajiTotal();
            }

  
            if (pegawai.getMasaKerjaThn() < 5) {

                double gajiLembur = pegawai.hitungGajiLembur();


                if (gajiLembur > gajiLemburTerbesar) {
                    gajiLemburTerbesar = gajiLembur;
                    pegawaiGajiLemburTerbesar = pegawai;
                }


                if (gajiLembur < gajiLemburTerkecil) {
                    gajiLemburTerkecil = gajiLembur;
                    pegawaiGajiLemburTerkecil = pegawai;
                }
            }
        }


        if (pegawaiGajiLemburTerkecil != null) {
            System.out.println("Data Pegawai dengan gaji lembur terkecil:");
            pegawaiGajiLemburTerkecil.printData();
        } else {
            System.out.println("Tidak ada pegawai dengan masa kerja < 5 tahun.");
        }


        System.out.println("Gaji lembur terbesar dari pegawai dengan masa kerja < 5 tahun: " + gajiLemburTerbesar);


        double rataRataGaji = 0.0;
        if (jumlahPegawai > 0) {
            rataRataGaji = (double) totalGaji / jumlahPegawai;
        }

 
        System.out.println("Jumlah Pegawai dengan masa kerja > 5 tahun: " + jumlahPegawai);
        System.out.println("Total Gaji Pegawai dengan masa kerja > 5 tahun: " + totalGaji);
        System.out.println("Rata-rata Gaji Pegawai dengan masa kerja > 5 tahun: " + rataRataGaji);
    }
}
