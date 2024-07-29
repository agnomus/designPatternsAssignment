package net.media.training.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:14:31 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class CompanyMember {
    private String name;
    protected String mgrName;
    protected int salary;
    protected int monthsSpent;
    public Validations nameValidations;
    public Validations salaryValidations;
    public Validations managerNameValidations;
    public Validations monthsSpentValidations;

    CompanyMember() {
        this.nameValidations = new Validations(new ArrayList<>());
        this.salaryValidations = new Validations(new ArrayList<>());
        this.managerNameValidations = new Validations(new ArrayList<>());
        this.monthsSpentValidations = new Validations(new ArrayList<>());
    }

    public void setName(String name) {
        nameValidations.validate();
        this.name = name;
    }

    public void setSalary(int salary) {
        salaryValidations.validate();
        this.salary = salary;
    }

    public void setManagerName(String name) {
        managerNameValidations.validate();
        this.mgrName = name;
    }

    public void setMonthsSpent(int months) {
        monthsSpentValidations.validate();
        this.monthsSpent = months;
    }
}
