package inf.ufg.br.mydoctor.presenter;

import android.app.Activity;

import java.util.HashMap;

import javax.inject.Inject;

import inf.ufg.br.mydoctor.utils.AndroidApplication;
import inf.ufg.br.mydoctor.utils.security.Encrypt;
import models.User;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import services.AuthService;


/**
 * Created by diogojayme on 10/4/16.
 */

public class AuthPresenter {

    @Inject
    Retrofit retrofit;

    public AuthPresenter(Activity activity){
        ((AndroidApplication) activity.getApplication()).component().inject(this);
        int a = 1;
    }

    public void authUser(String email, String password, final AuthCallback callback) {
        HashMap<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("password", Encrypt.toMd5(password));

        retrofit.create(AuthService.class).auth()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {
                        callback.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(User user) {
                        callback.showUser(user);
                    }
                });
    }

    public void registerUser(User user, final AuthCallback callback) {
        HashMap<String, String> body = new HashMap<>();

        retrofit.create(AuthService.class).register()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {
                        callback.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(User user) {
                        callback.showUser(user);
                    }
                });
    }


    public interface AuthCallback {
        void showUser(User user);

        void showError(String message);

        void showComplete();
    }

}
