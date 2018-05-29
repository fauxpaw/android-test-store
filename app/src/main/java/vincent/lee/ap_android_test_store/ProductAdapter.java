package vincent.lee.ap_android_test_store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<Product> products;
    private final LayoutInflater inflater;

    public ProductAdapter(Context context, ArrayList<Product> products) {
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
        View rowView = inflater.inflate(R.layout.list_item_product, parent, false);
        TextView titleTextView = rowView.findViewById(R.id.product_list_title);
        TextView subtitleTextView = rowView.findViewById(R.id.product_list_subtitle);
        TextView detailTextView = rowView.findViewById(R.id.product_list_detail);
        ImageView thumbnailImageView = rowView.findViewById(R.id.product_list_thumbnail);

        Product product = (Product)getItem(position);
        titleTextView.setText(product.name);
        subtitleTextView.setText(product.description);
        detailTextView.setText(product.label);

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
