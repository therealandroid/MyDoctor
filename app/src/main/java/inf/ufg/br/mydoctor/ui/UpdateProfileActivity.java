package inf.ufg.br.mydoctor.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import inf.ufg.br.mydoctor.R;

public class UpdateProfileActivity extends AppCompatActivity {

    @BindView(R.id.user_image) ImageView profileImage;
    @BindView(R.id.radio_male) RadioButton radioMale;
    @BindView(R.id.radio_female) RadioButton radioFemale;
    @BindView(R.id.radio_pacient) RadioButton radioPacient;
    @BindView(R.id.radio_professional) RadioButton radioProfessional;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        ButterKnife.bind(this);
        Picasso.with(this).load(R.drawable.bruno).into(profileImage);
    }


    @OnClick(R.id.radio_male) public void onMaleClick(View view){

    }

    @OnClick(R.id.radio_female) public void onFemaleClick(View view){
        radioMale.setActivated(false);
    }

    @OnClick(R.id.radio_pacient) public void onPacientClick(View view){
        radioProfessional.setActivated(false);
    }

    @OnClick(R.id.radio_professional) public void onProfessionalClick(View view){
        radioPacient.setActivated(false);
    }
}
