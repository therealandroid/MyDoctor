package inf.ufg.br.mydoctor.domain.modules;

import dagger.Module;
import dagger.Provides;
import inf.ufg.br.mydoctor.domain.presenter.AuthPresenter;
import inf.ufg.br.mydoctor.domain.presenter.LocalPresenter;
import inf.ufg.br.mydoctor.domain.presenter.SpecialtiesPresenter;

import inf.ufg.br.mydoctor.domain.presenter.UserPresenter;
import services.AuthService;
import services.LocalService;
import services.SpecialitiesService;
import services.UserService;
import retrofit2.Retrofit;

/**
 * Created by diogojayme on 10/20/16.
 */

@Module
public class PresenterModule {

    @Provides
    public AuthPresenter provideAuthPresenter(AuthService authService){
        return new AuthPresenter(authService);
    }

    @Provides
    public LocalPresenter provideLocalPresenter(LocalService localService){
        return new LocalPresenter(localService);
    }

    @Provides
    public SpecialtiesPresenter provideSpecialtiesPresenter(SpecialitiesService specialitiesService){
        return new SpecialtiesPresenter(specialitiesService);
    }

    @Provides
    public UserPresenter provideUserPresenter(UserService userService){
        return new UserPresenter(userService);
    }

}
