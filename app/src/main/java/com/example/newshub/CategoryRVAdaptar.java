package com.example.newshub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CategoryRVAdaptar extends RecyclerView.Adapter<CategoryRVAdaptar.ViewHolder> {
   private ArrayList<CategoryRvModal> categoryRVModals;
   private Context context;
   private CategoryClickInterface categoryClickInterface;

    public CategoryRVAdaptar(ArrayList<CategoryRvModal> categoryRVModals, Context context, CategoryClickInterface categoryClickInterface) {
        this.categoryRVModals = categoryRVModals;
        this.context = context;
        this.categoryClickInterface = categoryClickInterface;
    }

    @NonNull

    @Override
    public CategoryRVAdaptar.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_rv,parent,false);
        return new CategoryRVAdaptar.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRVAdaptar.ViewHolder holder, int position) {
        CategoryRvModal categoryRvModal = categoryRVModals.get(position);
        holder.categoryTV.setText(categoryRvModal.getCategory());
        Picasso.get().load(categoryRvModal.getCategoryImageUrl()).into(holder.categoryIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryClickInterface.onCategoryClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryRVModals.size();
    }
    public interface CategoryClickInterface{
        void onCategoryClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView categoryTV;
        private ImageView categoryIV;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            categoryIV = itemView.findViewById(R.id.imageCategory);
            categoryTV = itemView.findViewById(R.id.textviewCategory);
        }
    }
}
