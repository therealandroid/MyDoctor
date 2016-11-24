package inf.ufg.br.mydoctor.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import inf.ufg.br.mydoctor.R;
import inf.ufg.br.mydoctor.ui.profile.UpdateProfileActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_settings){
            updateProfile();
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateProfile() {
        startActivity(new Intent(this, UpdateProfileActivity.class));
    }
}
