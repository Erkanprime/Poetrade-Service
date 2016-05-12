App.factory('PoeService', ['$http', '$q', function($http, $q){

    return {

        search: function (tradeitem) {
            return $http.post('http://localhost:8080/poe-trade/search', tradeitem)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while searching');
                        return $q.reject(errResponse);
                    }
                );
        }
        
    };

}]);