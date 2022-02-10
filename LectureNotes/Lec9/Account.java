public class Account {
    private int id;
    private String name;

    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    // Note that the signature is Other, not Account
    public boolean equals (Object other) {
        // Make sure that the other object is instanciated
        if (other == null) {
            return false;
        // Test whether the other object is of the same type as this object
        } else if (this.getClass() != other.getClass()) {
            return false;
        } else {
            // We can safely type cast because of the above case
            // Now we can access the attrilbutes that are specific to the Account class
            Account acc = (Account) other;

            if (this.id != acc.id) {
                return false;
            // Before manipulating objects, first check if they are null
            } else if (this.name == null && acc.name != null) {
                return false;
            } else if (this.name != null && !this.name.equals(acc.name)) {
                return false;
            }
        }

        return true;
    }
}