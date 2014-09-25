package com.liferay.setgame;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SetGamePortlet
 */
public class SetGamePortlet extends MVCPortlet
{

    public void startGame( ActionRequest actionRequest, ActionResponse actionResponse ) {
        final String gameTypeParam = ParamUtil.getString( actionRequest, "gameType" );
        final String backURL = ParamUtil.getString( actionRequest, "backURL" );

        final String[] segments = gameTypeParam.split( "_" );
        if( segments.length > 0 ) {
            final String gameType = segments[segments.length-1];
            actionResponse.setRenderParameter( "gameType", gameType );
            actionResponse.setRenderParameter( "backURL", backURL );
            actionResponse.setRenderParameter( "mvcPath", "/html/start-game.jsp" );
        }
    }

}
