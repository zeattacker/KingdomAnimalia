package app.android.kingdomanimalia;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Unknown on 28/04/2016.
 */
public class AppHandler extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(config);
    }
}
