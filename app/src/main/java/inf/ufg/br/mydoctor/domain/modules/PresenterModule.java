package inf.ufg.br.mydoctor.domain.modules;

import dagger.Module;
import dagger.Provides;
import inf.ufg.br.mydoctor.domain.presenter.AuthPresenter;
import services.AuthService;

/**
 * Created by diogojayme on 10/20/16.
 */

@Module
public class PresenterModule {

    @Provides
    public AuthPresenter provideAuthPresenter(AuthService authService){
        return new AuthPresenter(authService);
    }
}
