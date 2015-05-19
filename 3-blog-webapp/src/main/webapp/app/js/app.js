angular.module('blogApp', ['blogApp.services', 'blogApp.controllers', 'ngRoute', 'ngResource'])
	.config(
		['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
			
			$routeProvider.when('/blog/create', {
				templateUrl: 'app/partials/blog-create.html',
				controller: 'blogController'
			});
			
			$routeProvider.otherwise({
				templateUrl: 'app/partials/blogs.html',
				controller: 'blogController'
			});
			
			$locationProvider.hashPrefix('!');
		}]
		
	);
