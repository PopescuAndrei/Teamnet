package exercise2;

/**
 * Created by Radu.Hoaghe on 20.04.2015.
 */
public class Student {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final Double averageGrade;

    public Student(Integer id, String firstName, String lastName, Double averageGrade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.averageGrade = averageGrade;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    // TODO Exercise 2 a) Override the toString() method
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " " + getAverageGrade();
    }

    // TODO Exercise 2 c) Override the equals() method
    @Override
    public boolean equals(Object o) {
        // TODO Exercise 2 c1) Check if the current instance is the same instance as the one from Object o
        if(!(this instanceof Object)){
            return false;
        }
        if(o == null){
            return false;
        }
        if((o instanceof Student)) {
            Student other = (Student) o;
            if (id.equals(other.getId())) {
                if (lastName.equals(other.getLastName())) {
                    if (firstName.equals(other.getFirstName())) {
                        return averageGrade.equals(other.getAverageGrade());
                    }
                }
            }
        }
        return false;

        // TODO Exercise 2 d) After you finished implementing equals method go to TODO Exercise 2 e) from Exercise2 class
    }

    // TODO Exercise 2 g) Override the hashCode() method
    // TODO Exercise 2 g) Hint: Don't forget to include in the hashCode result all the fields from
    // TODO Exercise 2 g) the Student class
    @Override
    public int hashCode() {
        int result = 0;
        result = id + lastName.hashCode() + firstName.hashCode() + averageGrade.hashCode();
        return result;
    }

}
