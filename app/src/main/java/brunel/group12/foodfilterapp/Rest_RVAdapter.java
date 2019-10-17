package brunel.group12.foodfilterapp;

/**
 * Created by Rajat on 18/01/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Rest_RVAdapter extends RecyclerView.Adapter<Rest_RVAdapter.ViewHolder> {

    private Context context;
    private List<restItems> RestItems;

    public Rest_RVAdapter(List<restItems> RestItems, Context context) {
        this.RestItems = RestItems;
        this.context = context;

    }

    @Override
    public Rest_RVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_items,parent,false);
        return new ViewHolder(v,context,RestItems);
    }

    @Override
    public void onBindViewHolder(Rest_RVAdapter.ViewHolder holder, int position) {

        final restItems restitem = RestItems.get(position);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,rest_page.class);
                intent.putExtra("res",restitem.getRest_name());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        holder.rest_name.setText(restitem.getRest_name());
        holder.rest_dist.setText(restitem.getRest_dist());

        Picasso.with(context).load(restitem.getRest_photo()).skipMemoryCache().into(holder.rest_photo);
    }

    @Override
    public int getItemCount() {
        return RestItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        Context context;
        TextView rest_name;
        TextView rest_dist;
        ImageView rest_photo;
        List<restItems> RestItems;
        LinearLayout linearLayout;

        public ViewHolder(View itemView, Context context, List <restItems> RestItems) {
            super(itemView);
            this.context=context;
            this.RestItems=RestItems;

            cv = (CardView)itemView.findViewById(R.id.cv);
            linearLayout =(LinearLayout)itemView.findViewById(R.id.linear_v2);
            rest_name = (TextView)itemView.findViewById(R.id.rest_name_rev);
            rest_dist = (TextView)itemView.findViewById(R.id.rest_dist);
            rest_photo = (ImageView)itemView.findViewById(R.id.rest_photo);
        }

    }
}
