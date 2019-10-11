package multithreading.mistakes.deadlock.cooperatingObjects;


import multithreading.mistakes.deadlock.cooperatingObjects.fixOpenCalls.Plane;
import multithreading.mistakes.deadlock.cooperatingObjects.fixOpenCalls.PlaneDispatcher;

//import multithreading.mistakes.deadlock.cooperatingObjects.bug.Plane;
//import multithreading.mistakes.deadlock.cooperatingObjects.bug.PlaneDispatcher;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        PlaneDispatcher planeDispatcher = new PlaneDispatcher();
        Plane plane = new Plane(planeDispatcher, "Moscow");

        Runnable dispatcherTask = planeDispatcher::createMap;
        Runnable planeTask = () -> {
            plane.setLocation("Moscow");
        };

        Thread dispatcherThread = new Thread(dispatcherTask);
        Thread planeThread = new Thread(planeTask);

        dispatcherThread.start();
        planeThread.start();

        Thread.sleep(1000);

        if(!dispatcherThread.isAlive() && !planeThread.isAlive()) {
            if(planeDispatcher.getMap().getMarks().isEmpty()) {
                System.out.println("The dispatcher could not create a map. The program worked incorrectly!");
            } else {
                System.out.println("Map created successfully!");
            }

            if(planeDispatcher.getLandingPandingSet().isEmpty()) {
                System.out.println("The dispatcher could not land the plane. The program worked incorrectly!");
            } else {
                System.out.println("The plane has landed!");
            }
        }
    }
}
