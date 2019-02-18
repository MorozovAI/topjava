package ru.javawebinar.topjava.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Саша on 14.02.2019.
 */
public class inMemoryMealsRepository implements MealsRepository {

    private AtomicInteger counter = new AtomicInteger(0);

    private Map<Integer, Meal> repository = new HashMap<>();


    @Override
    public Meal save(Meal meal) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            repository.put(meal.getId(), meal);
            return meal;
        }
        repository.put(meal.getId(), meal);
        return repository.get(meal.getId());
    }

    @Override
    public void delete(int id) {
        repository.remove(id);

    }

    @Override
    public Meal get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<Meal> getAllMeals() {
        return repository.values();
    }
}
