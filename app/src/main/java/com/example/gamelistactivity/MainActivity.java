package com.example.gamelistactivity;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random random = new Random();
    private GameListAdapter adapter;
    private List<Drawable> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.BlizzardApps);
        fillImages();
        List<Game> gameList = new ArrayList<>();

        Game overwatch = new Game("Overwatch", "Blizzard Entertainment| 12/4/2019",random.nextBoolean(), images.get(random.nextInt(images.size())));
        Game starcraft2 = new Game("Starcraft 2", "Blizzard Entertainment| 12/4/2019",random.nextBoolean(), images.get(random.nextInt(images.size())));
        Game diablo = new Game("Diablo3", "Blizzard Entertainment| 12/4/2019",random.nextBoolean(), images.get(random.nextInt(images.size())));
        Game hearthstone = new Game("Hearthstone", "Blizzard Entertainment| 12/4/2019",random.nextBoolean(), images.get(random.nextInt(images.size())));

        gameList.add(overwatch);
        gameList.add(starcraft2);
        gameList.add(diablo);
        gameList.add(hearthstone);

        adapter = new GameListAdapter(this, gameList);
        listView.setAdapter(adapter);
    }


    private void fillImages() {
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_report_image));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_add));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_agenda));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_camera));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_call));
    }

}
