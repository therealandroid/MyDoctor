package inf.ufg.br.mydoctor.ui.checkout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import inf.ufg.br.mydoctor.R;

/**
 * Created by diogojayme on 11/24/16.
 */

public class CheckoutActivity extends AppCompatActivity {

    @BindView(R.id.confirm_checkbox)
    CheckBox checkBox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        ButterKnife.bind(this);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Confirmar Agendamento");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.checkout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            super.onBackPressed();
        }else if(item.getItemId() == R.id.action_confirm){
            if(!checkBox.isChecked()){
                Toast.makeText(this, "Confirme o horario de agendamento", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Obrigado! Seu horario foi agendado", Toast.LENGTH_SHORT).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
