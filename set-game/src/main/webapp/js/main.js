
function startGame(panelId, imagesBaseUrl, invite, startUserId, inviteUserId) {
    var userId = Liferay.ThemeDisplay.getUserId();
    var ws = new WebSocket("ws://localhost:8080/set-game-portlet/game/SetGameServlet?userId=" + userId);

    var gameData = "";

    var success = function(set0, set1, set2) {
        AUI().use('aui-node', function(A) {
            debugger;
            var node = A.one("#score");
            var currentScore = parseInt(node.text());
            currentScore++;
            node.setHTML(currentScore);
        });

        ws.send("foundSet " + JSON.stringify(set0) + " " + JSON.stringify(set1) + " " + JSON.stringify(set2) + " " + exchange());
    };

    ws.onopen = function() {
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
            var data = msg.data.split(" ");
            var set0 = JSON.parse(data[1]);
            var set1 = JSON.parse(data[2]);
            var set2 = JSON.parse(data[3]);

            showSet(set0,set1,set2);
            alert('other player found a set');

            AUI().use('aui-node', function(A) {
                debugger;
                var node = A.one("#otherscore");
                var currentScore = parseInt(node.text());
                currentScore++;
                node.setHTML(currentScore);
            });

            var newCardsStr = msg.data.substr(data[1].length + data[2].length + data[3].length + 12, msg.data.length);
            exchange(set0, set1, set2, newCardsStr);
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