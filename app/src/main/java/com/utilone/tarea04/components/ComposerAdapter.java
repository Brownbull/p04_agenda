package com.utilone.tarea04.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.utilone.tarea04.R;

import java.util.List;

public class ComposerAdapter extends ArrayAdapter<Composer> {

  Context context;
  List<Composer> objects;


  public ComposerAdapter(@NonNull Context context, int resource, @NonNull List<Composer> objects) {
    super(context, resource, objects);

    this.context = context;
    this.objects = objects;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    Composer composer = objects.get(position);
    View view = LayoutInflater.from(getContext()).inflate(R.layout.item_composer, null);
    // Initialize TextViews
    TextView tvComposerHead = view.findViewById(R.id.tvComposerHead);
    TextView tvComposerBody = view.findViewById(R.id.tvComposerBody);
    // Set TextViews
    tvComposerHead.setText(String.format("%s %s %s",
        composer.getFirstName(), composer.getMiddleName(),composer.getLastName()));
    tvComposerBody.setText(String.format("DOB: %s, %s", composer.getDOB(), composer.getCountry()));

    return view;
  }
}
