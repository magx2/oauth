//= wrapped

angular
    .module("oauth.client.index")
    .factory("applicationDataFactory", applicationDataFactory);

function applicationDataFactory($http) {
    return {
        get: function() {
            return $http({method: "GET", url: "application"});
        }
    }
}

