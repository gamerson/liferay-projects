'use strict';

angular.module("todoServices", []).factory('todo', function($q, $http) {
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
});