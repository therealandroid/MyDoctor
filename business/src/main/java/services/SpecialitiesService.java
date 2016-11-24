package services;

import java.util.List;

import models.Speciality;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by diogojayme on 10/13/16.
 */

public interface SpecialitiesService {

    @GET("/specialities")
    Observable<List<Speciality>> loadSpecialities();
}
