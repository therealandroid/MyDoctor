package inf.ufg.br.mydoctor.ui.speciality;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import inf.ufg.br.mydoctor.AndroidApplication;
import inf.ufg.br.mydoctor.R;
import inf.ufg.br.mydoctor.domain.presenter.SpecialtiesPresenter;
import models.Speciality;

public class SpecialityActivity extends AppCompatActivity implements SpecialtiesPresenter.SpecialitiesCallback {

    @BindView(R.id.speciality_recyclerview) RecyclerView specialityRecylerView;

    SpecialityAdapter adapter;

    @Inject SpecialtiesPresenter specialtiesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speciality);
        ButterKnife.bind(this);
        ((AndroidApplication) getApplication()).component().inject(this);
        initializeList();
        loadSpecialities();
        adapter = new SpecialityAdapter(this);
        getSupportActionBar().setTitle("Escolha a especialidade médica");
    }

    private void loadSpecialities() {
        specialtiesPresenter.loadLocals(this);
    }

    private void initializeList() {
        specialityRecylerView.setAdapter(adapter);
        specialityRecylerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onLoadSuccess(List<Speciality> locals) {
        adapter.setSpecialityList(locals);
    }

    @Override
    public void onLoadFailed(String message) {
        System.out.println();
    }

    @Override
    public void onLoadFinished() {
        System.out.println();
        adapter.notifyDataSetChanged();
    }
}
