package com.example.jaguar.weather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class WeatherHolder extends RecyclerView.ViewHolder {
   public TextView weatherTextView;
   public ImageView weatherImageView;
   Bitmap image;

    public WeatherHolder(View itemView) {
        super(itemView);
        weatherImageView = itemView.findViewById(R.id.imageWeather);
        weatherTextView = itemView.findViewById(R.id.hello);
    }
    public void bindCrime(WeatherObjFactory.WeatherObj wObj) {
        weatherTextView.setText(wObj.getText());
        //String UrliconWeather = wObj.getImage();
        ImageLoad load = new ImageLoad();
        load.execute(wObj.getImage());
        weatherImageView.setImageBitmap(image);

    }
    class ImageLoad extends AsyncTask<String, Void, Bitmap> {

        protected Bitmap doInBackground(String... strings) {
            String UrliconWeather = null;
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(UrliconWeather).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            //wth.setImage(result);
            //weatherImageView.setImageBitmap(result);
            image = result;
        }
    }
}
