<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MoviesApp</title>
</head>
<body>
   <input type="text" id="usertext">
   <button onClick="getData()">SEARCH</button>
    <button onClick="getFav()">Watch</button>
   <p id="mydata"> </p> 
   <p id="message"></p>
   <p id="output"></p>
   
   <script type="text/javascript">
   var dataObj;
function getData(){
    var xmlHttp = new XMLHttpRequest();
    var word= document.getElementById("usertext").value;

   
    var url = "https://api.themoviedb.org/3/search/movie?api_key=628feb1e5d19aa715bd6f0824546c81d&query="+word;
    xmlHttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            var myArr= JSON.parse(this.responseText);
            dataObj= myArr;
           for(var i in dataObj.results)
        	   { 
        	   	 var info="Title = " +
                  dataObj.results[i].title + "<br> Ratings =" + dataObj.results[i].vote_average +
                  "<br> Release Date =" + dataObj.results[i].release_date + "<br> Overviews =" +
                  dataObj.results[i].overview +"<br>"+
                  "<button onClick=sendData("+i+")>Add To Fav</button>"+"<br>";
        	      document.getElementById("mydata").insertAdjacentHTML('afterend',info);
        	   }
           
}  
    };
    xmlHttp.open("GET",url,true);
    xmlHttp.send();
  }
  
  
  function sendData(i){
	  var xmlHttp = new XMLHttpRequest();
	  var params = "title=" +dataObj.results[i].title+ "&rating=" +dataObj.results[i].vote_average+ "&releaseDate=" +dataObj.results[i].release_date+ "&overview="+dataObj.results[i].overview;
	  var url1= "http://localhost:8081/MoviesApp/fav?"+params;
	  xmlHttp.open("GET",url1,true);
	  xmlHttp.send();
	  
	  xmlHttp.onreadystatechange = function() {
	        if(this.readyState == 4 && this.status == 200){
	  			var msg=this.responseText; 
	  			document.getElementById("message").innerHTML=msg;	
	        }
	  };            
  }
  
  function getFav(){
	  
	  var xmlHttp = new XMLHttpRequest();
	  var url1= "http://localhost:8081/MoviesApp/Favwatch";
	  xmlHttp.open("GET",url1,true);
	  xmlHttp.send();
	  
	  xmlHttp.onreadystatechange = function() {
	        if(this.readyState == 4 && this.status == 200){
	  			var watchfav=this.responseText; 
	  			//alert(watchfav);
	  			document.getElementById("output").innerHTML=watchfav;	
	        }
	  };            
  }
</script>
</body>
</html>