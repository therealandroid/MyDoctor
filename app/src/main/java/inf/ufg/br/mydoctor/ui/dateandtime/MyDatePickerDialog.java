package inf.ufg.br.mydoctor.ui.dateandtime;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;


/**
 * Created by alunoinf on 24/11/2016.
 */
public class MyDatePickerDialog extends DatePickerDialog {

    public MyDatePickerDialog() {

    }

    @Override
    public boolean isOutOfRange(int year, int month, int day) {
        // disable days that are odd
        return day % 2 == 0;
    }
}
