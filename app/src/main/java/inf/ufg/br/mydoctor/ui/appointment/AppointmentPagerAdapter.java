package inf.ufg.br.mydoctor.ui.appointment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by diogojayme on 11/10/16.
 */

public class AppointmentPagerAdapter extends FragmentPagerAdapter {

    public static final int SPECIALITIES = 0;
    public static final int LOCAL = 1;
    public static final int DOCTORS = 2;

    public static final int TOTAL_ITEMS = 3;

    public AppointmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return AppointmentFragment.getInstance(position);
    }

    @Override
    public int getCount() {
        return TOTAL_ITEMS;
    }
}
