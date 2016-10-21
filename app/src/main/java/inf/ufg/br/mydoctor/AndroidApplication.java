package inf.ufg.br.mydoctor;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import inf.ufg.br.mydoctor.domain.component.ApiComponent;
import inf.ufg.br.mydoctor.domain.component.DaggerApiComponent;
import inf.ufg.br.mydoctor.domain.modules.ApplicationModule;
import inf.ufg.br.mydoctor.domain.modules.PresenterModule;
import inf.ufg.br.mydoctor.utils.Constants;
import module.ApiModule;
import module.NetModule;

/**
 * Created by diogojayme on 9/30/16.
 */

public class AndroidApplication extends Application {

    private ApiComponent apiComponent;

    private static final String TOPIC_FOLLOWING = "following";

    @Override
    public void onCreate() {
        super.onCreate();
        apiComponent = DaggerApiComponent
                .builder()
                .apiModule(new ApiModule())
                .applicationModule(new ApplicationModule(this))
                .presenterModule(new PresenterModule())
                .netModule(new NetModule(Constants.BASE_URL))
                .build();

        FirebaseApp.initializeApp(this);
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC_FOLLOWING);
        String token = FirebaseInstanceId.getInstance().getToken();
        System.out.println(token);
    }

    public ApiComponent component() {
        return this.apiComponent;
    }

}
