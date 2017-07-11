package lcs_test;

import java.text.DecimalFormat;
import java.util.Random;

public class Lcs_test {

    public static class test {

        Random rand = new Random();
        int sayi;
        String random_string;
        double baslangic_zaman ;
        double sure ;

        public String rastgele_string(int uzunluk) {
            random_string = "";
            for (int i = 0; i < uzunluk; i++) {
                do {
                    sayi = rand.nextInt(75) + 48;
                } while (sayi == 64 || sayi == 63 || sayi == 62 || sayi == 61 || sayi == 60 || sayi == 59 || sayi == 58 || sayi == 91 || sayi == 92 || sayi == 93 || sayi == 94 || sayi == 95 || sayi == 96);
                random_string += String.valueOf((char) sayi);
            }

          return random_string;
        }
        public void sure_baslat()
        {
             baslangic_zaman = System.nanoTime();
        }
        public void sure_hesapla()
        {
        sure = System.nanoTime() - baslangic_zaman;
        DecimalFormat ondalik_gosterim = new DecimalFormat("#0.000000000");

        System.out.println(ondalik_gosterim.format(sure / 1000000000) + " sn");
        }

    }

    public static void main(String[] args) {
        
        test test = new test();
        lcs lcs = new lcs();
        
        int ilk_kelime_uzunluk=10;
        int ikinci_kelime_uzunluk=10;
        
        String ilk_kelime = test.rastgele_string(ilk_kelime_uzunluk);
        String ikinci_kelime = test.rastgele_string(ikinci_kelime_uzunluk);
        
        test.sure_baslat();
        lcs.string_karsilastir(ilk_kelime, ikinci_kelime);
        test.sure_hesapla();


        

    }

}
