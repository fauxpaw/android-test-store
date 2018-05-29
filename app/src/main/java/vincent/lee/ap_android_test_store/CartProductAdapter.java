package vincent.lee.ap_android_test_store;

import android.content.Context;
import android.icu.text.LocaleDisplayNames;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartProductAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<Product> products;
    private final LayoutInflater inflater;

    public CartProductAdapter(Context context, ArrayList<Product> products) {
        this.mContext = context;
        this.products = products;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = inflater.inflate(R.layout.cart_item_product, parent, false);
        TextView titleTextView = rowView.findViewById(R.id.cart_list_title);
        TextView quantityTextView = rowView.findViewById(R.id.cart_list_quantity);
        TextView priceTextView = rowView.findViewById(R.id.cart_list_price);
        ImageView thumbnailImageView = rowView.findViewById(R.id.cart_list_thumbnail);

        Product product = (Product)getItem(position);
        Double price = Double.parseDouble(product.price);
        Double priceAdded = price * product.count;
        String priceString = "$" + String.valueOf(priceAdded);

        titleTextView.setText(product.name);

        quantityTextView.setText(String.valueOf(product.count));
        priceTextView.setText(priceString);

        switch (product.name) {
            case "Orange": {
                thumbnailImageView.setImageResource(R.drawable.fruit_orange);
                break;
            }
            case "Banana": {
                thumbnailImageView.setImageResource(R.drawable.fruit_banana);
                break;
            }
            case "Apple": {
                thumbnailImageView.setImageResource(R.drawable.fruit_apple);
                break;
            }
        }

        return rowView;
    }
}
