App.controller('homeController',function($scope,Service){
	Service.getData();
$scope.tabsel = Service.tab;
$scope.data=Service.data;

$scope.selectedClassFunct = function(selected){
  Service.selectedClass = selected;
  Service.tab=selected;
  $scope.tabsel=selected;
};
});
