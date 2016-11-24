package services;

import java.util.List;
import java.util.Map;

import models.User;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by diogojayme on 9/30/16.
 */

public interface UserService {
    @POST("/user/edit")
    Observable edit(Map body);

    @GET("/locals/{local_id}/specialities/{specialities_id}/doctors")
    Observable<List<User>> loadDoctors(@Path("local_id") int localId, @Path("specialities_id") int specialistId);
}
