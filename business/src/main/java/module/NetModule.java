package module;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diogojayme on 10/20/16.
 */

@Module
public class NetModule {

    private String baseUrl;

    public NetModule(String b){
        this.baseUrl = b;
    }

    @Provides
    public Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }
}
