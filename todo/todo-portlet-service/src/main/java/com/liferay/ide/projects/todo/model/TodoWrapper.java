package com.liferay.ide.projects.todo.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Todo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Todo
 * @generated
 */
public class TodoWrapper implements Todo, ModelWrapper<Todo> {
    private Todo _todo;

    public TodoWrapper(Todo todo) {
        _todo = todo;
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

    /**
    * Returns the primary key of this todo.
    *
    * @return the primary key of this todo
    */
    @Override
    public long getPrimaryKey() {
        return _todo.getPrimaryKey();
    }

    /**
    * Sets the primary key of this todo.
    *
    * @param primaryKey the primary key of this todo
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _todo.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this todo.
    *
    * @return the uuid of this todo
    */
    @Override
    public java.lang.String getUuid() {
        return _todo.getUuid();
    }

    /**
    * Sets the uuid of this todo.
    *
    * @param uuid the uuid of this todo
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _todo.setUuid(uuid);
    }

    /**
    * Returns the todo ID of this todo.
    *
    * @return the todo ID of this todo
    */
    @Override
    public long getTodoId() {
        return _todo.getTodoId();
    }

    /**
    * Sets the todo ID of this todo.
    *
    * @param todoId the todo ID of this todo
    */
    @Override
    public void setTodoId(long todoId) {
        _todo.setTodoId(todoId);
    }

    /**
    * Returns the group ID of this todo.
    *
    * @return the group ID of this todo
    */
    @Override
    public long getGroupId() {
        return _todo.getGroupId();
    }

    /**
    * Sets the group ID of this todo.
    *
    * @param groupId the group ID of this todo
    */
    @Override
    public void setGroupId(long groupId) {
        _todo.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this todo.
    *
    * @return the company ID of this todo
    */
    @Override
    public long getCompanyId() {
        return _todo.getCompanyId();
    }

    /**
    * Sets the company ID of this todo.
    *
    * @param companyId the company ID of this todo
    */
    @Override
    public void setCompanyId(long companyId) {
        _todo.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this todo.
    *
    * @return the user ID of this todo
    */
    @Override
    public long getUserId() {
        return _todo.getUserId();
    }

    /**
    * Sets the user ID of this todo.
    *
    * @param userId the user ID of this todo
    */
    @Override
    public void setUserId(long userId) {
        _todo.setUserId(userId);
    }

    /**
    * Returns the user uuid of this todo.
    *
    * @return the user uuid of this todo
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _todo.getUserUuid();
    }

    /**
    * Sets the user uuid of this todo.
    *
    * @param userUuid the user uuid of this todo
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _todo.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this todo.
    *
    * @return the user name of this todo
    */
    @Override
    public java.lang.String getUserName() {
        return _todo.getUserName();
    }

    /**
    * Sets the user name of this todo.
    *
    * @param userName the user name of this todo
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _todo.setUserName(userName);
    }

    /**
    * Returns the create date of this todo.
    *
    * @return the create date of this todo
    */
    @Override
    public java.util.Date getCreateDate() {
        return _todo.getCreateDate();
    }

    /**
    * Sets the create date of this todo.
    *
    * @param createDate the create date of this todo
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _todo.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this todo.
    *
    * @return the modified date of this todo
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _todo.getModifiedDate();
    }

    /**
    * Sets the modified date of this todo.
    *
    * @param modifiedDate the modified date of this todo
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _todo.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this todo.
    *
    * @return the name of this todo
    */
    @Override
    public java.lang.String getName() {
        return _todo.getName();
    }

    /**
    * Sets the name of this todo.
    *
    * @param name the name of this todo
    */
    @Override
    public void setName(java.lang.String name) {
        _todo.setName(name);
    }

    /**
    * Returns the finished of this todo.
    *
    * @return the finished of this todo
    */
    @Override
    public boolean getFinished() {
        return _todo.getFinished();
    }

    /**
    * Returns <code>true</code> if this todo is finished.
    *
    * @return <code>true</code> if this todo is finished; <code>false</code> otherwise
    */
    @Override
    public boolean isFinished() {
        return _todo.isFinished();
    }

    /**
    * Sets whether this todo is finished.
    *
    * @param finished the finished of this todo
    */
    @Override
    public void setFinished(boolean finished) {
        _todo.setFinished(finished);
    }

    /**
    * Returns the due date of this todo.
    *
    * @return the due date of this todo
    */
    @Override
    public java.util.Date getDueDate() {
        return _todo.getDueDate();
    }

    /**
    * Sets the due date of this todo.
    *
    * @param dueDate the due date of this todo
    */
    @Override
    public void setDueDate(java.util.Date dueDate) {
        _todo.setDueDate(dueDate);
    }

    /**
    * Returns the description of this todo.
    *
    * @return the description of this todo
    */
    @Override
    public java.lang.String getDescription() {
        return _todo.getDescription();
    }

    /**
    * Sets the description of this todo.
    *
    * @param description the description of this todo
    */
    @Override
    public void setDescription(java.lang.String description) {
        _todo.setDescription(description);
    }

    @Override
    public boolean isNew() {
        return _todo.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _todo.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _todo.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _todo.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _todo.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _todo.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _todo.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _todo.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _todo.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _todo.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _todo.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new TodoWrapper((Todo) _todo.clone());
    }

    @Override
    public int compareTo(com.liferay.ide.projects.todo.model.Todo todo) {
        return _todo.compareTo(todo);
    }

    @Override
    public int hashCode() {
        return _todo.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.ide.projects.todo.model.Todo> toCacheModel() {
        return _todo.toCacheModel();
    }

    @Override
    public com.liferay.ide.projects.todo.model.Todo toEscapedModel() {
        return new TodoWrapper(_todo.toEscapedModel());
    }

    @Override
    public com.liferay.ide.projects.todo.model.Todo toUnescapedModel() {
        return new TodoWrapper(_todo.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _todo.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _todo.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _todo.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TodoWrapper)) {
            return false;
        }

        TodoWrapper todoWrapper = (TodoWrapper) obj;

        if (Validator.equals(_todo, todoWrapper._todo)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _todo.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Todo getWrappedTodo() {
        return _todo;
    }

    @Override
    public Todo getWrappedModel() {
        return _todo;
    }

    @Override
    public void resetOriginalValues() {
        _todo.resetOriginalValues();
    }
}
