package inf.ufg.br.mydoctor.domain.presenter;

import java.util.List;

import models.Specialties;
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

    public SpecialtiesPresenter(){
    }

    public void loadLocals(final SpecialitiesCallback callback) {
        retrofit.create(SpecialitiesService.class).loadSpecialities()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Specialties>>() {
                    @Override
                    public void onCompleted() {
                        callback.onLoadFinished();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onLoadFailed(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Specialties> locals) {
                        callback.onLoadSuccess(locals);
                    }
                });
    }

    public interface SpecialitiesCallback{
        void onLoadSuccess(List<Specialties> locals);
        void onLoadFailed(String message);
        void onLoadFinished();
    }
}
