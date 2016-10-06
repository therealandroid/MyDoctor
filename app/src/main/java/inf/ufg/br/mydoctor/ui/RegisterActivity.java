package inf.ufg.br.mydoctor.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import inf.ufg.br.mydoctor.R;
import inf.ufg.br.mydoctor.business.models.User;
import inf.ufg.br.mydoctor.presenter.AuthPresenter;

public class RegisterActivity extends AppCompatActivity  implements AuthPresenter.AuthCallback{

    @BindView(R.id.register_email_field) EditText email;
    @BindView(R.id.register_password_field) EditText password;
    @BindView(R.id.register_first_name_field) EditText firstName;
    @BindView(R.id.register_last_name_field) EditText lastName;
    @BindView(R.id.register_phone_field) EditText phone;
    @BindView(R.id.register_submit_button) Button submit;

    AuthPresenter authPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        authPresenter = new AuthPresenter();
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Cadastrar");
        }
    }

    @OnClick(R.id.register_submit_button) public void onSubmitClick(View view){
        User user = new User(firstName.getText().toString(), lastName.getText().toString(), password.getText().toString(), phone.getText().toString(), email.getText().toString());
        doRegister(user);
    }

    /***
     * Registrar usuário [RF-02 register]
     *
     * @param user
     */
    private void doRegister(User user){
        submit.setEnabled(false);
        authPresenter.registerUser(user, this);
    }

    @Override
    public void showUser(User user) {
        submit.setEnabled(false);
        submit.setText("Sucesso");
    }

    @Override
    public void showError(String message) {
        submit.setEnabled(true);
        submit.setText("Falhou");
        submit.setVisibility(View.VISIBLE);
    }

    @Override
    public void showComplete() {

    }
}
