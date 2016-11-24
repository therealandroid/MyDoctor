package inf.ufg.br.mydoctor.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.ButterKnife;
import butterknife.OnClick;
import inf.ufg.br.mydoctor.R;
import inf.ufg.br.mydoctor.ui.profile.UpdateProfileActivity;
import inf.ufg.br.mydoctor.ui.speciality.SpecialityActivity;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.book_container)
    public void onBookClick() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            updateProfile();
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateProfile() {
        startActivity(new Intent(this, UpdateProfileActivity.class));
    }

    @OnClick(R.id.book_container)
    public void onAgendaClick() {
        startActivity(new Intent(HomeActivity.this, SpecialityActivity.class));
    }
}
