package observer;


// Observer pattern - https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
// Interface koji implementiraju sve klase koje zele da se obaveste o promeni nad modelom
// kako bi mogle da se osveze
public interface Observer {

    void update(Object notification);

}
