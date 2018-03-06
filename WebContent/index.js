var dataObj;
// Function for search button and getting data from API
function getData() {
	var xmlHttp = new XMLHttpRequest();
	var word = document.getElementById("usertext").value;
	$('#favresult').empty();
	$('#apiresult').empty();

	var url = "https://api.themoviedb.org/3/search/movie?api_key=628feb1e5d19aa715bd6f0824546c81d&query="
			+ word;
	xmlHttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var myArr = JSON.parse(this.responseText);
			dataObj = myArr;
			for ( var i in dataObj.results) {
				var info = "Title = " + dataObj.results[i].title
						+ "<br> Ratings =" + dataObj.results[i].vote_average
						+ "<br> Release Date ="
						+ dataObj.results[i].release_date + "<br> Overviews ="
						+ dataObj.results[i].overview + "<br>"
						+ "<button onClick=sendData(" + i
						+ ")>Add To Favourite</button>" + "<br>" + "<hr>";
				$('#apiresult').append(info);
			}
		}
	};
	xmlHttp.open("GET", url, true);
	xmlHttp.send();
}
// Function for Add to Fav button and send data to json file
function sendData(i) {
	var xmlHttp = new XMLHttpRequest();
	var params = "title=" + dataObj.results[i].title + "&rating="
			+ dataObj.results[i].vote_average + "&releaseDate="
			+ dataObj.results[i].release_date + "&overview="
			+ dataObj.results[i].overview;
	var url1 = "http://localhost:8081/MoviesApp/fav?" + params;
	xmlHttp.open("GET", url1, true);
	xmlHttp.send();

	xmlHttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var msg = this.responseText;
			document.getElementById("message").innerHTML = msg;
		}
	};
}
// Function for Watch Favourite button
function getFav() {

	var xmlHttp = new XMLHttpRequest();
	var url1 = "http://localhost:8081/MoviesApp/Favwatch";
	xmlHttp.open("GET", url1, true);
	xmlHttp.send();
	$('#favresult').empty();
	$('#apiresult').empty();

	xmlHttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var watchfav = JSON.parse(this.responseText);
			for (var i = 0; i < watchfav.movie.length; i++) {
				var info = "Title = " + watchfav.movie[i].title
						+ "<br> Ratings =" + watchfav.movie[i].rating
						+ "<br> Release Date =" + watchfav.movie[i].releaseDate
						+ "<br> Overviews =" + watchfav.movie[i].overview
						+ "<br>" + "<button onClick=removeData(" + i
						+ ")>Remove</button>" + "<br>" + "<hr>";
				$('#favresult').append(info);
			}
		}
	};
}
// Function for remove button
function removeData(i) {

	var xmlHttp = new XMLHttpRequest();
	var url = "http://localhost:8081/MoviesApp/remove?id=" + i;
	xmlHttp.open("GET", url, true);
	xmlHttp.send();

	xmlHttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			alert(this.responseText);
		}
	};
}
