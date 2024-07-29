package net.media.training.designpattern.composite;

//import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 19, 2011
 * Time: 9:18:51 PM
 * To change this template use pre_refactoring.File | Settings | pre_refactoring.File Templates.
 */
public class Directory implements FileSystemElement {
    private final String name;
    private final List<FileSystemElement> fileSystemElements;
    private Directory parent;

    public String getName() {
        return name;
    }

    public Directory(String name, List<FileSystemElement> fileSystemElements) {
        this.name = name;
        this.fileSystemElements = fileSystemElements;

        for (FileSystemElement fileSystemElement : fileSystemElements) {
            fileSystemElement.setParent(this);
        }
    }

    public Boolean isFile() {
        return false;
    }

    public int getSize(Directory directory) {
        int sum = 0;

        for(FileSystemElement element: directory.getFileSystemElements()) {
            if(element.isFile()) sum += element.getSize();
            else sum += getSize((Directory) element);
        }

        return sum;
    }

    public int getSize() {
        return getSize(this);
    }

    public void setParent(Directory directory) {
        this.parent = directory;
    }

    public void delete(Directory directoryToDelete) {
        while (!directoryToDelete.getFileSystemElements().isEmpty()) {
            FileSystemElement element = directoryToDelete.getFileSystemElements().get(0);
            if(element.isFile()) {
                element.getParent().removeEntry((File)element);
            }
            else {
                delete((Directory) element);
            }
        }
        directoryToDelete.getParent().removeEntry(directoryToDelete);
    }

    public void delete() {
        delete(this);
    }

    public void removeEntry(File file) {
        fileSystemElements.remove(file);
    }

    public void removeEntry(Directory directory) {
        fileSystemElements.remove(directory);
    }

    public void add(Directory directory) {
        fileSystemElements.add(directory);
    }

    public Boolean fileSystemElementExists(String name) {
        if (name.equals(getName())) {
            return true;
        }

        for (FileSystemElement element : fileSystemElements) {
            if (element.fileSystemElementExists(name))
                return true;
        }

        return false;
    }

    private List<FileSystemElement> getFileSystemElements() {
        return fileSystemElements;
    }

    public Directory getParent() {
        return parent;
    }
}
