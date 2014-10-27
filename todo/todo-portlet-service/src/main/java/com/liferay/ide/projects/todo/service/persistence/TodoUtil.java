package com.liferay.ide.projects.todo.service.persistence;

import com.liferay.ide.projects.todo.model.Todo;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the todo service. This utility wraps {@link TodoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoPersistence
 * @see TodoPersistenceImpl
 * @generated
 */
public class TodoUtil {
    private static TodoPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Todo todo) {
        getPersistence().clearCache(todo);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Todo> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Todo> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Todo> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Todo update(Todo todo) throws SystemException {
        return getPersistence().update(todo);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Todo update(Todo todo, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(todo, serviceContext);
    }

    /**
    * Returns all the todos where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the todos where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.projects.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of todos
    * @param end the upper bound of the range of todos (not inclusive)
    * @return the range of matching todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the todos where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.projects.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of todos
    * @param end the upper bound of the range of todos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first todo in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching todo
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first todo in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching todo, or <code>null</code> if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last todo in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching todo
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last todo in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching todo, or <code>null</code> if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the todos before and after the current todo in the ordered set where uuid = &#63;.
    *
    * @param todoId the primary key of the current todo
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next todo
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a todo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo[] findByUuid_PrevAndNext(
        long todoId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_PrevAndNext(todoId, uuid, orderByComparator);
    }

    /**
    * Removes all the todos where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of todos where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching todos
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the todo where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.ide.projects.todo.NoSuchTodoException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching todo
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the todo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching todo, or <code>null</code> if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the todo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching todo, or <code>null</code> if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the todo where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the todo that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of todos where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching todos
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the todos where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the todos where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.projects.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of todos
    * @param end the upper bound of the range of todos (not inclusive)
    * @return the range of matching todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the todos where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.projects.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of todos
    * @param end the upper bound of the range of todos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first todo in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching todo
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first todo in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching todo, or <code>null</code> if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last todo in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching todo
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last todo in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching todo, or <code>null</code> if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the todos before and after the current todo in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param todoId the primary key of the current todo
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next todo
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a todo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo[] findByUuid_C_PrevAndNext(
        long todoId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(todoId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the todos where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid_C(uuid, companyId);
    }

    /**
    * Returns the number of todos where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching todos
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the todos where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId);
    }

    /**
    * Returns a range of all the todos where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.projects.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of todos
    * @param end the upper bound of the range of todos (not inclusive)
    * @return the range of matching todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    /**
    * Returns an ordered range of all the todos where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.projects.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of todos
    * @param end the upper bound of the range of todos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first todo in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching todo
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo findByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first todo in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching todo, or <code>null</code> if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo fetchByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last todo in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching todo
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo findByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last todo in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching todo, or <code>null</code> if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo fetchByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the todos before and after the current todo in the ordered set where userId = &#63;.
    *
    * @param todoId the primary key of the current todo
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next todo
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a todo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo[] findByUserId_PrevAndNext(
        long todoId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId_PrevAndNext(todoId, userId, orderByComparator);
    }

    /**
    * Removes all the todos where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserId(userId);
    }

    /**
    * Returns the number of todos where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching todos
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserId(userId);
    }

    /**
    * Returns all the todos where userId = &#63; and finished = &#63;.
    *
    * @param userId the user ID
    * @param finished the finished
    * @return the matching todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findByF_UserId(
        long userId, boolean finished)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByF_UserId(userId, finished);
    }

    /**
    * Returns a range of all the todos where userId = &#63; and finished = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.projects.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param finished the finished
    * @param start the lower bound of the range of todos
    * @param end the upper bound of the range of todos (not inclusive)
    * @return the range of matching todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findByF_UserId(
        long userId, boolean finished, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByF_UserId(userId, finished, start, end);
    }

    /**
    * Returns an ordered range of all the todos where userId = &#63; and finished = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.projects.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param finished the finished
    * @param start the lower bound of the range of todos
    * @param end the upper bound of the range of todos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findByF_UserId(
        long userId, boolean finished, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByF_UserId(userId, finished, start, end,
            orderByComparator);
    }

    /**
    * Returns the first todo in the ordered set where userId = &#63; and finished = &#63;.
    *
    * @param userId the user ID
    * @param finished the finished
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching todo
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo findByF_UserId_First(
        long userId, boolean finished,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByF_UserId_First(userId, finished, orderByComparator);
    }

    /**
    * Returns the first todo in the ordered set where userId = &#63; and finished = &#63;.
    *
    * @param userId the user ID
    * @param finished the finished
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching todo, or <code>null</code> if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo fetchByF_UserId_First(
        long userId, boolean finished,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByF_UserId_First(userId, finished, orderByComparator);
    }

    /**
    * Returns the last todo in the ordered set where userId = &#63; and finished = &#63;.
    *
    * @param userId the user ID
    * @param finished the finished
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching todo
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo findByF_UserId_Last(
        long userId, boolean finished,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByF_UserId_Last(userId, finished, orderByComparator);
    }

    /**
    * Returns the last todo in the ordered set where userId = &#63; and finished = &#63;.
    *
    * @param userId the user ID
    * @param finished the finished
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching todo, or <code>null</code> if a matching todo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo fetchByF_UserId_Last(
        long userId, boolean finished,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByF_UserId_Last(userId, finished, orderByComparator);
    }

    /**
    * Returns the todos before and after the current todo in the ordered set where userId = &#63; and finished = &#63;.
    *
    * @param todoId the primary key of the current todo
    * @param userId the user ID
    * @param finished the finished
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next todo
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a todo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo[] findByF_UserId_PrevAndNext(
        long todoId, long userId, boolean finished,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByF_UserId_PrevAndNext(todoId, userId, finished,
            orderByComparator);
    }

    /**
    * Removes all the todos where userId = &#63; and finished = &#63; from the database.
    *
    * @param userId the user ID
    * @param finished the finished
    * @throws SystemException if a system exception occurred
    */
    public static void removeByF_UserId(long userId, boolean finished)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByF_UserId(userId, finished);
    }

    /**
    * Returns the number of todos where userId = &#63; and finished = &#63;.
    *
    * @param userId the user ID
    * @param finished the finished
    * @return the number of matching todos
    * @throws SystemException if a system exception occurred
    */
    public static int countByF_UserId(long userId, boolean finished)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByF_UserId(userId, finished);
    }

    /**
    * Caches the todo in the entity cache if it is enabled.
    *
    * @param todo the todo
    */
    public static void cacheResult(
        com.liferay.ide.projects.todo.model.Todo todo) {
        getPersistence().cacheResult(todo);
    }

    /**
    * Caches the todos in the entity cache if it is enabled.
    *
    * @param todos the todos
    */
    public static void cacheResult(
        java.util.List<com.liferay.ide.projects.todo.model.Todo> todos) {
        getPersistence().cacheResult(todos);
    }

    /**
    * Creates a new todo with the primary key. Does not add the todo to the database.
    *
    * @param todoId the primary key for the new todo
    * @return the new todo
    */
    public static com.liferay.ide.projects.todo.model.Todo create(long todoId) {
        return getPersistence().create(todoId);
    }

    /**
    * Removes the todo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param todoId the primary key of the todo
    * @return the todo that was removed
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a todo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo remove(long todoId)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(todoId);
    }

    public static com.liferay.ide.projects.todo.model.Todo updateImpl(
        com.liferay.ide.projects.todo.model.Todo todo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(todo);
    }

    /**
    * Returns the todo with the primary key or throws a {@link com.liferay.ide.projects.todo.NoSuchTodoException} if it could not be found.
    *
    * @param todoId the primary key of the todo
    * @return the todo
    * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a todo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo findByPrimaryKey(
        long todoId)
        throws com.liferay.ide.projects.todo.NoSuchTodoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(todoId);
    }

    /**
    * Returns the todo with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param todoId the primary key of the todo
    * @return the todo, or <code>null</code> if a todo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.ide.projects.todo.model.Todo fetchByPrimaryKey(
        long todoId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(todoId);
    }

    /**
    * Returns all the todos.
    *
    * @return the todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the todos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.projects.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of todos
    * @param end the upper bound of the range of todos (not inclusive)
    * @return the range of todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the todos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.projects.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of todos
    * @param end the upper bound of the range of todos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of todos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.ide.projects.todo.model.Todo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the todos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of todos.
    *
    * @return the number of todos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static TodoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (TodoPersistence) PortletBeanLocatorUtil.locate(com.liferay.ide.projects.todo.service.ClpSerializer.getServletContextName(),
                    TodoPersistence.class.getName());

            ReferenceRegistry.registerReference(TodoUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(TodoPersistence persistence) {
    }
}
