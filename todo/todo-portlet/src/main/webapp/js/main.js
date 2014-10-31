(function(Liferay, angular) {
    Liferay.bootstrap = function(id, portletId) {
        var module = angular.module(id, ["todoServices"]);

        module.controller("MainCtrl", ['$scope', 'releaseFactory', 'todoFactory',
            function($scope, releaseFactory, todoFactory) {
                $scope.id = id;
                $scope.portletId = portletId.substr(1, portletId.length - 2);

                $scope.model = {
                    companyId: Liferay.ThemeDisplay.getCompanyId(),
                    isSignedIn: Liferay.ThemeDisplay.isSignedIn(),
                    userName: Liferay.ThemeDisplay.getUserName(),
                    userId: Liferay.ThemeDisplay.getUserId()
                }

                releaseFactory.getRelease($scope.portletId).then(function(release) {
                    $scope.model.release = release;
                });

                todoFactory.getUnfinishedTodos($scope.model.userId).then(function(data) {
                    console.log(data);
                    $scope.model.todos = data;
                });

                $scope.finish = function(todo) {
                    todoFactory.finishTodo(todo).then(function(result){
                        Liferay.fire('reloadTodos', { portletId: $scope.portletId });
                    });
                }
            }
        ]);

        module.directive('language', function() {
        	return {
        	    restrict: 'A',
        	    link: function(scope, element, attributes) {
        	        console.log(element);
        	        console.log(attributes);
        	        var msg = Liferay.Language.get(attributes["language"]);
        	        console.log(msg);
        	        element.html(msg);
        	    }
        	}
        });

        angular.bootstrap(document.getElementById(id), [id]);
    }
})(Liferay, angular);