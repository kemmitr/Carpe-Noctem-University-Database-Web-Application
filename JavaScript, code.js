document.getElementById("links2").style.display = "none";

function passIt() {

var pass = "Delta";
var user = "Admin";
var tempPass = document.getElementById("password").value;
var tempName = document.getElementById("userN").value;
if (tempPass == pass && tempName == user) {
    document.getElementById("links2").style.display = "block";
}
}
