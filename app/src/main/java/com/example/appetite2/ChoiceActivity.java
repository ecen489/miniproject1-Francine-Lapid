package com.example.appetite2;

//import android.app.Fragment;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ChoiceActivity extends AppCompatActivity
        implements FirstFragment.OnFragmentInteractionListener, SecondFragment.OnFragmentInteractionListener{

    Button firstFragment, secondFragment;
    String[] creditsArray = {"Francine Lapid", "ECEN 489", "Spring 2019"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);


        ArrayAdapter adapter = new ArrayAdapter<String> (this, R.layout.activity_listview, creditsArray);

        ListView creditsList = (ListView) findViewById(R.id.listView);
        creditsList.setAdapter(adapter);


        firstFragment = (Button) findViewById(R.id.firstFragment);
        secondFragment = (Button) findViewById(R.id.secondFragment);

        firstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FirstFragment());
            }
        });
        secondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SecondFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment) {

        //FragmentManager fm = getFragmentManager();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }

    //@Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

    // public void onFragmentInteractionListener
}
