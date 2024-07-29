package net.media.training.designpattern.abstractfactory;

public class ConcreteMotherBoardFactory extends MotherBoardFactory{

    String phoneType;

    ConcreteMotherBoardFactory (String phoneType) {
        this.phoneType = phoneType;
    }

    public MotherBoard buildAndroidMotherBoard() {
        MotherBoard motherBoard = new AndroidMotherBoard();
        motherBoard.attachBattery(new Battery());
        motherBoard.attachProcessor(new AndroidProcessor());
        return motherBoard;
    }
    public MotherBoard buildIphoneMotherboard() {
        MotherBoard motherBoard = new IphoneMotherBoard();
        motherBoard.attachBattery(new Battery());
        motherBoard.attachProcessor(new IphoneProcessor());
        return motherBoard;
    }
    @Override
    public MotherBoard getMotherBoard() {
        switch (this.phoneType) {
            case "Android":
                return buildAndroidMotherBoard();
            case "Iphone":
                return buildIphoneMotherboard();
            default:
                throw new IllegalArgumentException("Unknown Phone type " + this.phoneType);
        }
    }
}
