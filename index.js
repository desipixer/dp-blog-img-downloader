// index.js


/** Get settings from external file or use default params */
var settings = {
	id : "",
	startIndex : 1,
	maxResults : 500,
	alt : "json"
}

var getFeedUrl = function(id, startIndex, maxResults){
	id = id || settings.id;
	startIndex = startIndex || settings.startIndex,
	maxResults = maxResults || settings.maxResults;

	return "https://www.blogger.com/feeds/${id}/posts/default?start-index=${startIndex}&max-results=${maxResults}&alt=json"
}

console.log(getFeedUrl());