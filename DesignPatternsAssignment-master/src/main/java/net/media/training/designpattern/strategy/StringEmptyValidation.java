package net.media.training.designpattern.strategy;

public class StringEmptyValidation implements Validation{
    String str;
    StringEmptyValidation(String str) {
        this.str = str;
    }

    @Override
    public void validate() {
        if (str == null || str.isEmpty())
            throw new RuntimeException("not empty check failed for value:" + str);
    }
}