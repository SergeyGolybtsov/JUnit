import org.example.User;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class UserTest {
    public static final String NORMAL_LOGIN = "login";
    public static final String NORMAL_EMAIL = "email@mail.ru";
    public static final String ILLEGAL_EMAIL = "email.ru";
    public static final String LOGIN_EQUALS_EMAIL = "email@mail.ru";

    @Test
    @DisplayName("Пользователь успешно создан")
    public void shouldCreateUserAllArgs() {
        User user = new User(NORMAL_LOGIN, NORMAL_EMAIL);
        assertEquals(NORMAL_LOGIN, user.getLogin());
        assertEquals(NORMAL_EMAIL, user.getEmail());
    }

    @Test
    @DisplayName("Пользователь успешно создан ")
    public void shouldCreateUserNoArgs() {
        User user = new User();
        assertNull(user.getEmail());
        assertNull(user.getLogin());
    }

    @Test
    @DisplayName("Почта должна содержать \"@\" и \".\"")
    public void isEmailValidCheck() {
        assertThrows(IllegalArgumentException.class, () -> new User(NORMAL_LOGIN, ILLEGAL_EMAIL));
    }

    @Test
    @DisplayName("Почта не должна совпадать с логином")
    public void isEmailEqualsLogin() {
        assertThrows(IllegalArgumentException.class, () -> new User(LOGIN_EQUALS_EMAIL, NORMAL_EMAIL));
    }
}
