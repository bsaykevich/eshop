package net.golovach.eshop.dao.exception;

/**
 * describe potential system problems with DB:
 * - access right failed;
 * - DB connection lost;
 * - DB password incorrect;
 * - DB worktime ended;
 */

public class DaoSystemException extends DaoException {

    public DaoSystemException(String message) {
        super(message);
    }

    public DaoSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
