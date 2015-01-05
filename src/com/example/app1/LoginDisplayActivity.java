package com.example.app1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class LoginDisplayActivity extends Activity { 
	ListView liste = null;
    List<String> exemple;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
//*****************************
/*
       InputStream flux= null;
        try {
            flux = new FileInputStream("bieres.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader lecture=new InputStreamReader(flux);
        BufferedReader buff=new BufferedReader(lecture);
        String ligne="rien";
        try {
            ligne=buff.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

*/




//*****************************
	 setContentView(R.layout.login_display);
	 liste = (ListView) findViewById(R.id.listProg);
        ExtractBier Bieres = new ExtractBier();
      ArrayList<Biere> f=new ArrayList<Biere>();
//f=Bieres.getBieres();
       exemple = new ArrayList<String>();
		//exemple.add(f.get(0).getName());
        exemple.add("M");
		exemple.add("Sol");
		exemple.add("Hoegaarden");
        exemple.add("Chouffe");
         exemple.add("La B\\u00e9casse");
        exemple.add("Grimbergen Blonde");
        exemple.add("Grimbergen Double");
        exemple.add("Grimbergen Reserve");
        exemple.add("Grimbergen Blanche");
        exemple.add("Heineken");
        exemple.add("Munchner Bier");
        exemple.add("Brhama (spe edition Cerveja Do Brasil)");
        exemple.add("Budweiser Budvar");
        exemple.add("Delirium Tremens");
       exemple.add("Lowenbrau");
        exemple.add("San Miguel");
        exemple.add("Selecta San Miguel");
        exemple.add("Tripel Karmeliet");
        exemple.add("Estrella Damm");
        exemple.add("Duff Beer");
        exemple.add("Birra Peroni");
        exemple.add("Czech Lager");
        exemple.add("Yorkshire Best Bitter");
        exemple.add("Italian Lager");
        exemple.add("SouthWold Adnams Brewery");
        exemple.add("Devassa");
        exemple.add("Pelforth Brune");
        exemple.add("Itaipava");
        exemple.add("Mort Subite Original Kriek");



       // new HttpAsyncTask().execute("http://hmkcode.appspot.com/rest/controller/get.json");
       // exemple.add("taille fichier"+ligne.length());


		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, exemple);
		liste.setAdapter(adapter);
	}


public void add(String k){

    exemple.add(k);
}

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
           exemple.add("list :"+result);


        }
    }

    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }
    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }
}




