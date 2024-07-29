package net.media.training.designpattern.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 9:12:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sun implements Subject {
    private boolean isUp;

    private final Map<String, List<Observer>> eventManager = new HashMap<>();

    public Sun() {
    }
    @Override
    public void addObserver(String event, Observer observer) {
        List<Observer> observers = eventManager.computeIfAbsent(event, k -> new ArrayList<>());
        observers.add(observer);
        observer.update(event);
    }

    @Override
    public void removeObserver(String event, Observer observer) {
        List<Observer> observers =  eventManager.get(event);
        if(observers == null)   return;
        observers.remove(observer);
    }

    private void notifyObservers(String event) {
        for (Observer observer : eventManager.get(event)) {
            observer.update(event);
        }
    }
    public boolean isUp() {
        return isUp;
    }

    public void set() {
        isUp = false;
        notifyObservers("sunset");
    }

    public void rise() {
        isUp = true;
        notifyObservers("sunrise");
    }
}