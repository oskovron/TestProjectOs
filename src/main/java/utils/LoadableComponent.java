package utils;

public abstract class LoadableComponent<T extends LoadableComponent<T>> {

    protected abstract void isLoaded();

    protected abstract void load();

    public T get() {
        load();
        isLoaded();
        return (T) this;
    }

}
