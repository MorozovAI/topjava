package ru.javawebinar.topjava.web;

import org.springframework.stereotype.Controller;

import static ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;
@Controller
public class SecurityUtil {
    public static void setUserId(int userId) {
        SecurityUtil.userId = userId;
    }

    private static int userId;
    public static int authUserId() {
        return userId;
    }



    public static int authUserCaloriesPerDay() {
        return DEFAULT_CALORIES_PER_DAY;
    }
}