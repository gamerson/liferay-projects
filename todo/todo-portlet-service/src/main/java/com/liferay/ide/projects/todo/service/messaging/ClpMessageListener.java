package com.liferay.ide.projects.todo.service.messaging;

import com.liferay.ide.projects.todo.service.ClpSerializer;
import com.liferay.ide.projects.todo.service.TodoLocalServiceUtil;
import com.liferay.ide.projects.todo.service.TodoServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            TodoLocalServiceUtil.clearService();

            TodoServiceUtil.clearService();
        }
    }
}
