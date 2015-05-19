angular.module('blogApp.controllers', []).
controller('blogController', function ($scope, $location, blogService) {
	
	$scope.blogEntries = blogService.query();

	$scope.deleteBlogEntry = function(blogEntry) {
		blogEntry.$remove({blogId:blogEntry.id}, function() {
			$scope.blogEntries = blogService.query();
		});
	};
	
	$scope.blogEntry = new blogService();
	
	$scope.saveBlog = function() {
		$scope.blogEntry.$save(function() {
			$location.path('/');
		});
	};
});