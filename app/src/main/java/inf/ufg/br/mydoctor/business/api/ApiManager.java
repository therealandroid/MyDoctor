package inf.ufg.br.mydoctor.business.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diogojayme on 10/4/16.
 */

public class ApiManager {
    private static Retrofit retrofit;
    static final String BASE_URL = "https://private-0c768-mydoctor1.apiary-mock.com";

    public static Retrofit getInstance(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }

        return retrofit;
    }


}
