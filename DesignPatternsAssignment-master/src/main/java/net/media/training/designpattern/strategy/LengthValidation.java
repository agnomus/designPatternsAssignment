package net.media.training.designpattern.strategy;

public class LengthValidation implements Validation{
    String str;
    int allowedLength;
    LengthValidation(String str, int allowedLength) {
        this.str = str;
        this.allowedLength = allowedLength;
    }
    
    @Override
    public void validate() {
        if (str.length() > allowedLength)
            throw new RuntimeException("Invalid length:" + allowedLength);
    }
}
