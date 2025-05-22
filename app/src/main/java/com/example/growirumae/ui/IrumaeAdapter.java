package com.example.growirumae.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cs24game.R;
import com.example.growirumae.data.irumaeDB.Irumae;
import com.example.growirumae.data.irumaeDB.Converters;

public class IrumaeAdapter extends ListAdapter<Irumae, IrumaeAdapter.IrumaeViewHolder> {
    protected IrumaeAdapter(@NonNull DiffUtil.ItemCallback<Irumae> diffCallback) {
        super(diffCallback);
    }

    public static final DiffUtil.ItemCallback<Irumae> DIFF_CALLBACK = new DiffUtil.ItemCallback<Irumae>() {
        @Override
        public boolean areItemsTheSame(@NonNull Irumae oldItem, @NonNull Irumae newItem) {
            return (oldItem.getId() == newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Irumae oldItem, @NonNull Irumae newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public IrumaeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.irumae_item, parent, false);
        return new IrumaeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IrumaeViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class IrumaeViewHolder extends RecyclerView.ViewHolder {
        TextView idText, rumaeNameText, playerNameText, majorText, intelligenceText, energyText, stressText;

        public IrumaeViewHolder(@NonNull View itemView) {
            super(itemView);
            idText = itemView.findViewById(R.id.idText);
            rumaeNameText = itemView.findViewById(R.id.rumaeNameText);
            playerNameText = itemView.findViewById(R.id.playerNameText);
            majorText = itemView.findViewById(R.id.majorText);
            intelligenceText = itemView.findViewById(R.id.intelligenceText);
            energyText = itemView.findViewById(R.id.energyText);
            stressText = itemView.findViewById(R.id.stressText);
        }

        void bind(Irumae data) {
            idText.setText(data.getId());
            rumaeNameText.setText(data.getRumaeName());
            playerNameText.setText(data.getPlayerName());
            majorText.setText(Converters.fromEnum(data.getMajor()));
            intelligenceText.setText(data.getIntelligence());
            energyText.setText(data.getEnergy());
            stressText.setText(data.getStress());
        }
    }
}