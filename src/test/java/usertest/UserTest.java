package usertest;

import org.junit.jupiter.api.*;
import user.IncorrectFillingException;
import user.User;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user = new User("Ivan", "xxx@mail.ru");

    @BeforeEach
    void setUp() {
        this.user = new User(" ", " ");
    }


//    нужно создать конструктор по умолчанию в классе юзер, в тесте создать юзера
//    без параметров и проверить, что в юзере действительно нет параметров.
    @Test
    @DisplayName("When the login and email address are not transmitted then the data is not set")
   public void userWithoutParamsTest() {
        User user = new User();
        assertEquals(null, user.getLogin(), "XXX");
    }



    //    Когда e-mail не содержит '@' или '.', то выкидывается исключение
    @Test
    @DisplayName("When e-mail does not contain '@' or '.' then exception is thrown")
    void checkEmailTest() {
        assertThatThrownBy(() -> user.checkEmail("xxx mail ru"))
                .isInstanceOf(IncorrectFillingException.class);
    }

    //    Когда логин и адрес электронной почты идентичны, то выкидывается исключение
    @Test
    @DisplayName("When the login and email are identical, then exception is thrown")
    void checkLoginInequalityTest() {
        assertThatThrownBy(() -> user.checkLogin("Ivan", "Ivan"))
                .isInstanceOf(IncorrectFillingException.class);
    }
}