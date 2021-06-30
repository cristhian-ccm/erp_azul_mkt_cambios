package com.upgrade.persistence.util;

import java.util.List;

public interface ServiceInterface<T> {

    public List<T> list() throws Exception;

    public T save(T object) throws Exception;

    public T update(T object) throws Exception;

    public void delete(T object) throws Exception;

}
