package image.upload.test.realmtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);
        final Realm realm = Realm.getDefaultInstance();
        final RealmResults<User> users = realm.where(User.class).findAll();
        if (users.size() > 0) {
            startActivity(new Intent(this, Home.class));
        }

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                User user = new User();
                user.setEmail(email.getText().toString());
                user.setPassword(password.getText().toString());
                realm.copyToRealm(user);
                realm.commitTransaction();
                startActivity(new Intent(MainActivity.this, Home.class));
            }
        });
    }
}
