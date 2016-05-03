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
<body ng-app="myApp">
<div class="container" ng-controller="FormController">
    <div class="col-lg-12">
        <form class="form-horizontal">
            <div class="form-group row">

                <label for="league" class="col-lg-1 control-label">League</label>
                <div class="col-lg-3">
                    <select ng-model="tradeitem.league" class="form-control" id="league">
                        <option value="Hardcore Perandus">Hardcore Perandus</option>
                        <option value="Perandus">Perandus</option>
                        <option value="Hardcore">Hardcore</option>
                        <option value="Standard">Standard</option>
                    </select>

                </div>
                <label for="type" class="col-lg-1 control-label">Type</label>
                <div id="type" class="col-lg-3" ng-include="typeUrl">

                </div>
                <label for="base" class="col-lg-1 control-label">Base</label>
                <div id="base" class="col-lg-3" ng-include="baseUrl">

                </div>
            </div>
            <hr>
            <div class="form-group row">
                <label for="name" class="col-lg-1 control-label">Name</label>
                <div class="col-lg-3">
                    <input ng-model="tradeitem.name" type="text" class="form-control" id="name">
                </div>
            </div>
            <div class="form-group row" id="damageDiv">
                <hr>
                <h3 class="bold">Offence</h3>
                <!-- TODO: implementera Dps värde -->
                <div class="col-lg-4">
                    <label for="minDps" class="col-lg-3 control-label">Dps</label>
                    <div class="col-lg-4">
                        <input ng-model="dps.minValue" type="number" class="form-control" id="minDps" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="dps.maxValue" type="number" class="form-control" id="maxDps" placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minAps" class="col-lg-3 control-label">Aps</label>
                    <div class="col-lg-4">
                        <input ng-model="aps.minValue" type="number" class="form-control" id="minAps" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="aps.maxValue" type="number" class="form-control" id="maxAps" placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minCrit" class="col-lg-3 control-label">Crit.chance</label>
                    <div class="col-lg-4">
                        <input ng-model="crit.minValue" type="number" class="form-control" id="minCrit"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="crit.maxValue" type="number" class="form-control" id="maxCrit"
                               placeholder="max">
                    </div>
                </div>
            </div>

            <div class="form-group row" id="defenseDiv">
                <hr>
                <h3 class="bold">Defense</h3>
                <div class="col-lg-4">
                    <label for="minArmour" class="col-lg-3 control-label">Armour</label>
                    <div class="col-lg-4">
                        <input ng-model="armour.minValue" type="number" class="form-control" id="minArmour"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="armour.maxValue" type="number" class="form-control" id="maxArmour"
                               placeholder="max">
                    </div>
                </div>

                <div class="col-lg-4">
                    <label for="minEnergy" class="col-lg-3 control-label">Shield</label>
                    <div class="col-lg-4">
                        <input ng-model="energy.minValue" type="number" class="form-control" id="minEnergy"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="energy.maxValue" type="number" class="form-control" id="maxEnergy"
                               placeholder="max">
                    </div>
                </div>

                <div class="col-lg-4">
                    <label for="minEvasion" class="col-lg-3 control-label">Evasion</label>
                    <div class="col-lg-4">
                        <input ng-model="evasion.minValue" type="number" class="form-control" id="minEvasion"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="evasion.maxValue" type="number" class="form-control" id="maxEvasion"
                               placeholder="max">
                    </div>
                </div>

            </div>


            <div class="form-group row" id="socketDiv">
                <hr>
                <h3 class="bold">Sockets</h3>
                <div class="col-lg-4">
                    <label for="minSockets" class="col-lg-3 control-label">Sockets</label>
                    <div class="col-lg-4">
                        <input ng-model="tradeitem.sockets.socketMinValue" type="number" class="form-control"
                               id="minSockets" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="tradeitem.sockets.socketMaxValue" type="number" class="form-control"
                               id="maxSockets" placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minLinks" class="col-lg-3 control-label">Links</label>
                    <div class="col-lg-4">
                        <input ng-model="tradeitem.sockets.linksMinValue" type="number" class="form-control"
                               id="minLinks" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="tradeitem.sockets.linksMaxValue" type="number" class="form-control"
                               id="maxLinks" placeholder="max">
                    </div>
                </div>
            </div>


            <div id="reqDiv" class="form-group row">
                <hr>
                <h3 class="bold">Requirements</h3>
                <div class="col-lg-4">
                    <label for="minLvl" class="col-lg-3 control-label">Level</label>
                    <div class="col-lg-4">
                        <input ng-model="level.minValue" type="number" class="form-control" id="minLvl"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="level.maxValue" type="number" class="form-control" id="maxLvl"
                               placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minStr" class="col-lg-3 control-label">Strength</label>
                    <div class="col-lg-4">
                        <input ng-model="strength.minValue" type="number" class="form-control" id="minStr"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="strength.maxValue" type="number" class="form-control" id="maxStr"
                               placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minDex" class="col-lg-3 control-label">Dexterity</label>
                    <div class="col-lg-4">
                        <input ng-model="dexterity.minValue" type="number" class="form-control" id="minDex"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="dexterity.maxValue" type="number" class="form-control" id="maxDex"
                               placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minInt" class="col-lg-3 control-label">Intelligence</label>
                    <div class="col-lg-4">
                        <input ng-model="intelligence.minValue" type="number" class="form-control" id="minInt"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="intelligence.maxValue" type="number" class="form-control" id="maxInt"
                               placeholder="max">
                    </div>
                </div>
            </div>

            <hr>
            <h3 class="bold">Mods</h3>
            <hr/>
            <div id="mods">

                <fieldset data-ng-repeat="mod in tradeitem.mods">

                    <div class="col-lg-6" ng-controller="SelectController">
                    <select style="margin-bottom:20px;" class="form-control" ng-model="mod.name" ng-options="mods for mods in modSelect"></select>

                    </div>

                    <div class="col-lg-6">
                        <div class="col-lg-3">
                            <input ng-model="mod.minValue" class="form-control" type="number" placeholder="min"
                                   name="min">
                        </div>
                        <div class="col-lg-3">
                            <input ng-model="mod.maxValue" class="form-control" type="number" placeholder="max"
                                   name="max">
                        </div>
                        <div class="col-lg-3">
                            <span>
                                <i ng-click="removeMod($index)" style="margin-top:5px; cursor: pointer; font-size:1.5em; display:block; text-align:center;"
                                   class="glyphicon glyphicon-remove removeBtn">

                                </i>
                            </span>
                        </div>
                    </div>

                </fieldset>

                <br>
                <hr>
                <button ng-click="addNewMod()" id="addmod" type="button" class="btn btn-default">Add mod</button>

            </div>
            <br>
            <div class="form-group row" id="miscDiv">
                <hr>
                <h3 class="bold">Misc</h3>
                <div class="col-lg-4">
                    <label for="minDps" class="col-lg-3 control-label">Quality</label>
                    <div class="col-lg-4">
                        <input ng-model="quality.minValue" type="number" class="form-control" id="minQuality"
                               placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input ng-model="quality.maxValue" type="number" class="form-control" id="maxQuality"
                               placeholder="max">
                    </div>
                </div>
                <label for="identified" class="col-lg-1 control-label">Identified</label>
                <div class="col-lg-2">
                    <select ng-model="tradeitem.identified" class="form-control" id="identified">
                        <option value="Either">Either</option>
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                    </select>
                </div>
                <label for="corrupted" class="col-lg-1 control-label">Corrupted</label>
                <div class="col-lg-2">
                    <select ng-model="tradeitem.corrupted" class="form-control" id="corrupted">
                        <option value="Either">Either</option>
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                    </select>
                </div>
            </div>
            <hr>
            <br>
            <button style="float:left; margin-right:10%;" type="button" ng-click="showObject()" class="btn btn-default">
                Test
            </button>
            <button style="float:right; margin-right:10%;" type="button" ng-click="searchTradeItem()"
                    class="btn btn-warning">Search
            </button>
        </form>
    </div>
    <br>
    <hr>
    <div id="fetchedItems">
        <div ng-repeat="response in tradeitemResponse">
            {{response.name}}
            <img src="{{response.icon}}" height="60px" width="60px">
        </div>
    </div>

</div>
</body>
</html>
