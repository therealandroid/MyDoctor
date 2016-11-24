package inf.ufg.br.mydoctor.ui.locals;

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
import inf.ufg.br.mydoctor.domain.presenter.LocalPresenter;
import models.Local;

public class LocalsActivity extends AppCompatActivity implements LocalPresenter.LocalCallback {

    @BindView(R.id.locals_recyclerview) RecyclerView localsRecyclerView;

    @Inject LocalPresenter localPresenter;

    LocalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locals);
        ButterKnife.bind(this);
        adapter = new LocalAdapter(this);
        ((AndroidApplication) getApplication()).component().inject(this);
        initializeList();
        loadLocals(3);
    }

    private void loadLocals(int id) {
        localPresenter.loadLocals(id, this);
    }

    private void initializeList() {
        localsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        localsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onLoadSuccess(List<Local> locals) {
        adapter.setLocals(locals);
    }

    @Override
    public void onLoadFailed(String message) {

    }

    @Override
    public void onLoadFinished() {

    }
}
