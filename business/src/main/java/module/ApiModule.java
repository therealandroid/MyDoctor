package module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import services.AuthService;
import services.LocalService;
import services.SpecialitiesService;
import services.UserService;

/**
 * Created by diogojayme on 10/21/16.
 */

@Module
public class ApiModule {

    @Singleton
    @Provides
    AuthService provideAuthService(Retrofit retrofit) {
        return retrofit.create(AuthService.class);
    }

    @Singleton
    @Provides
    UserService provideUserService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }

    @Singleton
    @Provides
    SpecialitiesService provideSpecialitiesService(Retrofit retrofit) {
        return retrofit.create(SpecialitiesService.class);
    }

    @Singleton
    @Provides
    LocalService provideLocalService(Retrofit retrofit) {
        return retrofit.create(LocalService.class);
    }

}
