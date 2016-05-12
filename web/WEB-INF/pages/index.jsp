<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Poe</title>
    <script src="https://code.jquery.com/jquery-2.2.3.js"
            integrity="sha256-laXWtGydpwqJ8JA+X9x2miwmaiKhn8tVmOVEigRNtP4="
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-sanitize.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <script src="<c:url value='/resources/js/app.js'/>"></script>
    <script src="<c:url value='/resources/js/controller/controller.js'/>"></script>
    <script src="<c:url value='/resources/js/controller/SelectController.js'/>"></script>
    <script src="<c:url value='/resources/js/service/service.js'/>"></script>

    <link rel="stylesheet" href="<c:url value='/resources/css.css'/>">
</head>
<body ng-app="myApp" ng-controller="FormController">
<div class="container" style="margin-top: 15%;">
    <button ng-click="hideForm()" ng-show="formFlag" class="col-lg-12 showFormBtn ng-hide btn btn-default"><h4>Hide
        form</h4></button>
    <button ng-click="showForm()" ng-show="!formFlag" class="col-lg-12 showFormBtn ng-hide btn btn-default"><h4>Show
        form</h4></button>
</div>
<div class="container customForm">
    <div ng-show="formFlag" class="ng-hide innerForm">
        <form class="form-horizontal">
            <div class="form-group row col-lg-12">

                <label for="league" class="col-lg-1 control-label customText">League</label>
                <div class="col-lg-3">
                    <select ng-model="tradeitem.league" class="form-control selectText" id="league">
                        <option value="Hardcore Perandus">Hardcore Perandus</option>
                        <option value="Perandus">Perandus</option>
                        <option value="Hardcore">Hardcore</option>
                        <option value="Standard">Standard</option>
                        <option value="Hardcore">Perandus Flashback HC</option>
                        <option value="Standard">Perandus Flashback</option>
                    </select>

                </div>
                <label for="type" class="col-lg-1 control-label customText">Type</label>
                <div id="type" class="col-lg-3" ng-include="typeUrl">

                </div>
                <label for="base" class="col-lg-1 control-label customText">Base</label>
                <div id="base" class="col-lg-3" ng-include="baseUrl">

                </div>
            </div>
            <hr>
            <div class="form-group row col-lg-12">
                <label for="name" class="col-lg-1 control-label customText">Name</label>
                <div class="col-lg-3">
                    <input ng-model="tradeitem.name" type="text" class="form-control selectText" id="name">
                </div>
            </div>
            <div class="form-group col-lg-12 row" id="damageDiv">
                <hr>
                <h3 class="bold">Offence</h3>
                <!-- TODO: implementera Dps värde -->
                <div class="col-lg-4">
                    <label for="minDps" class="col-lg-4 control-label customText">Dps</label>
                    <div class="col-lg-4">
                        <input ng-model="tradeitem.minPdps" type="number" class="form-control selectText" id="minDps"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="tradeitem.maxPdps" type="number" class="form-control selectText" id="maxDps"
                               placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minAps" class="col-lg-4 control-label customText">Aps</label>
                    <div class="col-lg-4">
                        <input ng-model="aps.minValue" type="number" class="form-control selectText" id="minAps"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="aps.maxValue" type="number" class="form-control selectText" id="maxAps"
                               placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minCrit" class="col-lg-4 control-label customText">Crit.chance</label>
                    <div class="col-lg-4">
                        <input ng-model="crit.minValue" type="number" class="form-control selectText" id="minCrit"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="crit.maxValue" type="number" class="form-control selectText" id="maxCrit"
                               placeholder="max">
                    </div>
                </div>
            </div>

            <div class="form-group row col-lg-12" id="defenseDiv">
                <hr>
                <h3 class="bold">Defense</h3>
                <div class="col-lg-4">
                    <label for="minArmour" class="col-lg-4 control-label customText">Armour</label>
                    <div class="col-lg-4">
                        <input ng-model="armour.minValue" type="number" class="form-control selectText" id="minArmour"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="armour.maxValue" type="number" class="form-control selectText" id="maxArmour"
                               placeholder="max">
                    </div>
                </div>

                <div class="col-lg-4">
                    <label for="minEnergy" class="col-lg-4 control-label customText">Shield</label>
                    <div class="col-lg-4">
                        <input ng-model="energy.minValue" type="number" class="form-control selectText" id="minEnergy"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="energy.maxValue" type="number" class="form-control selectText" id="maxEnergy"
                               placeholder="max">
                    </div>
                </div>

                <div class="col-lg-4">
                    <label for="minEvasion" class="col-lg-4 control-label customText">Evasion</label>
                    <div class="col-lg-4">
                        <input ng-model="evasion.minValue" type="number" class="form-control selectText" id="minEvasion"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="evasion.maxValue" type="number" class="form-control selectText" id="maxEvasion"
                               placeholder="max">
                    </div>
                </div>

            </div>


            <div class="form-group row col-lg-12" id="socketDiv">
                <hr>
                <h3 class="bold">Sockets</h3>
                <div class="col-lg-4">
                    <label for="minSockets" class="col-lg-4 control-label customText">Sockets</label>
                    <div class="col-lg-4">
                        <input ng-model="tradeitem.sockets.socketMinValue" type="number" class="form-control selectText"
                               id="minSockets" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="tradeitem.sockets.socketMaxValue" type="number" class="form-control selectText"
                               id="maxSockets" placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minLinks" class="col-lg-4 control-label customText">Links</label>
                    <div class="col-lg-4">
                        <input ng-model="tradeitem.sockets.linksMinValue" type="number" class="form-control selectText"
                               id="minLinks" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="tradeitem.sockets.linksMaxValue" type="number" class="form-control selectText"
                               id="maxLinks" placeholder="max">
                    </div>
                </div>
            </div>


            <div class="form-group row col-lg-12">
                <hr>
                <h3 class="bold">Requirements</h3>
                <div class="col-lg-4">
                    <label for="minLvl" class="col-lg-4 control-label customText">Level</label>
                    <div class="col-lg-4">
                        <input ng-model="level.minValue" type="number" class="form-control selectText" id="minLvl"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="level.maxValue" type="number" class="form-control selectText" id="maxLvl"
                               placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minStr" class="col-lg-4 control-label customText">Strength</label>
                    <div class="col-lg-4">
                        <input ng-model="strength.minValue" type="number" class="form-control selectText" id="minStr"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="strength.maxValue" type="number" class="form-control selectText" id="maxStr"
                               placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minDex" class="col-lg-4 control-label customText">Dexterity</label>
                    <div class="col-lg-4">
                        <input ng-model="dexterity.minValue" type="number" class="form-control selectText" id="minDex"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="dexterity.maxValue" type="number" class="form-control selectText" id="maxDex"
                               placeholder="max">
                    </div>
                </div>
            </div>
            <div class="row col-lg-12">
                <div class="col-lg-4">
                    <label for="minInt" class="col-lg-4 control-label customText">Intelligence</label>
                    <div class="col-lg-4">
                        <input ng-model="intelligence.minValue" type="number" class="form-control selectText"
                               id="minInt"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="intelligence.maxValue" type="number" class="form-control selectText"
                               id="maxInt"
                               placeholder="max">
                    </div>
                </div>
            </div>

            <hr>
            <h3 class="bold">Mods</h3>
            <hr/>
            <div class="col-lg-12 row" id="mods">

                <fieldset data-ng-repeat="mod in tradeitem.mods">

                    <div class="col-lg-6" ng-controller="SelectController">
                        <select style="margin-bottom:20px;" class="form-control selectText" ng-model="mod.name"
                                ng-options="mods for mods in modSelect"></select>

                    </div>

                    <div class="col-lg-6">
                        <div class="col-lg-3">
                            <input ng-model="mod.minValue" class="form-control selectText" type="number"
                                   placeholder="min"
                                   name="min">
                        </div>
                        <div class="col-lg-3">
                            <input ng-model="mod.maxValue" class="form-control selectText" type="number"
                                   placeholder="max"
                                   name="max">
                        </div>
                        <div class="col-lg-3">
                            <span>
                                <i ng-click="removeMod($index)"
                                   style="margin-top:5px; cursor: pointer; font-size:1.5em; display:block; text-align:center; color:white;"
                                   class="glyphicon glyphicon-remove removeBtn">

                                </i>
                            </span>
                        </div>
                    </div>

                </fieldset>

                <br>
                <button ng-click="addNewMod()" id="addmod" type="button" class="btn btn-default"
                        style="font-size:16px;">Add mod
                </button>

            </div>
            <br>
            <div class="form-group row col-lg-12" id="miscDiv">
                <hr>
                <h3 class="bold">Misc</h3>
                <div class="col-lg-4">
                    <label for="minQuality" class="col-lg-4 control-label customText">Quality</label>
                    <div class="col-lg-4">
                        <input ng-model="quality.minValue" type="number" class="form-control selectText" id="minQuality"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="quality.maxValue" type="number" class="form-control selectText" id="maxQuality"
                               placeholder="max">
                    </div>
                </div>
                <label for="identified" class="col-lg-2 control-label customText">Identified</label>
                <div class="col-lg-2">
                    <select ng-model="tradeitem.identified" class="form-control" id="identified">
                        <option value="Either">Either</option>
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                    </select>
                </div>
                <label for="corrupted" class="col-lg-2 control-label customText">Corrupted</label>
                <div class="col-lg-2">
                    <select ng-model="tradeitem.corrupted" class="form-control" id="corrupted">
                        <option value="Either">Either</option>
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                    </select>
                </div>
            </div>
            <div class="row col-lg-12">
                <div class="col-lg-4">
                    <label for="rarity" class="col-lg-4 control-label customText">Rarity</label>
                    <div class="col-lg-6">
                        <select ng-model="tradeitem.rarity" class="form-control" id="rarity">
                            <option value="any">Any</option>
                            <option value=0>White</option>
                            <option value=1>Magic</option>
                            <option value=2>Rare</option>
                            <option value=3>Unique</option>
                        </select>
                    </div>
                </div>
                <div class="col-lg-6">
                    <label for="minIlvl" class="col-lg-4 control-label customText">ItemLevel</label>
                    <div class="col-lg-3">
                        <input ng-model="tradeitem.minIlvl" type="number" class="form-control selectText" id="minIlvl"
                               placeholder="min">
                    </div>
                    <div class="col-lg-3">
                        <input ng-model="tradeitem.maxIlvl" type="number" class="form-control selectText" id="maxIlvl"
                               placeholder="max">
                    </div>
                </div>
            </div>
            <hr>
            <br>
            <button style="float:left; margin-right:10%; margin-top:5%; margin-bottom:10%;"
                    type="button" ng-click="showObject()" class="btn btn-default">
                Test
            </button>
            <button style="float:right; margin-right:10%; margin-top:5%; margin-bottom:10%;" type="button" ng-click="searchTradeItem()"
                    class="btn searchButton">Search
            </button>
        </form>
    </div>

