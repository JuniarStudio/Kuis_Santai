package com.juniarstudio.kuissantai;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filterable;

import java.util.ArrayList;

import android.widget.Filter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemJawabanAdapter extends RecyclerView.Adapter<ItemJawabanAdapter.ViewHolder> implements Filterable {

    private static final String TAG = ItemJawabanAdapter.class.getSimpleName();
    private Context context;
    private ArrayList<ItemJawabanModel> dataset;
    private ArrayList<ItemJawabanModel> datasetFilter;
    private static ClickListener clickListener;
    private CustomFilter filter;

    public ItemJawabanAdapter(Context context, ArrayList<ItemJawabanModel> dataset) {
        this.context = context;
        this.dataset = dataset;
        this.datasetFilter = dataset;
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        ItemJawabanAdapter.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jawaban, parent, false);
        return new ViewHolder(view);
    }

    public interface ClickListener {
        void onItemClick(int position, View view);

        void onItemLongClick(int position, View view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemJawabanModel item = dataset.get(position);
        holder.txtChar.setText(""+item.getaChar());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void clear() {
        int size = this.dataset.size();
        this.dataset.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilter();
        }
        return filter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private EditText txtChar;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            txtChar = itemView.findViewById(R.id.txtChar);
            txtChar.setText("");
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }
    }

    class CustomFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                constraint = constraint.toString();
                Log.d(TAG, constraint.toString());
                ArrayList<ItemJawabanModel> filter = new ArrayList<>();
                for (int i = 0; i < datasetFilter.size(); i++) {
//                    if (datasetFilter.get(i).getaChar()) {
//                        ItemJawabanModel m = datasetFilter.get(i);
//                        filter.add(m);
//                    }
                }
                filterResults.count = filter.size();
                filterResults.values = filter;
            } else {
                filterResults.count = datasetFilter.size();
                filterResults.values = datasetFilter;
            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dataset = (ArrayList<ItemJawabanModel>) results.values;
            notifyDataSetChanged();
        }
    }
}