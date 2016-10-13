package inf.ufg.br.mydoctor.business.services;

import java.util.Map;

import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by diogojayme on 9/30/16.
 */

public interface UserService {
    @POST("/user/edit")
    Observable edit(Map body);
}
