package brunel.group12.foodfilterapp;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder> {

    private List<GridItem> gridItems;
    private Context context;


    public GridViewAdapter(List<GridItem> gridItems, Context context) {
        this.gridItems = gridItems;
        this.context = context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_grid,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final GridItem griditem = gridItems.get(position);

        holder.layout_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, "Clicked!" + griditem.getDesc(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,Restaurant_Options.class);
                intent.putExtra("filter",griditem.getDesc());
                intent.putExtra("post",griditem.getpost());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


        Picasso.with(context)
                .load(griditem.getImgURL())
                .skipMemoryCache()
                .into(holder.filters);

    }


    @Override
    public int getItemCount()
    {

        return gridItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        public ImageView filters;
        public LinearLayout layout_options;

        public ViewHolder(View itemView) {
            super(itemView);

            layout_options = (LinearLayout) itemView.findViewById(R.id.layout_filter);
            filters = (ImageView) itemView.findViewById(R.id.image_filter);
           // itemView.setTag(itemView);

        }

      /*  @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            GridItem gridItems = this.gridItems.get(position);
            Intent intent = new Intent(this.context,Restaurant_Options.class);
            intent.putExtra("filter",gridItems.getPhotoid());
            this.context.startActivity(intent);
        } */
    }


}
