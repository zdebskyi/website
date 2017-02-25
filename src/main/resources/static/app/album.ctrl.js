(function () {
    angular.module("mainApp")
.controller("AlbumController", function ($http, $scope) {
        var vm=this;
        vm.name="roman"
    $http.get("/album").then(function(response){vm.albumList = response.data})
    vm.saveImage=function(){console.log($scope.file)};
$scope.onLoad = function (e, reader, file, fileList, fileOjects, fileObj) {
    alert(file);
  };
     });

})();
