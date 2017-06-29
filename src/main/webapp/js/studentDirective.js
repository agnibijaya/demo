'use strict';
angular.module('myDirective',[]).directive('student', function(Service) {
   var directive = {};
    directive.restrict= 'E';

    directive.templateUrl= 'views/studentTemplate.html';
    directive.scope = {
  data : "=data",

};
directive.controller=function($scope){
	$scope.setExpanded=function(m){
        console.log("opened");
        m.expanded=true;
      };
      $scope.setClosed=function(m){
        console.log("closed");
        m.expanded='false';
      };
};
/*directive.compile = function(element, attributes) {
var createtable = function($scope, element,
    attributes) {
$scope.$watch(
        'data',
        function(newValue, oldValue) {
          if (newValue == undefined)
            return;
      $scope.data=newValue;
        },true);

        $scope.setExpanded=function(m){
          console.log("opened");
          m.expanded=true;
        };
        $scope.setClosed=function(m){
          console.log("closed");
          m.expanded='false';
        };

      }


  return createtable;
};*/
return directive;

  });
