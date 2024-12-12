package Controllers;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;

public class UserController {

    @Step("Создание пользователя")
    public Response postUser(String email, String password, String name) {
        HashMap<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("password", password);
        map.put("name", name);
        return Specification.getRequestSpecification().body(map).post("/api/auth/register");
    }

    @Step("Логин пользователя")
    public Response loginUser(String email, String password) {
        HashMap<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("password", password);
        return Specification.getRequestSpecification().body(map).post("/api/auth/login");
    }

    @Step("Удаление пользователя")
    public Response deleteUser(String token) {
        return Specification.getRequestSpecification()
                .header("Authorization", token)
                .delete("/api/auth/user");
    }
}
