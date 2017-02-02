(function () {
    angular.module("mainApp")
.controller("AlbumController", function ($http) {
        var vm=this;
        vm.name="roman"
        $http.get("/album").then(function(response){vm.albumList = response.data})
    })
})();