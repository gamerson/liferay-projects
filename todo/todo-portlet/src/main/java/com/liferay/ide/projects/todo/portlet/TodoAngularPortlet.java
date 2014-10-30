package com.liferay.ide.projects.todo.portlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Release;
import com.liferay.portal.service.ReleaseLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class TodoAngularPortlet
 */
public class TodoAngularPortlet extends MVCPortlet {

    @Override
    public void serveResource( ResourceRequest resourceRequest, ResourceResponse resourceResponse ) throws IOException,
        PortletException
    {
        final String resourceId = resourceRequest.getResourceID();

        if("buildNumber".equals( resourceId )) {
            long releaseId = ParamUtil.getLong( resourceRequest, "releaseId" );
            try
            {
                final Release release = ReleaseLocalServiceUtil.getRelease(releaseId);

                String json = "";
                if( release != null ) {
                    Gson gson = new Gson();
                    json = gson.toJson( release );
                }

                resourceResponse.getWriter().print(json);
            }
            catch( PortalException e )
            {
            }
            catch( SystemException e )
            {
            }
        }
    }

}
