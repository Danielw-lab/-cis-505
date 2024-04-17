/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/
import java.util.List;

public class Composer {
    private int id;
    private String name;
    private String genre;

    public Composer() {
        this.id = 0;
        this.name = "";
        this.genre = "";
    }

    public Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    // Accessor methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Id: " + id + "\nName: " + name + "\nGenre: " + genre;
    }
}

interface GenericDao<E, K> {
    List<E> findAll();

    E findBy(K key);

    void insert(E entity);
}

interface ComposerDao extends GenericDao<Composer, Integer> {
    // Additional methods specific to ComposerDao can be added here if needed
}