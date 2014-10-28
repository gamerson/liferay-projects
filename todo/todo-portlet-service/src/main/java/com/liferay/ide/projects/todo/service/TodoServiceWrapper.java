package com.liferay.ide.projects.todo.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TodoService}.
 *
 * @author Brian Wing Shun Chan
 * @see TodoService
 * @generated
 */
public class TodoServiceWrapper implements TodoService,
    ServiceWrapper<TodoService> {
    private TodoService _todoService;

    public TodoServiceWrapper(TodoService todoService) {
        _todoService = todoService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _todoService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _todoService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _todoService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TodoService getWrappedTodoService() {
        return _todoService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTodoService(TodoService todoService) {
        _todoService = todoService;
    }

    @Override
    public TodoService getWrappedService() {
        return _todoService;
    }

    @Override
    public void setWrappedService(TodoService todoService) {
        _todoService = todoService;
    }
}
