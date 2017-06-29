'use strict';
var App = angular.module('myapp',['ui.router','myDirective']);

App.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
                //default?
                $urlRouterProvider.otherwise("/home")
                $stateProvider
                       .state('home', {
                           url: "/home",
                           templateUrl: "views/home.html"

                       })
                       }]);
