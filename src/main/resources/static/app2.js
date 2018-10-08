var socket = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    socket = new WebSocket('ws://'+location.host+'/echo.do');
    socket.onopen = function (e) {
    	if( e.target.readyState != 1) return false;
    	socket.onmessage = showGreeting;
    	setConnected(true);
    	
    }
}

function disconnect() {
    if (socket !== null) {
        socket.close();
    }
    setConnected(socket.readyState == 1);
}

function sendName() {
    socket.send($('#name').val());
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message.data + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    $( "#name" ).keyup(function(e) {
    	if( e.keyCode == 13 ) {sendName();};
    });
});

