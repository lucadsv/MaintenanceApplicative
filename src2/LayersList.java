import java.util.LinkedList;
import java.util.List;

public class LayersList {

    private List<Layer> layers;

    // === create_layers_list ===
    public LayersList() {
        layers = new LinkedList<>();
    }

    // === delete_layers_list ===
    public void deleteLayersList() {
        for (Layer l : layers) {
            l.deleteLayer();
        }
        layers.clear();
    }

    // === add_layer_to_list ===
    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    // === remove_layer_from_list ===
    public void removeLayer(Layer layer) {
        layers.remove(layer);
    }

    public List<Layer> getAll() {
        return layers;
    }
}
