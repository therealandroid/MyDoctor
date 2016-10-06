package inf.ufg.br.mydoctor.business.services;

import inf.ufg.br.mydoctor.business.models.User;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by diogojayme on 9/30/16.
 */

public interface AuthService {

    @GET("/auth/login")
    Observable<User> auth();

    @GET("/auth/activity_register")
    Observable<User> register();

}
