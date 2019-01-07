package com.example.jaguar.weather;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherHolder extends RecyclerView.ViewHolder {
   public TextView weatherTextView;
   public ImageView weatherImageView;
    public WeatherHolder(View itemView) {
        super(itemView);
        weatherImageView = itemView.findViewById(R.id.imageWeather);
        weatherTextView = itemView.findViewById(R.id.hello);
    }
    public void bindCrime(WeatherObjFactory.WeatherObj wObj) {
        weatherTextView.setText(wObj.getText());
        weatherImageView.setImageBitmap(wObj.getImage());

    }
}
