package com.liferay.ide.projects.set;

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

    public void startGame( ActionRequest actionRequest, ActionResponse actionResponse )
    {
        final ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest .getAttribute(WebKeys.THEME_DISPLAY);
        final String backURL = ParamUtil.getString( actionRequest, "backURL" );
        final String invitePlayer = ParamUtil.getString( actionRequest, "invitePlayer" );
        final Boolean invite = ParamUtil.getBoolean( actionRequest, "invite" );

        try
        {
            final long companyId = themeDisplay.getCompanyId();

            final User inviteUser = UserLocalServiceUtil.getUserByEmailAddress(companyId, invitePlayer);

            actionResponse.setRenderParameter( "backURL", backURL );
            actionResponse.setRenderParameter( "startUserId", Long.toString(themeDisplay.getUser().getUserId()));
            actionResponse.setRenderParameter( "inviteUserId", Long.toString(inviteUser.getUserId()));
            actionResponse.setRenderParameter( "invite", Boolean.toString(invite));
            actionResponse.setRenderParameter( "mvcPath", "/html/start-game.jsp" );
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
