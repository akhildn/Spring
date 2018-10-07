'use strict';

// Declare app level module which depends on views, and components
angular.module('springRest', [
  'ngRoute',
  'springRest.login',
  'springRest.customer'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/home'});
}]);
