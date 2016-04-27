
App.controller('FormController', ['$scope', 'PoeService', function($scope, PoeService) {

    $scope.tradeitem={
     league: "Hardcore",
     name: null,
     type: null,
     base: null,
     minQuality:null,
     maxQuality:null,
     minLevel: null,
     maxLevel: null,
     minArmour: null,
     maxArmour: null,
     minEnergy: null,
     maxEnergy: null,
     minEvasion: null,
     maxEvasion: null,
     minStrength: null,
     maxStrength: null,
     minDexterity: null,
     maxDexterity: null,
     minIntelligence: null,
     maxIntelligence: null,
     minDps: null,
     maxDps: null,
     minAps: null,
     maxAps: null,
     minSockets:null,
     maxSockets:null,
     minLinks:null,
     maxLinks:null,
     identified:"Either",
     corrupted: "Either",
     mods:[
         {name:"-- --",
         minValue: null,
         maxValue: null
         }
     ]

    };
    $scope.modsUrl="/poe-trade/resources/select.html";
    $scope.typeUrl="/poe-trade/resources/type.html";
    $scope.baseUrl="/poe-trade/resources/base.html";

    $scope.submit = function() {
        console.log($scope.tradeitem);
    };

    $scope.addNewMod = function() {

        $scope.tradeitem.mods.push({
            name:"-- --",
            minValue: null,
            maxValue: null
        });
    };

    $scope.removeMod = function(index) {
        console.log(index);
        $scope.tradeitem.mods.splice(index, 1);
    };
}]);