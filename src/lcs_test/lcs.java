
package lcs_test;


public class lcs {
     private int[][] matris;
     private char[][] oklar;
   
    public void string_karsilastir(String a, String b)
    {
        matris = new int[a.length() + 1][b.length() + 1];
        oklar = new char[a.length() + 1][b.length() + 1];

        for (int i = 0; i < a.length() + 1; i++) {
            matris[i][0] = 0;
            oklar[i][0] = '0';
        }
        for (int i = 0; i < b.length() + 1; i++) {
            matris[0][i] = 0;
            oklar[0][i] = '0';
        }
        // İfadelerin karşılaştırılması ve okların yerleştirilmesi
        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length() + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    matris[i][j] = matris[i - 1][j - 1] + 1;
                    oklar[i][j] = '⇱';
                } else if (matris[i - 1][j] >= matris[i][j - 1]) {
                    matris[i][j] = matris[i - 1][j];
                    oklar[i][j] = '↑';
                } else {
                    matris[i][j] = matris[i][j - 1];
                    oklar[i][j] = '←';
                }
            }
        }
        //Matrisin yazdırılması
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                System.out.print(matris[i][j]+" ");
            }
                 System.out.print("    ");
            for (int j = 0; j < b.length() + 1; j++) {
                 System.out.print(oklar[i][j]+" ");
            }
             System.out.println();
        }
        System.out.println("Alt Katar uzunluğu ..:"+matris[a.length()][b.length()]);

        //Alt katarın bulunması
        char[] altKatar = new char[matris[a.length()][b.length()]];
        int tempi = a.length();
        int tempj = b.length();
        int sayac = 0;
        while (matris[tempi][tempj] != 0) {
            if (oklar[tempi][tempj] == '↑') {
                tempi = tempi - 1;
            } else if (oklar[tempi][tempj] == '←') {
                tempj = tempj - 1;
            } else if (oklar[tempi][tempj] == '⇱') {
                altKatar[sayac] = b.charAt(tempj - 1);
                sayac++;
                tempi = tempi - 1;
                tempj = tempj - 1;
            }
        }

        for (int j = 0; j < altKatar.length / 2; j++) {
            char temp = altKatar[j];
            altKatar[j] = altKatar[altKatar.length - j - 1];
            altKatar[altKatar.length - j - 1] = temp;
        }
         System.out.println(altKatar);
    }
}
