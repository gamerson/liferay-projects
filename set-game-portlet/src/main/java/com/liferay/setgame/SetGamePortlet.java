package com.liferay.setgame;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class SetGamePortlet
 */
public class SetGamePortlet extends MVCPortlet
{


    public void startGame( ActionRequest actionRequest, ActionResponse actionResponse )
    {
        final String gameTypeParam = ParamUtil.getString( actionRequest, "gameType" );

        final String[] segments = gameTypeParam.split( "_" );
        if( segments.length > 0 ) {
            final String gameType = segments[segments.length-1];
            actionResponse.setRenderParameter( "gameType", gameType );
            actionResponse.setRenderParameter("mvcPath", "/html/start-game.jsp");
        }

    }

}
