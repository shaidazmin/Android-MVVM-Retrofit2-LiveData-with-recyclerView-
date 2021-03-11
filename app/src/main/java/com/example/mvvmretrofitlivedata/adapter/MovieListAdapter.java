package com.example.mvvmretrofitlivedata.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmretrofitlivedata.R;
import com.example.mvvmretrofitlivedata.model.MovieModel;
import com.example.mvvmretrofitlivedata.viewmodel.MovieListViewModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private Context context;
    private List<MovieModel> modelList;


    public MovieListAdapter(Context context, List<MovieModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    public void setMovieList(List<MovieModel> modelList){
         this.modelList = modelList;
         notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);

        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

         holder.textView.setText(modelList.get(position).getTitle());
        Glide.with(context).load(modelList.get(position).getThumbnailUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        if(this.modelList != null){
            return modelList.size() ;
        }
        return 0 ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }

}
