package vincent.lee.ap_android_test_store;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class Product {
    String name;
    String id;
    String description;
    String label;
    String price;
    int count;

    public Product(String name, String id, String description, String label, String price, int count) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.label = label;
        this.price = price;
        this.count = count;
    }
    public  Product() {

    }

    public static ArrayList<Product> getProductsFromFile(String filename, Context context){
        final ArrayList<Product> productList = new ArrayList<>();
        try {
            // Load data
            String jsonString = loadJsonFromAsset(filename, context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray products = json.getJSONArray("products");

            // Get Recipe objects from data
            for(int i = 0; i < products.length(); i++){
                Product product = new Product();

                product.name = products.getJSONObject(i).getString("name");
                product.id = products.getJSONObject(i).getString("id");
                product.description = products.getJSONObject(i).getString("description");
                product.label = products.getJSONObject(i).getString("label");
                product.price = products.getJSONObject(i).getString("price");
                product.count = products.getJSONObject(i).getInt("count");

                productList.add(product);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public static ArrayList<Product> getProductsInCart(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("CART", MODE_PRIVATE);
        ArrayList<Product> productInfo = Product.getProductsFromFile("products.json", context);
        ArrayList<Product> cartProducts = new ArrayList<Product>();

        for (int x = 0; x < productInfo.size(); x++) {
            int count = sharedPreferences.getInt(productInfo.get(x).name, 0);
            if (count > 0) {
                Product product = new Product();
                product.name = productInfo.get(x).name;
                product.id = productInfo.get(x).id;
                product.description = productInfo.get(x).description;
                product.label = productInfo.get(x).label;
                product.price = productInfo.get(x).price;
                product.count = count;
                cartProducts.add(product);
            }
        }
        return cartProducts;
    }

    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}
