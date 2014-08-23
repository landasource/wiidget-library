package com.landasource.wiidget.library.html.datatable;

import com.landasource.wiidget.WiidgetException;
import com.landasource.wiidget.library.html.table.Table;

/**
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 */
public class PageableDataTable extends Table {

	private Pageable<?> pageable;

	@Override
	public void init() {
		super.init();

		if (getValue() instanceof Pageable == false) {
			throw new WiidgetException("Value must be pageable");
		}

		this.pageable = (Pageable<?>) super.getValue();
	}

	@Override
	public void run() {

		setValue(pageable.getPage(getCurrentPage()));

		super.run();
	}

	public int getDataSize() {
		return pageable.size();
	}

	protected int getCurrentPage() {

		final Paginator paginator = getPaginator();

		if (null == paginator) {
			return 1;
		}
		return paginator.getCurrentPage();
	}

	private Paginator getPaginator() {
		return getChildRecursive(Paginator.class);
	}

	public Pageable<?> getPageable() {
		return pageable;
	}

}
