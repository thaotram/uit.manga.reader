package reader.manga.uit.activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;

@SuppressLint("Registered")
public class AppActivity extends AppCompatActivity {
    protected final Realm realm = Realm.getDefaultInstance();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
