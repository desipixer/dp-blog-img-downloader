// this will download all the images from blog and saves to json

/** Define Node Modules */
var request = require('request'),
	fs = require('fs'),
	async = require('async'),
	cheerio = require('cheerio');


/** Get settings from external file or use default params */
var settings = {
	id : "",
	startIndex : 1,
	maxResults : 500,
	alt : "json"
}

var DB = {};

var URLUtil = (function(){
	var getFeedUrl = function(id, startIndex, maxResults){
		id = id || settings.id;
		startIndex = startIndex || settings.startIndex,
		maxResults = maxResults || settings.maxResults;

		return "https://www.blogger.com/feeds/${id}/posts/default?start-index=${startIndex}&max-results=${maxResults}&alt=json"
	}


	return {
		getFeedUrl : getFeedUrl
	}

})();


DB.imgArray = [];

// Initializes the download and build default call Url
function initDownload(){
	var initUrl = URLUtil.getFeedUrl();
	console.log(initUrl)
	downloadAllFeeds([initUrl]);	
}

function downloadAllFeeds(urlArray){
	async(urlArray, settings.threads, function(url, cb) {
		request(url, function(code, response, error){
			if(code != null){

			}
		})
	}
}

var module = (function(){
	// contains blog related information
	var settings = {
		id : "",
		startIndex : 1,
		maxResults : 500,
		alt : "json"
	}


	return {
		settings : settings
	}
})();


