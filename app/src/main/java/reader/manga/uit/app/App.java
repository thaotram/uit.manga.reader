package reader.manga.uit.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import io.realm.Realm;
import model.Const;
import reader.manga.uit.apollo.ApolloClientHelper;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Const.setResource(getResources());
        Realm.init(this);
        Fresco.initialize(this);
        ApolloClientHelper.Initialize(this);
    }
}
