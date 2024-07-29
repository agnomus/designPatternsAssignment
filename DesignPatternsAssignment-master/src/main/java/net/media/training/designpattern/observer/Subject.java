package net.media.training.designpattern.observer;

public interface Subject {
    void addObserver(String event, Observer observer);
    void removeObserver(String event, Observer observer);
}
