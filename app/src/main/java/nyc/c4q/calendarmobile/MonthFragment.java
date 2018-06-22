package nyc.c4q.calendarmobile;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonthFragment extends Fragment {


    public MonthFragment() {
        // Required empty public constructor
    }

    private View rootView;
    private ViewPager viewPager;
    private CalendarAdapter calendarAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_calendar, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        viewPager = view.findViewById(R.id.viewpager);
        viewPager.setAdapter(calendarAdapter);
    }



    //inner class adapter
    public class CalendarAdapter extends PagerAdapter {


        private static final String LOG_TAG = "ITEM: " ;

        @Override
        public int getCount() {
            return 12;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return object == view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position){

            View view = getActivity().getLayoutInflater()
                    .inflate(R.layout.monthpager_item, container, false);

            container.addView(view);

            return view;

        }

        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object){
            container.removeView((View) object);
            Log.i(LOG_TAG, "destroyItem() [position: " + position + "]");
        }
    }

}
