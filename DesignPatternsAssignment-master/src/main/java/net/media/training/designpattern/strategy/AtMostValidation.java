package net.media.training.designpattern.strategy;

public class AtMostValidation implements Validation{
    int value;
    int max;
    AtMostValidation(int value, int max) {
        this.value = value;
        this.max = max;
    }

    @Override
    public void validate() {
        if (value > max)
            throw new RuntimeException("at least check failed:" + value);
    }
}