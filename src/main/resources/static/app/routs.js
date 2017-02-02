(function () {
    'use strict';


    angular.module("mainApp")
        .config(function($stateProvider, $urlRouterProvider){


            $stateProvider

                .state('album', {
                    url: '/album',
                    controller: 'AlbumController',
                    controllerAs: '$album',
                    templateUrl: 'templates/album.html'
                })

$urlRouterProvider.when('/', '/album');
            $urlRouterProvider.when('', '/album');

        })
})();