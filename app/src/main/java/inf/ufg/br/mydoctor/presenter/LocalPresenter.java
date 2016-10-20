package inf.ufg.br.mydoctor.presenter;

import java.util.List;

import models.Local;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import services.LocalService;

/**
 * Created by diogojayme on 10/13/16.
 */

public class LocalPresenter {

    Retrofit retrofit;

    public LocalPresenter(){
    }

    public void loadLocals(final LocalCallback callback) {
        retrofit.create(LocalService.class).loadLocals()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Local>>() {
                    @Override
                    public void onCompleted() {
                        callback.onLoadFinished();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onLoadFailed(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Local> locals) {
                        callback.onLoadSuccess(locals);
                    }
                });
    }

    public interface LocalCallback{
        void onLoadSuccess(List<Local> locals);
        void onLoadFailed(String message);
        void onLoadFinished();
    }

}
