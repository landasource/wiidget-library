package com.landasource.wiidget.library.html.datatable;

/**
 * Data paginator.
 *
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 */
public interface Paginator {

    int DEFAULT_PAGE_SIZE = 10;

    public int getCurrentPage();

    public int getPageCount();

    public int getPageSize();

}
