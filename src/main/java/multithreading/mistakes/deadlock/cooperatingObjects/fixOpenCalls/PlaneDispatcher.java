package multithreading.mistakes.deadlock.cooperatingObjects.fixOpenCalls;

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

    /**
     * Получить
     * @return
     */
    public List getLandingPandingSet() {
        return this.planesPandingLanping;
    }

    public synchronized void requestLanding(Plane plane) {
        planesPandingLanping.add(plane);
    }

    public synchronized PlaneMap createMap() {
        List<Plane> copy;

        /*
         * Синхронизация необходима воизбежании добавления новых самолетов
         * в процессе копирования.
         */
        synchronized (this) {
            copy = new ArrayList<>(planeList);
        }

        for(Plane plane : copy) {
            map.drawPlaneMarker(plane.getLocation());
        }

        return map;
    }
}
