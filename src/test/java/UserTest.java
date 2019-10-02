import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void create_user() {

        // GIVEN - ARRANGE
        int id = 1;
        String lastName = "lastName";
        String firstName = "firstName";
        LocalDate date = LocalDate.now();

        // WHEN - ACT
        User result = new User(id, lastName, firstName, date);

        // THEN - ASSERT
        User expected = new User();
        expected.setId(1);
        expected.setLastName("lastName");
        expected.setFirstName("firstName");
        expected.setDate(date);
        Assertions.assertThat(result.toString()).isEqualTo(expected.toString());
    }


    @Test
    public void is_a_valid_user() {

        // GIVEN - ARRANGE
        User given = new User(1, "lastName", "firstName", LocalDate.now().minusYears(19));

        // WHEN - ACT
        boolean result = given.isValid();

        // THEN - ASSERT
        boolean expected = true;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void is_an_invalid_user_by_date() {

        // GIVEN - ARRANGE
        User given = new User(1, "lastName", "firstName", LocalDate.now());

        // WHEN - ACT
        boolean result = given.isValid();

        // THEN - ASSERT
        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void is_an_invalid_user_by_lastName() {

        // GIVEN - ARRANGE
        User given = new User(1, "", "firstName", LocalDate.now().minusYears(19));

        // WHEN - ACT
        boolean result = given.isValid();

        // THEN - ASSERT
        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void is_an_invalid_user_by_firstName() {

        // GIVEN - ARRANGE
        User given = new User(1, "lastName", "", LocalDate.now().minusYears(19));

        // WHEN - ACT
        boolean result = given.isValid();

        // THEN - ASSERT
        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }
}