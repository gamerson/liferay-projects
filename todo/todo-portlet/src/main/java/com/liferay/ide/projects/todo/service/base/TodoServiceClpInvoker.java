package com.liferay.ide.projects.todo.service.base;

import com.liferay.ide.projects.todo.service.TodoServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TodoServiceClpInvoker {
    private String _methodName30;
    private String[] _methodParameterTypes30;
    private String _methodName31;
    private String[] _methodParameterTypes31;
    private String _methodName36;
    private String[] _methodParameterTypes36;
    private String _methodName37;
    private String[] _methodParameterTypes37;
    private String _methodName38;
    private String[] _methodParameterTypes38;

    public TodoServiceClpInvoker() {
        _methodName30 = "getBeanIdentifier";

        _methodParameterTypes30 = new String[] {  };

        _methodName31 = "setBeanIdentifier";

        _methodParameterTypes31 = new String[] { "java.lang.String" };

        _methodName36 = "addTodo";

        _methodParameterTypes36 = new String[] {
                "java.lang.String", "java.lang.String", "java.util.Date",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName37 = "getUnfinishedUserTodos";

        _methodParameterTypes37 = new String[] { "long" };

        _methodName38 = "finishTodo";

        _methodParameterTypes38 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName30.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
            return TodoServiceUtil.getBeanIdentifier();
        }

        if (_methodName31.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
            TodoServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName36.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
            TodoServiceUtil.addTodo((java.lang.String) arguments[0],
                (java.lang.String) arguments[1], (java.util.Date) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);

            return null;
        }

        if (_methodName37.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
            return TodoServiceUtil.getUnfinishedUserTodos(((Long) arguments[0]).longValue());
        }

        if (_methodName38.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
            TodoServiceUtil.finishTodo(((Long) arguments[0]).longValue());

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
