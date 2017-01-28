//= wrapped
//= require /angular/angular
//= require /oauth/client/core/oauth.client.core
//= require /oauth/client/index/oauth.client.index

angular.module("oauth.client", [
        "oauth.client.core",
        "oauth.client.index"
    ]);
