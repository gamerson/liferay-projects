var empty_r_c_a = [0, 0, 0];
var fill_r_c_a = [0, 0, 0];
var potted_r_c_a = [0, 0, 0];
var red_c_a = [empty_r_c_a, fill_r_c_a, potted_r_c_a];

var empty_g_c_a = [0, 0, 0];
var fill_g_c_a = [0, 0, 0];
var potted_g_c_a = [0, 0, 0];
var green_c_a = [empty_g_c_a, fill_g_c_a, potted_g_c_a];

var empty_b_c_a = [0, 0, 0];
var fill_b_c_a = [0, 0, 0];
var potted_b_c_a = [0, 0, 0];
var blue_c_a = [empty_b_c_a, fill_b_c_a, potted_b_c_a];

var circle_a = [red_c_a, green_c_a, blue_c_a];

var empty_r_b_a = [0, 0, 0];
var fill_r_b_a = [0, 0, 0];
var potted_r_b_a = [0, 0, 0];
var red_b_a = [empty_r_b_a, fill_r_b_a, potted_r_b_a];

var empty_g_b_a = [0, 0, 0];
var fill_g_b_a = [0, 0, 0];
var potted_g_b_a = [0, 0, 0];
var green_b_a = [empty_g_b_a, fill_g_b_a, potted_g_b_a];

var empty_b_b_a = [0, 0, 0];
var fill_b_b_a = [0, 0, 0];
var potted_b_b_a = [0, 0, 0];
var blue_b_a = [empty_b_b_a, fill_b_b_a, potted_b_b_a];

var block_a = [red_b_a, green_b_a, blue_b_a];

var empty_r_d_a = [0, 0, 0];
var fill_r_d_a = [0, 0, 0];
var potted_r_d_a = [0, 0, 0];
var red_d_a = [empty_r_d_a, fill_r_d_a, potted_r_d_a];

var empty_g_d_a = [0, 0, 0];
var fill_g_d_a = [0, 0, 0];
var potted_g_d_a = [0, 0, 0];
var green_d_a = [empty_g_d_a, fill_g_d_a, potted_g_d_a];

var empty_b_d_a = [0, 0, 0];
var fill_b_d_a = [0, 0, 0];
var potted_b_d_a = [0, 0, 0];
var blue_d_a = [empty_b_d_a, fill_b_d_a, potted_b_d_a];

var diamond_a = [red_d_a, green_d_a, blue_d_a];

var shape_a = [circle_a, diamond_a, block_a];
var click_num = 0;
var e_array = new Array();
var set = new Array();
var td_obj=new Array();

function init(a) {
	var e = document.getElementById("panel");
	var flag = document.getElementById("table");
	if (flag != null) {
		flag.parentNode.removeChild(flag);

	}
	if (a == 1) {
		var table = document.createElement("table");
		table.setAttribute("id", "table");
		table.setAttribute("border", "1");

		for (var i = 1; i <= 3; i++) {
			var tr = document.createElement("tr");

			for (var j = 1; j <= 3; j++) {
				var td = document.createElement("td");
				td.setAttribute("width", "160px");
				td.setAttribute("height", "160px");
				td.setAttribute("name", "unchecked");
				td.setAttribute("onclick", "chooseElement(event)");
				tr.appendChild(td);

			}
			table.appendChild(tr);
		}

		e.appendChild(table);
		loadImage();

	} else if (a == 2) {
		var e = document.getElementById("panel");
		var table = document.createElement("table");
		table.setAttribute("id", "table");
		table.setAttribute("border", "1");

		for (var i = 1; i <= 3; i++) {
			var tr = document.createElement("tr");

			for (var j = 1; j <= 4; j++) {
				var td = document.createElement("td");
				td.setAttribute("width", "160px");
				td.setAttribute("height", "160px");
				td.setAttribute("name", "unchecked");
				td.setAttribute("onclick", "chooseElement(event)");
				tr.appendChild(td);

			}
			table.appendChild(tr);
		}
		e.appendChild(table);
		loadImage();
	} else if (a == 3) {
		var e = document.getElementById("panel");
		var table = document.createElement("table");
		table.setAttribute("id", "table");
		table.setAttribute("border", "1");

		for (var i = 1; i <= 3; i++) {
			var tr = document.createElement("tr");

			for (var j = 1; j <= 5; j++) {
				var td = document.createElement("td");
				td.setAttribute("width", "160px");
				td.setAttribute("height", "160px");
				td.setAttribute("name", "unchecked");
				td.setAttribute("onclick", "chooseElement(event)");
				tr.appendChild(td);

			}
			table.appendChild(tr);
		}
		e.appendChild(table);
		loadImage();
	}

}

