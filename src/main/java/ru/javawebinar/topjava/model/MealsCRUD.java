package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Саша on 14.02.2019.
 */
public interface MealsCRUD {

    void addMeals(LocalDateTime dateTime, String description, int calories);
    void editMeals(int id, LocalDateTime dateTime, String description, int calories);
    void deleteMeals(int id);
    List<Meal> getAllMeals();
}
