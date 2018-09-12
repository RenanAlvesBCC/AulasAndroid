package com.example.renanalves.gridviewcalledotherapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class GridActivity extends Activity {

    ArrayList<Application> applications = new ArrayList<Application>();
    GridView gridView;
    Uri uri;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = findViewById(R.id.grid);

        Application application = new  Application(R.drawable.googlemaps);
        applications.add(application);
        application = new Application(R.drawable.googlecall);
        applications.add(application);
        application = new Application(R.drawable.googlechrome);
        applications.add(application);
        application = new Application(R.drawable.msg);
        applications.add(application);

        GridViewCustom adapter = new GridViewCustom(applications,this);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        intent = new Intent(Intent.ACTION_VIEW);
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway%2C+CA");
                            intent.setData(uri);
                            startActivity(intent);
                        }
                        break;
                    case 1:
                        intent = new Intent(Intent.ACTION_DIAL);
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            uri.parse("tel:"+"33333333");
                            intent.setData(uri);
                            startActivity(intent);
                        }
                        break;
                    case 2:
                        Uri webpage = Uri.parse("http://www.ucb.br");
                        intent = new Intent(Intent.ACTION_VIEW, webpage);
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                        break;
                    case 3:
                        intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
                        intent.putExtra("sms_body", "hellow world");
                        intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("sms: 33333333"));
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                        break;
                }
            }
        }));
    }
}
