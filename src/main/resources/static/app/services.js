app.factory("Industry", function ($resource) {
    return $resource('/industry/:id', null, {
        query: {
            method: "GET",
            isArray: false
        }
    });
});
