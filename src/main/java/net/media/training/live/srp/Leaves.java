package net.media.training.live.srp;

public class Leaves {

    private static int TOTAL_LEAVES_ALLOWED = 30;
    private int leavesTaken;
    private int leaveTaken;
    private int[] leavesLeftPreviously;
    private int yearsInOrg;

    public Leaves(int leavesTaken, int[] leavesLeftPreviously) {
        this.leavesTaken = leavesTaken;
        this.leavesLeftPreviously = leavesLeftPreviously;
        this.yearsInOrg = leavesLeftPreviously.length;
    }

    public static int getTotalLeavesAllowed() {
        return TOTAL_LEAVES_ALLOWED;
    }

    public static void setTotalLeavesAllowed(int totalLeavesAllowed) {
        TOTAL_LEAVES_ALLOWED = totalLeavesAllowed;
    }
    public int[] getLeavesLeftPreviously() {
        return leavesLeftPreviously;
    }

    public void setLeavesLeftPreviously(int[] leavesLeftPreviously) {
        this.leavesLeftPreviously = leavesLeftPreviously;
    }

    public int getLeaveTaken() {
        return leaveTaken;
    }

    public void setLeaveTaken(int leaveTaken) {
        this.leaveTaken = leaveTaken;
    }

    public int getLeavesTaken() {
        return leavesTaken;
    }

    public void setLeavesTaken(int leavesTaken) {
        this.leavesTaken = leavesTaken;
    }

    public int getYears() {
        int years = 3;
        if (this.getYearsInOrg() < 3) {
            years = this.getYearsInOrg();
        }
        return years;
    }
    public int getTotalLeavesLeftPreviously() {
        int totalLeaveLeftPreviously = 0;
        for (int i = 0; i < this.getYears(); i++) {
            totalLeaveLeftPreviously += this.getLeavesLeftPreviously()[this.getYearsInOrg()-i-1];
        }
        return totalLeaveLeftPreviously;
    }

    public int getYearsInOrg() {
        return yearsInOrg;
    }

    public void setYearsInOrg(int yearsInOrg) {
        this.yearsInOrg = yearsInOrg;
    }
}
