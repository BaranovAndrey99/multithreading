package multithreading.mistakes.deadlock.cooperatingObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Карта. На ней располагаются отметки о местоположении самолетов.
 */
public class PlaneMap {
    /**
     * Положения самолетов.
     */
    private List<String> marks;

    public PlaneMap() {
        this.marks = new ArrayList<>();
    }

    public List getMarks() {
        return this.marks;
    }

    /**
     * Добавление маркера(местоположения) самолета
     *  на карту.
     * @param location - метка(местоположение) самолета.
     */
    public void drawPlaneMarker(String location) {
        marks.add(location);
    }
}
