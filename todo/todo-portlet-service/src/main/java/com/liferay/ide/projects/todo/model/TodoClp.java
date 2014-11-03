package com.liferay.ide.projects.todo.model;

import com.liferay.ide.projects.todo.service.ClpSerializer;
import com.liferay.ide.projects.todo.service.TodoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TodoClp extends BaseModelImpl<Todo> implements Todo {
    private String _uuid;
    private long _todoId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private boolean _finished;
    private Date _dueDate;
    private String _description;
    private BaseModel<?> _todoRemoteModel;

    public TodoClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Todo.class;
    }

    @Override
    public String getModelClassName() {
        return Todo.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _todoId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setTodoId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _todoId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("todoId", getTodoId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("finished", getFinished());
        attributes.put("dueDate", getDueDate());
        attributes.put("description", getDescription());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long todoId = (Long) attributes.get("todoId");

        if (todoId != null) {
            setTodoId(todoId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        Boolean finished = (Boolean) attributes.get("finished");

        if (finished != null) {
            setFinished(finished);
        }

        Date dueDate = (Date) attributes.get("dueDate");

        if (dueDate != null) {
            setDueDate(dueDate);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_todoRemoteModel != null) {
            try {
                Class<?> clazz = _todoRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_todoRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getTodoId() {
        return _todoId;
    }

    @Override
    public void setTodoId(long todoId) {
        _todoId = todoId;

        if (_todoRemoteModel != null) {
            try {
                Class<?> clazz = _todoRemoteModel.getClass();

                Method method = clazz.getMethod("setTodoId", long.class);

                method.invoke(_todoRemoteModel, todoId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_todoRemoteModel != null) {
            try {
                Class<?> clazz = _todoRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_todoRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_todoRemoteModel != null) {
            try {
                Class<?> clazz = _todoRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_todoRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_todoRemoteModel != null) {
            try {
                Class<?> clazz = _todoRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_todoRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_todoRemoteModel != null) {
            try {
                Class<?> clazz = _todoRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_todoRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_todoRemoteModel != null) {
            try {
                Class<?> clazz = _todoRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_todoRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_todoRemoteModel != null) {
            try {
                Class<?> clazz = _todoRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_todoRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_todoRemoteModel != null) {
            try {
                Class<?> clazz = _todoRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_todoRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getFinished() {
        return _finished;
    }

    @Override
    public boolean isFinished() {
        return _finished;
    }

    @Override
    public void setFinished(boolean finished) {
        _finished = finished;

        if (_todoRemoteModel != null) {
            try {
                Class<?> clazz = _todoRemoteModel.getClass();

                Method method = clazz.getMethod("setFinished", boolean.class);

                method.invoke(_todoRemoteModel, finished);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getDueDate() {
        return _dueDate;
    }

    @Override
    public void setDueDate(Date dueDate) {
        _dueDate = dueDate;

        if (_todoRemoteModel != null) {
            try {
                Class<?> clazz = _todoRemoteModel.getClass();

                Method method = clazz.getMethod("setDueDate", Date.class);

                method.invoke(_todoRemoteModel, dueDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_todoRemoteModel != null) {
            try {
                Class<?> clazz = _todoRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_todoRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Todo.class.getName()));
    }

    public BaseModel<?> getTodoRemoteModel() {
        return _todoRemoteModel;
    }

    public void setTodoRemoteModel(BaseModel<?> todoRemoteModel) {
        _todoRemoteModel = todoRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _todoRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_todoRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            TodoLocalServiceUtil.addTodo(this);
        } else {
            TodoLocalServiceUtil.updateTodo(this);
        }
    }

    @Override
    public Todo toEscapedModel() {
        return (Todo) ProxyUtil.newProxyInstance(Todo.class.getClassLoader(),
            new Class[] { Todo.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        TodoClp clone = new TodoClp();

        clone.setUuid(getUuid());
        clone.setTodoId(getTodoId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setName(getName());
        clone.setFinished(getFinished());
        clone.setDueDate(getDueDate());
        clone.setDescription(getDescription());

        return clone;
    }

    @Override
    public int compareTo(Todo todo) {
        int value = 0;

        value = DateUtil.compareTo(getDueDate(), todo.getDueDate());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TodoClp)) {
            return false;
        }

        TodoClp todo = (TodoClp) obj;

        long primaryKey = todo.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", todoId=");
        sb.append(getTodoId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", finished=");
        sb.append(getFinished());
        sb.append(", dueDate=");
        sb.append(getDueDate());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append("com.liferay.ide.projects.todo.model.Todo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>todoId</column-name><column-value><![CDATA[");
        sb.append(getTodoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>finished</column-name><column-value><![CDATA[");
        sb.append(getFinished());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dueDate</column-name><column-value><![CDATA[");
        sb.append(getDueDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
