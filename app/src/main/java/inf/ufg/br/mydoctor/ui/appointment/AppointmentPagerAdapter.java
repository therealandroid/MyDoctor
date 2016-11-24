package inf.ufg.br.mydoctor.ui.appointment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by diogojayme on 11/10/16.
 */

public class AppointmentPagerAdapter extends FragmentPagerAdapter {

    public static final int TOTAL_ITEMS = 3;

    public AppointmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return TOTAL_ITEMS;
    }
}
