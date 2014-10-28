package com.liferay.ide.projects.todo.service.base;

import com.liferay.ide.projects.todo.service.TodoLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TodoLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName16;
    private String[] _methodParameterTypes16;
    private String _methodName17;
    private String[] _methodParameterTypes17;
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName50;
    private String[] _methodParameterTypes50;
    private String _methodName51;
    private String[] _methodParameterTypes51;
    private String _methodName56;
    private String[] _methodParameterTypes56;
    private String _methodName57;
    private String[] _methodParameterTypes57;
    private String _methodName58;
    private String[] _methodParameterTypes58;
    private String _methodName59;
    private String[] _methodParameterTypes59;
    private String _methodName60;
    private String[] _methodParameterTypes60;
    private String _methodName61;
    private String[] _methodParameterTypes61;

    public TodoLocalServiceClpInvoker() {
        _methodName0 = "addTodo";

        _methodParameterTypes0 = new String[] {
                "com.liferay.ide.projects.todo.model.Todo"
            };

        _methodName1 = "createTodo";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteTodo";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteTodo";

        _methodParameterTypes3 = new String[] {
                "com.liferay.ide.projects.todo.model.Todo"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchTodo";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "fetchTodoByUuidAndCompanyId";

        _methodParameterTypes11 = new String[] { "java.lang.String", "long" };

        _methodName12 = "fetchTodoByUuidAndGroupId";

        _methodParameterTypes12 = new String[] { "java.lang.String", "long" };

        _methodName13 = "getTodo";

        _methodParameterTypes13 = new String[] { "long" };

        _methodName14 = "getPersistedModel";

        _methodParameterTypes14 = new String[] { "java.io.Serializable" };

        _methodName15 = "getTodoByUuidAndCompanyId";

        _methodParameterTypes15 = new String[] { "java.lang.String", "long" };

        _methodName16 = "getTodoByUuidAndGroupId";

        _methodParameterTypes16 = new String[] { "java.lang.String", "long" };

        _methodName17 = "getTodos";

        _methodParameterTypes17 = new String[] { "int", "int" };

        _methodName18 = "getTodosCount";

        _methodParameterTypes18 = new String[] {  };

        _methodName19 = "updateTodo";

        _methodParameterTypes19 = new String[] {
                "com.liferay.ide.projects.todo.model.Todo"
            };

        _methodName50 = "getBeanIdentifier";

        _methodParameterTypes50 = new String[] {  };

        _methodName51 = "setBeanIdentifier";

        _methodParameterTypes51 = new String[] { "java.lang.String" };

        _methodName56 = "getUserTodos";

        _methodParameterTypes56 = new String[] { "long" };

        _methodName57 = "getUnfinishedUserTodos";

        _methodParameterTypes57 = new String[] { "long" };

        _methodName58 = "getUnfinishedUserTodosCount";

        _methodParameterTypes58 = new String[] { "long" };

        _methodName59 = "getUserTodosCount";

        _methodParameterTypes59 = new String[] { "long" };

        _methodName60 = "addTodo";

        _methodParameterTypes60 = new String[] {
                "java.lang.String", "java.lang.String", "java.util.Date",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName61 = "finishTodo";

        _methodParameterTypes61 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return TodoLocalServiceUtil.addTodo((com.liferay.ide.projects.todo.model.Todo) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return TodoLocalServiceUtil.createTodo(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return TodoLocalServiceUtil.deleteTodo(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return TodoLocalServiceUtil.deleteTodo((com.liferay.ide.projects.todo.model.Todo) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return TodoLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return TodoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return TodoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return TodoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return TodoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return TodoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return TodoLocalServiceUtil.fetchTodo(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return TodoLocalServiceUtil.fetchTodoByUuidAndCompanyId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return TodoLocalServiceUtil.fetchTodoByUuidAndGroupId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return TodoLocalServiceUtil.getTodo(((Long) arguments[0]).longValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return TodoLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return TodoLocalServiceUtil.getTodoByUuidAndCompanyId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName16.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
            return TodoLocalServiceUtil.getTodoByUuidAndGroupId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName17.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
            return TodoLocalServiceUtil.getTodos(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            return TodoLocalServiceUtil.getTodosCount();
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            return TodoLocalServiceUtil.updateTodo((com.liferay.ide.projects.todo.model.Todo) arguments[0]);
        }

        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            return TodoLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName51.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
            TodoLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            return TodoLocalServiceUtil.getUserTodos(((Long) arguments[0]).longValue());
        }

        if (_methodName57.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
            return TodoLocalServiceUtil.getUnfinishedUserTodos(((Long) arguments[0]).longValue());
        }

        if (_methodName58.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
            return TodoLocalServiceUtil.getUnfinishedUserTodosCount(((Long) arguments[0]).longValue());
        }

        if (_methodName59.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
            return TodoLocalServiceUtil.getUserTodosCount(((Long) arguments[0]).longValue());
        }

        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            return TodoLocalServiceUtil.addTodo((java.lang.String) arguments[0],
                (java.lang.String) arguments[1], (java.util.Date) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            TodoLocalServiceUtil.finishTodo(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
