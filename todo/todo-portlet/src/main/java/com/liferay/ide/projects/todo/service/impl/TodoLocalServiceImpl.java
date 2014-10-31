package com.liferay.ide.projects.todo.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.liferay.ide.projects.todo.TodoNameException;
import com.liferay.ide.projects.todo.model.Todo;
import com.liferay.ide.projects.todo.service.base.TodoLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

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

    public List<Todo> getUserTodos(long userId)
    {
        try
        {
            return todoPersistence.findByUserId(userId);
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public List<Todo> getUnfinishedUserTodos( long userId )
    {
        try
        {
            return todoPersistence.findByF_UserId( userId, false );
        }
        catch( SystemException e )
        {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public int getUnfinishedUserTodosCount( long userId )
    {
        try
        {
            return (int) todoPersistence.countByF_UserId( userId, false );
        }
        catch( SystemException e )
        {
            e.printStackTrace();
        }

        return 0;
    }

    public int getUserTodosCount(long userId)
    {
        try
        {
            return (int) todoPersistence.countByUserId(userId);
        }
        catch (SystemException e)
        {
            e.printStackTrace();
        }

        return 0;
    }

    public Todo addTodo( String name, String description, Date dueDate, ServiceContext serviceContext) throws PortalException, SystemException
    {
        final Date now = new Date();

        validate(name);

        final long todoId = counterLocalService.increment();

        final Todo todo = todoPersistence.create( todoId );

        todo.setUserId( serviceContext.getUserId() );
        todo.setCreateDate( serviceContext.getCreateDate( now ) );
        todo.setModifiedDate( serviceContext.getModifiedDate( now ) );
        todo.setName( name );
        todo.setDescription( description );
        todo.setFinished( false );
        todo.setDueDate( dueDate );

        todoPersistence.update( todo );

        return todo;
    }

    public void finishTodo( long todoId ) throws Exception
    {
        final Todo todo = fetchTodo( todoId );
        todo.setFinished( true );

        todoPersistence.update( todo );
    }

    protected void validate(String name) throws PortalException {
        if (Validator.isNull(name)) {
            throw new TodoNameException();
        }
    }
}
