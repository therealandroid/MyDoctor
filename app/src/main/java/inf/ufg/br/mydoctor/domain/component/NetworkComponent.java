package inf.ufg.br.mydoctor.domain.component;

import javax.inject.Singleton;

import dagger.Component;
import inf.ufg.br.mydoctor.domain.modules.PresenterModule;
import inf.ufg.br.mydoctor.ui.AuthenticationActivity;
import module.NetModule;

/**
 * Created by diogojayme on 10/20/16.
 */

@Singleton
@Component(modules = { NetModule.class, PresenterModule.class})
public interface NetworkComponent {
    void inject(AuthenticationActivity authenticationActivity);
}
