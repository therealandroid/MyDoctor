package services;

import models.User;
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
