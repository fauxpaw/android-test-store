package vincent.lee.ap_android_test_store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Setup Click Listeners for buttons.
        Button loginSuccessButton = (Button)findViewById(R.id.LoginSuccessButton);
        loginSuccessButton.setOnClickListener(ButtonClickListener);
        Button loginFailButton = (Button)findViewById(R.id.LoginFailButton);
        loginFailButton.setOnClickListener(ButtonClickListener);


    }

    private View.OnClickListener ButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.LoginSuccessButton: {
                    EditText emailEditText = (EditText)findViewById(R.id.EmailEditText);
                    String email = emailEditText.getText().toString();
                    Log.d(TAG, "Login Success Pressed: Email: " + email);

                    Intent intent = new Intent(MainActivity.this, StoreListActivity.class);
                    startActivity(intent);

                    break;
                }
                case R.id.LoginFailButton: {
                    Log.d(TAG, "Login Fail Pressed");
                    break;
                }
            }
        }
    };
}
