package inf.ufg.br.mydoctor.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import inf.ufg.br.mydoctor.R;

public class UpdateProfileActivity extends AppCompatActivity {

    @BindView(R.id.profile_img) ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        ButterKnife.bind(this);
        Picasso.with(this).load(R.drawable.bruno).into(profileImage);
    }
}
