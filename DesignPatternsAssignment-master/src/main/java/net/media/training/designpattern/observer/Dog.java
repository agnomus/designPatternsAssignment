package net.media.training.designpattern.observer;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 10:13:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dog implements Observer {
    private boolean outdoors;
    private boolean feelingWarm;
    private boolean feelingTired;
    private final Subject sun;

    Dog(Subject sun) {
        this.sun = sun;
    }

    public boolean isFeelingWarm() {
        return feelingWarm;
    }

    public void goOutdoors() {
        outdoors = true;
        sun.addObserver("sunrise", this);
        sun.addObserver("sunset", this);
    }

    public void goIndoors() {
        outdoors = false;
        feelingTired = true;
        sun.removeObserver("sunrise", this);
        sun.removeObserver("sunset", this);
    }

    public boolean isOutdoors() {
        return outdoors;
    }

    @Override
    public void update(String event){
        if(event.equals("sunrise")) {
            notifySunRose();
        }
        else {
            notifySunSet();
        }
    }

    public void notifySunRose() {
        feelingWarm = true;
    }

    public void notifySunSet() {
        feelingWarm = false;
        if (outdoors)
            feelingTired = true;
    }

    public boolean isFeelingTired() {
        return feelingTired;
    }
}
