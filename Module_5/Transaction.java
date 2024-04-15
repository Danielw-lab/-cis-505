/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/
package Module_5;

class Transaction {
    private String date;
    private String description;
    private double amount;

    // Constructors
    public Transaction() {
        setDate("MM-dd-yyyy"); // Default value is today's date
        setDescription("");
        setAmount(0);
    }

    public Transaction(String date, String description, double amount) {
        setDate(date);
        setDescription(description);
        setAmount(amount);
    }

    // Accessor and Mutator methods
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Date: " + date + "\nDescription: " + description + "\nAmount: $" + amount;
    }
}