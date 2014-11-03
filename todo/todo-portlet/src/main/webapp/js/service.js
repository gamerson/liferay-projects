'use strict';

angular.module("todoServices", []).
factory('urlFactory', function() {
    return {
        create: function(pid, name) {
            var resourceURL = Liferay.PortletURL.createRenderURL();
            resourceURL.setPortletId(pid);
            resourceURL.setPortletMode('view');
            resourceURL.setWindowState('exclusive');
            resourceURL.setParameter('jspPage', '/angularjs/' + name + '.jsp');
            return resourceURL.toString();
        }
    };
}).
factory('releaseFactory', function($q, $http) {
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
    var addTodo = function(todo, userId) {
        var defer = $q.defer();

        console.log(userId);
        Liferay.Service(
                '/todo-portlet.todo/add-todo',
                {
                  name: todo.name,
                  description: todo.description,
                  dueDate: todo.dueDate,
                  serviceContext:  {
                      userId: userId
                  }
                },
                function(obj) {
                    console.log(obj);
                    defer.resolve(obj);
                }
              );

        return defer.promise;
    };

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
        addTodo: addTodo,
        getUnfinishedTodos: getUnfinishedTodos,
        finishTodo: finishTodo
    };
});