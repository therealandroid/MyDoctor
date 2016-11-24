package inf.ufg.br.mydoctor.domain.modules;

import dagger.Module;
import dagger.Provides;
import inf.ufg.br.mydoctor.domain.presenter.AuthPresenter;
import inf.ufg.br.mydoctor.domain.presenter.LocalPresenter;
import inf.ufg.br.mydoctor.domain.presenter.SpecialtiesPresenter;
import retrofit2.Retrofit;

/**
 * Created by diogojayme on 10/20/16.
 */

@Module
public class PresenterModule {

    @Provides
    public AuthPresenter provideAuthPresenter(Retrofit retrofit){
        return new AuthPresenter(retrofit);
    }

    @Provides
    public SpecialtiesPresenter provideSpecialitiesPresenter(Retrofit retrofit){
        return new SpecialtiesPresenter(retrofit);
    }

    @Provides
    public LocalPresenter provideLocalPresenter(Retrofit retrofit){
        return new LocalPresenter(retrofit);
    }
}
