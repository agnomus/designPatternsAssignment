package net.media.training.designpattern.strategy;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:31:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Employee extends CompanyMember {
    private int maxAllowedLeaves;
    private Validations maxAllowedLeavesValidations;

    @Override
    public void setSalary(int salary) {
        salaryValidations.validations.add(new AtLeastValidation(salary, 1));
        salaryValidations.validations.add(new AtMostValidation(salary, 1000));
        super.setSalary(salary);
    }

    @Override
    public void setMonthsSpent(int months) {
        monthsSpentValidations.validations.add(new AtLeastValidation(months, 0));
        super.setMonthsSpent(months);
    }

    public void setMaxAllowedLeaves(int leaves) {
        if(maxAllowedLeavesValidations == null) maxAllowedLeavesValidations = new Validations(new ArrayList<>());
        maxAllowedLeavesValidations.validations.add(new AtLeastValidation(leaves, 1));
        maxAllowedLeavesValidations.validate();
        this.maxAllowedLeaves = leaves;
    }

    @Override
    public void setManagerName(String name) {
        managerNameValidations.validations.add(new LengthValidation(name, 50));
        managerNameValidations.validations.add(new StringEmptyValidation(name));
        super.setManagerName(name);
    }

    @Override
    public void setName(String name) {
        nameValidations.validations.add(new LengthValidation(name, 50));
        super.setName(name);
    }
}

