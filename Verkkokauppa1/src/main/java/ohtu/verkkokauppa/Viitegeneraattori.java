package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

public class Viitegeneraattori implements Vg {


    
    private int seuraava;
    
    public Viitegeneraattori(){
        seuraava = 1;    
    }
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
