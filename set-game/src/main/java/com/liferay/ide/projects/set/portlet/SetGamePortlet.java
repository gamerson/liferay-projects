package com.liferay.ide.projects.set.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SetGamePortlet
 */
public class SetGamePortlet extends MVCPortlet
{

    public void beginGame( ActionRequest actionRequest, ActionResponse actionResponse )
    {
        final ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest .getAttribute(WebKeys.THEME_DISPLAY);
        final String gameTypeParam = ParamUtil.getString( actionRequest, "gameType" );
        final String backURL = ParamUtil.getString( actionRequest, "backURL" );
        final String invitePlayer = ParamUtil.getString( actionRequest, "invitePlayer" );

        try
        {
            final long companyId = themeDisplay.getCompanyId();

            final User inviteUser = UserLocalServiceUtil.getUserByScreenName(companyId, invitePlayer);

            final String[] segments = gameTypeParam.split( "_" );

            if( segments.length > 0 )
            {
                final String gameType = segments[segments.length-1];
                actionResponse.setRenderParameter( "gameType", gameType );
                actionResponse.setRenderParameter( "backURL", backURL );
                actionResponse.setRenderParameter( "inviteUserId", Long.toString(inviteUser.getUserId()));
                actionResponse.setRenderParameter( "mvcPath", "/html/start-game.jsp" );
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
