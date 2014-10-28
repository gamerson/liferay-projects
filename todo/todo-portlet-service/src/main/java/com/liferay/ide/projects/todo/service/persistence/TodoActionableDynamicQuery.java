package com.liferay.ide.projects.todo.service.persistence;

import com.liferay.ide.projects.todo.model.Todo;
import com.liferay.ide.projects.todo.service.TodoLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class TodoActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public TodoActionableDynamicQuery() throws SystemException {
        setBaseLocalService(TodoLocalServiceUtil.getService());
        setClass(Todo.class);

        setClassLoader(com.liferay.ide.projects.todo.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("todoId");
    }
}
