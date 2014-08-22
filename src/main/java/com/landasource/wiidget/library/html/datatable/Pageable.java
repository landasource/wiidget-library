package com.landasource.wiidget.library.html.datatable;

import java.util.Collection;

public interface Pageable<E> extends Collection<E> {

	public Collection<E> getPage(int page);

	public int getPageSize();
}
