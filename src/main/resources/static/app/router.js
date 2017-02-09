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
                .state('news', {
                    url: '/news',
                    controller: 'NewsController',
                    controllerAs: '$news',
                    templateUrl: 'templates/news.html'
                                })
                          .state('main', {
                    url: '/',
                    controller: 'MainController',
                    controllerAs: '$main',
                    templateUrl: 'templates/main.html'
})

      })
})();