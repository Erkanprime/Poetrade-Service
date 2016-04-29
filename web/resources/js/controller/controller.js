
App.controller('FormController', ['$scope', 'PoeService', function($scope, PoeService) {
    $scope.tradeitemResponse=[];
    $scope.tradeitemCopy={};

    $scope.tradeitem={
     league: "Hardcore Perandus",
     name: null,
     type: "any",
     base: "any",
     requirements:[],
     parameters:[],
     identified:"Either",
     corrupted: "Either",
     sockets:{
            socketMinValue:null,
            socketMaxValue:null,
            linksMinValue:null,
            linksMaxValue:null
     },
     mods:[
         {name:"-- --", minValue: null, maxValue: null}
     ]

    };

    $scope.quality={
        name:"Quality",
        minValue:null,
        maxValue:null
    };

    $scope.armour={
        name:"Armour",
        minValue:null,
        maxValue:null
    };
    $scope.evasion={
        name:"Evasion Rating",
        minValue:null,
        maxValue:null
    };
    $scope.energy={
        name:"Energy Shield",
        minValue:null,
        maxValue:null
    };
    $scope.strength={
        name:"Str",
        minValue:null,
        maxValue:null
    };
    $scope.dexterity={
        name:"Dex",
        minValue:null,
        maxValue:null
    };
    $scope.intelligence={
        name:"Int",
        minValue:null,
        maxValue:null
    };
    $scope.dps={
        name:null,
        minValue:null,
        maxValue:null
    };
    $scope.aps={
        name:"Attacks per Second",
        minValue:null,
        maxValue:null
    };
    $scope.crit={
        name:"Critical Strike Chance",
        minValue:null,
        maxValue:null
    };

    $scope.level={
        name:"Level",
        minValue:null,
        maxValue:null
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

    $scope.updateBase = function(){
        $scope.tradeitem.base = 'any';
    };

    $scope.searchTradeItem = function(){
        $scope.prepareTradeItem();
        PoeService.search($scope.tradeitemCopy)
            .then(
                function(d) {
                    $scope.tradeitemResponse = d;
                    console.log($scope.tradeitemResponse);
                },
                function(errResponse){
                    console.error('Error while fetching tradeitems');
                }
            );
    };

    $scope.prepareTradeItem = function(){
        $scope.tradeitemCopy = angular.copy($scope.tradeitem);

        if($scope.tradeitemCopy.corrupted == 'Either'){
            $scope.tradeitemCopy.corrupted = null;
        }else
        if($scope.tradeitemCopy.corrupted == 'Yes'){
            $scope.tradeitemCopy.corrupted = true;
        }else
        if($scope.tradeitemCopy.corrupted == 'No'){
            $scope.tradeitemCopy.corrupted = false;
        }

        if($scope.tradeitemCopy.identified == 'Either'){
            $scope.tradeitemCopy.identified = null;
        }else
        if($scope.tradeitemCopy.identified == 'Yes'){
            $scope.tradeitemCopy.identified = true;
        }else
        if($scope.tradeitemCopy.identified == 'No'){
            $scope.tradeitemCopy.identified = false;
        }

        if($scope.tradeitemCopy.base == 'any'){
            $scope.tradeitemCopy.base = null;
        }
        if($scope.tradeitemCopy.type == 'any'){
            $scope.tradeitemCopy.type = null;
        }
        //parameters
        if($scope.quality.minValue != null || $scope.quality.maxValue != null){
            $scope.tradeitemCopy.parameters.push($scope.quality);
        }
        if($scope.armour.minValue != null || $scope.armour.maxValue != null){
            $scope.tradeitemCopy.parameters.push($scope.armour);
        }
        if($scope.evasion.minValue != null || $scope.evasion.maxValue != null){
            $scope.tradeitemCopy.parameters.push($scope.evasion);
        }
        if($scope.energy.minValue != null || $scope.quality.energy != null){
            $scope.tradeitemCopy.parameters.push($scope.energy);
        }
        if($scope.aps.minValue != null || $scope.aps.maxValue != null){
            $scope.tradeitemCopy.parameters.push($scope.aps);
        }
        if($scope.crit.minValue != null || $scope.crit.maxValue != null){
            $scope.tradeitemCopy.parameters.push($scope.crit);
        }

        //requirements
        if($scope.strength.minValue != null || $scope.strength.maxValue != null){
            $scope.tradeitemCopy.requirements.push($scope.strength);
        }
        if($scope.dexterity.minValue != null || $scope.dexterity.maxValue != null){
            $scope.tradeitemCopy.requirements.push($scope.dexterity);
        }
        if($scope.intelligence.minValue != null || $scope.intelligence.maxValue != null){
            $scope.tradeitemCopy.requirements.push($scope.intelligence);
        }
        if($scope.level.minValue != null || $scope.level.maxValue != null){
            $scope.tradeitemCopy.requirements.push($scope.level);
        }

    };

    $scope.showObject= function(){
        console.log($scope.tradeitem);
        $scope.prepareTradeItem();
        console.log($scope.tradeitemCopy);
        $scope.tradeitemCopy = {};
    };


}]);