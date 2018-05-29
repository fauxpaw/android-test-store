package vincent.lee.ap_android_test_store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    Double totalPrice = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ListView listView = findViewById(R.id.cartListView);
        TextView totalTextView = findViewById(R.id.cartTotalTextView);
        Button checkoutButton= findViewById(R.id.checkoutButton);

        final ArrayList<Product> cartProducts = Product.getProductsInCart(this);
        CartProductAdapter adapter = new CartProductAdapter(this, cartProducts);
        listView.setAdapter(adapter);

        for (int x = 0; x < cartProducts.size(); x++) {
            Product product = cartProducts.get(x);
            Double price = Double.parseDouble(product.price);
            int count = product.count;
            Double priceAdded = count * price;
            this.totalPrice = this.totalPrice + priceAdded;
        }
        totalTextView.setText("$" + String.format("%.2f", this.totalPrice));

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
                intent.putExtra("total", totalPrice);
                startActivity(intent);
            }
        });
    }
}
