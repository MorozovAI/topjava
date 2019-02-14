package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.MealsCRUD;
import ru.javawebinar.topjava.model.MealsListCRUD;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Саша on 14.02.2019.
 */
public class MealServlet extends HttpServlet {

    private static final Logger log = getLogger(MealServlet.class);

    MealsCRUD mealsCRUD;

    public MealServlet() {
        MealsCRUD mealsCRUD = new MealsListCRUD();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.debug("forward to meals");


        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            mealsCRUD.deleteMeals(id);

            request.setAttribute("meals", MealsUtil.getFilteredWithExcess(mealsCRUD.getAllMeals(), LocalTime.MIN, LocalTime.MAX, 2000));
            request.getRequestDispatcher("/meals.jsp").forward(request, response);
        } else         request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}
