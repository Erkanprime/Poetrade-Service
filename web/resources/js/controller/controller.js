
App.controller('FormController', ['$scope', 'PoeService', function($scope, PoeService) {
    $scope.formFlag=true;
    $scope.tradeitemResponse=[];
    $scope.tradeitemCopy={};

    $scope.userLogin ={
        username:null,
        password:null
    };
    $scope.signedIn = false;
    
    $scope.tradeitem={
     league: "Hardcore Perandus",
     name: null,
     type: "any",
     base: "any",
     rarity:"any",   
     requirements:[],
     properties:[],
     identified:"Either",
     corrupted: "Either",
     minPdps:null,
     maxPdps:null,
     minEdps:null,
     maxEdps:null,
     minIlvl:null,
     maxIlvl:null,   
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
        if($scope.tradeitem.mods.length < 10){
            $scope.tradeitem.mods.push({
                name:"-- --",
                minValue: null,
                maxValue: null
            });
        }    
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
                    $scope.formFlag = false;
                },
                function(errResponse){
                    console.error('Error while fetching tradeitems');
                }
            );
    };


    $scope.userSignUp = function(){
        console.log($scope.userLogin);
        PoeService.signUp($scope.userLogin)
            .then(
                function(d) {
                    $scope.signedIn = true;
                },
                function(errResponse){
                    console.error('Error while Signing in');
                }
            );
    };



    $scope.userSignIn = function(){
        console.log($scope.userLogin);
        PoeService.login($scope.userLogin)
            .then(
                function(d) {
                    $scope.signedIn = true;
                },
                function(errResponse){
                    console.error('Error while logging in');
                }
            );
    };
    
    
    
    $scope.prepareTradeItem = function(){
        $scope.tradeitemCopy = angular.copy($scope.tradeitem);
        $scope.tradeitemCopy.mods = [];
        
        //mods
        angular.forEach($scope.tradeitem.mods, function (value, key) {

            if(value.name != "-- --"){
                $scope.tradeitemCopy.mods.push(value);
            }
        });
        
        if($scope.tradeitemCopy.name == ""){
            $scope.tradeitemCopy.name = null;
        }

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
        if($scope.tradeitemCopy.rarity == 'any'){
            $scope.tradeitemCopy.rarity = null;
        }
        //properties
        if($scope.quality.minValue != null || $scope.quality.maxValue != null){
            $scope.tradeitemCopy.properties.push($scope.quality);
        }
        if($scope.armour.minValue != null || $scope.armour.maxValue != null){
            $scope.tradeitemCopy.properties.push($scope.armour);
        }
        if($scope.evasion.minValue != null || $scope.evasion.maxValue != null){
            $scope.tradeitemCopy.properties.push($scope.evasion);
        }
        if($scope.energy.minValue != null || $scope.quality.energy != null){
            $scope.tradeitemCopy.properties.push($scope.energy);
        }
        if($scope.aps.minValue != null || $scope.aps.maxValue != null){
            $scope.tradeitemCopy.properties.push($scope.aps);
        }
        if($scope.crit.minValue != null || $scope.crit.maxValue != null){
            $scope.tradeitemCopy.properties.push($scope.crit);
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
        
        $scope.prepareTradeItem();
        console.log($scope.tradeitemCopy);
        $scope.tradeitemCopy = {};
    };


    $scope.hideForm = function () {
        $scope.formFlag = false;
    };
    $scope.showForm = function () {
        $scope.formFlag = true;
    };

    $scope.getImgSize = function (type) {
      if(type == "Ring" || type == "Amulet" ||
        type == "Map" ||
        type == "Divination Card" || type == "Gem" ||
        type == "Jewel" ||
        type == "Vaal Fragments") {
          
          return 'smallImg';
      }else
      if(type == "Belt" || type == "Flask" ){
          
          return 'mediumSmallImg';
      }else
      if(type == "Quiver" ||
         type == "One Hand Sword" ||
         type == "One Hand Axe" || type == "One Hand Mace" ||
         type == "Claw" || type == "Dagger" || type == "Sceptre" ||
         type == "Gloves" || type == "Boots" || type == "Helmet" || type == "Wand"){
          
          return 'mediumImg';
      }else {
          
          return 'largeImg';
      }
    };
    
    $scope.getRarity = function (rarity) {
      
        if(rarity == 0){
            return 'white';
        }
        if(rarity == 1){
            return 'magic';
        }
        if(rarity == 2){
            return 'rare';
        }
        if(rarity == 3){
            return 'unique';
        }
        
        return 'Gem';
    };

    $scope.getSocketColour = function (colour) {
        if(colour == 'Red'){
            return 'socketStr';
        }
        if(colour == 'Blue'){
            return 'socketInt';
        }
        if(colour == 'Green'){
            return 'socketDex';
        }
        if(colour == 'White'){
            return 'socketCor';
        }
    };
    
    $scope.getSocketPosition = function (index) {
        if(index == 0){
            return 'socket1';
        }
        if(index == 1){
            return 'socket2';
        }
        if(index == 2){
            return 'socket3';
        }
        if(index == 3){
            return 'socket4';
        }
        if(index == 4){
            return 'socket5';
        }
        if(index == 5){
            return 'socket6';
        }
    };

    $scope.previousGroupId = null;

    $scope.isLinkedWithPrevious = function (id, index) {

        if(index > 0){
            if($scope.previousGroupId == id){
                $scope.previousGroupId = id;
                if(index == 1){

                    return 'linkHori linkHori1';
                }
                if(index == 2){

                    return 'linkVerti linkVerti1';
                }
                if(index == 3){
                    
                    return 'linkHori linkHori2'
                }
                if(index == 4){
                    
                    return 'linkVerti linkVerti2';
                }
                if(index == 5){
                    
                    return 'linkHori linkHori3';
                }
            }
            
        }

        $scope.previousGroupId = id;


    };

}]);