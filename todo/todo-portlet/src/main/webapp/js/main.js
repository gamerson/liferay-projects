(function(Liferay, angular) {
    Liferay.bootstrap = function(id, portletId) {
        var module = angular.module(id, ['todoServices','quark.relativeDate']);

        module.controller("MainCtrl", ['$scope', '$timeout', 'releaseFactory', 'todoFactory', 'urlFactory',
            function($scope, $timeout, releaseFactory, todoFactory, urlFactory) {
                $scope.id = id;
                $scope.portletId = portletId.substr(1, portletId.length - 2);

                $scope.page = urlFactory.create($scope.portletId, 'list');

                $scope.model = {
                    currentTodo: {},
                    companyId: Liferay.ThemeDisplay.getCompanyId(),
                    isSignedIn: Liferay.ThemeDisplay.isSignedIn(),
                    userName: Liferay.ThemeDisplay.getUserName(),
                    userId: Liferay.ThemeDisplay.getUserId()
                }

                releaseFactory.getRelease($scope.portletId).then(function(release) {
                    $scope.model.release = release;
                });

                todoFactory.getUnfinishedTodos($scope.model.userId).then(function(data) {
                    $scope.model.todos = data;
                });

                $scope.finish = function(todo) {
                    todoFactory.finishTodo(todo).then(function(result){
                        Liferay.fire('reloadTodos', { portletId: $scope.portletId });
                        $scope.main();
                    });
                }

                $scope.main = function() {
                    $scope.model.currentTodo = {};
                    $scope.page = urlFactory.create($scope.portletId, 'list');
                    $scope.reload();
                }

                $scope.add = function() {
                    $scope.model.currentTodo = {};
                    $scope.page = urlFactory.create($scope.portletId, 'add');
                }

                $scope.store = function() {
                    console.log('store');
                    todoFactory.addTodo($scope.model.currentTodo, $scope.model.userId).then(function(result){
                        console.log('fire reload');
                        Liferay.fire('reloadTodos', { portletId: $scope.portletId } );
                        $scope.main();
                    });
                }

                $scope.reload = function() {
                    $timeout(function() {
                        todoFactory.getUnfinishedTodos($scope.model.userId).then(function(todos){
                            $scope.model.todos = todos;
                        });
                    });
                }

                Liferay.on('reloadTodos', function(event){
                    if(event.portletId != $scope.portletId) {
                        $scope.reload();
                    }
                });
            }
        ]);

        module.directive('language', function() {
            return {
                restrict: 'A',
                link: function(scope, element, attributes) {
                    var msg = Liferay.Language.get(attributes["language"]);
                    element.html(msg);
                }
            }
        });

        angular.bootstrap(document.getElementById(id), [id]);
    }
})(Liferay, angular);
