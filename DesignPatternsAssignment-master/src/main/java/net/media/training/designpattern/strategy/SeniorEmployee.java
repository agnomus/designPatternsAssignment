package net.media.training.designpattern.strategy;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:35:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeniorEmployee extends CompanyMember {
    private int setMaxBonus;
    private Validations maxBonusValidations;

    @Override
    public void setSalary(int salary) {
        salaryValidations.validations.add(new AtLeastValidation(salary, 200));
        salaryValidations.validations.add(new AtMostValidation(salary, 1000));
        super.setSalary(salary);
    }

    @Override
    public void setMonthsSpent(int months) {
        monthsSpentValidations.validations.add(new AtLeastValidation(months, 60));
        super.setMonthsSpent(months);
    }

    public void setMaxBonus(int bonus) {
        if(maxBonusValidations == null) maxBonusValidations = new Validations(new ArrayList<>());
        maxBonusValidations.validations.add(new AtLeastValidation(bonus, 1));
        maxBonusValidations.validate();
        this.setMaxBonus = bonus;
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
