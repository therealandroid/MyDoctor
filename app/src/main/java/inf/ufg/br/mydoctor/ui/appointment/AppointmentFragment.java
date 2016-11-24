package inf.ufg.br.mydoctor.ui.appointment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import inf.ufg.br.mydoctor.AndroidApplication;
import inf.ufg.br.mydoctor.R;
import inf.ufg.br.mydoctor.domain.presenter.LocalPresenter;
import inf.ufg.br.mydoctor.domain.presenter.SpecialtiesPresenter;
import inf.ufg.br.mydoctor.domain.presenter.UserPresenter;

/**
 * Created by diogojayme on 11/10/16.
 */

public class AppointmentFragment extends Fragment {

    @BindView(R.id.appointment_recycler_view) RecyclerView recyclerView;

    @Inject UserPresenter userPresenter;
    @Inject SpecialtiesPresenter specialtiesPresenter;
    @Inject LocalPresenter localPresenter;

    public static AppointmentFragment getInstance(int page){
        Bundle bundle = new Bundle();
        bundle.putInt("page", page);
        AppointmentFragment appointmentFragment = new AppointmentFragment();
        appointmentFragment.setArguments(bundle);
        return appointmentFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AndroidApplication) getActivity().getApplication()).component().inject(this); //Inject context

        View view =  inflater.inflate(R.layout.fragment_appointment, container, false);
        int page = getArguments().getInt("page");

        switch (page){
            case AppointmentPagerAdapter.SPECIALITIES:
                break;
            case AppointmentPagerAdapter.LOCAL:
                break;
            case AppointmentPagerAdapter.DOCTORS:
                break;
        }

        return view;
    }
}
