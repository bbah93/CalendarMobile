package nyc.c4q.calendarmobile;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

public class MonthPresenter {

    MonthFragment monthFragment;

    public View getMonthView(int itemPosition, Activity activity, ViewGroup container){
        View monthView = null;

        switch (itemPosition){
            case 0: monthView = activity.getLayoutInflater().inflate(R.layout.january_pager_item, container,false);
                    break;
            case 1: monthView = activity.getLayoutInflater().inflate(R.layout.feb_pager_item, container,false);
                    break;
            case 2: monthView = activity.getLayoutInflater().inflate(R.layout.march_pager_item, container,false);
                    break;
            case 3: monthView = activity.getLayoutInflater().inflate(R.layout.april_pager_item, container,false);
                    break;
            case 4: monthView = activity.getLayoutInflater().inflate(R.layout.may_pager_item, container,false);
                    break;
            case 5: monthView = activity.getLayoutInflater().inflate(R.layout.june_pager_item, container,false);
                    break;
            case 6: monthView = activity.getLayoutInflater().inflate(R.layout.july_pager_item, container,false);
                    break;
            case 7: monthView = activity.getLayoutInflater().inflate(R.layout.august_pager_item, container,false);
                    break;
            case 8: monthView = activity.getLayoutInflater().inflate(R.layout.sept_pager_item, container,false);
                    break;
            case 9: monthView = activity.getLayoutInflater().inflate(R.layout.october_pager_item, container,false);
                break;
            case 10: monthView = activity.getLayoutInflater().inflate(R.layout.november_pager_item, container,false);
                    break;
            case 11: monthView = activity.getLayoutInflater().inflate(R.layout.december_pager_item, container,false);
                        break;
        }

        return monthView;
    }

    public void currentDayHighlight(View viewMonth, Calendar calendar){
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        ViewGroup rowOne = viewMonth.findViewById(R.id.rowOne);
        ViewGroup rowTwo = viewMonth.findViewById(R.id.rowTwo);
        ViewGroup rowThree = viewMonth.findViewById(R.id.rowThree);
        ViewGroup rowFour = viewMonth.findViewById(R.id.rowFour);
        ViewGroup rowFive = viewMonth.findViewById(R.id.rowFive);



        ViewGroup[] layoutArray = {rowOne, rowTwo, rowThree, rowFour, rowFive};

        for (int i = 0; i < layoutArray.length; i++){
            for (int j = 0; j < layoutArray[i].getChildCount(); j++){

                TextView dayView = (TextView) layoutArray[i].getChildAt(j);
                String dayText = ((TextView)layoutArray[i].getChildAt(j)).getText().toString();

                if(!dayText.equals("#") && !dayText.isEmpty()){
                    if(Integer.parseInt(dayText) == currentDay){
                        dayView.setBackgroundColor(Color.parseColor("#1db954"));
                        break;
                }
              }
            }
        }
    }

    public void dayViewListener(View day, final FragmentActivity fragActivity){

        //TODO: Set up clicklistener logic to see individual days
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventFragment eventFragment = new EventFragment();

                FragmentTransaction transaction = fragActivity.getSupportFragmentManager().beginTransaction();
                transaction.hide(monthFragment);
                transaction.show(eventFragment);
                transaction.commit();
            }
        });
    }
}
