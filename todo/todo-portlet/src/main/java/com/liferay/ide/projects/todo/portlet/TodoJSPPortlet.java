
package com.liferay.ide.projects.todo.portlet;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.ide.projects.todo.service.TodoLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class TodoJSPPortlet extends MVCPortlet
{

    public void updateTodo( ActionRequest actionRequest, ActionResponse actionResponse ) throws Exception
    {
        final long todoId = ParamUtil.getLong( actionRequest, "todoId" );
        final String name = ParamUtil.getString( actionRequest, "name" );
        final String description = ParamUtil.getString( actionRequest, "description" );
        final Date dueDate = ParamUtil.getDate( actionRequest, "dueDate", new SimpleDateFormat() );
        final ServiceContext serviceContext = ServiceContextFactory.getInstance( actionRequest );

        try
        {
            if( todoId <= 0 )
            {
                TodoLocalServiceUtil.addTodo( name, description, dueDate, serviceContext );
            }
            else
            {
//                TodoLocalServiceUtil.updateTodo( todoId, name, description, dueDate, serviceContext );
            }
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

        sendRedirect( actionRequest, actionResponse );
    }

    public void finishTodo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception
    {
        final long todoId = ParamUtil.getLong( actionRequest, "todoId" );

        try
        {
            TodoLocalServiceUtil.finishTodo( todoId );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

        sendRedirect( actionRequest, actionResponse );
    }

}
