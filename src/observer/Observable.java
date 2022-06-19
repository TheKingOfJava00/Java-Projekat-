package observer;

import java.util.ArrayList;
import java.util.List;


// Klasa koju nasledjuju sve klase koje zele da imaju svoje "slusaoce" (Observere) kako bi im javili da se osveze
public class Observable {

    public List<Observer> observers = new ArrayList<>();

    // Dodaje observera u listu slusaca
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    // Metoda koje prolazi kroz listu sve slusaca i obavestava ih da se desila promena
    public void notifyObservers(Object notification) {
        for (Observer o: observers) {
            o.update(notification);
        }
    }
}
