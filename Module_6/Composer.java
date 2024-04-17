import java.util.List;
import java.util.ArrayList;

class Composer {
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
