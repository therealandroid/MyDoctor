package inf.ufg.br.mydoctor.utils;

import android.app.Application;

import inf.ufg.br.mydoctor.domain.component.NetworkComponent;
import inf.ufg.br.mydoctor.domain.component.DaggerNetworkComponent;
import module.NetModule;

/**
 * Created by diogojayme on 9/30/16.
 */

public class AndroidApplication extends Application {

    NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        networkComponent = DaggerNetworkComponent
                .builder()
                .netModule(new NetModule(Constants.BASE_URL))
                .build();
    }


    public NetworkComponent component() {
        return this.networkComponent;
    }

}
