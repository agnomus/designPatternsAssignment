package net.media.training.live.dip;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 13, 2011
 * Time: 10:20:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class EncodingModuleClient {
    public static void main(String[] args){

        EncodingModule fileEncodingModule = new FileEncoder();
        fileEncodingModule.encode();

        EncodingModule networkAndDatabaseEncoding = new NetworkAndDatabaseEncoder();
        networkAndDatabaseEncoding.encode();
    }
}
