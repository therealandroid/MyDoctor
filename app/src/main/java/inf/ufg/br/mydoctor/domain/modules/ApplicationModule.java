package inf.ufg.br.mydoctor.domain.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import inf.ufg.br.mydoctor.R;

/**
 * Created by diogojayme on 10/21/16.
 */

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(){
        return application.getSharedPreferences(application.getString(R.string.app_name), Context.MODE_PRIVATE);
    }
}
