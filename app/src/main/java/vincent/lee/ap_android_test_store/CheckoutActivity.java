package vincent.lee.ap_android_test_store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Button purchaseButton = findViewById(R.id.purchaseButton);
        final Double totalPrice = this.getIntent().getExtras().getDouble("total");

        purchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, PurchaseConfirmationActivity.class);
                intent.putExtra("total", totalPrice);
                startActivity(intent);
            }
        });
    }
}
