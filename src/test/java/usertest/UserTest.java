package usertest;

import org.junit.jupiter.api.*;
import user.IncorrectFillingException;
import user.User;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        this.user = new User();
    }

    @Test
    @DisplayName("When the login and email parameters are passed to the User object, then they are set")
   public void userSetParamsTest() {
        User user = new User("Ivan", " xxx@mail.ru");
        String actualResult = user.getLogin() + user.getEmail();
         assertEquals("Ivan xxx@mail.ru", actualResult, "Parameters are not passed correctly");
    }

    @Test
    @DisplayName("When no parameters are passed to the User object, then the values are null")
    public void userNotParamsTest() {
        User userNull = new User();
        String actualResult = user.getLogin() + user.getEmail();
        assertEquals(userNull.getEmail(), userNull.getLogin(), actualResult);
    }

    @Test
    @DisplayName("When e-mail does not contain '@' or '.' then exception is thrown")
    void checkEmailTest() {
        assertThatThrownBy(() -> user.checkEmail("xxx mail ru"))
                .isInstanceOf(IncorrectFillingException.class);
    }

    @Test
    @DisplayName("When the login is equal to the email, then an exception is thrown")
    void checkLoginInequalityTest() {
        assertThatThrownBy(() -> user.checkLogin("Ivan", "Ivan"))
                .isInstanceOf(IncorrectFillingException.class);
    }
}