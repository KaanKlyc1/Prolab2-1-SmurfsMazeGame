
package main;

public class karakter {
    
    public int ID;
    public String ad;
    public String tür;
    public lokasyon lokasyon;
   
    public karakter(int ID, String ad, String tür, lokasyon lokasyon) {
        this.ID = ID;
        this.ad = ad;
        this.tür = tür;
        this.lokasyon = lokasyon;
    }
    
    public karakter(){
        
        
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTür() {
        return tür;
    }

    public void setTür(String tür) {
        this.tür = tür;
    }

    public lokasyon getLokasyon() {
        return lokasyon;
    }

    public void setLokasyon(lokasyon lokasyon) {
        this.lokasyon = lokasyon;
    }

    public void EnKısaYol(){
        
    }
    
}