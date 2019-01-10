package com.example.jaguar.weather.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaguar.weather.R;
import com.example.jaguar.weather.model.WeatherObj;

import java.io.InputStream;

public class WeatherHolder extends RecyclerView.ViewHolder {
   public TextView weatherTextView;
   public ImageView weatherImageView;

    public WeatherHolder(View itemView) {
        super(itemView);
        weatherImageView = itemView.findViewById(R.id.imageWeather);
        weatherTextView = itemView.findViewById(R.id.hello);
    }
    public void bindCrime(WeatherObj wObj) {
        weatherTextView.setText(wObj.getText());
        String UrliconWeather = wObj.getImage();
        ImageLoad load = new ImageLoad(weatherImageView, UrliconWeather);
        load.execute(wObj.getImage());

    }
    class ImageLoad extends AsyncTask<String, Void, Bitmap> {
        private final ImageView weatherImageView;
        private final String image;

        public ImageLoad(ImageView weatherImgeView, String image) {
            this.weatherImageView = weatherImgeView;
            this.image = image;
        }

        protected Bitmap doInBackground(String... strings) {
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(image).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            weatherImageView.setImageBitmap(result);
        }
    }
}
