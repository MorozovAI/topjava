package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Саша on 14.02.2019.
 */
public class MealsListCRUD implements MealsCRUD {
private static AtomicInteger counter = new AtomicInteger(5);



    private List<Meal> meals = Arrays.asList(
            new Meal(0,LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
            new Meal(1,LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
            new Meal(2,LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
            new Meal(3,LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
            new Meal(4,LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
            new Meal(5,LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));;

    @Override
    public void addMeals(LocalDateTime dateTime, String description, int calories) {
        meals.add(new Meal(counter.getAndIncrement(),dateTime, description, calories));
    }

    @Override
    public void editMeals(int id, LocalDateTime dateTime, String description, int calories) {
        meals.set(id, new Meal(id,dateTime, description, calories));
    }

    @Override
    public void deleteMeals(int id) {
        meals.remove(id);
    }

    @Override
    public List<Meal> getAllMeals() {
        return meals;
    }
}
