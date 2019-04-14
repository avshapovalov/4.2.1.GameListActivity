package com.example.gamelistactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameListAdapter extends BaseAdapter {
    private List<Game> games;
    private LayoutInflater inflater;

    private CompoundButton.OnCheckedChangeListener myCheckChangeList
            = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            games.get((Integer) buttonView.getTag()).setChacked(isChecked);
        }
    };

    GameListAdapter(Context context, List<Game> games) {
        if (games == null) {
            this.games = new ArrayList<>();
        } else {
            this.games = games;
        }
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    void addItem(Game item) {
        this.games.add(item);
        notifyDataSetChanged();
    }

    void removeItem(int position) {
        games.remove(position);
        notifyDataSetChanged();
    }

    // Обязательный метод абстрактного класса BaseAdapter.
    // Он возвращает колличество элементов списка.
    @Override
    public int getCount() {
        return games.size();
    }

    @Override
    public Game getItem(int position) {
        if (position < games.size()) {
            return games.get(position);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Самый интересный обязательный метод.
    // Создает или возвращает переиспользуемый View, с новыми данными
    // для конкретной позиции. BaseAdapter – хитрый класс,
    // он не держит в памяти все View - это дорого и будет тормозить.
    // Поэтому он рисует только то что видно. Для этого есть convertView.
    // Если нет чего переиспользовать, то создается новый View.
    // А потом напоняет старую или новую View нужными данными.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.game_list_item, parent, false);
        }

        Game game = games.get(position);

        ImageView image = view.findViewById(R.id.icon);
        TextView title = view.findViewById(R.id.title);
        TextView subtitle = view.findViewById(R.id.subtitle);
        CheckBox checkBox = view.findViewById(R.id.checkbox);

        image.setImageDrawable(game.getImage());
        title.setText(game.getName());
        subtitle.setText(game.getVersion());
        checkBox.setOnCheckedChangeListener(myCheckChangeList);
        checkBox.setTag(position);
        checkBox.setChecked(game.isChacked());

        return view;
    }


}
