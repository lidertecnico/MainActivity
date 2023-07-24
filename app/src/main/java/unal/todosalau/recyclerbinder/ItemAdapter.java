package unal.todosalau.recyclerbinder;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import unal.todosalau.recyclerbinder.databinding.ItemLayoutBinding;
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
private List<Item> items;
// Constructor que recibe una lista de elementos Item
public ItemAdapter(List<Item> items) {
    this.items = items;
}
// Método llamado cuando se crea un nuevo ViewHolder
@NonNull
@Override
public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    // Se infla el layout del elemento de la lista utilizando DataBindingUtil
    // Esto vincula el layout con el archivo de diseño item_layout.xml y genera una clase de enlace ItemLayoutBinding
    ItemLayoutBinding binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.getContext()),
            R.layout.item_layout, parent, false);
    return new ItemViewHolder(binding);
}
// Método llamado cuando se vincula un ViewHolder con los datos en una posición específica
@Override
public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
    // Obtiene el elemento Item de la lista en la posición dada
    Item item = items.get(position);
    // Vincula el elemento Item con el enlace en el ViewHolder para actualizar la vista
    holder.binding.setItem(item);
}
// Método que devuelve la cantidad total de elementos en la lista
@Override
public int getItemCount() {
    return items.size();
}
// Clase ViewHolder que contiene la vista de un elemento de la lista
static class ItemViewHolder extends RecyclerView.ViewHolder {
    ItemLayoutBinding binding;

    // Constructor que recibe el enlace generado para el layout del elemento
    public ItemViewHolder(ItemLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
}