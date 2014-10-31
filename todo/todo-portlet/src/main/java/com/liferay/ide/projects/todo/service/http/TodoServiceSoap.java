package com.liferay.ide.projects.todo.service.http;

import com.liferay.ide.projects.todo.service.TodoServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.ide.projects.todo.service.TodoServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.ide.projects.todo.model.TodoSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.ide.projects.todo.model.Todo}, that is translated to a
 * {@link com.liferay.ide.projects.todo.model.TodoSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoServiceHttp
 * @see com.liferay.ide.projects.todo.model.TodoSoap
 * @see com.liferay.ide.projects.todo.service.TodoServiceUtil
 * @generated
 */
public class TodoServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(TodoServiceSoap.class);

    public static com.liferay.ide.projects.todo.model.TodoSoap[] getUnfinishedUserTodos(
        long userId) throws RemoteException {
        try {
            java.util.List<com.liferay.ide.projects.todo.model.Todo> returnValue =
                TodoServiceUtil.getUnfinishedUserTodos(userId);

            return com.liferay.ide.projects.todo.model.TodoSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void finishTodo(long todoId) throws RemoteException {
        try {
            TodoServiceUtil.finishTodo(todoId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
