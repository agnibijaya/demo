App.controller('productController',function($scope,Service){
$scope.tabsel = Service.tab;
$scope.data=Service.data;

$scope.selectedClassFunct = function(selected){
  Service.selectedClass = selected;
  Service.tab=selected;
  $scope.tabsel=selected;
};
});
