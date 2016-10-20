package services;

import java.util.List;

import models.Specialties;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by diogojayme on 10/13/16.
 */

public interface SpecialitiesService {

    @GET("/locals/1/specialties")
    Observable<List<Specialties>> loadSpecialities();
}
