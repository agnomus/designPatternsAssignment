package net.media.training.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

public class Validations implements Validation{
    List<Validation> validations = new ArrayList<>();

    Validations(List<Validation> validations) {
        this.validations = validations;
    }

    public void validate() {
        for(Validation validation: validations) {
            validation.validate();
        }
    }
}
