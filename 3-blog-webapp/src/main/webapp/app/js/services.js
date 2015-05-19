angular.module('blogApp.services', []).
factory('blogService', function($resource) {
	
	return $resource('service/blog/:blogId', {blogId: '@blogId'});

});
