package com.liferay.ide.projects.todo.service.impl;

import java.util.List;

import com.liferay.ide.projects.todo.model.Todo;
import com.liferay.ide.projects.todo.service.TodoLocalServiceUtil;
import com.liferay.ide.projects.todo.service.base.TodoServiceBaseImpl;

/**
 * The implementation of the todo remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.ide.projects.todo.service.TodoService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.ide.projects.todo.service.base.TodoServiceBaseImpl
 * @see com.liferay.ide.projects.todo.service.TodoServiceUtil
 */
public class TodoServiceImpl extends TodoServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.ide.projects.todo.service.TodoServiceUtil} to access the todo remote service.
     */

    public List<Todo> getUnfinishedUserTodos( long userId )
    {
        return TodoLocalServiceUtil.getUnfinishedUserTodos( userId );
    }

    public void finishTodo( long todoId )
    {
        try
        {
            TodoLocalServiceUtil.finishTodo( todoId );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
