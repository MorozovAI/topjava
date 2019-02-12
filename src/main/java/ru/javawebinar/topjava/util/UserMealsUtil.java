package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        for (UserMealWithExceed u : getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000)) {
            System.out.println(u.getDateTime() + " " + u.getCalories() + " " + u.getDescription() + " " + u.isExceed());
        }
//        .toLocalDate();
//        .toLocalTime();

    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
                List<UserMealWithExceed> result = new ArrayList<>();
        Map<LocalDate, Integer> map = new HashMap<>();

        for (UserMeal uM : mealList) {
            int calories = uM.getCalories();
            LocalDate ld = uM.getDateTime().toLocalDate();
            map.put(ld, map.getOrDefault(ld,0) + calories);


        }
        for (UserMeal uM : mealList) {
            LocalDate ld = uM.getDateTime().toLocalDate();
            LocalTime lt = uM.getDateTime().toLocalTime();
            if (TimeUtil.isBetween(lt, startTime, endTime)) {
                if (map.get(ld) > caloriesPerDay)
                    result.add(new UserMealWithExceed(uM.getDateTime(), uM.getDescription(), uM.getCalories(), true));
                else result.add(new UserMealWithExceed(uM.getDateTime(), uM.getDescription(), uM.getCalories(), false));
            }

        }


        return result;
    }
}
