package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Main {

    static JFrame fr;
    static araYüz arayüz;
    public static int[][] Harita;
    public static int sayac1, sayac2;
    public static oyuncu şirin;
    public static ArrayList<düşman> düşmanlar;
    public static düşman düşman;
    static Scanner sc;
    public static ArrayList<ArrayList<String>> yollar;
    public static ArrayList<Kenar> kenarlar;
    public static ArrayList<lokasyon> kapılar;

    public static void main(String[] args) {

        sayac1 = 0;
        sayac2 = 0;
        Harita = new int[11][13];
        yollar = new ArrayList<>();
        düşmanlar = new ArrayList<>();
        kapılar = new ArrayList<>();
        kenarlar = new ArrayList<>();
        sc = new Scanner(System.in);
        fr = new JFrame("Şirinler");
        fr.setResizable(false);
        fr.setFocusable(false);
        fr.setSize(1000, 1000);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);

        arayüz = new araYüz();
        arayüz.requestFocus();
        arayüz.addKeyListener(arayüz);
        arayüz.setFocusable(true);
        arayüz.setFocusTraversalKeysEnabled(false);

        şirinSec();
        dosyadanOku();
//        for (int i = 0; i < sayac1; i++) {
//            for (int j = 0; j < sayac2; j++) {
//                System.out.print(Harita[i][j]);
//            }
//            System.out.println("");
//        }

        for (int i = 0; i < 11; i++) {

            for (int j = 0; j < 13; j++) {

                Kenar kenar1 = new Kenar();

                if (Harita[i][j] == 1) {

                    kenar1.kenarY = i;
                    kenar1.kenarX = j;
                    kenarlar.add(kenar1);

                }

            }

        }

        for (var k : kenarlar) {

            for (var l : kenarlar) {

                if (k.kenarX == l.kenarX && k.kenarY + 1 == l.kenarY) {//alt komşu

                    k.komşu[0] = l;

                } else if (k.kenarX == l.kenarX && k.kenarY - 1 == l.kenarY) {//üst komşu

                    k.komşu[1] = l;

                } else if (k.kenarX + 1 == l.kenarX && k.kenarY == l.kenarY) {//sağ komşu

                    k.komşu[2] = l;

                } else if (k.kenarX - 1 == l.kenarX && k.kenarY == l.kenarY) {//sol komşu

                    k.komşu[3] = l;

                }

            }

        }

        Kenar başlangıç = kenarlar.get(38);
        başlangıç.uzunluk = 0;
        kısaYolHesapla(başlangıç);

        for (int i = 0; i < düşmanlar.size(); i++) {

            int x = düşmanlar.get(i).getLokasyon().getX();
            int y = düşmanlar.get(i).getLokasyon().getY();

            if (düşmanlar.get(i).getID() == 1) {

                for (var a : kenarlar) {

                    if (a.kenarX == x && a.kenarY == y) {

                        Kenar gargamelBasla = a;
                        yollar.add(gargamelBasla.yol);
                    }

                }

            }
            if (düşmanlar.get(i).getID() == 2) {

                for (var b : kenarlar) {

                    if (b.kenarX == x && b.kenarY == y) {

                        Kenar azmanBasla = b;
                        yollar.add(azmanBasla.yol);
                    }

                }

            }

        }

//        for (int i = 0; i < yollar.size(); i++) {
//            for (int j = 0; j < yollar.get(i).size(); j++) {
//
//                String[] str = yollar.get(i).get(j).split(",");
//                int x = Integer.parseInt(str[0]);
//                int y = Integer.parseInt(str[1]);
//
//                System.out.println(x + " " + y);
//            }
//        }

        fr.add(arayüz);
        fr.setVisible(true);

    }

    static void kısaYolHesapla(Kenar basla) {

        if (basla.komşu[0] != null) {//alt yol komşularını ekleyen kontrol

            if (basla.komşu[0].uzunluk == -1) {

                for (var i : basla.yol) {

                    basla.komşu[0].yol.add(i);

                }
                basla.komşu[0].yol.add(basla.kenarX + "," + basla.kenarY);
                basla.komşu[0].uzunluk = basla.komşu[0].yol.size();
                kısaYolHesapla(basla.komşu[0]);
            } else if (basla.komşu[0].uzunluk > (basla.uzunluk + 1)) {

                ArrayList<String> yeniYol = new ArrayList<String>();

                for (var i : basla.yol) {

                    yeniYol.add(i);

                }

                yeniYol.add(basla.kenarX + "," + basla.kenarY);
                basla.komşu[0].yol = yeniYol;
                basla.komşu[0].uzunluk = basla.komşu[0].yol.size();
                kısaYolHesapla(basla.komşu[0]);
            }

        }

        if (basla.komşu[1] != null) {//üst yol komşularını ekleyen kontrol

            if (basla.komşu[1].uzunluk == -1) {

                for (var i : basla.yol) {

                    basla.komşu[1].yol.add(i);

                }
                basla.komşu[1].yol.add(basla.kenarX + "," + basla.kenarY);
                basla.komşu[1].uzunluk = basla.komşu[1].yol.size();
                kısaYolHesapla(basla.komşu[1]);
            } else if (basla.komşu[1].uzunluk > (basla.uzunluk + 1)) {

                ArrayList<String> yeniYol = new ArrayList<String>();

                for (var i : basla.yol) {

                    yeniYol.add(i);

                }

                yeniYol.add(basla.kenarX + "," + basla.kenarY);
                basla.komşu[1].yol = yeniYol;
                basla.komşu[1].uzunluk = basla.komşu[1].yol.size();
                kısaYolHesapla(basla.komşu[1]);
            }

        }

        if (basla.komşu[2] != null) {//sağ yol komşularını ekleyen kontrol

            if (basla.komşu[2].uzunluk == -1) {

                for (var i : basla.yol) {

                    basla.komşu[2].yol.add(i);

                }
                basla.komşu[2].yol.add(basla.kenarX + "," + basla.kenarY);
                basla.komşu[2].uzunluk = basla.komşu[2].yol.size();
                kısaYolHesapla(basla.komşu[2]);
            } else if (basla.komşu[2].uzunluk > (basla.uzunluk + 1)) {

                ArrayList<String> yeniYol = new ArrayList<String>();

                for (var i : basla.yol) {

                    yeniYol.add(i);

                }

                yeniYol.add(basla.kenarX + "," + basla.kenarY);
                basla.komşu[2].yol = yeniYol;
                basla.komşu[2].uzunluk = basla.komşu[2].yol.size();
                kısaYolHesapla(basla.komşu[2]);
            }

        }

        if (basla.komşu[3] != null) {//sol yol komşularını ekleyen kontrol

            if (basla.komşu[3].uzunluk == -1) {

                for (var i : basla.yol) {

                    basla.komşu[3].yol.add(i);

                }
                basla.komşu[3].yol.add(basla.kenarX + "," + basla.kenarY);
                basla.komşu[3].uzunluk = basla.komşu[3].yol.size();
                kısaYolHesapla(basla.komşu[3]);
            } else if (basla.komşu[3].uzunluk > (basla.uzunluk + 1)) {

                ArrayList<String> yeniYol = new ArrayList<String>();

                for (var i : basla.yol) {

                    yeniYol.add(i);

                }

                yeniYol.add(basla.kenarX + "," + basla.kenarY);
                basla.komşu[3].yol = yeniYol;
                basla.komşu[3].uzunluk = basla.komşu[3].yol.size();
                kısaYolHesapla(basla.komşu[3]);
            }

        }

    }

    static void dosyadanOku() {
        try {

            File dosya = new File("harita.txt");
            BufferedReader oku = new BufferedReader(new InputStreamReader(
                    new FileInputStream(dosya), "UTF-8"));

            String satır;

            while ((satır = oku.readLine()) != null) {

                String[] ayrım = satır.split(":");

                if (ayrım[0].equals("Karakter")) {

                    düşmanOluştur(satır);

                } else {

                    haritaOluştur(satır);

                }

            }

        } catch (Exception e) {
        }

    }

    static void haritaOluştur(String satır) {

        sayac2 = 0;

        for (int i = 0; i < satır.length(); i++) {

            if (satır.charAt(i) == '0') {

                Harita[sayac1][sayac2] = 0;
                sayac2++;
            } else if (satır.charAt(i) == '1') {

                Harita[sayac1][sayac2] = 1;
                sayac2++;

            }

        }
        sayac1++;
    }

    static void şirinSec() {

        System.out.println("Tembel şirin için 1'e basın."
                + "\nGözlüklü şirin için 2'ye basın.");

        int seçim = sc.nextInt();

        if (seçim == 1) {
            şirin = new tembelŞirin(20, 1, "tembelŞirin", "oyuncu", new lokasyon(6, 5));
        } else if (seçim == 2) {
            şirin = new gözlüklüŞirin(20, 2, "gözlüklüŞirin", "oyuncu", new lokasyon(6, 5));
        }
    }

    static void düşmanOluştur(String satır) {

        düşman kötü;
        String[] ayraç = satır.split(",");
        String[] ayraç1 = ayraç[0].split(":");
        String[] ayraç2 = ayraç[1].split(":");

        if (ayraç1[1].equals("Gargamel")) {

            kötü = new gargamel(1, "gargamel", "düşman", lokasyonOluştur(ayraç2[1]));
            düşmanlar.add(kötü);
            kapılar.add(lokasyonOluştur(ayraç2[1]));

        }

        if (ayraç1[1].equals("Azman")) {

            kötü = new azman(2, "azman", "düşman", lokasyonOluştur(ayraç2[1]));
            düşmanlar.add(kötü);
            kapılar.add(lokasyonOluştur(ayraç2[1]));
        }

    }

    static lokasyon lokasyonOluştur(String kapı) {

        if (kapı.equals("A")) {
            return new lokasyon(3, 0);
        } else if (kapı.equals("B")) {
            return new lokasyon(10, 0);
        } else if (kapı.equals("C")) {
            return new lokasyon(0, 5);
        } else if (kapı.equals("D")) {
            return new lokasyon(3, 10);
        } else {
            return null;
        }

    }

}
