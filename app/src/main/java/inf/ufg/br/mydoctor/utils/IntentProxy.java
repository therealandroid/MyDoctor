package inf.ufg.br.mydoctor.utils;

import android.app.Activity;
import android.content.Intent;

import inf.ufg.br.mydoctor.ui.HomeActivity;

/**
 * Created by diogojayme on 10/13/16.
 */

public class IntentProxy {


    /***
     * TODO Mapear todos os parametros que vão passar para a outra tela
     * param map[keys,values] {"username", "Diogo"}
     *
     */
    public static void loginToHome(Activity fromActivity, String key, String extra){
        Intent intent = new Intent(fromActivity, HomeActivity.class);
        intent.putExtra(key, extra);
        fromActivity.startActivity(intent);
    }


}
