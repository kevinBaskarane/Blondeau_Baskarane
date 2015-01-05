package com.example.app1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by valentin on 29/12/14.
 */
public  class ExtractBier {

    public ExtractBier(){


    }

    ArrayList<Biere> Bieres;

    public ArrayList<Biere> getBier() {


       /* String Category,int Category_id ,  String date_creation, String description, int id, String image,  String name , int note, String last_update,String country,
                String buveur,int note_moyenne,int nbr_notes*/

        Bieres = new ArrayList<Biere>();
        Biere k=new Biere("biére blonde",1,"2014-05-01T18:56:37Z","2013",1,"/uploads/biere/image/1/M_Espagne.jpg","M",0,"2014-12-19T14:05:04Z","Espagne","djauss",2,1);
Bieres.set(0, k);
       // public Biere(String Category,int Category_id ,  String date_creation, String description, int id, String image,  String name , int note, String last_update,String country,String buveur,int note_moyenne,int nbr_notes)

        k=new Biere("biére blonde",1,"2014-05-01T18:56:38Z","2013",2,"/uploads/biere/image/2/Sol_Mexique.png","Sol",0,"2014-12-19T14:05:04Z","Mexique","djauss",0,0);
        Bieres.set(0, k);
        // On retourne la liste des personnes
        return Bieres;
    }

public ArrayList<Biere> getBieres(){
        return Bieres;
    }
}