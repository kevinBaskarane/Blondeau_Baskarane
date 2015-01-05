package com.example.app1;

public class Biere {

	   String Category;
	    int Category_id;
	    String date_creation;String description;int id;String image; String name; int note;String last_update;String country;
	    String buveur;int note_moyenne;int nbr_notes;


	public Biere(){
	    Category=null;
	   Category_id=0;
	    date_creation=null;description=null;id=0;image=null; name=null;note=0;last_update=null;country=null;
	    buveur=null;note_moyenne=0;nbr_notes=0;

	}

public Biere(String Category,int Category_id ,  String date_creation, String description, int id, String image,  String name , int note, String last_update,String country,String buveur,int note_moyenne,int nbr_notes){
    this.buveur=buveur;
    this.Category=Category;
    this.Category_id=Category_id;this.country=country;
    this.image=image;this.date_creation=date_creation;this.description=description;this.id=id;this.name=name;this.note=note;this.last_update=last_update;
    this.note_moyenne=note_moyenne;this.nbr_notes=nbr_notes;

}

   /* public Biere(String category, int category_id, String date_creation, String description, int id, String image, String name, int note, String last_update, String country, String buveur, int note_moyenne, int nbr_notes) {

        this.buveur=buveur;
        this.Category=Category;
        this.Category_id=Category_id;this.country=country;
        this.image=image;this.date_creation=date_creation;this.description=description;this.id=id;this.name=name;this.note=note;this.last_update=last_update;
        this.note_moyenne=note_moyenne;this.nbr_notes=nbr_notes;
    }*/

    public int getCategory_id(){
	       return Category_id;
	   }
	    public String getDate_creation(){
	        return date_creation;
	    }

	    public void setBuveur(String buveur) {
	        this.buveur = buveur;
	    }

	    public void setCategory(String category) {
	        Category = category;
	    }

	    public void setCategory_id(int category_id) {
	        Category_id = category_id;
	    }

	    public void setCountry(String country) {
	        this.country = country;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public void setDate_creation(String date_creation) {
	        this.date_creation = date_creation;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public void setImage(String image) {
	        this.image = image;
	    }

	    public void setLast_update(String last_update) {
	        this.last_update = last_update;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setNbr_notes(int nbr_notes) {
	        this.nbr_notes = nbr_notes;
	    }

	    public void setNote(int note) {
	        this.note = note;
	    }

	    public void setNote_moyenne(int note_moyenne) {
	        this.note_moyenne = note_moyenne;
	    }

	    public int getId() {
	        return id;
	    }

	    public int getNbr_notes() {
	        return nbr_notes;
	    }

	    public int getNote() {
	        return note;
	    }

	    public int getNote_moyenne() {
	        return note_moyenne;
	    }

	    public String getBuveur() {
	        return buveur;
	    }

	    public String getCategory() {
	        return Category;
	    }

	    public String getCountry() {
	        return country;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public String getImage() {
	        return image;
	    }

	    public String getLast_update() {
	        return last_update;
	    }

	    public String getName() {
	        return name;
	    }

	}