package inf.ufg.br.mydoctor.presenter;

import java.util.HashMap;

import models.User;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import services.UserService;

/**
 * Created by diogojayme on 10/13/16.
 */

public class UserPresenter {
    Retrofit retrofit;

    public UserPresenter(){
    }

    public interface EditUserCallback{
        void editFinished();
        void editSuccess();
        void editFailed(String message);
    }

    public void editUser(String parameterName, String parameterValue, final EditUserCallback callback) {
        HashMap<String, String> body = new HashMap<>();
        body.put(parameterName, parameterValue);

        retrofit.create(UserService.class).edit(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {
                        callback.editFinished();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.editFailed(e.getMessage());
                    }

                    @Override
                    public void onNext(User user) {
                        callback.editSuccess();
                    }
                });
    }
}
