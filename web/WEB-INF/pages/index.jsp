<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Poe</title>
    <script src="https://code.jquery.com/jquery-2.2.3.js" integrity="sha256-laXWtGydpwqJ8JA+X9x2miwmaiKhn8tVmOVEigRNtP4="
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <spring:url value="/resources/form.js" var="formJs"/>
    <spring:url value="/resources/css.css" var="css"/>
    <script src="${formJs}"></script>
    <link rel="stylesheet" href="${css}">


</head>
<body>
<div class="container">
    <div class="col-lg-12">
        <form class="form-horizontal">
            <div class="form-group row">

                <label for="league" class="col-lg-1 control-label">League</label>
                <div class="col-lg-4">
                        <select class="form-control" id="league">
                            <option value="Hardcore Perandus">Hardcore Perandus</option>
                            <option value="Perandus">Perandus</option>
                            <option value="Hardcore">Hardcore</option>
                            <option value="Standard">Standard</option>
                        </select>

                </div>
                <label for="league" class="col-lg-1 control-label">Base</label>
                <div id="base" class="col-lg-4">

                </div>
            </div>
            <hr>
            <div class="form-group row">
                <label for="name" class="col-lg-1 control-label">Name</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control" id="name">
                </div>
            </div>
            <hr>
            <div class="form-group row" id="damageDiv">
                <hr>
                <h2 class="bold">Offence</h2>
                <div class="col-lg-4">
                    <label for="minDps" class="col-lg-3 control-label">Dps</label>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="minDps" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="maxDps" placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minAps" class="col-lg-3 control-label">Aps</label>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="minAps" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="maxAps" placeholder="max">
                    </div>
                </div>
            </div>

            <div class="form-group row" id="defenseDiv">
                <hr>
                <h2 class="bold">Defense</h2>
                <div class="col-lg-4">
                    <label for="minArmour" class="col-lg-3 control-label">Armour</label>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="minArmour" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="maxArmour" placeholder="max">
                    </div>
                </div>

                <div class="col-lg-4">
                    <label for="minEnergy" class="col-lg-3 control-label">Shield</label>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="minEnergy" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="maxEnergy" placeholder="max">
                    </div>
                </div>

                <div class="col-lg-4">
                    <label for="minEvasion" class="col-lg-3 control-label">Evasion</label>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="minEvasion" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="maxEvasion" placeholder="max">
                    </div>
                </div>

            </div>

            <div id="reqDiv" class="form-group row">
                <hr>
                <h2 class="bold">Requirements</h2>
                <div class="col-lg-4">
                    <label for="minLvl" class="col-lg-3 control-label">Level</label>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="minLvl" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="maxLvl" placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minStr" class="col-lg-3 control-label">Strength</label>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="minStr" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="maxStr" placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minDex" class="col-lg-3 control-label">Dexterity</label>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="minDex" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="maxDex" placeholder="max">
                    </div>
                </div>
                <div class="col-lg-4">
                    <label for="minInt" class="col-lg-3 control-label">Intelligence</label>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="minInt" placeholder="min">
                    </div>
                    <div class="col-lg-4">
                        <input type="number" class="form-control" id="maxInt" placeholder="max">
                    </div>
                </div>
            </div>


            <h2 class="bold">Mods</h2>
            <hr/>
            <div id="mods">



            </div>

            <button id="addmod" type="button" class="btn btn-default">Add mod</button>
        </form>
    </div>

</div>
</body>
</html>
