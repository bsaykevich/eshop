package net.golovach.eshop.Controller;

import net.golovach.eshop.dao.ProductDao;
import net.golovach.eshop.dao.exception.DaoSystemException;
import net.golovach.eshop.dao.impl.ProductDaoMock;
import net.golovach.eshop.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductAllController extends HttpServlet {

    ProductDao productDao = new ProductDaoMock();

    public static final String ATTRIBUTE_PRODUCTALL_TO_VIEW = "productAll";
    public static final String PAGE_PRODUCTALL = "productAll.jsp";
    // can be initialized with DI?
    public static final String PAGE_ERROR = "error.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Product> products = productDao.selectAll();
            req.setAttribute(ATTRIBUTE_PRODUCTALL_TO_VIEW, products);
            req.getRequestDispatcher(PAGE_PRODUCTALL).forward(req, resp);
            return;
        } catch (DaoSystemException e) { /*do smth*/ }

       resp.sendRedirect(PAGE_ERROR);
    }
}
