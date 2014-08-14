package com.liferay.ide.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LiferayJSDebugService}.
 *
 * @author Brian Wing Shun Chan
 * @see LiferayJSDebugService
 * @generated
 */
public class LiferayJSDebugServiceWrapper implements LiferayJSDebugService,
    ServiceWrapper<LiferayJSDebugService> {
    private LiferayJSDebugService _liferayJSDebugService;

    public LiferayJSDebugServiceWrapper(
        LiferayJSDebugService liferayJSDebugService) {
        _liferayJSDebugService = liferayJSDebugService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _liferayJSDebugService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _liferayJSDebugService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _liferayJSDebugService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public void debugJS(java.lang.String log) {
        _liferayJSDebugService.debugJS(log);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LiferayJSDebugService getWrappedLiferayJSDebugService() {
        return _liferayJSDebugService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLiferayJSDebugService(
        LiferayJSDebugService liferayJSDebugService) {
        _liferayJSDebugService = liferayJSDebugService;
    }

    @Override
    public LiferayJSDebugService getWrappedService() {
        return _liferayJSDebugService;
    }

    @Override
    public void setWrappedService(LiferayJSDebugService liferayJSDebugService) {
        _liferayJSDebugService = liferayJSDebugService;
    }
}
