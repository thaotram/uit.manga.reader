package reader.manga.uit.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import io.realm.Realm;

import static reader.manga.uit.utils.Timer.setTimeout;

@SuppressLint("Registered")
public class AppActivity extends AppCompatActivity {
    protected final Realm realm = Realm.getDefaultInstance();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    protected void showToast(int text) {
        Toast.makeText(
                getApplicationContext(),
                text,
                Toast.LENGTH_SHORT
        ).show();
    }

    public void delayStartActivity(Intent intent) {
        setTimeout(() -> startActivity(intent), 300);
    }
}
