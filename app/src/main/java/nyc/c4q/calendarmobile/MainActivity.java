package nyc.c4q.calendarmobile;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton createEventButton;
    MonthFragment monthFragment = new MonthFragment();
    EventFragment eventFragment = new EventFragment();

    //TODO: Create RecyclerView for individual day view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createEventButton = findViewById(R.id.createEvent_FAB);

        if (savedInstanceState == null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, monthFragment);
            transaction.commit();
        }

        createEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction()
                        .add(R.id.fragment_container, eventFragment)
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .show(eventFragment)
                        .hide(monthFragment)
                        .commit();

                createEventButton.setVisibility(View.INVISIBLE);
            }
        });
    }

}
