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

    public static final String ATTRIBUTE_PRODUCTALL_TO_VIEW = "productList";
    public static final String PAGE_OK = "productAll.jsp";
    // can be initialized with DI?
    public static final String PAGE_ERROR = "error.jsp";
    //it is better not to redirect to error page, but suggest another similar product

    //DELEGATION PATTERN
    ProductDao productDao = new ProductDaoMock();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Product> model = productDao.selectAll();
            req.setAttribute(ATTRIBUTE_PRODUCTALL_TO_VIEW, model);
            req.getRequestDispatcher(PAGE_OK).forward(req, resp);
            return;
        } catch (DaoSystemException ignore) { /*do smth*/ }

       resp.sendRedirect(PAGE_ERROR);
    }
}
