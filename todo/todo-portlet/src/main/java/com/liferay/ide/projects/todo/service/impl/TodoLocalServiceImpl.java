package com.liferay.ide.projects.todo.service.impl;

import java.util.Collections;
import java.util.List;

import com.liferay.ide.projects.todo.model.Todo;
import com.liferay.ide.projects.todo.service.base.TodoLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the todo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.ide.projects.todo.service.TodoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.ide.projects.todo.service.base.TodoLocalServiceBaseImpl
 * @see com.liferay.ide.projects.todo.service.TodoLocalServiceUtil
 */
public class TodoLocalServiceImpl extends TodoLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.ide.projects.todo.service.TodoLocalServiceUtil} to access the todo local service.
     */

    public List<Todo> getUserTodos(long userId) {
        try {
            return todoPersistence.findByUserId(userId);
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public int getUserTodosCount(long userId) {
        try {
            return (int) todoPersistence.countByUserId(userId);
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
