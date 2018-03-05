<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MoviesApp</title>
</head>
<body>
	<div class="py-5 text-white bg-dark text-center">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
         <h1>MoviesApp</h1>
         <p class="lead mb-4">ENTERTAINMENT ENTERTAINMENT ENTERTAINMENT</p>
          <p class="lead mb-4">Find your entertainment over here</p>
         <form class="form-inline justify-content-center">
           <div class="input-group my-2 w-50">
           <input type="text" class="form-control mr-3 my-1" id="usertext" placeholder="Movie name"> </div>
           <button type="button" class="btn btn-secondary btn-lg mr-2" onclick="getData()">SEARCH</button>
           <button type="button" class="btn btn-secondary btn-lg" onclick="getFav()">WATCH FAVOURITE</button> 
         </form>     
    <div class="py-5 text-center" id="message"></div>
       </div>
     </div>
   </div>
 </div>
<div class="container" id ="apiresult">
<!-- <div id="apiresult">hi api</div> -->
</div>
    
 <div class="container" id ="favresult">
<!-- <div  id="favresult">bye fav</div> -->
</div>
    


    <script type="text/javascript" src="index.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
      <!-- <input type="text" id="usertext">
   <button onClick="getData()">SEARCH</button>
    <button onClick="getFav()">Watch</button> -->
    
  <!--  <p id="mydata"> </p> 
   <p id="message"></p>
   <p id="output"></p> -->
   <script src="index.js"></script>
</body>
</html>