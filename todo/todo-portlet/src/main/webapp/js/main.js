(function(Liferay, angular) {
    Liferay.bootstrap = function(id, portletId) {
        var module = angular.module(id, ["todoServices"]);

        module.controller("MainCtrl", ['$scope', 'todo',
            function($scope, todo) {
                $scope.id = id;
                $scope.portletId = portletId.substr(1, portletId.length - 2);

                $scope.model = {
                    companyId: Liferay.ThemeDisplay.getCompanyId(),
                    isSignedIn: Liferay.ThemeDisplay.isSignedIn(),
                    userName: Liferay.ThemeDisplay.getUserName()
                }

                todo.getRelease($scope.portletId).then(function(release) {
                    $scope.model.release = release;
                });
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