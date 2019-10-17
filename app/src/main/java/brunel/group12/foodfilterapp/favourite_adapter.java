package brunel.group12.foodfilterapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rajat on 01/03/2017.
 */

public class favourite_adapter extends RecyclerView.Adapter<favourite_adapter.ViewHolder>  {

    private Context context;
    private List<favItems> item2;

    public favourite_adapter (List<favItems> favItems, Context context){
        this.item2=favItems;
        this.context=context;
    }

    @Override
    public favourite_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favourite_items,parent,false);
        return new ViewHolder(v,context,item2);
    }

    @Override
    public void onBindViewHolder(favourite_adapter.ViewHolder holder, int position) {

        final favItems fav= item2.get(position);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,rest_page.class);
                intent.putExtra("res",fav.getFav_name());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.fav_name.setText(fav.getFav_name());

    }

    @Override
    public int getItemCount() {
        return item2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv_fav;
        Context context;
        TextView fav_name;
        List<favItems> favItems;
        LinearLayout linearLayout;

        public ViewHolder(View itemView, Context context, List<favItems> favItems) {
            super(itemView);
            this.context = context;
            this.favItems = favItems;

            cv_fav = (CardView) itemView.findViewById(R.id.cv_fav);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.fav_linear);
            fav_name = (TextView) itemView.findViewById(R.id.fav_name_res);

        }
    }
}
