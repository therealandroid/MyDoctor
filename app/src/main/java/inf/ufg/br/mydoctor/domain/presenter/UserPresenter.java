package inf.ufg.br.mydoctor.domain.presenter;

import java.util.HashMap;
import java.util.List;

import models.User;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import services.UserService;

/**
 * Created by diogojayme on 10/13/16.
 */

public class UserPresenter {

    UserService userService;

    public UserPresenter(UserService userService){
        this.userService = userService;
    }

    public interface EditUserCallback{
        void editFinished();
        void editSuccess();
        void editFailed(String message);
    }

    public interface LoadDoctorCallback{
        void onSuccess(List<User> users);
        void onFailed();
    }

    public void editUser(String parameterName, String parameterValue, final EditUserCallback callback) {
        HashMap<String, String> body = new HashMap<>();
        body.put(parameterName, parameterValue);

        userService.edit(body)
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

    public void loadDoctors(int localId, int specialitieId, final LoadDoctorCallback callback) {
        userService.loadDoctors(localId, specialitieId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailed();
                    }

                    @Override
                    public void onNext(List<User> user) {
                        callback.onSuccess(user);
                    }
                });
    }
}
