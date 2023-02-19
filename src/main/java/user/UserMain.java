package user;

public class UserMain {
    public static void main(String[] args) {
        User user = new User( "Ivan", "xxx@mail.ru");

        System.out.println(user.checkLogin("Ivan", "xxx@mail.ru"));
        System.out.println(user.checkEmail("xxx@mial.ru"));

    }


}
