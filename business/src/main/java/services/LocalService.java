package services;

import java.util.List;

import models.Local;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by diogojayme on 10/13/16.
 */

public interface LocalService {

    @GET("/locals")
    Observable<List<Local>> loadLocals();
}
