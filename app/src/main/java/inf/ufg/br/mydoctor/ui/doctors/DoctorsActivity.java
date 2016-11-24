package inf.ufg.br.mydoctor.ui.doctors;

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
import inf.ufg.br.mydoctor.domain.presenter.UserPresenter;
import models.User;

public class DoctorsActivity extends AppCompatActivity implements UserPresenter.LoadDoctorCallback{

    @BindView(R.id.locals_recyclerview) RecyclerView localsRecyclerView;

    @Inject
    UserPresenter userPresenter;

    DoctorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locals);
        ButterKnife.bind(this);
        adapter = new DoctorAdapter(this);
        ((AndroidApplication) getApplication()).component().inject(this);
        initializeList();
        userPresenter.loadDoctors(1, 1, this);
    }

    private void initializeList() {
        localsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        localsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onSuccess(List<User> users) {
        adapter.setUsers(users);
    }

    @Override
    public void onFailed() {

    }
}
