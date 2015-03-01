package com.landasource.wiidget.library.html.datatable;

import java.util.Collection;
import java.util.List;

public interface Pageable<E> extends Collection<E> {

	public List<E> getPage(int page, int pageSize);

}
