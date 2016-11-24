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
import models.Specialties;

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

        loadSpecialities();
        getSupportActionBar().setTitle("Escolha a especialidade médica");
    }

    private void loadSpecialities() {
        specialtiesPresenter.loadLocals(this);
    }

    @Override
    public void onLoadSuccess(List<Specialties> locals) {
        adapter = new SpecialityAdapter(this);
        specialityRecylerView.setLayoutManager(new LinearLayoutManager(this));
        specialityRecylerView.setAdapter(adapter);
        adapter.setSpecialtiesList(locals);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadFailed(String message) {
    }

    @Override
    public void onLoadFinished() {
    }
}
