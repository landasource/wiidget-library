package com.landasource.wiidget.library.html.datatable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListPageable<E> extends ArrayList<E> implements Pageable<E> {

	private static final long serialVersionUID = -9131442573060608098L;

	public ArrayListPageable(final Collection<E> list) {
		super(list);
	}

	@Override
	public List<E> getPage(final int currentPage, final int pageSize) {

		final int fromItem = pageSize * (currentPage - 1);
		final int toItem = pageSize * currentPage;

		if (this.size() < toItem) {
			return this;
		}
		return this.subList(fromItem, toItem);
	}

}
