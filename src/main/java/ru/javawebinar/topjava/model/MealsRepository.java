package ru.javawebinar.topjava.model;

import java.util.Collection;

/**
 * Created by Саша on 14.02.2019.
 */
public interface MealsRepository {

    Meal save(Meal meal);

    void delete(int id);

    Meal get(int id);

    Collection<Meal> getAll();
}
