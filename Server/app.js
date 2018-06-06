var express = require('express');
var app = express();
var container="";
var check;
var check2;
var Header;
var Contents ="";
var horizontal;
app.get('/news',function(req,res){
    var allnews = req.query['allnews'];
    var updatednews = allnews.replace("[[","[");
    var othernews = updatednews.replace("]]","]");
    var filter_one = othernews.replace("["," ");
    var split_main = filter_one.split("]");
    for(var i=0;i<split_main.length;i++){

    	var eachnews = split_main[i];
    	var filter = eachnews.replace("["," ");
    	var contents = eachnews.split(",");
         for(var j=0;j<contents.length;j++){
         	var Header = contents[0];
         	console.log(Header);
        	if(contents[j].search("\\[")!= -1){
        		var contentFilter = contents[j].replace("["," ");

        	}
        	else{
        		var contentFilter = contents[j];
        	}
        	container +=   "<div>"+contentFilter+"</div> <br/>";         	
        }
        horizontal = "<hr/>";
        container += horizontal
        
    }
    	
    res.sendFile(__dirname + "/index.html");
 

});
app.get('/upload',function(req,res){
 
 		 res.status(200).send(container);   
})
app.listen(3000);

