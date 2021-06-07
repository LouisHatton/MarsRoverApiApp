let apiData = document.getElementById("roverData")

let queryString = window.location.search;
let urlParams = new URLSearchParams(queryString);
let roverData = urlParams.get("roverData");
updateRoverButtons(roverData)

function updateRoverButtons(roverData) {
	if (roverData == null)
		roverData = "Curiosity"
		
	roverData = roverData.charAt(0).toUpperCase() + roverData.slice(1);
	document.getElementById("rover"+roverData).classList.remove("btn-secondary") 
	document.getElementById("rover"+roverData).classList.add("btn-primary")
	apiData.value = roverData
}



let roverButtons = document.querySelectorAll("button[id*='rover']")

roverButtons.forEach( button => button.addEventListener("click", function (){
									let name = this.id.split("rover")[1]
									let btnRoverVal = document.getElementById("roverData")
									if (btnRoverVal.value != name)
										document.getElementById("rover"+btnRoverVal.value).classList.remove("btn-primary") 
										document.getElementById("rover"+btnRoverVal.value).classList.add("btn-secondary")
										this.classList.remove("btn-secondary")
										this.classList.add("btn-primary")
										btnRoverVal.value = name
									//document.getElementById("frmRoverName").submit()
								}))


									
let marsSol = urlParams.get("marsSol")
if (marsSol != null)
	document.getElementById("marsSol").value=marsSol

