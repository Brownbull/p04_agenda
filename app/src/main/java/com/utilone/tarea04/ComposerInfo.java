package com.utilone.tarea04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.utilone.tarea04.components.Composer;

public class ComposerInfo extends AppCompatActivity {

  TextView tvLabelName;
  ImageView ivImage;
  TextView tvInfo;
  TextView tvDescription;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_composer_info);
    setTitle("Composer Information");

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    tvLabelName = findViewById(R.id.tvLabelName);
    ivImage= (ImageView)findViewById(R.id.ivImage);
    tvInfo = findViewById(R.id.tvInfo);
    tvDescription = findViewById(R.id.tvDescription);

    Intent intent = getIntent();

    Composer composer = new Composer(
        intent.getStringExtra("firstName"),
        intent.getStringExtra("middleName"),
        intent.getStringExtra("lastName"),
        intent.getStringExtra("country"),
        intent.getStringExtra("DOB"),
        intent.getStringExtra("image"),
        intent.getStringExtra("desc") );

    tvLabelName.setText(String.format("%s %s %s",
      composer.getFirstName(), composer.getMiddleName(), composer.getLastName()));

    String uri = "@drawable/" + composer.getImageURL();  // where myresource (without the extension) is the file
    int imageResource = getResources().getIdentifier(uri, null, getPackageName());
    Drawable res = getResources().getDrawable(imageResource);
    ivImage.setImageDrawable(res);

    tvInfo.setText(String.format("born on %s, %s",
        composer.getDOB(), composer.getCountry()));
    tvDescription.setText(composer.getDesc());
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    int itemId = item.getItemId();
    switch(itemId){
      case android.R.id.home:
        finish();
        //goMain();
        Toast.makeText(this, "Back in Home", Toast.LENGTH_SHORT).show();
        break;
      default:
        Toast.makeText(this, "Action id: " + itemId, Toast.LENGTH_SHORT).show();
        break;
    }
    return super.onOptionsItemSelected(item);
  }
}
