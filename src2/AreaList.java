import java.util.LinkedList;
import java.util.List;

public class AreaList {

    private List<Area> areas;

    // === create_area_list ===
    public AreaList() {
        areas = new LinkedList<>();
    }

    // === delete_area_list ===
    public void deleteAreaList() {
        for (Area a : areas) {
            a.deleteArea();
        }
        areas.clear();
    }

    // === add_area_to_list ===
    public void addArea(Area area) {
        areas.add(area);
    }

    // === remove_area_from_list ===
    public void removeArea(Area area) {
        areas.remove(area);
    }

    public List<Area> getAll() {
        return areas;
    }
}
