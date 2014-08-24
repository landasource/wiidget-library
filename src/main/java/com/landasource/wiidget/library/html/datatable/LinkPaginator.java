package com.landasource.wiidget.library.html.datatable;

import com.landasource.wiidget.annotation.DefaultField;
import com.landasource.wiidget.library.html.TemplatedHtmlWiidget;
import com.landasource.wiidget.validator.Required;

/**
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 */
public class LinkPaginator extends TemplatedHtmlWiidget implements Paginator {

    @Required
    @DefaultField
    private PageableDataTable dataTable;

    private String cssClass = "pagination";

    @Required
    private String pageVar = "page";

    private String listCssClass = "paginator-list";

    private final String itemCssClass = "item";

    private String prevPageLabel = "&laquo;";

    private String nextPageLabel = "&raquo;";

    private boolean useAjax = false;

    private int pageSize = 10;

    public PageableDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(final PageableDataTable dataTable) {
        this.dataTable = dataTable;
    }

    @Override
    public int getCurrentPage() {
        final String clientPageVar = getClientPageVar();

        final Object pageObj = getWiidgetFactory().getWiidgetContext().get(clientPageVar);
        if (null == pageObj) {
            return 1;
        } else {

            return Integer.parseInt(pageObj.toString());
        }
    }

    @Override
    public int getPageCount() {
        final int listSize = getDataTable().getDataSize();

        return (int) Math.ceil(listSize / getPageSize());
    }

    public void setPageVar(final String pageVar) {
        this.pageVar = pageVar;
    }

    public String getClientPageVar() {
        final String tableId = getDataTable().getId();
        return tableId + "." + getPageVar();
    }

    public String getPageVar() {
        return pageVar;
    }

    public String getListCssClass() {
        return listCssClass;
    }

    public void setListCssClass(final String listCssClass) {
        this.listCssClass = listCssClass;
    }

    /**
     * @return the itemCssClass
     */
    public String getItemCssClass() {
        return itemCssClass;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(final String cssClass) {
        this.cssClass = cssClass;
    }

    public String getPrevPageLabel() {
        return prevPageLabel;
    }

    public void setPrevPageLabel(final String prevPageLabel) {
        this.prevPageLabel = prevPageLabel;
    }

    public String getNextPageLabel() {
        return nextPageLabel;
    }

    public void setNextPageLabel(final String nextPageLabel) {
        this.nextPageLabel = nextPageLabel;
    }

    /**
     * @return the useAjax
     */
    public boolean isUseAjax() {
        return useAjax;
    }

    /**
     * @param useAjax
     *            the useAjax to set
     */
    public void setUseAjax(final boolean useAjax) {
        this.useAjax = useAjax;
    }

    /**
     * @return the pageSize
     */
    @Override
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize
     *            the pageSize to set
     */
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

}
