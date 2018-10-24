package image.upload.test.realmtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class Home extends AppCompatActivity {

//    List<User> userList;

    TextView names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        names = findViewById(R.id.names);
//        userList = new ArrayList<>();
        final Realm realm = Realm.getDefaultInstance();
        final RealmResults<User> users = realm.where(User.class).findAll();

        for (int x=0; x<users.size(); x++){
           names.append(users.get(x).getEmail()+"\n");
        }
    }
}
