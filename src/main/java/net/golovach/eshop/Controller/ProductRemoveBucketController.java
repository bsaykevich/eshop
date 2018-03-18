package net.golovach.eshop.Controller;

import net.golovach.eshop.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

import static net.golovach.eshop.Controller.SessionAttributes.PRODUCTS_IN_BUCKET;

public class ProductRemoveBucketController extends HttpServlet{


    public static final String PAGE_OK = "productAll.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if(session != null) {

            Map<Product, Integer> bucket = (Map<Product, Integer>) session.getAttribute(PRODUCTS_IN_BUCKET);

            if (bucket != null) {
                session.setAttribute(PRODUCTS_IN_BUCKET, null);
            }
        }

        req.getRequestDispatcher(PAGE_OK).forward(req, resp);
    }
}
