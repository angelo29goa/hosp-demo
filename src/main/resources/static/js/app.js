angular.module('HospDemo', ['hosp','errors', 'ngRoute', 'ui.directives']).
    config(function ($locationProvider, $routeProvider) {
//        $routeProvider.when('/errors', {
//            controller: 'ErrorsController',
//            templateUrl: 'templates/errors.html'
//        });
        $routeProvider.otherwise({
            controller: 'HospController',
            templateUrl: 'templates/hosp.html'
        });
    }
);
