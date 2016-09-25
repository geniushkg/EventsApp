package com.hardikgoswami.eventsapp.data.event;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hardikgoswami.eventsapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by geniushkg on 9/25/2016.
 */
public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {
    private List<Website> mEvents;
    private Context mContext;

    public EventListAdapter(List<Website> eventsList) {
        mEvents = eventsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        // Inflate the custom layout
        View eventView = inflater.inflate(R.layout.event_row_layout, parent, false);
        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(eventView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Website website = mEvents.get(position);
        holder.Name.setText(website.getName());
        holder.Experience.setText(website.getExperience());
        holder.Category.setText(website.getCategory());
        holder.Description.setText(website.getDescription());
        Log.d("EVENTSAPP","PICASO : "+website.getImage());
    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name, Experience,Category, Description;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.tvName);
            Experience = (TextView) itemView.findViewById(R.id.tvExperience);
            Category = (TextView) itemView.findViewById(R.id.tvCategory);
            Description = (TextView) itemView.findViewById(R.id.tvDescription);
            imageView = (ImageView) itemView.findViewById(R.id.ivEvent);
        }
    }
}
