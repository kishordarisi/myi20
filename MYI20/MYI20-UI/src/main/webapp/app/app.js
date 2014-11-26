var Myi20 = angular.module("Myi20", ['ngCookies']);

Myi20.config(function($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'index.html',
        controller: 'RegistrationContoller'
    });
});