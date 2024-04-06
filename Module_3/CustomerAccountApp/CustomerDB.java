/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/
package Module_3.CustomerAccountApp;

public class CustomerDB {
    
    public static Customer getCustomer(Integer id) {
        Customer customer;
        if (id == 1007) {
            customer = new Customer("Scott Bob", "16960 W Maple Rd", "Omaha", "68116");
        } else if (id == 1008) {
            customer = new Customer("Edward Tom", "4700 N 27th St", "Lincoln", "68521");
        } else if (id == 1009) {
            customer = new Customer("Marta JR", "3201 Manawa Centre Dr", "Council Bluffs", "51501");
        } else {
            customer = new Customer(); // Default customer
        }
        return customer;
    }
}