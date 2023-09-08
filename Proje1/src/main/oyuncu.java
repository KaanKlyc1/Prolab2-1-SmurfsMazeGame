
package main;

public class oyuncu extends karakter{
    
    public int Skor;

    public oyuncu(int Skor, int ID, String ad, String tür, lokasyon lokasyon) {
        super(ID, ad, tür, lokasyon);
        this.Skor = Skor;
    }

    public oyuncu() {
        
    }

    public int getSkor() {
        return Skor;
    }

    public void setSkor(int Skor) {
        this.Skor = Skor;
    }
    
    
    
    public void PuaniGoster(){
        
        System.out.println("Skor"+this.getSkor());
        
    }

}
