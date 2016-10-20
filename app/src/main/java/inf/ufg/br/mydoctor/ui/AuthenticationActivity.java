package inf.ufg.br.mydoctor.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import inf.ufg.br.mydoctor.R;
import inf.ufg.br.mydoctor.domain.presenter.AuthPresenter;
import inf.ufg.br.mydoctor.utils.AndroidApplication;
import inf.ufg.br.mydoctor.utils.IntentProxy;
import models.User;

public class AuthenticationActivity extends AppCompatActivity  implements AuthPresenter.AuthCallback{

    @BindView(R.id.login_email_field) EditText email;
    @BindView(R.id.login_password_field) EditText password;
    @BindView(R.id.login_submit_button) Button submit;

    @Inject AuthPresenter authPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ((AndroidApplication) getApplication()).component().inject(this);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle("MyDoctor");
        }
    }

    @OnClick(R.id.login_submit_button) public void onSubmitClick(View view){
        doLogin(email.getText().toString(), password.getText().toString());
    }

    @OnClick(R.id.login_go_to_register) public void onRegisterClick(View view){
        startActivity(new Intent(this, RegisterActivity.class));
    }

    /***
     * Autenticação de usuário [RF-01 LOGIN]
     *
     * @param username or email
     * @param password
     */
    private void  doLogin(String username, String password){
        submit.setEnabled(false);
        authPresenter.authUser(username, password, this);
    }

    @Override
    public void showUser(User user) {
        submit.setText("Sucesso");
        IntentProxy.loginToHome(this, "username", user.getFirstName());
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
