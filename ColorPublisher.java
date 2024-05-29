import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

// Define a class named ColorPublisher responsible for managing subscribers and publishing color changes
public class ColorPublisher {
    // Declare a private list for storing subscribers
    private List<ColorSubscriber> subscribers;

    // Used Constructor for initializing the list of subscribers
    public ColorPublisher() {
        subscribers = new ArrayList<>();
    }

    // Method for add a subscriber to the list
    public synchronized void addSubscriber(ColorSubscriber cs) {
        subscribers.add(cs);
    }

    // Method for publish color changes to all subscribers
    public synchronized void publish(Color c) {
        // Notify all subscribers of the color change
        for (ColorSubscriber subscriber : subscribers) {
            subscriber.notifyColorChange(c);
        }
    }
}
