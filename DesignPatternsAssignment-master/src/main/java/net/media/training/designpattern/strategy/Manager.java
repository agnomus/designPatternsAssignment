package net.media.training.designpattern.strategy;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:37:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Manager extends CompanyMember {
    private String managementBand;
    private Validations managementBandValidations;

    @Override
    public void setSalary(int salary) {
        salaryValidations.validations.add(new AtLeastValidation(salary, 1));
        super.setSalary(salary);
    }
    @Override
    public void setManagerName(String name) {
        managerNameValidations.validations.add(new LengthValidation(name, 50));
        super.setManagerName(name);
    }

    @Override
    public void setName(String name) {
        nameValidations.validations.add(new LengthValidation(name, 50));
        super.setName(name);
    }

    public void setMonthsSpent(int months) {
        super.setMonthsSpent(months);
    }

    public void setManagementBand(String managementBand) {
        if(managementBandValidations == null) managementBandValidations = new Validations(new ArrayList<>());
        managementBandValidations.validations.add(new StringEmptyValidation(managementBand));
        managementBandValidations.validate();
        this.managementBand = managementBand;
    }
}
