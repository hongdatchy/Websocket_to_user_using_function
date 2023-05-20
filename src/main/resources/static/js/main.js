
var stompClient = null;
myCount = 0
function connect(username) {
    var socket = new SockJS('/hello');
    stompClient = Stomp.over(socket);
    // dang test nen cho token = username luon
    stompClient.connect({username: username, token: username}, function() {

        console.log('Web Socket is connected');
        stompClient.subscribe("/queue/messages/" + username, function(message) {
            $("#message").text(message.body);
        });
        // subscribe(destination, callback, headers = {})

    });
}
// about stomp js https://stomp-js.github.io/stomp-websocket/codo/class/Client.html

// -> cai send cung can co token
$(function() {
    $("form").on('submit', function(e) {
        e.preventDefault();
    });
    $("#connect").click(function() {
        connect($("#username").val());
    });
    $("#send").click(function() {
        stompClient.send("/app/hello",
            {from : $("#username").val(), to : $("#partner").val()}
            , "Nice to meet you");
    });
    //send(destination, headers = {}, body = '')
});