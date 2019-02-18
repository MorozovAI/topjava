package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealsRepository;
import ru.javawebinar.topjava.model.inMemoryMealsRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Саша on 14.02.2019.
 */
public class MealServlet extends HttpServlet {

    private static final Logger log = getLogger(MealServlet.class);

    MealsRepository repository;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        repository = new inMemoryMealsRepository();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("ID");
        Meal meal = new Meal(id.isEmpty() ? null : Integer.parseInt(id),
                LocalDateTime.parse(request.getParameter("DateTime")),
                request.getParameter("Description"),
                Integer.parseInt(request.getParameter("Calories")));

        log.info(meal.isNew() ? " Create {}" : "Update {}", meal);
        repository.save(meal);

        response.sendRedirect("meals");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("getAll");


        String action = request.getParameter("action");

        switch (action == null ? "all" : action) {


            case "delete":
                log.info("delete");
                repository.delete(Integer.parseInt(request.getParameter("Id")));
                request.setAttribute("meals",
                        MealsUtil.getWithExcess(repository.getAll(), MealsUtil.CALORIES_PER_DAY));
                request.getRequestDispatcher("/meals.jsp").forward(request, response);
                break;
            case "edit":
            case "insert":
                final Meal meal = "insert".equals(action) ?
                        new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 1000) :
                        repository.get(Integer.parseInt(request.getParameter("Id")));
                request.setAttribute("meal", meal);
                request.getRequestDispatcher("/mealsForm.jsp").forward(request, response);
                break;

            case "all":
            default:
                log.info("getAll");
                request.setAttribute("meals",
                        MealsUtil.getWithExcess(repository.getAll(), MealsUtil.CALORIES_PER_DAY));
                request.getRequestDispatcher("/meals.jsp").forward(request, response);
                break;
        }

    }
}
