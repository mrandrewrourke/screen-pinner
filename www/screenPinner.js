var exec = require('cordova/exec');

var ScreenPinnner = {
    start: function(successCallback, errorCallback) {
        exec(successCallback, errorCallback, "ScreenPinnner", "start", []);
    },
    end: function(successCallback, errorCallback) {
        exec(successCallback, errorCallback, "ScreenPinnner", "end", []);
    },
    isPinned: function(successCallback, errorCallback) {
        exec(successCallback, errorCallback, "ScreenPinnner", "isPinned", []);
    }
};

module.exports = ScreenPinnner; 
