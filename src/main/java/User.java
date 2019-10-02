import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class User {
    private int id;
    private String lastName;
    private String firstName;
    private LocalDate date;

    public User(){

    }

    public User(int id, String lastName, String firstName, LocalDate date) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", date=" + date +
                '}';
    }

    public boolean isValid(){
        return(this.lastName != "" && this.firstName != "" && isMajeur());
    }

    private boolean isMajeur(){
        LocalDate localDate = LocalDate.now();
        return this.date.getYear() <= localDate.minusYears(18).getYear();
    }
}
