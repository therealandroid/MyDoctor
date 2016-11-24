package inf.ufg.br.mydoctor.ui.appointment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import inf.ufg.br.mydoctor.R;

/**
 * Created by diogojayme on 11/10/16.
 */

public class AppointmentActivity extends AppCompatActivity{

    @BindView(R.id.appointment_pager) ViewPager pager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        ButterKnife.bind(this);

        pager.setAdapter(new AppointmentPagerAdapter(getSupportFragmentManager()));
    }
}
