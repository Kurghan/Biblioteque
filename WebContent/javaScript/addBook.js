
function openList(){
	window.open("listeAuteurs", "_blank", "toolbar=yes,scrollbars=yes,resizable=no,top=200,left=-950,width=600,height=730");
}

//Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("btnAuthors");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

function getName(name,surname){
	auteur.value = surname +" "+ name;
	
}

function addAuthor(){
	modal.style.display = "none";
}