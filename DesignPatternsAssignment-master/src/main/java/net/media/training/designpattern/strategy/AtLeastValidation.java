package net.media.training.designpattern.strategy;

public class AtLeastValidation implements Validation{
    int value;
    int min;
    AtLeastValidation(int value, int min) {
        this.value = value;
        this.min = min;
    }

    @Override
    public void validate() {
        if (value < min)
            throw new RuntimeException("at least check failed:" + value);
    }
}
