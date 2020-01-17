package com.juniarstudio.kuissantai;

public class AcakKata {
    private StringBuilder sb;
    private String result="";
    final static String hrf = "qwertyuiopasdfghjklzxcvbnm";

    public AcakKata(String jwbn) {
        sb = new StringBuilder();

        sb.append(jwbn);
        for (int i = 0; i < 12 - jwbn.length(); i++) {
            java.util.Random r = new java.util.Random();
            //char hrf = (char)(r.nextInt(26)+'A');
            char hrf = huruf();

            sb.append(hrf);
        }
        //System.out.println(sb);
        acak();
    }

    private void acak(){
        int isiRandom;
        int ka = 0;
        boolean lanjut = true;
        boolean[] ket = new boolean[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            ket[i] = false;
        }

        while (lanjut) {
            isiRandom = new java.util.Random().nextInt(sb.length());
            if (ket[isiRandom]==false) {
                result+=sb.charAt(isiRandom);
                ket[isiRandom]=true;
                ka++;
            }
            if (ka>=sb.length()) {
                lanjut = false;
            }
        }

        //System.out.println(result);

    }

    private static char huruf() {
        return hrf.charAt(new java.util.Random().nextInt(hrf.length()));
    }

    public String getResult() {
        return result;
    }
}
