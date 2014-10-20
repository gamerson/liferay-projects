function newGameData(gameType, baseUrl) {
    var total_td_list = new Array(gameSize(gameType));
    total_td_list.forEach(function(e){
    	e = {
			baseUrl:"",
			background:""
    	};
    });
    var col = total_td_list.length / 3;
    var row_a = new Array();
    var row_b = new Array();
    var row_c = new Array();
    var row_list = [row_a, row_b, row_c];

    for (var j = 0; j < 3; j++) {
        for (var i = 0; i < col; i++) {
            row_list[j][i] = total_td_list[j * col + i];
            row_list[j][i].baseUrl = baseUrl;
            row_list[j][i].background = baseUrl + "/html/images/" + randomImage();
        }
    }
    JSON.stringify(total_td_list);
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

function startGame(gameType, panelId, imagesBaseUrl, inviteUserId) {
	var ws = new WebSocket("ws://localhost:8080/set-game-portlet/wschat/WsChatServlet");
    ws.onopen = function() {
    	var gameData = newGameData(gameType, imagesBaseUrl);
    	ws.send("startGame " + Liferay.ThemeDisplay.getUserId() + " " + inviteUserId + " " + gameData);
    }
}

function gameSize(gameType) {
	if ("large" == gameType)
		return 15;
	if ("small" == gameType)
		return 9;

	return 12;
}