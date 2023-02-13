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
        this.user = new User("null", "null");
    }

    //    Когда логин и адрес электронной почты не переданы, то данные не установлены
    @Test
    @DisplayName("When the login and email address are not transmitted then the data is not set")
   public void createUserTest() {
        String actualResult = user.createUser("Ivan", "xxx@mail.ru");
        assertEquals("'Ivan' 'xxx@mail.ru'",
                actualResult, "Данные не установлены!");
    }


    //    Когда параметры в логин и е-мэйл не переданы, то объект "пользователь" не создается
    @Test
    @DisplayName("When the parameters in the login and e-mail are not passed" +
            " then the 'user' object is not created")
    public void correctUserTest() {
        String actualResult = user.correctUser("Ivan", "xxx@mail.ru");
        assertEquals("'Ivan' 'xxx@mail.ru'",
                actualResult, "Пользователь не создан! Заполните поля логин и e-mail!");
    }



    //    Когда e-mail не содержит '@' или '.', то выкидывается исключение
    @Test
    @DisplayName("When e-mail does not contain '@' or '.' then exception is thrown")
    void correctEmailTest() {
        assertThatThrownBy(() -> user.correctEmail("xxx mail ru"))
                .isInstanceOf(IncorrectFillingException.class);
    }


    //    Когда логин и адрес электронной почты идентичны, то выкидывается исключение
    @Test
    @DisplayName("When the login and email are identical, then exception is thrown")
    void loginEmailIdentity() {
        assertThatThrownBy(() -> user.loginEmail("Ivan", "Ivan"))
                .isInstanceOf(IncorrectFillingException.class);
    }
}