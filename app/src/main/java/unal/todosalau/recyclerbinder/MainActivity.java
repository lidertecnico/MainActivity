package unal.todosalau.recyclerbinder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import unal.todosalau.recyclerbinder.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private List<Item> items = new ArrayList<>();
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    // Añadir datos de prueba
    for (int i = 0; i < 10; i++) {
        items.add(new Item("Item " + (i + 1)));
    }

    // Configurar RecyclerView
    binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    binding.recyclerView.setAdapter(new ItemAdapter(items));
    }
}