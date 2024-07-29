package net.media.training.designpattern.abstractfactory;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 6:34:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhoneMaker {

    public Case buildPhone(String phoneType) {
        AbstractPhoneFactory abstractPhoneFactory;
        switch (phoneType) {
            case "Android":
                abstractPhoneFactory = new AndroidPhoneFactory();
                return abstractPhoneFactory.getPhone();
            case "Iphone":
                abstractPhoneFactory = new IphoneFactory();
                return abstractPhoneFactory.getPhone();
            default:
                throw new IllegalArgumentException("Unknown Phone type " + phoneType);
        }
    }
}
