package vincent.lee.ap_android_test_store;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        final String productName = this.getIntent().getExtras().getString("name");
        String productId = this.getIntent().getExtras().getString("id");
        String productDescription = this.getIntent().getExtras().getString("description");
        String productLabel = this.getIntent().getExtras().getString("label");
        String productPrice = this.getIntent().getExtras().getString("price");

        TextView productTextView = findViewById(R.id.productDetailTextView);
        ImageView productImageView = findViewById(R.id.productDetailImageView);
        TextView productPriceTextView= findViewById(R.id.productDetailPriceTextView);
        Button addButton= findViewById(R.id.productDetailAddButton);
        Button cartButton= findViewById(R.id.cartButton);

        productTextView.setText(productName);
        productPriceTextView.setText("$" + productPrice);

        switch (productName) {
            case "Orange": {
                productImageView.setImageResource(R.drawable.fruit_orange);
                break;
            }
            case "Banana": {
                productImageView.setImageResource(R.drawable.fruit_banana);
                break;
            }
            case "Apple": {
                productImageView.setImageResource(R.drawable.fruit_apple);
                break;
            }
        }

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add to Cart Code
                //Get Product Count in Cart
                SharedPreferences sharedPreferences = ProductDetailActivity.this.getSharedPreferences("CART", MODE_PRIVATE);
                int count = sharedPreferences.getInt(productName, 0);

                // Add to Product Count
                count++;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(productName, count);
                editor.commit();
            }
        });

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }
}
