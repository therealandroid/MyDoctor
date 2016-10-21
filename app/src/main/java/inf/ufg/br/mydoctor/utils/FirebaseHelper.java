package inf.ufg.br.mydoctor.utils;

import com.google.firebase.database.DatabaseReference;

import javax.inject.Inject;

/**
 * Created by diogojayme on 10/21/16.
 */

public class FirebaseHelper<T> {

    @Inject DatabaseReference databaseReference;

    @Inject
    public FirebaseHelper(){

    }

    public void writeObject(String id, T t){
        System.out.println(id);
    }
}
