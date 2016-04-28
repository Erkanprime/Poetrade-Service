
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
        $scope.tradeitemCopy = $scope.tradeitem;
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
        $scope.tradeitemCopy.parameters.push($scope.quality);
        $scope.tradeitemCopy.parameters.push($scope.armour);
        $scope.tradeitemCopy.parameters.push($scope.evasion);
        $scope.tradeitemCopy.parameters.push($scope.energy);
        $scope.tradeitemCopy.parameters.push($scope.aps);
        $scope.tradeitemCopy.parameters.push($scope.crit);

        //requirements
        $scope.tradeitemCopy.requirements.push($scope.strength);
        $scope.tradeitemCopy.requirements.push($scope.dexterity);
        $scope.tradeitemCopy.requirements.push($scope.intelligence);
        $scope.tradeitemCopy.requirements.push($scope.level);


    };

    $scope.showObject= function(){
        $scope.prepareTradeItem();
        console.log($scope.tradeitemCopy);
        $scope.tradeitemCopy = {};
    };


}]);