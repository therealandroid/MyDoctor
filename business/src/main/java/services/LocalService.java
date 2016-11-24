package services;

import java.util.List;

import models.Local;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by diogojayme on 10/13/16.
 */

public interface LocalService {

    @GET("/locals/{specialist_id}")
    Observable<List<Local>> loadLocals(@Path("specialist_id") long id);
}
