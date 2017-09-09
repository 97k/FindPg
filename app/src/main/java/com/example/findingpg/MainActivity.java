package com.example.findingpg;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    TextView LocationTv;
    Spinner locationSpinner;
    String userChoice = "";
    PgAdapter locationArrayAdaptor;

    private ArrayList<String> locationData;

    // Firebase instance variables.
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mFirebaseDatabaseReference; // To read from the database we need a database reference.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseDatabaseReference = mFirebaseDatabase.getReference().child("city");
        LocationTv = (TextView) findViewById(R.id.location_tv);
        DataAsyncTask dataAsyncTask = new DataAsyncTask();
        dataAsyncTask.execute(mFirebaseDatabaseReference);

        locationSpinner = (Spinner) findViewById(R.id.spinner_location);
//        locationArrayAdaptor.notifyDataSetChanged();


//        locationSpinner.setAdapter(locationArrayAdaptor);
//        Log.e(TAG, "clicked value is " + locationArrayAdaptor.getString());





//        ArrayAdapter<String> locationArrayAdaptor = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
//                locationData);

        // Specify dropdown layout style - simple list view with 1 item per line
//        locationArrayAdaptor.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner.






    }

    private class DataAsyncTask extends AsyncTask<DatabaseReference, Void, ArrayList<String>>{



        @Override
        protected ArrayList<String> doInBackground(DatabaseReference... databaseReferences) {
            FirebaseHelper helper = new FirebaseHelper(databaseReferences[0]);
            return helper.retrieve();
        }

        @Override
        protected void onPostExecute(ArrayList<String> strings) {

            //super.onPostExecute(strings);
            locationData = strings;
            locationArrayAdaptor = new PgAdapter(getApplicationContext(), strings);
            locationSpinner.setAdapter(locationArrayAdaptor);
            locationArrayAdaptor.notifyDataSetChanged();



        }
    }
}

