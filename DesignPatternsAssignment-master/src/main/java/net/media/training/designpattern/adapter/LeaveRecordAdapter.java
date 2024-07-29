package net.media.training.designpattern.adapter;

import net.media.training.designpattern.adapter.thirdparty.ThirdPartyLeaveRecord;

import java.util.Arrays;

public class LeaveRecordAdapter implements LeaveRecord{
    ThirdPartyLeaveRecord leaveRecord = new ThirdPartyLeaveRecord();

    public String getNewerTypeName(String name) {
        String[] names = name.split(",");
        String[] firstName = names[1].trim().split("\\s+");
        String[] lastName = names[0].trim().split("\\s+");
        return String.join(" ", firstName) + " " + String.join(" ", lastName);
    }

    public String getOlderTypeName(String name) {
        String[] names = name.split("\\s+");
        String[] remainName = Arrays.copyOf(names, names.length - 1);
        return names[names.length - 1] + ", " + String.join(" ", remainName);
    }
    @Override
    public String getMostAbsentEmployee() {
        Employee employee = leaveRecord.getMostAbsentEmployee();
        return getNewerTypeName(employee.getName());
    }

    @Override
    public int getEmployeeAbsences(String name) {
        Employee employee = new Employee(getOlderTypeName(name));
        System.out.println(employee.getName());
        return leaveRecord.getEmployeeAbsences(employee);
    }
}
