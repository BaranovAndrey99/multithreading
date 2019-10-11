package multithreading.mistakes.deadlock.cooperatingObjects.bug;

import multithreading.mistakes.deadlock.cooperatingObjects.PlaneMap;

import java.util.ArrayList;
import java.util.List;

public class PlaneDispatcher {
    private final List<Plane> planeList;
    private final List<Plane> planesPandingLanping;
    private PlaneMap map;

    public PlaneDispatcher() {
        this.planeList = new ArrayList<>();
        this.planesPandingLanping = new ArrayList<>();
        this.map = new PlaneMap();
    }

    /**
     * Добавить самолет в "распоряжение" диспетчера.
     * @param plane - добавляемый самолет.
     */
    public void addPlane(Plane plane) {
        this.planeList.add(plane);
    }

    /**
     * Получить карту, созданную диспетчером.
     * Если она не создана - список меток самолетов пуст.
     * @return - карта самолетов.
     */
    public PlaneMap getMap() {
        return this.map;
    }

    public List getLandingPandingSet() {
        return this.planesPandingLanping;
    }

    public synchronized void requestLanding(Plane plane) {
        planesPandingLanping.add(plane);
    }

    public synchronized PlaneMap createMap() {
        for(Plane plane : planeList) {
            map.drawPlaneMarker(plane.getLocation());
        }

        return map;
    }
}
