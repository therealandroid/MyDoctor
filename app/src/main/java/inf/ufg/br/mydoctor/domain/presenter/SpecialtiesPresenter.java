package inf.ufg.br.mydoctor.domain.presenter;

import java.util.List;

import models.Speciality;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import services.SpecialitiesService;

/**
 * Created by diogojayme on 10/13/16.
 */

public class SpecialtiesPresenter {
    Retrofit retrofit;

    public SpecialtiesPresenter(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    public void loadLocals(final SpecialitiesCallback callback) {
        retrofit.create(SpecialitiesService.class).loadSpecialities()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Speciality>>() {
                    @Override
                    public void onCompleted() {
                        callback.onLoadFinished();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onLoadFailed(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Speciality> locals) {
                        callback.onLoadSuccess(locals);
                    }
                });
    }

    public interface SpecialitiesCallback{
        void onLoadSuccess(List<Speciality> locals);
        void onLoadFailed(String message);
        void onLoadFinished();
    }
}
