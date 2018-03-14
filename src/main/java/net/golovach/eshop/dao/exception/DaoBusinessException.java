package net.golovach.eshop.dao.exception;

/**
 * It is better to create Exceptions due to Entity problem types but not for particular types of Entity
 *
 * This Exception is used for problems related to business logic:
 * - DB doesn`t contain required entity (product, user, discount etc.);
 * - DB already contains the entity you try to insert;
 * - DB already contains User with such login;
 */

public class DaoBusinessException extends DaoException {

    public DaoBusinessException(String message) {
        super(message);
    }

    public DaoBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
