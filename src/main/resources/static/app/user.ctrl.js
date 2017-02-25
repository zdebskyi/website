(function () {
    angular.module("mainApp")
.controller("UserController", function ($http) {
        var vm=this;
        vm.name="roman"
        $http.get("/user").then(function(response){vm.userList = response.data})
    })
})();