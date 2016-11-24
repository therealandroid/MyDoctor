package inf.ufg.br.mydoctor.domain.component;

import javax.inject.Singleton;

import dagger.Component;
import inf.ufg.br.mydoctor.domain.modules.ApplicationModule;
import inf.ufg.br.mydoctor.domain.modules.PresenterModule;
import inf.ufg.br.mydoctor.ui.appointment.AppointmentFragment;
import inf.ufg.br.mydoctor.ui.AuthenticationActivity;

import module.ApiModule;

import inf.ufg.br.mydoctor.ui.locals.LocalsActivity;
import inf.ufg.br.mydoctor.ui.speciality.SpecialityActivity;
import module.NetModule;

/**
 * Created by diogojayme on 10/20/16.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class, PresenterModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(AuthenticationActivity authenticationActivity);
    void inject(AppointmentFragment fragment);
    void inject(SpecialityActivity specialityActivity);
    void inject(LocalsActivity localsActivity);
}
