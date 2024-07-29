package net.media.training.designpattern.composite;

public interface FileSystemElement {
    void setParent(Directory parent);
    String getName();
    int getSize();
    Directory getParent();
    Boolean isFile();
    Boolean fileSystemElementExists(String name);
    void delete();
}
