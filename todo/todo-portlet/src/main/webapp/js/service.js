'use strict';

angular.module("todoServices", [])
.factory('releaseFactory', function($q, $http) {
    var getRelease = function(pid) {
        var defer = $q.defer();
        var url = Liferay.PortletURL.createResourceURL();
        url.setResourceId("buildNumber");
        url.setPortletId(pid);
        url.setParameter("releaseId", "1");

        $http.get(url.toString()).success(function(data, status, headers, config) {
            defer.resolve(data);
        });

        return defer.promise;
    };

    return {
        getRelease: getRelease
    };
})
.factory('todoFactory', function($q, $http) {
    var getUnfinishedTodos = function (id) {
        var defer = $q.defer();

        Liferay.Service(
            '/todo-portlet.todo/get-unfinished-user-todos',
            {
                userId: id
            },
            function(obj) {
                defer.resolve(obj);
            }
        );

        return defer.promise;
    };

    var finishTodo = function(todo) {
        var defer = $q.defer();
        console.log(todo.todoId);
        Liferay.Service(
            '/todo-portlet.todo/finish-todo',
            {
                todoId: todo.todoId
            },
            function(obj) {
                defer.resolve(obj);
            }
        );

        return defer.promise;
    }

    return {
        getUnfinishedTodos: getUnfinishedTodos,
        finishTodo: finishTodo
    };
});