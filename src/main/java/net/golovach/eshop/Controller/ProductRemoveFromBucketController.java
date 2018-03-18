package net.golovach.eshop.Controller;

import net.golovach.eshop.dao.ProductDao;
import net.golovach.eshop.dao.exception.DaoException;
import net.golovach.eshop.dao.exception.DaoSystemException;
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

public class ProductRemoveFromBucketController extends HttpServlet{

    public static final String PARAM_ID = "id";
    ProductDao productDao = new ProductDaoMock();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStr = req.getParameter(PARAM_ID);
        Integer id = Integer.valueOf(idStr);

        HttpSession session = req.getSession(false);
        if(session != null) {

            Map<Product, Integer> bucket = (Map<Product, Integer>) session.getAttribute(PRODUCTS_IN_BUCKET);

            if (bucket != null) {
                try {

                    Product product = productDao.selectById(id);

                    Integer productCount = bucket.get(product);
                    if (productCount != null && productCount >= 0) {
                        Map<Product, Integer> newBucket = new LinkedHashMap<>(bucket);
                        if (productCount <= 1) {
                            newBucket.remove(product);
                        } else {
                            newBucket.put(product, --productCount);
                        }
                        session.setAttribute(PRODUCTS_IN_BUCKET, Collections.unmodifiableMap(newBucket));
                    }

                } catch (NumberFormatException | DaoException e) {

                }
            }
        }

        String nextDestination = "product.do?id=" + id;
        resp.sendRedirect(nextDestination);
    }
}

