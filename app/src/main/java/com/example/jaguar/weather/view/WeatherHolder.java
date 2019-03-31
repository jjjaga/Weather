package com.example.jaguar.weather.view;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.jaguar.weather.R;
import com.example.jaguar.weather.model.WeatherObj;

public class WeatherHolder extends RecyclerView.ViewHolder {
    private final TextView weatherTextView;

    public WeatherHolder(final View itemView) {
        super(itemView);
        weatherTextView = itemView.findViewById(R.id.hello);

        final Dialog dialog = new Dialog(itemView.getContext());
        dialog.setContentView(R.layout.activity_weather_full);
        final TextView text = dialog.findViewById(R.id.text);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(weatherTextView.getText());
                dialog.show();
            }
        });
    }
    public void bindCrime(WeatherObj wObj) {
        weatherTextView.setText(wObj.getText());
    }

}
