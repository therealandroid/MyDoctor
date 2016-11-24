package inf.ufg.br.mydoctor.ui.dateandtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import inf.ufg.br.mydoctor.R;

public class ChooseDateActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_date);
        showCalendar();
    }

    private void showCalendar() {
        Calendar now = Calendar.getInstance();
        MyDatePickerDialog dpd = new MyDatePickerDialog();
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

    }
}
