(function () {
    angular.module("mainApp")
.controller("NewsController", function ($http) {
        var vm=this;
        vm.name="roman"
        $http.get("/news").then(function(response){vm.newsList = response.data})
    })
})();