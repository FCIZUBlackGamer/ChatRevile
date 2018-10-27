package image.upload.test.realmtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class FragmentLogin extends AppCompatActivity {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login_chat);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public void onStart() {
        super.onStart();
        fragmentManager.beginTransaction().replace(R.id.frame_login, new FragmentRegister()).commit();
    }
}