function loadImage() {
	var total_td_list = new Array();
	total_td_list = document.getElementsByTagName("td");
	var col = total_td_list.length / 3;
	var row_a = new Array();
	var row_b = new Array();
	var row_c = new Array();
	var row_list = [row_a, row_b, row_c];

	for (var j = 0; j < 3; j++) {
		for (var i = 0; i < col; i++) {
			row_list[j][i] = total_td_list[j * col + i];
			row_list[j][i].setAttribute("background", "images/" + randomImage());
		}
	}
	
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

function chooseElement(e) {
	if (!e) {
		var e = window.event;
	}
	var targ = e.target;

	var temp = targ.getAttribute("name");
	if (temp == "unchecked") {
		if (click_num != 3) {
			targ.setAttribute("style", "border:3px solid red;");
			targ.setAttribute("name", "checked");
			click_num++;
			if (click_num == 3) {
				judge_init();
				if (judgeIsSet(set[0],set[1],set[2])) {
		alert("It's good set!!");
		exchange();
	} else {
		alert("It's bad set!!");
		restore();
	}
				
			}
		}
	} else {
		targ.setAttribute("name", "unchecked");
		targ.setAttribute("style", "");
		click_num--;

	}
}

function restore() {
	var td_a = new Array();
	td_a = document.getElementsByTagName("td");
	for (var i = 0; i < td_a.length; i++) {
		var flag = td_a[i].getAttribute("name");
		if (flag == "checked") {
			td_a[i].setAttribute("name", "unchecked");
			td_a[i].setAttribute("style", "");
			click_num = 0;
		}
	}
}

function exchange() {
	var td_a = new Array();
	td_a = document.getElementsByTagName("td");
	for (var i = 0; i < td_a.length; i++) {
		var flag = td_a[i].getAttribute("name");
		if (flag == "checked") {
			td_a[i].setAttribute("name", "unchecked");
			td_a[i].setAttribute("style", "");
			td_a[i].setAttribute("background", "images/" + randomImage());
			
			click_num = 0;
		}
	}
}

function judge_init() {
	var td_a = new Array();
	td_a = document.getElementsByTagName("td");
	var m = 0;
	for (var i = 0; i < td_a.length; i++) {
		var flag = td_a[i].getAttribute("name");
			var file_name = td_a[i].getAttribute("background").substr(7,4);
			var set_instance = {
				shape : file_name.substr(0, 1),
				color : file_name.substr(1, 1),
				fill : file_name.substr(2, 1),
				number : file_name.substr(3, 1)
			};
			td_obj[i]=set_instance;
		if (flag == "checked") {
			set[m] = set_instance;
			m++;
		}
	}
	if(!isThereSet(td_obj)){
	 alert("there isn't any good set in this panel !! please reset the panel !!");
	}
}

function judgeIsSet(a, b, c) {
	var flag = false;
	if (sod(a.shape, b.shape, c.shape)) {
		if (sod(a.color, b.color, c.color)) {
			if (sod(a.fill, b.fill, c.fill)) {
				if (sod(a.number, b.number, c.number)) {
					flag = true;
					shape_a[set[0].shape-1][set[0].color-1][set[0].fill-1][set[0].number-1];
					shape_a[set[1].shape-1][set[1].color-1][set[1].fill-1][set[1].number-1];
					shape_a[set[2].shape-1][set[2].color-1][set[2].fill-1][set[2].number-1];
				}

			}

		}

	}

	return flag;
	
}

function sod(a, b, c) {
	if (a == b && b == c && c == a) {
		return true;
	} else if (a != b && b != c && c != a) {
		return true;
	} else {
		return false;
	}
}

function isThereSet(a){
	var flag=false;
	for(var i=0;i<a.length-2;i++){
		for(var j=i+1;j<a.length-1;j++){
			for(var k=j+1;k<a.length;k++){
				temp=judgeIsSet(a[i],a[j],a[k]);
				if(temp){
					// alert("("+a[i].shape+a[i].color+a[i].fill+a[i].number+")("+a[j].shape+a[j].color+a[j].fill+a[j].number+")("+a[k].shape+a[k].color+a[k].fill+a[k].number+")");
					flag=true;
				}
			}
		}
	}
	return flag;
}

