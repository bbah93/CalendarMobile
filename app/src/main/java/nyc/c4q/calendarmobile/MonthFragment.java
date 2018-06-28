package nyc.c4q.calendarmobile;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonthFragment extends Fragment {
    TextView monthText;
    TextView yearText;
    TextView dayText;
    FloatingActionButton setAppointmentButton;
    MonthPresenter presenter = new MonthPresenter();
    Calendar calendar = Calendar.getInstance();




    public MonthFragment() {
        // Required empty public constructor
    }

    private View rootView;
    private ViewPager viewPager;

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
        viewPager.setAdapter(new CalendarAdapter());
        viewPager.setCurrentItem(calendar.get(Calendar.MONTH));

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
            System.out.println(object == view);

            return object == view;
        }


        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position){

            View view = presenter.getMonthView(position, getActivity(), container);


             int year = calendar.get(Calendar.YEAR);
             Log.d(TAG, "MONTH: " + year);


            container.addView(view);


            yearText = view.findViewById(R.id.year_textView);

            dayText = view.findViewById(R.id.r1columnOne);

            yearText.setText(String.valueOf(year));

            //sey up logic for days on view of calendars


            Log.d(LOG_TAG, "instantiateItem() [position: " + position + "]");
            return view;

        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return super.getItemPosition(object);
        }

        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object){
            container.removeView((View) object);
            Log.d(LOG_TAG, "destroyItem() [position: " + position + "]");
        }
    }

}
