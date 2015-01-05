package com.example.app1;

import java.util.List;
import java.util.Vector;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;


public class MainActivity extends FragmentActivity implements OnClickListener {
	TextView monTexte = null;
	Button b = null;
	Button b1 = null;
	Button b2 = null;
	ListView liste = null;
	private PagerAdapter mPagerAdapter;
    EditText etResponse;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Cr�ation de la liste de Fragments que fera d�filer le PagerAdapter
		List<Fragment> fragments = new Vector<Fragment>();
        etResponse = (EditText) findViewById(R.id.Nom);
		// Ajout des Fragments dans la liste
		
		fragments.add(Fragment.instantiate(this,main.class.getName()));
		fragments.add(Fragment.instantiate(this,PageGaucheFragment.class.getName()));

		fragments.add(Fragment.instantiate(this,PageDroiteFragment.class.getName()));

		// Cr�ation de l'adapter qui s'occupera de l'affichage de la liste de
		// Fragments
		this.mPagerAdapter = new MyPagerAdapter(
				super.getSupportFragmentManager(), fragments);

		ViewPager pager = (ViewPager) super.findViewById(R.id.viewpager);
		// Affectation de l'adapter au ViewPager
		pager.setAdapter(this.mPagerAdapter);

		monTexte = (TextView) findViewById(R.id.Nom);
		monTexte.setText("");
		Button b = (Button) findViewById(R.id.buttonid1);
		b.setOnClickListener(this);
		Button b1 = (Button) findViewById(R.id.button2);
		// On attribut un �couteur d'�v�nement � tout les boutons

		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.google.fr"));
				startActivity(intent);
			}
		});
//		 Button b2 = (Button) findViewById(R.id.button3);
//		 b2.setOnClickListener(new View.OnClickListener() {
//		 public void onClick(View v) {
//		 Intent intent = new Intent(MainActivity.this,
//				 Listedroite.class);
//		 startActivity(intent);
//		 }
//		 });
       new HttpAsyncTask().execute("http://binouze.fabrigli.fr/bieres.json");

		// liste = (ListView) findViewById(R.id.listProg);
		// List<String> exemple = new ArrayList<String>();
		// exemple.add("PRODUIT N�_1");
		// exemple.add("PRODUIT N�_2");
		// exemple.add("PRODUIT N�_3");
		//
		// ArrayAdapter<String> adapter = new
		// ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
		// exemple);
		//
		// liste.setAdapter(adapter);
		//
		// liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		// @Override
		// public void onItemClick(AdapterView<?> adapterView, View view,int
		// position, long id) {
		// if (position==1){
		 //monTexte.setText("COU1111111111111111");
		// Intent intent = new Intent(MainActivity.this,
		// LoginDisplayActivity.class);
		// startActivity(intent);
		// }else{
		// monTexte.setText("COUCOU_BANDE DE NOUILL2E");
		// }
		// System.out.println(position);
		// }
		// });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		Intent intent = new Intent(MainActivity.this,
				LoginDisplayActivity.class);
		startActivity(intent);


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
            etResponse.setText(result);


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
    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }
}