</div>

<div class="container" id="fetchedItems">

    <table class="col-lg-12">
        <tr class="resultRow" ng-repeat="response in tradeitemResponse">
            <td class="iconCell col-lg-2">
            <div style="position: relative; left: 0; top: 0;">
                <img class="displayImage" src="{{response.icon}}">
                <div style="position: absolute; left: -20; top: 0;">
                    <div ng-repeat="socket in response.sockets"
                         ng-class="getSocketColour(socket.colour) + ' ' + getSocketPosition($index)">
                        <div ng-class="isLinkedWithPrevious(socket.groupId, $index)"></div>
                    </div>
                </div>
            </div>
            </td>
            <td class="statsCell col-lg-4">
                <h2 ng-class="getRarity(response.rarity)">{{response.name}}</h2>
                <hr>
                    <span>
                        <small class="requirements"
                               ng-repeat="(key,val) in response.requirements"> {{key}}: {{val}}</small>
                    </span>
                <hr>
                <p ng-repeat="mod in response.mods">{{mod}}</p>
                <h2 ng-show="!response.identified" class="ng-hide" style="color:red;">Unidentified</h2>
                <h2 ng-show="response.corrupted" class="ng-hide" style="color:red;">Corrupted</h2>
                <h3>Itemlevel: {{response.ilvl}}</h3>
            </td>
            <td class="statsCell col-lg-4">
                <h2>Physical Damage: {{response.pDps}}</h2>
                <h2>Elemental Damage : {{response.eDps}}</h2>
                <hr>
                <p ng-repeat="(key,val) in response.properties"> {{key}}{{val=='' ? ' ' : ':'}} {{val}}</p>
                <p> {{response.base}}</p>
                <hr>
                <h3>Price: {{response.price}}</h3>
                <h3>Owner: {{response.shopOwner}}</h3>
            </td>
        </tr>
    </table>

</div>

</body>
</html>
