/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/
import java.util.ArrayList;
import java.util.List;

    public class MemComposerDao implements ComposerDao {
        private List<Composer> composers;
    
        public MemComposerDao() {
            composers = new ArrayList<>();
            // Default list of five composers
            composers.add(new Composer(1007, "Ludwig Van Beethoven", "Classical"));
            composers.add(new Composer(1008, "Johann Sebastian Bach", "Classical"));
            composers.add(new Composer(1009, "Wolfgang Amadeus Mozart", "Classical"));
            composers.add(new Composer(1010, "Johannes Brahm", "Classical"));
            composers.add(new Composer(1011, "Joseph Haydn", "Classical"));
        }
    
        @Override
        public List<Composer> findAll() {
            return composers;
        }
    
        @Override
        public Composer findBy(Integer id) {
            for (Composer composer : composers) {
                if (composer.getId() == id) {
                    return composer;
                }
            }
            return null; // Return null if composer with given id is not found
        }
    
        @Override
        public void insert(Composer entity) {
            composers.add(entity);
        }
    }
    