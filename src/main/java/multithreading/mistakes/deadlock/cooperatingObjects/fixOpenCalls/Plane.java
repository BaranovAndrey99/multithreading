package multithreading.mistakes.deadlock.cooperatingObjects.fixOpenCalls;

public class Plane {
    private String location, destination;
    private final PlaneDispatcher dispatcher;

    public Plane(PlaneDispatcher dispatcher, String destination) {
        this.dispatcher = dispatcher;
        this.destination = destination;
        this.dispatcher.addPlane(this);
    }

    /**
     * Получение местоположения самолета.
     * @return - местоположение самолета.
     */
    public synchronized String getLocation() {
        return this.location;
    }

    /**
     * Установить текущее положение самолета.
     * @param location - текущее местоположение.
     */
    public void setLocation(String location) {
        boolean destinationIsReached;
        synchronized (this) {
            this.location = location;
            destinationIsReached = location.equals(destination);
        }
        if (destinationIsReached) {
            dispatcher.requestLanding(this);
        }
    }
}
