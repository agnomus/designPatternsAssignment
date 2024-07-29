package net.media.training.designpattern.abstractfactory;

public class AndroidPhoneFactory implements AbstractPhoneFactory {

    @Override
    public Case getPhone(){
        MotherBoardFactory motherBoardFactory = new ConcreteMotherBoardFactory("Android");
        MotherBoard motherBoard = motherBoardFactory.getMotherBoard();
        Screen screen = new AndroidScreen();
        Case phoneCase = new AndroidCase();
        phoneCase.attachMotherBoard(motherBoard);
        phoneCase.attachScreen(screen);

        return phoneCase;
    }
}