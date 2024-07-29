package net.media.training.designpattern.observer;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 9:35:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person implements Observer {
    private boolean feelingWarm;
    private boolean outdoors;
    private boolean feelingTired;
    private final Subject sun;

    Person(Subject sun) {
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

    @Override
    public void update(String event){
        if(event.equals("sunrise")) {
            notifySunRose();
        }
        else {
            notifySunSet();
        }
    }

    public boolean isOutdoors() {
        return outdoors;
    }

    public void notifySunRose() {
        if (outdoors)
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
