package net.media.training.live.lsp;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 11, 2011
 * Time: 12:56:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersistentObject<T> {
    private String data;

    public PersistentObject(T data) {
        this.data = data.toString();
    }

    public Object getData() {
        return this.data;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    public boolean equals(Object other) {
        return this.data.equals(other);
    }
}
