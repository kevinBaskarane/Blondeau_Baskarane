package com.example.app1;
import java.util.ArrayList;

public class AfficheBieres {


    ArrayList<Biere> BieresList;

public AfficheBieres() {
    ExtractBier extract = new ExtractBier();
    BieresList = new ArrayList<Biere>();
    BieresList=extract.getBier();

}

    public ArrayList<Biere> getBiereList(){
        return BieresList;
    }
}