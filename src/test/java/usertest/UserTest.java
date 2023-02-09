package usertest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.User;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private final User user = new User("Ivan", "xxx@mail.ru");


    //    Когда логин и адрес электронной почты переданы правильно, то объект user успешно создан
    @Test
    @DisplayName("When the login and e-mail are correctly passed, then the user object is successfully created")
    void createUserTest() {
        String actualResult = user.realUser("Ivan", "xxx@mail.ru");
        assertEquals("User created 'correct' 'correct'!"
                , actualResult, "Необходимо корректно заполнить логин и e-mail");
    }


    //    Когда в логин и емейл не переданы параметры, то создание пользователя не выполняется
    @Test
    @DisplayName("When parameters are not passed to the login and e-mail, then the user creation is not performed.")
    void nullUserParametersTest() {
        String actualResult = user.realUser("Ivan", "xxx@mail.ru");
        assertEquals("User created 'correct' 'correct'!", actualResult,
                "Пользователь не создан! Введите корректно логин и email!");
    }



    //    Когда e-mail содержит '@' или '.', то e-mail указан правильно
    @Test
    @DisplayName("When the e-mail contains '@' or '.', then the e-mail is correct")
    void correctUserEmailTest() {
        String actualResult = user.correctEmail("xxx@mail.ru");
        assertEquals("correct", actualResult, "Адрес заполнен не верно!");
    }


    //    Когда логин и адрес электронной почты идентичны, то создание пользователя не выполняется
    @Test
    @DisplayName("When the login and email are identical, then the creation of the user is incorrect")
    void loginEmailIdentity() {
        String actualResult = user.loginEmail("yyy", "xxx@mail.ru");
        assertEquals("correct", actualResult, "Логин и e-mail пользователя не должны совпадать!");
    }
}