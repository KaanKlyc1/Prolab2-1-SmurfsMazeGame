package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class araYüz extends JPanel implements KeyListener, ActionListener {

    private BufferedImage image;

    public araYüz() {

        setBackground(Color.WHITE);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1000, 1000);

        for (int i = 0; i < 11; i++) {

            for (int j = 0; j < 13; j++) {

                //labirent çizimi
                if (Main.Harita[i][j] == 1) {

                    g.setColor(Color.YELLOW);
                    g.fill3DRect(100 + j * 60, 120 + i * 60, 60, 60, true);
                    g.setColor(Color.WHITE);

                } else {

                    g.setColor(Color.DARK_GRAY);
                    g.fill3DRect(100 + j * 60, 120 + i * 60, 60, 60, true);
                    g.setColor(Color.WHITE);

                }

                if (j == 3 && i == 0) {//A kapısı

                    g.setColor(Color.PINK);
                    g.fill3DRect(100 + j * 60, 120 + i * 60, 60, 60, true);
                    try {
                        image = ImageIO.read(new FileImageInputStream(new File("A.png")));
                        g.drawImage(image, 115 + (60 * j), 130 + (60 * i), image.getWidth(), image.getHeight(), this);
                    } catch (IOException ex) {
                        Logger.getLogger(araYüz.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                if (j == 10 && i == 0) {//B kapısı

                    g.setColor(Color.PINK);
                    g.fill3DRect(100 + j * 60, 120 + i * 60, 60, 60, true);
                    try {
                        image = ImageIO.read(new FileImageInputStream(new File("B.png")));
                        g.drawImage(image, 115 + (60 * j), 130 + (60 * i), image.getWidth(), image.getHeight(), this);
                    } catch (IOException ex) {
                        Logger.getLogger(araYüz.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                if (j == 0 && i == 5) {//C kapısı

                    g.setColor(Color.PINK);
                    g.fill3DRect(100 + j * 60, 120 + i * 60, 60, 60, true);
                    try {
                        image = ImageIO.read(new FileImageInputStream(new File("C.png")));
                        g.drawImage(image, 115 + (60 * j), 130 + (60 * i), image.getWidth(), image.getHeight(), this);
                    } catch (IOException ex) {
                        Logger.getLogger(araYüz.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                if (j == 3 && i == 10) {//D kapısı

                    g.setColor(Color.PINK);
                    g.fill3DRect(100 + j * 60, 120 + i * 60, 60, 60, true);
                    try {
                        image = ImageIO.read(new FileImageInputStream(new File("D.png")));
                        g.drawImage(image, 115 + (60 * j), 130 + (60 * i), image.getWidth(), image.getHeight(), this);
                    } catch (IOException ex) {
                        Logger.getLogger(araYüz.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        }

        for (int i = 0; i < Main.yollar.size(); i++) {
            for (int j = 0; j < Main.yollar.get(i).size(); j++) {

                String[] str = Main.yollar.get(i).get(j).split(",");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);

                g.setColor(Color.GREEN);
                g.fill3DRect(100 + (x * 60), 120 + (y * 60), 60, 60, true);

            }
        }

        try {
            image = ImageIO.read(new FileImageInputStream(new File("sirine.png")));
            g.drawImage(image, 870, 510, image.getWidth() / 4, image.getHeight() / 4, this);
        } catch (IOException ex) {
            Logger.getLogger(araYüz.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            image = ImageIO.read(new FileImageInputStream(new File("skor.png")));
            g.drawImage(image, 100, 30, image.getWidth(), image.getHeight(), this);
        } catch (IOException ex) {
            Logger.getLogger(araYüz.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (Main.şirin.getID() == 1) {

            int x = Main.şirin.getLokasyon().getX();
            int y = Main.şirin.getLokasyon().getY();

            try {
                image = ImageIO.read(new FileImageInputStream(new File("tembelsirin.png")));
                g.drawImage(image, 100 + (x * 60), 120 + (y * 60), image.getWidth(), image.getHeight(), this);
            } catch (IOException ex) {
                Logger.getLogger(araYüz.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (Main.şirin.getID() == 2) {

            int x = Main.şirin.getLokasyon().getX();
            int y = Main.şirin.getLokasyon().getY();

            try {
                image = ImageIO.read(new FileImageInputStream(new File("gozluklusirin.png")));
                g.drawImage(image, 100 + (60 * x), 120 + (60 * y), image.getWidth(), image.getHeight(), this);
            } catch (IOException ex) {
                Logger.getLogger(araYüz.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        for (int i = 0; i < Main.düşmanlar.size(); i++) {
            if (new Rectangle(100 + (60 * Main.şirin.getLokasyon().getX()), 120 + (60 * Main.şirin.getLokasyon().getY()), 60, 60).intersects(new Rectangle(100 + (60 * Main.düşmanlar.get(i).getLokasyon().getX()), 120 + (60 * Main.düşmanlar.get(i).getLokasyon().getY()), 45, 45))) {

                if (Main.düşmanlar.get(i).getID() == 1) {

                    Main.şirin.setSkor(Main.şirin.getSkor() - 15);
                    Main.düşmanlar.get(i).setLokasyon(Main.kapılar.get(i));

                } else if (Main.düşmanlar.get(i).getID() == 2) {

                    Main.şirin.setSkor(Main.şirin.getSkor() - 5);
                    Main.düşmanlar.get(i).setLokasyon(Main.kapılar.get(i));

                }

            }

        }

        g.setColor(Color.BLACK);
        g.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.PLAIN, 80));
        g.drawString("" + Main.şirin.getSkor(), 350, 90);

        for (int i = 0; i < Main.düşmanlar.size(); i++) {

            int x = Main.düşmanlar.get(i).getLokasyon().getX();
            int y = Main.düşmanlar.get(i).getLokasyon().getY();

            if (Main.düşmanlar.get(i).getID() == 1) {

                try {
                    image = ImageIO.read(new FileImageInputStream(new File("gargamel.png")));
                    g.drawImage(image, 100 + (60 * x), 120 + (60 * y), image.getWidth(), image.getHeight(), this);
                } catch (IOException ex) {
                    Logger.getLogger(araYüz.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (Main.düşmanlar.get(i).getID() == 2) {

                try {
                    image = ImageIO.read(new FileImageInputStream(new File("azman.png")));
                    g.drawImage(image, 100 + (60 * x), 120 + (60 * y), image.getWidth(), image.getHeight(), this);
                } catch (IOException ex) {
                    Logger.getLogger(araYüz.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

        for (int i = 0; i < Main.düşmanlar.size(); i++) {

            if (Main.düşmanlar.get(i).getID() == 1) {

                g.setColor(Color.BLACK);
                g.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.PLAIN, 26));
                g.drawString(Main.düşmanlar.get(i).getAd() + " (" + Main.düşmanlar.get(i).getLokasyon().getX() + "," + Main.düşmanlar.get(i).getLokasyon().getY() + ") noktasından " + "(" + Main.şirin.getLokasyon().getX() + "," + Main.şirin.getLokasyon().getY() + ") noktasına " + Main.yollar.get(i).size() + " adımda ulaşmaktadır.", 100, 810 + (i * 60));

            } else if (Main.düşmanlar.get(i).getID() == 2) {

                g.setColor(Color.BLACK);
                g.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.PLAIN, 26));
                g.drawString(Main.düşmanlar.get(i).getAd() + " (" + Main.düşmanlar.get(i).getLokasyon().getX() + "," + Main.düşmanlar.get(i).getLokasyon().getY() + ") noktasından " + "(" + Main.şirin.getLokasyon().getX() + "," + Main.şirin.getLokasyon().getY() + ") noktasına " + Main.yollar.get(i).size() + " adımda ulaşmaktadır.", 100, 810 + (i * 60));

            }

        }

        if (Main.şirin.getSkor() > 0 && new Rectangle(100 + (60 * Main.şirin.getLokasyon().getX()), 120 + (60 * Main.şirin.getLokasyon().getY()), 60, 60).intersects(new Rectangle(100 + (60 * 12), 120 + (60 * 7), 60, 60))) {

            String message = "!Kazandınız!";
            JOptionPane.showMessageDialog(this, message);
            System.exit(0);
        }

        if (Main.şirin.getSkor() <= 0) {

            String message = "!Kaybettiniz!";
            JOptionPane.showMessageDialog(this, message);
            System.exit(0);

        }

    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int c = e.getKeyCode();

        if (c == KeyEvent.VK_RIGHT) {

            int x = Main.şirin.getLokasyon().getX();
            int y = Main.şirin.getLokasyon().getY();

            if (Main.şirin.getID() == 1 && Main.şirin.getSkor() > 0) {

                if ((x + 1) <= 13) {

                    if (Main.Harita[y][x + 1] == 1) {

                        Main.şirin.getLokasyon().setX(x + 1);

                        Main.kenarlar.removeAll(Main.kenarlar);
                        Main.yollar.removeAll(Main.yollar);

                        for (int i = 0; i < 11; i++) {

                            for (int j = 0; j < 13; j++) {

                                Kenar kenar = new Kenar();

                                if (Main.Harita[i][j] == 1) {

                                    kenar.kenarY = i;
                                    kenar.kenarX = j;
                                    Main.kenarlar.add(kenar);

                                }

                            }

                        }

                        for (var k : Main.kenarlar) {

                            for (var l : Main.kenarlar) {

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

                        for (var a : Main.kenarlar) {

                            if (a.kenarX == Main.şirin.getLokasyon().getX() && a.kenarY == Main.şirin.getLokasyon().getY()) {

                                Kenar başlangıç = a;
                                başlangıç.uzunluk = 0;
                                Main.kısaYolHesapla(başlangıç);

                            }

                        }

                        for (int i = 0; i < Main.düşmanlar.size(); i++) {

                            x = Main.düşmanlar.get(i).getLokasyon().getX();
                            y = Main.düşmanlar.get(i).getLokasyon().getY();

                            if (Main.düşmanlar.get(i).getID() == 1) {

                                for (var a : Main.kenarlar) {

                                    if (a.kenarX == x && a.kenarY == y) {

                                        Kenar gargamelBasla = a;
                                        Main.yollar.add(gargamelBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    if (Main.yollar.get(i).size() >= 2) {

                                        int index = Main.yollar.get(i).size() - 2;
                                        String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                        x = Integer.parseInt(ayraç[0]);
                                        y = Integer.parseInt(ayraç[1]);

                                        Main.düşmanlar.get(i).getLokasyon().setX(x);
                                        Main.düşmanlar.get(i).getLokasyon().setY(y);

                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);
                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                    }
                                }

                            }
                            if (Main.düşmanlar.get(i).getID() == 2) {

                                for (var b : Main.kenarlar) {

                                    if (b.kenarX == x && b.kenarY == y) {

                                        Kenar azmanBasla = b;
                                        Main.yollar.add(azmanBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    int index = Main.yollar.get(i).size() - 1;
                                    String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                    x = Integer.parseInt(ayraç[0]);
                                    y = Integer.parseInt(ayraç[1]);

                                    Main.düşmanlar.get(i).getLokasyon().setX(x);
                                    Main.düşmanlar.get(i).getLokasyon().setY(y);
                                    Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                }

                            }

                        }
                        repaint();

                    }

                }

            }

            if (Main.şirin.getID() == 2 && Main.şirin.getSkor() > 0) {

                if ((x + 2) <= 13) {

                    if (Main.Harita[y][x + 2] == 1 && Main.Harita[y][x + 1] != 0) {

                        Main.şirin.getLokasyon().setX(x + 2);

                        Main.kenarlar.removeAll(Main.kenarlar);
                        Main.yollar.removeAll(Main.yollar);

                        for (int i = 0; i < 11; i++) {

                            for (int j = 0; j < 13; j++) {

                                Kenar kenar = new Kenar();

                                if (Main.Harita[i][j] == 1) {

                                    kenar.kenarY = i;
                                    kenar.kenarX = j;
                                    Main.kenarlar.add(kenar);

                                }

                            }

                        }

                        for (var k : Main.kenarlar) {

                            for (var l : Main.kenarlar) {

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

                        for (var a : Main.kenarlar) {

                            if (a.kenarX == Main.şirin.getLokasyon().getX() && a.kenarY == Main.şirin.getLokasyon().getY()) {

                                Kenar başlangıç = a;
                                başlangıç.uzunluk = 0;
                                Main.kısaYolHesapla(başlangıç);

                            }

                        }

                        for (int i = 0; i < Main.düşmanlar.size(); i++) {

                            x = Main.düşmanlar.get(i).getLokasyon().getX();
                            y = Main.düşmanlar.get(i).getLokasyon().getY();

                            if (Main.düşmanlar.get(i).getID() == 1) {

                                for (var a : Main.kenarlar) {

                                    if (a.kenarX == x && a.kenarY == y) {

                                        Kenar gargamelBasla = a;
                                        Main.yollar.add(gargamelBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    if (Main.yollar.get(i).size() >= 2) {

                                        int index = Main.yollar.get(i).size() - 2;
                                        String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                        x = Integer.parseInt(ayraç[0]);
                                        y = Integer.parseInt(ayraç[1]);

                                        Main.düşmanlar.get(i).getLokasyon().setX(x);
                                        Main.düşmanlar.get(i).getLokasyon().setY(y);

                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);
                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                    }
                                }

                            }
                            if (Main.düşmanlar.get(i).getID() == 2) {

                                for (var b : Main.kenarlar) {

                                    if (b.kenarX == x && b.kenarY == y) {

                                        Kenar azmanBasla = b;
                                        Main.yollar.add(azmanBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    int index = Main.yollar.get(i).size() - 1;
                                    String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                    x = Integer.parseInt(ayraç[0]);
                                    y = Integer.parseInt(ayraç[1]);

                                    Main.düşmanlar.get(i).getLokasyon().setX(x);
                                    Main.düşmanlar.get(i).getLokasyon().setY(y);
                                    Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                }

                            }

                        }

                        repaint();

                    }

                }

            }

        }

        if (c == KeyEvent.VK_DOWN) {

            int x = Main.şirin.getLokasyon().getX();
            int y = Main.şirin.getLokasyon().getY();

            if (Main.şirin.getID() == 1 && Main.şirin.getSkor() > 0) {

                if ((y + 1) <= 11) {

                    if (Main.Harita[y + 1][x] == 1) {

                        Main.şirin.getLokasyon().setY(y + 1);

                        Main.kenarlar.removeAll(Main.kenarlar);
                        Main.yollar.removeAll(Main.yollar);

                        for (int i = 0; i < 11; i++) {

                            for (int j = 0; j < 13; j++) {

                                Kenar kenar = new Kenar();

                                if (Main.Harita[i][j] == 1) {

                                    kenar.kenarY = i;
                                    kenar.kenarX = j;
                                    Main.kenarlar.add(kenar);

                                }

                            }

                        }

                        for (var k : Main.kenarlar) {

                            for (var l : Main.kenarlar) {

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

                        for (var a : Main.kenarlar) {

                            if (a.kenarX == Main.şirin.getLokasyon().getX() && a.kenarY == Main.şirin.getLokasyon().getY()) {

                                Kenar başlangıç = a;
                                başlangıç.uzunluk = 0;
                                Main.kısaYolHesapla(başlangıç);

                            }

                        }

                        for (int i = 0; i < Main.düşmanlar.size(); i++) {

                            x = Main.düşmanlar.get(i).getLokasyon().getX();
                            y = Main.düşmanlar.get(i).getLokasyon().getY();

                            if (Main.düşmanlar.get(i).getID() == 1) {

                                for (var a : Main.kenarlar) {

                                    if (a.kenarX == x && a.kenarY == y) {

                                        Kenar gargamelBasla = a;
                                        Main.yollar.add(gargamelBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    if (Main.yollar.get(i).size() >= 2) {

                                        int index = Main.yollar.get(i).size() - 2;
                                        String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                        x = Integer.parseInt(ayraç[0]);
                                        y = Integer.parseInt(ayraç[1]);

                                        Main.düşmanlar.get(i).getLokasyon().setX(x);
                                        Main.düşmanlar.get(i).getLokasyon().setY(y);
                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);
                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                    }
                                }

                            }
                            if (Main.düşmanlar.get(i).getID() == 2) {

                                for (var b : Main.kenarlar) {

                                    if (b.kenarX == x && b.kenarY == y) {

                                        Kenar azmanBasla = b;
                                        Main.yollar.add(azmanBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    int index = Main.yollar.get(i).size() - 1;
                                    String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                    x = Integer.parseInt(ayraç[0]);
                                    y = Integer.parseInt(ayraç[1]);

                                    Main.düşmanlar.get(i).getLokasyon().setX(x);
                                    Main.düşmanlar.get(i).getLokasyon().setY(y);
                                    Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);
                                }

                            }

                        }
                        repaint();
                    }

                }

            }

            if (Main.şirin.getID() == 2 && Main.şirin.getSkor() > 0) {

                if ((y + 2) <= 11) {

                    if (Main.Harita[y + 2][x] == 1 && Main.Harita[y + 1][x] != 0) {

                        Main.şirin.getLokasyon().setY(y + 2);

                        Main.kenarlar.removeAll(Main.kenarlar);
                        Main.yollar.removeAll(Main.yollar);

                        for (int i = 0; i < 11; i++) {

                            for (int j = 0; j < 13; j++) {

                                Kenar kenar = new Kenar();

                                if (Main.Harita[i][j] == 1) {

                                    kenar.kenarY = i;
                                    kenar.kenarX = j;
                                    Main.kenarlar.add(kenar);

                                }

                            }

                        }

                        for (var k : Main.kenarlar) {

                            for (var l : Main.kenarlar) {

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

                        for (var a : Main.kenarlar) {

                            if (a.kenarX == Main.şirin.getLokasyon().getX() && a.kenarY == Main.şirin.getLokasyon().getY()) {

                                Kenar başlangıç = a;
                                başlangıç.uzunluk = 0;
                                Main.kısaYolHesapla(başlangıç);

                            }

                        }

                        for (int i = 0; i < Main.düşmanlar.size(); i++) {

                            x = Main.düşmanlar.get(i).getLokasyon().getX();
                            y = Main.düşmanlar.get(i).getLokasyon().getY();

                            if (Main.düşmanlar.get(i).getID() == 1) {

                                for (var a : Main.kenarlar) {

                                    if (a.kenarX == x && a.kenarY == y) {

                                        Kenar gargamelBasla = a;
                                        Main.yollar.add(gargamelBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    if (Main.yollar.get(i).size() >= 2) {

                                        int index = Main.yollar.get(i).size() - 2;
                                        String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                        x = Integer.parseInt(ayraç[0]);
                                        y = Integer.parseInt(ayraç[1]);

                                        Main.düşmanlar.get(i).getLokasyon().setX(x);
                                        Main.düşmanlar.get(i).getLokasyon().setY(y);

                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);
                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                    }
                                }

                            }
                            if (Main.düşmanlar.get(i).getID() == 2) {

                                for (var b : Main.kenarlar) {

                                    if (b.kenarX == x && b.kenarY == y) {

                                        Kenar azmanBasla = b;
                                        Main.yollar.add(azmanBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    int index = Main.yollar.get(i).size() - 1;
                                    String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                    x = Integer.parseInt(ayraç[0]);
                                    y = Integer.parseInt(ayraç[1]);

                                    Main.düşmanlar.get(i).getLokasyon().setX(x);
                                    Main.düşmanlar.get(i).getLokasyon().setY(y);
                                    Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                }

                            }

                        }

                        repaint();
                    }

                }

            }

        }

        if (c == KeyEvent.VK_LEFT) {

            int x = Main.şirin.getLokasyon().getX();
            int y = Main.şirin.getLokasyon().getY();

            if (Main.şirin.getID() == 1 && Main.şirin.getSkor() > 0) {

                if ((x - 1) >= 0) {

                    if (Main.Harita[y][x - 1] == 1) {

                        Main.şirin.getLokasyon().setX(x - 1);

                        Main.kenarlar.removeAll(Main.kenarlar);
                        Main.yollar.removeAll(Main.yollar);

                        for (int i = 0; i < 11; i++) {

                            for (int j = 0; j < 13; j++) {

                                Kenar kenar = new Kenar();

                                if (Main.Harita[i][j] == 1) {

                                    kenar.kenarY = i;
                                    kenar.kenarX = j;
                                    Main.kenarlar.add(kenar);

                                }

                            }

                        }

                        for (var k : Main.kenarlar) {

                            for (var l : Main.kenarlar) {

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

                        for (var a : Main.kenarlar) {

                            if (a.kenarX == Main.şirin.getLokasyon().getX() && a.kenarY == Main.şirin.getLokasyon().getY()) {

                                Kenar başlangıç = a;
                                başlangıç.uzunluk = 0;
                                Main.kısaYolHesapla(başlangıç);

                            }

                        }

                        for (int i = 0; i < Main.düşmanlar.size(); i++) {

                            x = Main.düşmanlar.get(i).getLokasyon().getX();
                            y = Main.düşmanlar.get(i).getLokasyon().getY();

                            if (Main.düşmanlar.get(i).getID() == 1) {

                                for (var a : Main.kenarlar) {

                                    if (a.kenarX == x && a.kenarY == y) {

                                        Kenar gargamelBasla = a;
                                        Main.yollar.add(gargamelBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    if (Main.yollar.get(i).size() >= 2) {

                                        int index = Main.yollar.get(i).size() - 2;
                                        String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                        x = Integer.parseInt(ayraç[0]);
                                        y = Integer.parseInt(ayraç[1]);

                                        Main.düşmanlar.get(i).getLokasyon().setX(x);
                                        Main.düşmanlar.get(i).getLokasyon().setY(y);
                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);
                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                    }

                                }

                            }
                            if (Main.düşmanlar.get(i).getID() == 2) {

                                for (var b : Main.kenarlar) {

                                    if (b.kenarX == x && b.kenarY == y) {

                                        Kenar azmanBasla = b;
                                        Main.yollar.add(azmanBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    int index = Main.yollar.get(i).size() - 1;
                                    String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                    x = Integer.parseInt(ayraç[0]);
                                    y = Integer.parseInt(ayraç[1]);

                                    Main.düşmanlar.get(i).getLokasyon().setX(x);
                                    Main.düşmanlar.get(i).getLokasyon().setY(y);
                                    Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                }

                            }

                        }
                        repaint();
                    }

                }

            }

            if (Main.şirin.getID() == 2 && Main.şirin.getSkor() > 0) {

                if ((x - 2) >= 0) {

                    if (Main.Harita[y][x - 2] == 1 && Main.Harita[y][x - 1] != 0) {

                        Main.şirin.getLokasyon().setX(x - 2);

                        Main.kenarlar.removeAll(Main.kenarlar);
                        Main.yollar.removeAll(Main.yollar);

                        for (int i = 0; i < 11; i++) {

                            for (int j = 0; j < 13; j++) {

                                Kenar kenar = new Kenar();

                                if (Main.Harita[i][j] == 1) {

                                    kenar.kenarY = i;
                                    kenar.kenarX = j;
                                    Main.kenarlar.add(kenar);

                                }

                            }

                        }

                        for (var k : Main.kenarlar) {

                            for (var l : Main.kenarlar) {

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

                        for (var a : Main.kenarlar) {

                            if (a.kenarX == Main.şirin.getLokasyon().getX() && a.kenarY == Main.şirin.getLokasyon().getY()) {

                                Kenar başlangıç = a;
                                başlangıç.uzunluk = 0;
                                Main.kısaYolHesapla(başlangıç);

                            }

                        }

                        for (int i = 0; i < Main.düşmanlar.size(); i++) {

                            x = Main.düşmanlar.get(i).getLokasyon().getX();
                            y = Main.düşmanlar.get(i).getLokasyon().getY();

                            if (Main.düşmanlar.get(i).getID() == 1) {

                                for (var a : Main.kenarlar) {

                                    if (a.kenarX == x && a.kenarY == y) {

                                        Kenar gargamelBasla = a;
                                        Main.yollar.add(gargamelBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    if (Main.yollar.get(i).size() >= 2) {

                                        int index = Main.yollar.get(i).size() - 2;
                                        String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                        x = Integer.parseInt(ayraç[0]);
                                        y = Integer.parseInt(ayraç[1]);

                                        Main.düşmanlar.get(i).getLokasyon().setX(x);
                                        Main.düşmanlar.get(i).getLokasyon().setY(y);

                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);
                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                    }
                                }

                            }
                            if (Main.düşmanlar.get(i).getID() == 2) {

                                for (var b : Main.kenarlar) {

                                    if (b.kenarX == x && b.kenarY == y) {

                                        Kenar azmanBasla = b;
                                        Main.yollar.add(azmanBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    int index = Main.yollar.get(i).size() - 1;
                                    String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                    x = Integer.parseInt(ayraç[0]);
                                    y = Integer.parseInt(ayraç[1]);

                                    Main.düşmanlar.get(i).getLokasyon().setX(x);
                                    Main.düşmanlar.get(i).getLokasyon().setY(y);
                                    Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                }

                            }

                        }

                        repaint();
                    }

                }

            }

        }

        if (c == KeyEvent.VK_UP) {

            int x = Main.şirin.getLokasyon().getX();
            int y = Main.şirin.getLokasyon().getY();

            if (Main.şirin.getID() == 1 && Main.şirin.getSkor() > 0) {

                if ((y - 1) >= 0) {

                    if (Main.Harita[y - 1][x] == 1) {

                        Main.şirin.getLokasyon().setY(y - 1);

                        Main.kenarlar.removeAll(Main.kenarlar);
                        Main.yollar.removeAll(Main.yollar);

                        for (int i = 0; i < 11; i++) {

                            for (int j = 0; j < 13; j++) {

                                Kenar kenar = new Kenar();

                                if (Main.Harita[i][j] == 1) {

                                    kenar.kenarY = i;
                                    kenar.kenarX = j;
                                    Main.kenarlar.add(kenar);

                                }

                            }

                        }

                        for (var k : Main.kenarlar) {

                            for (var l : Main.kenarlar) {

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

                        for (var a : Main.kenarlar) {

                            if (a.kenarX == Main.şirin.getLokasyon().getX() && a.kenarY == Main.şirin.getLokasyon().getY()) {

                                Kenar başlangıç = a;
                                başlangıç.uzunluk = 0;
                                Main.kısaYolHesapla(başlangıç);

                            }

                        }

                        for (int i = 0; i < Main.düşmanlar.size(); i++) {

                            x = Main.düşmanlar.get(i).getLokasyon().getX();
                            y = Main.düşmanlar.get(i).getLokasyon().getY();

                            if (Main.düşmanlar.get(i).getID() == 1) {

                                for (var a : Main.kenarlar) {

                                    if (a.kenarX == x && a.kenarY == y) {

                                        Kenar gargamelBasla = a;
                                        Main.yollar.add(gargamelBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    if (Main.yollar.get(i).size() >= 2) {

                                        int index = Main.yollar.get(i).size() - 2;
                                        String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                        x = Integer.parseInt(ayraç[0]);
                                        y = Integer.parseInt(ayraç[1]);

                                        Main.düşmanlar.get(i).getLokasyon().setX(x);
                                        Main.düşmanlar.get(i).getLokasyon().setY(y);
                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);
                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                    }
                                }

                            }
                            if (Main.düşmanlar.get(i).getID() == 2) {

                                for (var b : Main.kenarlar) {

                                    if (b.kenarX == x && b.kenarY == y) {

                                        Kenar azmanBasla = b;
                                        Main.yollar.add(azmanBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    int index = Main.yollar.get(i).size() - 1;
                                    String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                    x = Integer.parseInt(ayraç[0]);
                                    y = Integer.parseInt(ayraç[1]);

                                    Main.düşmanlar.get(i).getLokasyon().setX(x);
                                    Main.düşmanlar.get(i).getLokasyon().setY(y);
                                    Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                }

                            }

                        }
                        repaint();
                    }

                }

            }

            if (Main.şirin.getID() == 2 && Main.şirin.getSkor() > 0) {

                if ((y - 2) >= 0) {

                    if (Main.Harita[y - 2][x] == 1 && Main.Harita[y - 1][x] != 0) {

                        Main.şirin.getLokasyon().setY(y - 2);

                        Main.kenarlar.removeAll(Main.kenarlar);
                        Main.yollar.removeAll(Main.yollar);

                        for (int i = 0; i < 11; i++) {

                            for (int j = 0; j < 13; j++) {

                                Kenar kenar = new Kenar();

                                if (Main.Harita[i][j] == 1) {

                                    kenar.kenarY = i;
                                    kenar.kenarX = j;
                                    Main.kenarlar.add(kenar);

                                }

                            }

                        }

                        for (var k : Main.kenarlar) {

                            for (var l : Main.kenarlar) {

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

                        for (var a : Main.kenarlar) {

                            if (a.kenarX == Main.şirin.getLokasyon().getX() && a.kenarY == Main.şirin.getLokasyon().getY()) {

                                Kenar başlangıç = a;
                                başlangıç.uzunluk = 0;
                                Main.kısaYolHesapla(başlangıç);

                            }

                        }

                        for (int i = 0; i < Main.düşmanlar.size(); i++) {

                            x = Main.düşmanlar.get(i).getLokasyon().getX();
                            y = Main.düşmanlar.get(i).getLokasyon().getY();

                            if (Main.düşmanlar.get(i).getID() == 1) {

                                for (var a : Main.kenarlar) {

                                    if (a.kenarX == x && a.kenarY == y) {

                                        Kenar gargamelBasla = a;
                                        Main.yollar.add(gargamelBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    if (Main.yollar.get(i).size() >= 2) {

                                        int index = Main.yollar.get(i).size() - 2;
                                        String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                        x = Integer.parseInt(ayraç[0]);
                                        y = Integer.parseInt(ayraç[1]);

                                        Main.düşmanlar.get(i).getLokasyon().setX(x);
                                        Main.düşmanlar.get(i).getLokasyon().setY(y);

                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);
                                        Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                    }
                                }

                            }
                            if (Main.düşmanlar.get(i).getID() == 2) {

                                for (var b : Main.kenarlar) {

                                    if (b.kenarX == x && b.kenarY == y) {

                                        Kenar azmanBasla = b;
                                        Main.yollar.add(azmanBasla.yol);
                                    }

                                }

                                if (Main.yollar.get(i).size() > 0) {

                                    int index = Main.yollar.get(i).size() - 1;
                                    String[] ayraç = Main.yollar.get(i).get(index).split(",");
                                    x = Integer.parseInt(ayraç[0]);
                                    y = Integer.parseInt(ayraç[1]);

                                    Main.düşmanlar.get(i).getLokasyon().setX(x);
                                    Main.düşmanlar.get(i).getLokasyon().setY(y);
                                    Main.yollar.get(i).remove(Main.yollar.get(i).size() - 1);

                                }

                            }

                        }

                        repaint();
                    }

                }

            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
