package reader.manga.uit.app;

import android.app.Application;

import io.realm.Realm;
import model.Const;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Const.setResource(getResources());
        Realm.init(this);
    }
}
