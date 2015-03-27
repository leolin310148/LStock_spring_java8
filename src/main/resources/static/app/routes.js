app.config(function ($routeProvider) {
    $routeProvider
        .when('/Industry', {
            templateUrl: 'pages/industry.html',
            controller: 'IndustryController'
        })
        .when('/Stock', {
            templateUrl: 'pages/stock.html',
            controller: 'StockController'
        })
        .otherwise({redirectTo: '/'})
});