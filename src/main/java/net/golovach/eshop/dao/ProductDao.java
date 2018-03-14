package net.golovach.eshop.dao;

import net.golovach.eshop.dao.exception.DaoSystemException;
import net.golovach.eshop.dao.exception.NoSuchEntityException;
import net.golovach.eshop.entity.Product;

import java.util.List;

public interface ProductDao {

    Product selectById(Integer id) throws DaoSystemException, NoSuchEntityException;

    // we can add selectByName, priseDiapazone etc.

    List<Product> selectAll() throws DaoSystemException;
}
