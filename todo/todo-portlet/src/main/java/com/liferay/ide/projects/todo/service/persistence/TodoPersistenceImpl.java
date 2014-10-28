package com.liferay.ide.projects.todo.service.persistence;

import com.liferay.ide.projects.todo.NoSuchTodoException;
import com.liferay.ide.projects.todo.model.Todo;
import com.liferay.ide.projects.todo.model.impl.TodoImpl;
import com.liferay.ide.projects.todo.model.impl.TodoModelImpl;
import com.liferay.ide.projects.todo.service.persistence.TodoPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the todo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoPersistence
 * @see TodoUtil
 * @generated
 */
public class TodoPersistenceImpl extends BasePersistenceImpl<Todo>
    implements TodoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link TodoUtil} to access the todo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = TodoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            TodoModelImpl.UUID_COLUMN_BITMASK |
            TodoModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "todo.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "todo.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(todo.uuid IS NULL OR todo.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            TodoModelImpl.UUID_COLUMN_BITMASK |
            TodoModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "todo.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "todo.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(todo.uuid IS NULL OR todo.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "todo.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            TodoModelImpl.UUID_COLUMN_BITMASK |
            TodoModelImpl.COMPANYID_COLUMN_BITMASK |
            TodoModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "todo.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "todo.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(todo.uuid IS NULL OR todo.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "todo.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
            new String[] { Long.class.getName() },
            TodoModelImpl.USERID_COLUMN_BITMASK |
            TodoModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "todo.userId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_F_USERID = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByF_UserId",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_USERID =
        new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByF_UserId",
            new String[] { Long.class.getName(), Boolean.class.getName() },
            TodoModelImpl.USERID_COLUMN_BITMASK |
            TodoModelImpl.FINISHED_COLUMN_BITMASK |
            TodoModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_F_USERID = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByF_UserId",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    private static final String _FINDER_COLUMN_F_USERID_USERID_2 = "todo.userId = ? AND ";
    private static final String _FINDER_COLUMN_F_USERID_FINISHED_2 = "todo.finished = ?";
    private static final String _SQL_SELECT_TODO = "SELECT todo FROM Todo todo";
    private static final String _SQL_SELECT_TODO_WHERE = "SELECT todo FROM Todo todo WHERE ";
    private static final String _SQL_COUNT_TODO = "SELECT COUNT(todo) FROM Todo todo";
    private static final String _SQL_COUNT_TODO_WHERE = "SELECT COUNT(todo) FROM Todo todo WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "todo.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Todo exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Todo exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(TodoPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Todo _nullTodo = new TodoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Todo> toCacheModel() {
                return _nullTodoCacheModel;
            }
        };

    private static CacheModel<Todo> _nullTodoCacheModel = new CacheModel<Todo>() {
            @Override
            public Todo toEntityModel() {
                return _nullTodo;
            }
        };

    public TodoPersistenceImpl() {
        setModelClass(Todo.class);
    }

    /**
     * Returns all the todos where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching todos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Todo> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Todo> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
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
    @Override
    public List<Todo> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Todo> list = (List<Todo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Todo todo : list) {
                if (!Validator.equals(uuid, todo.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_TODO_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TodoModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Todo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Todo>(list);
                } else {
                    list = (List<Todo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Todo findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchTodoException, SystemException {
        Todo todo = fetchByUuid_First(uuid, orderByComparator);

        if (todo != null) {
            return todo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTodoException(msg.toString());
    }

    /**
     * Returns the first todo in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching todo, or <code>null</code> if a matching todo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Todo fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Todo> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Todo findByUuid_Last(String uuid, OrderByComparator orderByComparator)
        throws NoSuchTodoException, SystemException {
        Todo todo = fetchByUuid_Last(uuid, orderByComparator);

        if (todo != null) {
            return todo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTodoException(msg.toString());
    }

    /**
     * Returns the last todo in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching todo, or <code>null</code> if a matching todo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Todo fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Todo> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Todo[] findByUuid_PrevAndNext(long todoId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchTodoException, SystemException {
        Todo todo = findByPrimaryKey(todoId);

        Session session = null;

        try {
            session = openSession();

            Todo[] array = new TodoImpl[3];

            array[0] = getByUuid_PrevAndNext(session, todo, uuid,
                    orderByComparator, true);

            array[1] = todo;

            array[2] = getByUuid_PrevAndNext(session, todo, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Todo getByUuid_PrevAndNext(Session session, Todo todo,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TODO_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(TodoModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(todo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Todo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the todos where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Todo todo : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(todo);
        }
    }

    /**
     * Returns the number of todos where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching todos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_TODO_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
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
    @Override
    public Todo findByUUID_G(String uuid, long groupId)
        throws NoSuchTodoException, SystemException {
        Todo todo = fetchByUUID_G(uuid, groupId);

        if (todo == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchTodoException(msg.toString());
        }

        return todo;
    }

    /**
     * Returns the todo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching todo, or <code>null</code> if a matching todo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Todo fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
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
    @Override
    public Todo fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Todo) {
            Todo todo = (Todo) result;

            if (!Validator.equals(uuid, todo.getUuid()) ||
                    (groupId != todo.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_TODO_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<Todo> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Todo todo = list.get(0);

                    result = todo;

                    cacheResult(todo);

                    if ((todo.getUuid() == null) ||
                            !todo.getUuid().equals(uuid) ||
                            (todo.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, todo);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Todo) result;
        }
    }

    /**
     * Removes the todo where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the todo that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Todo removeByUUID_G(String uuid, long groupId)
        throws NoSuchTodoException, SystemException {
        Todo todo = findByUUID_G(uuid, groupId);

        return remove(todo);
    }

    /**
     * Returns the number of todos where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching todos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_TODO_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the todos where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching todos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Todo> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Todo> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
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
    @Override
    public List<Todo> findByUuid_C(String uuid, long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] { uuid, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] {
                    uuid, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<Todo> list = (List<Todo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Todo todo : list) {
                if (!Validator.equals(uuid, todo.getUuid()) ||
                        (companyId != todo.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_TODO_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TodoModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Todo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Todo>(list);
                } else {
                    list = (List<Todo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Todo findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchTodoException, SystemException {
        Todo todo = fetchByUuid_C_First(uuid, companyId, orderByComparator);

        if (todo != null) {
            return todo;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTodoException(msg.toString());
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
    @Override
    public Todo fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Todo> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Todo findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchTodoException, SystemException {
        Todo todo = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

        if (todo != null) {
            return todo;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTodoException(msg.toString());
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
    @Override
    public Todo fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Todo> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Todo[] findByUuid_C_PrevAndNext(long todoId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchTodoException, SystemException {
        Todo todo = findByPrimaryKey(todoId);

        Session session = null;

        try {
            session = openSession();

            Todo[] array = new TodoImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, todo, uuid, companyId,
                    orderByComparator, true);

            array[1] = todo;

            array[2] = getByUuid_C_PrevAndNext(session, todo, uuid, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Todo getByUuid_C_PrevAndNext(Session session, Todo todo,
        String uuid, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TODO_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_C_UUID_2);
        }

        query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(TodoModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(todo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Todo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the todos where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Todo todo : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(todo);
        }
    }

    /**
     * Returns the number of todos where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching todos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid_C(String uuid, long companyId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

        Object[] finderArgs = new Object[] { uuid, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_TODO_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the todos where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching todos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Todo> findByUserId(long userId) throws SystemException {
        return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Todo> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
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
    @Override
    public List<Todo> findByUserId(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Todo> list = (List<Todo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Todo todo : list) {
                if ((userId != todo.getUserId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_TODO_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TodoModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<Todo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Todo>(list);
                } else {
                    list = (List<Todo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Todo findByUserId_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchTodoException, SystemException {
        Todo todo = fetchByUserId_First(userId, orderByComparator);

        if (todo != null) {
            return todo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTodoException(msg.toString());
    }

    /**
     * Returns the first todo in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching todo, or <code>null</code> if a matching todo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Todo fetchByUserId_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Todo> list = findByUserId(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Todo findByUserId_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchTodoException, SystemException {
        Todo todo = fetchByUserId_Last(userId, orderByComparator);

        if (todo != null) {
            return todo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTodoException(msg.toString());
    }

    /**
     * Returns the last todo in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching todo, or <code>null</code> if a matching todo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Todo fetchByUserId_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserId(userId);

        if (count == 0) {
            return null;
        }

        List<Todo> list = findByUserId(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Todo[] findByUserId_PrevAndNext(long todoId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchTodoException, SystemException {
        Todo todo = findByPrimaryKey(todoId);

        Session session = null;

        try {
            session = openSession();

            Todo[] array = new TodoImpl[3];

            array[0] = getByUserId_PrevAndNext(session, todo, userId,
                    orderByComparator, true);

            array[1] = todo;

            array[2] = getByUserId_PrevAndNext(session, todo, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Todo getByUserId_PrevAndNext(Session session, Todo todo,
        long userId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TODO_WHERE);

        query.append(_FINDER_COLUMN_USERID_USERID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(TodoModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(todo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Todo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the todos where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserId(long userId) throws SystemException {
        for (Todo todo : findByUserId(userId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(todo);
        }
    }

    /**
     * Returns the number of todos where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching todos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserId(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_TODO_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the todos where userId = &#63; and finished = &#63;.
     *
     * @param userId the user ID
     * @param finished the finished
     * @return the matching todos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Todo> findByF_UserId(long userId, boolean finished)
        throws SystemException {
        return findByF_UserId(userId, finished, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Todo> findByF_UserId(long userId, boolean finished, int start,
        int end) throws SystemException {
        return findByF_UserId(userId, finished, start, end, null);
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
    @Override
    public List<Todo> findByF_UserId(long userId, boolean finished, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_USERID;
            finderArgs = new Object[] { userId, finished };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_F_USERID;
            finderArgs = new Object[] {
                    userId, finished,
                    
                    start, end, orderByComparator
                };
        }

        List<Todo> list = (List<Todo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Todo todo : list) {
                if ((userId != todo.getUserId()) ||
                        (finished != todo.getFinished())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_TODO_WHERE);

            query.append(_FINDER_COLUMN_F_USERID_USERID_2);

            query.append(_FINDER_COLUMN_F_USERID_FINISHED_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TodoModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(finished);

                if (!pagination) {
                    list = (List<Todo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Todo>(list);
                } else {
                    list = (List<Todo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Todo findByF_UserId_First(long userId, boolean finished,
        OrderByComparator orderByComparator)
        throws NoSuchTodoException, SystemException {
        Todo todo = fetchByF_UserId_First(userId, finished, orderByComparator);

        if (todo != null) {
            return todo;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", finished=");
        msg.append(finished);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTodoException(msg.toString());
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
    @Override
    public Todo fetchByF_UserId_First(long userId, boolean finished,
        OrderByComparator orderByComparator) throws SystemException {
        List<Todo> list = findByF_UserId(userId, finished, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Todo findByF_UserId_Last(long userId, boolean finished,
        OrderByComparator orderByComparator)
        throws NoSuchTodoException, SystemException {
        Todo todo = fetchByF_UserId_Last(userId, finished, orderByComparator);

        if (todo != null) {
            return todo;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", finished=");
        msg.append(finished);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTodoException(msg.toString());
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
    @Override
    public Todo fetchByF_UserId_Last(long userId, boolean finished,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByF_UserId(userId, finished);

        if (count == 0) {
            return null;
        }

        List<Todo> list = findByF_UserId(userId, finished, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Todo[] findByF_UserId_PrevAndNext(long todoId, long userId,
        boolean finished, OrderByComparator orderByComparator)
        throws NoSuchTodoException, SystemException {
        Todo todo = findByPrimaryKey(todoId);

        Session session = null;

        try {
            session = openSession();

            Todo[] array = new TodoImpl[3];

            array[0] = getByF_UserId_PrevAndNext(session, todo, userId,
                    finished, orderByComparator, true);

            array[1] = todo;

            array[2] = getByF_UserId_PrevAndNext(session, todo, userId,
                    finished, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Todo getByF_UserId_PrevAndNext(Session session, Todo todo,
        long userId, boolean finished, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TODO_WHERE);

        query.append(_FINDER_COLUMN_F_USERID_USERID_2);

        query.append(_FINDER_COLUMN_F_USERID_FINISHED_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(TodoModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        qPos.add(finished);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(todo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Todo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the todos where userId = &#63; and finished = &#63; from the database.
     *
     * @param userId the user ID
     * @param finished the finished
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByF_UserId(long userId, boolean finished)
        throws SystemException {
        for (Todo todo : findByF_UserId(userId, finished, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(todo);
        }
    }

    /**
     * Returns the number of todos where userId = &#63; and finished = &#63;.
     *
     * @param userId the user ID
     * @param finished the finished
     * @return the number of matching todos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByF_UserId(long userId, boolean finished)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_F_USERID;

        Object[] finderArgs = new Object[] { userId, finished };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_TODO_WHERE);

            query.append(_FINDER_COLUMN_F_USERID_USERID_2);

            query.append(_FINDER_COLUMN_F_USERID_FINISHED_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(finished);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the todo in the entity cache if it is enabled.
     *
     * @param todo the todo
     */
    @Override
    public void cacheResult(Todo todo) {
        EntityCacheUtil.putResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoImpl.class, todo.getPrimaryKey(), todo);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { todo.getUuid(), todo.getGroupId() }, todo);

        todo.resetOriginalValues();
    }

    /**
     * Caches the todos in the entity cache if it is enabled.
     *
     * @param todos the todos
     */
    @Override
    public void cacheResult(List<Todo> todos) {
        for (Todo todo : todos) {
            if (EntityCacheUtil.getResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
                        TodoImpl.class, todo.getPrimaryKey()) == null) {
                cacheResult(todo);
            } else {
                todo.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all todos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(TodoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(TodoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the todo.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Todo todo) {
        EntityCacheUtil.removeResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoImpl.class, todo.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(todo);
    }

    @Override
    public void clearCache(List<Todo> todos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Todo todo : todos) {
            EntityCacheUtil.removeResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
                TodoImpl.class, todo.getPrimaryKey());

            clearUniqueFindersCache(todo);
        }
    }

    protected void cacheUniqueFindersCache(Todo todo) {
        if (todo.isNew()) {
            Object[] args = new Object[] { todo.getUuid(), todo.getGroupId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, todo);
        } else {
            TodoModelImpl todoModelImpl = (TodoModelImpl) todo;

            if ((todoModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { todo.getUuid(), todo.getGroupId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    todo);
            }
        }
    }

    protected void clearUniqueFindersCache(Todo todo) {
        TodoModelImpl todoModelImpl = (TodoModelImpl) todo;

        Object[] args = new Object[] { todo.getUuid(), todo.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((todoModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    todoModelImpl.getOriginalUuid(),
                    todoModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new todo with the primary key. Does not add the todo to the database.
     *
     * @param todoId the primary key for the new todo
     * @return the new todo
     */
    @Override
    public Todo create(long todoId) {
        Todo todo = new TodoImpl();

        todo.setNew(true);
        todo.setPrimaryKey(todoId);

        String uuid = PortalUUIDUtil.generate();

        todo.setUuid(uuid);

        return todo;
    }

    /**
     * Removes the todo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param todoId the primary key of the todo
     * @return the todo that was removed
     * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a todo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Todo remove(long todoId) throws NoSuchTodoException, SystemException {
        return remove((Serializable) todoId);
    }

    /**
     * Removes the todo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the todo
     * @return the todo that was removed
     * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a todo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Todo remove(Serializable primaryKey)
        throws NoSuchTodoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Todo todo = (Todo) session.get(TodoImpl.class, primaryKey);

            if (todo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchTodoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(todo);
        } catch (NoSuchTodoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Todo removeImpl(Todo todo) throws SystemException {
        todo = toUnwrappedModel(todo);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(todo)) {
                todo = (Todo) session.get(TodoImpl.class,
                        todo.getPrimaryKeyObj());
            }

            if (todo != null) {
                session.delete(todo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (todo != null) {
            clearCache(todo);
        }

        return todo;
    }

    @Override
    public Todo updateImpl(com.liferay.ide.projects.todo.model.Todo todo)
        throws SystemException {
        todo = toUnwrappedModel(todo);

        boolean isNew = todo.isNew();

        TodoModelImpl todoModelImpl = (TodoModelImpl) todo;

        if (Validator.isNull(todo.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            todo.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (todo.isNew()) {
                session.save(todo);

                todo.setNew(false);
            } else {
                session.merge(todo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !TodoModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((todoModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { todoModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { todoModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((todoModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        todoModelImpl.getOriginalUuid(),
                        todoModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        todoModelImpl.getUuid(), todoModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((todoModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { todoModelImpl.getOriginalUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { todoModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }

            if ((todoModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        todoModelImpl.getOriginalUserId(),
                        todoModelImpl.getOriginalFinished()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_F_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_USERID,
                    args);

                args = new Object[] {
                        todoModelImpl.getUserId(), todoModelImpl.getFinished()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_F_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_USERID,
                    args);
            }
        }

        EntityCacheUtil.putResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
            TodoImpl.class, todo.getPrimaryKey(), todo);

        clearUniqueFindersCache(todo);
        cacheUniqueFindersCache(todo);

        return todo;
    }

    protected Todo toUnwrappedModel(Todo todo) {
        if (todo instanceof TodoImpl) {
            return todo;
        }

        TodoImpl todoImpl = new TodoImpl();

        todoImpl.setNew(todo.isNew());
        todoImpl.setPrimaryKey(todo.getPrimaryKey());

        todoImpl.setUuid(todo.getUuid());
        todoImpl.setTodoId(todo.getTodoId());
        todoImpl.setGroupId(todo.getGroupId());
        todoImpl.setCompanyId(todo.getCompanyId());
        todoImpl.setUserId(todo.getUserId());
        todoImpl.setUserName(todo.getUserName());
        todoImpl.setCreateDate(todo.getCreateDate());
        todoImpl.setModifiedDate(todo.getModifiedDate());
        todoImpl.setName(todo.getName());
        todoImpl.setFinished(todo.isFinished());
        todoImpl.setDueDate(todo.getDueDate());
        todoImpl.setDescription(todo.getDescription());

        return todoImpl;
    }

    /**
     * Returns the todo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the todo
     * @return the todo
     * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a todo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Todo findByPrimaryKey(Serializable primaryKey)
        throws NoSuchTodoException, SystemException {
        Todo todo = fetchByPrimaryKey(primaryKey);

        if (todo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchTodoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return todo;
    }

    /**
     * Returns the todo with the primary key or throws a {@link com.liferay.ide.projects.todo.NoSuchTodoException} if it could not be found.
     *
     * @param todoId the primary key of the todo
     * @return the todo
     * @throws com.liferay.ide.projects.todo.NoSuchTodoException if a todo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Todo findByPrimaryKey(long todoId)
        throws NoSuchTodoException, SystemException {
        return findByPrimaryKey((Serializable) todoId);
    }

    /**
     * Returns the todo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the todo
     * @return the todo, or <code>null</code> if a todo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Todo fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Todo todo = (Todo) EntityCacheUtil.getResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
                TodoImpl.class, primaryKey);

        if (todo == _nullTodo) {
            return null;
        }

        if (todo == null) {
            Session session = null;

            try {
                session = openSession();

                todo = (Todo) session.get(TodoImpl.class, primaryKey);

                if (todo != null) {
                    cacheResult(todo);
                } else {
                    EntityCacheUtil.putResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
                        TodoImpl.class, primaryKey, _nullTodo);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
                    TodoImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return todo;
    }

    /**
     * Returns the todo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param todoId the primary key of the todo
     * @return the todo, or <code>null</code> if a todo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Todo fetchByPrimaryKey(long todoId) throws SystemException {
        return fetchByPrimaryKey((Serializable) todoId);
    }

    /**
     * Returns all the todos.
     *
     * @return the todos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Todo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Todo> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Todo> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Todo> list = (List<Todo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_TODO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_TODO;

                if (pagination) {
                    sql = sql.concat(TodoModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Todo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Todo>(list);
                } else {
                    list = (List<Todo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the todos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Todo todo : findAll()) {
            remove(todo);
        }
    }

    /**
     * Returns the number of todos.
     *
     * @return the number of todos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_TODO);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the todo persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.ide.projects.todo.model.Todo")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Todo>> listenersList = new ArrayList<ModelListener<Todo>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Todo>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(TodoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
