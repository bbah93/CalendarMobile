package nyc.c4q.calendarmobile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {
    View rootView;

    public EventFragment() {
        // Required empty public constructor
    }

    //TODO: Add functions for Cancel and Submit
    //TODO: Add button to set date(day)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.event, container, false);

        return rootView;
    }

}
