package com.example.jaguar.weather.presenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.jaguar.weather.R;
import com.example.jaguar.weather.model.CallBackImage;
import com.example.jaguar.weather.model.WeatherObj;
import com.example.jaguar.weather.view.WeatherFullActivity;
import java.io.InputStream;

public class WeatherHolder extends RecyclerView.ViewHolder {
   private TextView weatherTextView;
   private ImageView weatherImageView;

    public WeatherHolder(final View itemView, final Context context) {
        super(itemView);
        weatherImageView = itemView.findViewById(R.id.imageWeather);
        weatherTextView = itemView.findViewById(R.id.hello);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WeatherFullActivity.class);
                context.startActivity(intent.putExtra("textFor",weatherTextView.getText()));
            }
        });
    }
    public void bindCrime(WeatherObj wObj) {
        new ImageLoad(wObj.getImage(), new CallBackImage() {
            @Override
            public void Bind(Bitmap bitmap) {
                weatherImageView.setImageBitmap(bitmap);
            }
        }).execute();
        weatherTextView.setText(wObj.getText());
    }
    class ImageLoad extends AsyncTask<String, Void, Bitmap> {
        private final String image;
        private final CallBackImage call;

        ImageLoad(String image, CallBackImage call) {
            this.image = image;
            this.call = call;
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
            call.Bind(result);
        }
    }
}
