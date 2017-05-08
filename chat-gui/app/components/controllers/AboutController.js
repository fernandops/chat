// AboutController.js
// For distribution, all controllers
// are concatanated into single app.js file
// by using Gulp

'use strict';

angular.module('mostPopularListingsApp.about', ['ngRoute'])

// Routing configuration for this module
.config(['$routeProvider',function($routeprovider){
	$routeprovider.when('/register', {
		controller: 'AboutController',
		templateUrl: 'components/views/aboutView.html'
	});
}])

// Controller definition for this module
.controller('AboutController', function($scope, ApiService) {

	$scope.submitRegisterUser = function() {
		$scope.ret = ApiService.submitRegisterUser($scope.userid, $scope.password, $scope.name, $scope.email);
	};

	// Just a housekeeping.
	// In the init method we are declaring all the
	// neccesarry settings and assignments to be run once
	// controller is invoked
	init();

	function init(){
	
	};

	this.message = "Hello About!";

});