package inf.ufg.br.mydoctor.business.services;

import inf.ufg.br.mydoctor.business.models.User;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by diogojayme on 9/30/16.
 */

public interface AuthService {

    @POST("/auth/login")
    Observable<User> auth();

    @POST("/auth/register")
    Observable<User> register();

}
