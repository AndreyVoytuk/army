package interfaces;

public interface Observer {
    void addObservable(Observable observable);
    void removeObservable(Observable observable);
    void notifyObservables();
}