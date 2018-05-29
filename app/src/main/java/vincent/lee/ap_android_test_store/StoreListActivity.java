package vincent.lee.ap_android_test_store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class StoreListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list);

        ListView listView = findViewById(R.id.productListView);
        final ArrayList<Product> productList = Product.getProductsFromFile("products.json", this);
        ProductAdapter adapter = new ProductAdapter(this, productList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = productList.get(position);
                Intent intent = new Intent(StoreListActivity.this, ProductDetailActivity.class);
                intent.putExtra("name", product.name);
                intent.putExtra("id", product.id);
                intent.putExtra("description", product.description);
                intent.putExtra("label", product.label);
                intent.putExtra("price", product.price);
                startActivity(intent);
            }
        });
    }
}
