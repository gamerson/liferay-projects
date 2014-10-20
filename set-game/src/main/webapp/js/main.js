function newGameData(baseUrl) {
    var numCols = 4;
    var numRows = 3;
    var row_a = new Array();
    var row_b = new Array();
    var row_c = new Array();
    var row_list = [row_a, row_b, row_c];

    for (var i = 0; i < numRows; i++) {
        for (var j = 0; j < numCols; j++) {
            row_list[i][j] = { background: baseUrl + "/html/images/" + randomImage() }
        }
    }

    return JSON.stringify(row_list);
}

function randomImage() {
    var shape = Math.floor(Math.random() * 3) + 1;
    var color = Math.floor(Math.random() * 3) + 1;
    var fill = Math.floor(Math.random() * 3) + 1;
    var number = Math.floor(Math.random() * 3) + 1;
    //shape 1 circle 2 block 3 diamond
    //color 1 red    2 green 3 blue
    //fill  1 empty  2 fill  3 potted
    if (shape_a[shape-1][color-1][fill-1][number - 1] == 0) {
        var file_name = shape + "" + color + "" + fill + "" + number + ".png";
        shape_a[shape-1][color-1][fill-1][number - 1] = 1;
        return file_name;
    } else {
        return randomImage();
    }
}

function startGame(panelId, imagesBaseUrl, invite, startUserId, inviteUserId) {
    var userId = Liferay.ThemeDisplay.getUserId();
    var ws = new WebSocket("ws://localhost:8080/set-game-portlet/game/SetGameServlet?userId=" + userId);

    var gameData = "";

    var success = function(set0, set1, set2) {
        ws.send("foundSet " + set0 + " " + set1 + " " + set2);
    };

    ws.onopen = function() {
        console.log('connection open invite ' + invite);
        if(invite == "true") {
            gameData = newGameData(imagesBaseUrl);
            ws.send("startGame " + startUserId + " " + inviteUserId + " " + gameData);
        }
        else {
            ws.send("ready");
        }
    }

    ws.onmessage = function(msg) {
        if(msg.data == "ready") {
            ws.send("gameData " + gameData);
        }
        else if(msg.data.lastIndexOf("gameData", 0) === 0 ) {
            gameData = msg.data.substr("gameData ".length, msg.data.length);
            setupSetGame(panelId, gameData, success);
            ws.send("start");
        }
        else if(msg.data == "start") {
            setupSetGame(panelId, gameData, success);
        }
        else if(msg.data.lastIndexOf("foundSet ", 0) === 0 ) {
            alert('other player found set ' + msg.data.substr("foundSet ".length, msg.data.length));
        }
    }
}

function checkForInvite(callback) {
    var userId = Liferay.ThemeDisplay.getUserId();
    var ws = new WebSocket("ws://localhost:8080/set-game-portlet/game/SetGameServlet?userId=" + userId);

    ws.onmessage = function(msg) {
        if(msg.data.lastIndexOf("joinGame", 0) === 0 ) {
            AUI().use('aui', function(A) {
                callback();
            });
        }
    }
}