package net.media.training.designpattern.abstractfactory;

public class IphoneFactory implements AbstractPhoneFactory {

    @Override
    public Case getPhone(){
        MotherBoardFactory motherBoardFactory = new ConcreteMotherBoardFactory("Iphone");
        MotherBoard motherBoard = motherBoardFactory.getMotherBoard();
        Screen screen = new IphoneScreen();
        Case phoneCase = new IphoneCase();
        phoneCase.attachMotherBoard(motherBoard);
        phoneCase.attachScreen(screen);

        return phoneCase;
    }
}