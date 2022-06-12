package com.example.newshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
    String title, desc, content, imageURL, url;
    private TextView newstitle, newssubtitle, newscontent;
    private ImageView newsimage;
    private Button newsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_news_detail);
        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("desc");
        content = getIntent().getStringExtra("content");
        imageURL = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");
        newstitle =  findViewById(R.id.newsDetail_title);
        newssubtitle = findViewById(R.id.newsDetail_subtitle);
        newsimage = findViewById(R.id.newsDetail_image);
        newsButton = findViewById(R.id.newsDetail_button);
        newscontent = findViewById(R.id.newsDetail_content);
        newstitle.setText(title);
        newssubtitle.setText(desc);
        newscontent.setText(url);
        Picasso.get().load(imageURL).into(newsimage);
        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(content));
                startActivity(i);
            }
        });
    }
}