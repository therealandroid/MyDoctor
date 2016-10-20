package inf.ufg.br.mydoctor.component;

import javax.inject.Singleton;

import dagger.Component;
import inf.ufg.br.mydoctor.presenter.AuthPresenter;
import module.NetModule;

/**
 * Created by diogojayme on 10/20/16.
 */

@Singleton
@Component(modules = NetModule.class)
public interface NetComponent {
    void inject(AuthPresenter presenter);
}
