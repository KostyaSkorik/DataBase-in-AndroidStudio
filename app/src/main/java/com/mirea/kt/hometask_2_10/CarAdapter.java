package com.mirea.kt.hometask_2_10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    private ArrayList<Car> cars;

    public CarAdapter(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView modelView;
        private final TextView numberView;
        private final TextView yearView;
        ViewHolder(View view){
            super(view);
            modelView =view.findViewById(R.id.tvModel);
            numberView =view.findViewById(R.id.tvNumber);
            yearView =view.findViewById(R.id.tvYear);
        }
    }



    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cars,parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car car= cars.get(position);
        holder.modelView.setText(String.format("%s",car.getModel()));
        holder.numberView.setText(String.format("%s",car.getNumber()));
        holder.yearView.setText(String.format("%s",car.getYear()));

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
