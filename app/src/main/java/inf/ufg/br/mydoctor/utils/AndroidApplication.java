package inf.ufg.br.mydoctor.utils;

import android.app.Application;

import inf.ufg.br.mydoctor.Constants;
import inf.ufg.br.mydoctor.component.DaggerNetComponent;
import inf.ufg.br.mydoctor.component.NetComponent;
import module.NetModule;

/**
 * Created by diogojayme on 9/30/16.
 */

public class AndroidApplication extends Application {

    NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        netComponent = DaggerNetComponent
                .builder()
                .netModule(new NetModule(Constants.BASE_URL))
                .build();

    }


    public NetComponent component() {
        return this.netComponent;
    }
}
