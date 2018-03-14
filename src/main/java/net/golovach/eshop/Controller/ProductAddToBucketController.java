package net.golovach.eshop.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class ProductAddToBucketController extends HttpServlet {

    public static final String PARAM_ID = "id";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter(PARAM_ID);

        if (parameter != null) {
            Integer id;
            try {
                id = Integer.valueOf(PARAM_ID);
            }catch (NumberFormatException e){
                System.out.println("Invalid ID value!");
            }

            


        }
    }
}
