App.factory('Service', ['$http', '$q', function($http, $q) {
var Service = {};

Service.getData=function() {
	return $http.get('/Spring4MVCAngularJS/students');
};
Service.datas=Service.getData();
Service.datas.then(
		function(response){
			Service.tab=response.data[0];
			Service.data=response.data;
			Service.selectedClass=response.data[0].className;
			return response.data;
		}, 
		function(errResponse){
			console.error('Error while fetching Items');
			return $q.reject(errResponse);
		}
);




return Service;
}]);
