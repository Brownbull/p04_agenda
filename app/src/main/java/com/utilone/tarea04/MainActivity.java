package com.utilone.tarea04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.utilone.tarea04.components.Composer;
import com.utilone.tarea04.components.ComposerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

  ListView lvComposers;
  List<Composer> composers;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setTitle("Classical Music Composers");
    lvComposers = findViewById(R.id.lvComposers);

    composers = new ArrayList();

    Composer composer = new Composer(
        "Wolfgang", "Amadeus", "Mozart",
        "Austria",
        "01/27/1756",
        "mozart",
        "Wolfgang Amadeus Mozart, baptised as Johannes Chrysostomus Wolfgangus Theophilus Mozart, was a prolific and influential composer of the classical era. Born in Salzburg, Mozart showed prodigious ability from his earliest childhood."
    );
    composers.add(composer);
    composer = new Composer(
        "Johann", "Sebastian", "Bach",
        "Germany",
        "03/31/1685",
        "bach",
        "Johann Sebastian Bach was a German composer and musician of the Baroque period. He is known for instrumental compositions such as the Art of Fugue, the Brandenburg Concertos, and the Goldberg Variations, and for vocal music such as the St Matthew Passion and the Mass in B minor"
    );
    composers.add(composer);
    composer = new Composer(
        "Ludwig", "van", "Beethoven",
        "Germany",
        "03/26/1770",
        "beethoven",
        "Ludwig van Beethoven was a German composer and pianist. A crucial figure in the transition between the classical and romantic eras in classical music, he remains one of the most recognized and influential musicians of this period, and is considered to be one of the greatest composers of all time."
    );
    composers.add(composer);
    composer = new Composer(
        "Pyotr", "Ilyich", "Tchaikovsky",
        "Russia",
        "05/07/1840",
        "tchaivkosvky",
        "Pyotr Ilyich Tchaikovsky was a Russian composer of the romantic period, whose works are among the most popular music in the classical repertoire. He was the first Russian composer whose music made a lasting impression internationally, bolstered by his appearances as a guest conductor in Europe and the United States."
    );
    composers.add(composer);
    composer = new Composer(
        "Frédéric", "", "Chopin",
        "Poland",
        "03/01/1810",
        "chopin",
        "Frédéric François Chopin was a Polish composer and virtuoso pianist of the Romantic era who wrote primarily for solo piano. He has maintained worldwide renown as a leading musician of his era, one whose \"poetic genius was based on a professional technique that was without equal in his generation."
    );
    composers.add(composer);

    ArrayAdapter<Composer> arrAdaptr = new ComposerAdapter(this, 0, composers);
    lvComposers.setAdapter(arrAdaptr);
    lvComposers.setOnItemClickListener(this);

  }

  @Override
  public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    Composer composer = composers.get(i);
    String firstName = composer.getFirstName();
    String middleName = composer.getMiddleName();
    String lastName = composer.getLastName();
    String country = composer.getCountry();
    String DOB = composer.getDOB();
    String imageURL = composer.getImageURL();
    String desc = composer.getDesc();

    goComposer(composer);
    Toast.makeText(this, firstName + " " + lastName, Toast.LENGTH_SHORT).show();
  }

  public void goComposer(Composer composer) {
    Intent intent = new Intent(this, ComposerInfo.class);
    intent.putExtra("firstName", composer.getFirstName());
    intent.putExtra("middleName", composer.getMiddleName());
    intent.putExtra("lastName", composer.getLastName());
    intent.putExtra("country", composer.getCountry());
    intent.putExtra("DOB", composer.getDOB());
    intent.putExtra("image", composer.getImageURL());
    intent.putExtra("desc", composer.getDesc());
    startActivity(intent);
    Toast.makeText(this, "Ir a\n" +
        "Composer Info Activity", Toast.LENGTH_SHORT).show();
    //finish();
  }
}
