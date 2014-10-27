package com.liferay.ide.projects.todo.model.impl;

import com.liferay.ide.projects.todo.model.Todo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Todo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Todo
 * @generated
 */
public class TodoCacheModel implements CacheModel<Todo>, Externalizable {
    public String uuid;
    public long todoId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public boolean finished;
    public long dueDate;
    public String description;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", todoId=");
        sb.append(todoId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", name=");
        sb.append(name);
        sb.append(", finished=");
        sb.append(finished);
        sb.append(", dueDate=");
        sb.append(dueDate);
        sb.append(", description=");
        sb.append(description);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Todo toEntityModel() {
        TodoImpl todoImpl = new TodoImpl();

        if (uuid == null) {
            todoImpl.setUuid(StringPool.BLANK);
        } else {
            todoImpl.setUuid(uuid);
        }

        todoImpl.setTodoId(todoId);
        todoImpl.setGroupId(groupId);
        todoImpl.setCompanyId(companyId);
        todoImpl.setUserId(userId);

        if (userName == null) {
            todoImpl.setUserName(StringPool.BLANK);
        } else {
            todoImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            todoImpl.setCreateDate(null);
        } else {
            todoImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            todoImpl.setModifiedDate(null);
        } else {
            todoImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            todoImpl.setName(StringPool.BLANK);
        } else {
            todoImpl.setName(name);
        }

        todoImpl.setFinished(finished);

        if (dueDate == Long.MIN_VALUE) {
            todoImpl.setDueDate(null);
        } else {
            todoImpl.setDueDate(new Date(dueDate));
        }

        if (description == null) {
            todoImpl.setDescription(StringPool.BLANK);
        } else {
            todoImpl.setDescription(description);
        }

        todoImpl.resetOriginalValues();

        return todoImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        todoId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        finished = objectInput.readBoolean();
        dueDate = objectInput.readLong();
        description = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(todoId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        objectOutput.writeBoolean(finished);
        objectOutput.writeLong(dueDate);

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }
    }
}
