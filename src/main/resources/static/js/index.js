let roverButtons = document.querySelectorAll("button[id*='rover']")

roverButtons.forEach( button => button.addEventListener("click", function (){
													let name = this.id.split("rover")[1]
													let apiData = document.getElementById("roverData")
													apiData.value = name.toLowerCase()
													document.getElementById("frmRoverName").submit()
												}))


									
let queryString = window.location.search;
let urlParams = new URLSearchParams(queryString);
let roverData = urlParams.get("roverData");
updateRoverButtons(roverData)

function updateRoverButtons(roverData) {
	if (roverData == null)
		roverData = "curiosity"
		
	roverData = roverData.charAt(0).toUpperCase() + roverData.slice(1);
	document.getElementById("rover"+roverData).classList.remove("btn-secondary")
	document.getElementById("rover"+roverData).classList.add("btn-primary")
}

