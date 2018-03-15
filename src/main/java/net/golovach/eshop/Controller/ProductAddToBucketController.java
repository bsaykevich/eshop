package net.golovach.eshop.Controller;

import net.golovach.eshop.dao.ProductDao;
import net.golovach.eshop.dao.exception.DaoException;
import net.golovach.eshop.dao.impl.ProductDaoMock;
import net.golovach.eshop.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static net.golovach.eshop.Controller.SessionAttributes.PRODUCTS_IN_BUCKET;


public class ProductAddToBucketController extends HttpServlet {

    public static final String PARAM_ID = "id";
    public static final String PAGE_OK = "";
    public static final String PAGE_ERROR = "error.jsp";

    ProductDao productDao = new ProductDaoMock();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStr = req.getParameter(PARAM_ID);

        if (idStr != null) {
            try {
                Integer id = Integer.valueOf(idStr);
                Product product = productDao.selectById(id);

                HttpSession session = req.getSession(true);
                Map<Product, Integer> oldBucket = (Map<Product, Integer>) session.getAttribute(PRODUCTS_IN_BUCKET);


                if(oldBucket == null){
                    //TODO: correct this line
                    session.setAttribute(PRODUCTS_IN_BUCKET, Collections.singletonMap(product, 1));
                } else {
                    Map<Product, Integer> newBucket = new LinkedHashMap<>(oldBucket);
                    if (!newBucket.containsKey(product)) {
                        newBucket.put(product, 1);
                    } else {
                        Integer prodCount = newBucket.get(product);
                        newBucket.put(product, ++prodCount);
                    }
                    //unmodifiableMap: bucket can`t be changed in another place, but we have to use oldBucket->newBucket
                    session.setAttribute(PRODUCTS_IN_BUCKET, Collections.unmodifiableMap(newBucket));
                }

                String nextDestination = "product.do?id=" + id;
                resp.sendRedirect(nextDestination);


            }catch (NumberFormatException | DaoException e){
                //System.out.println("Invalid ID value!");
            }

            


        }
    }
}
