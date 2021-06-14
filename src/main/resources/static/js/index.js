let roverData = document.getElementById("roverData")

updateRoverButtons(roverData);

function updateRoverButtons(roverData) {
	roverData.value = roverData.value.charAt(0).toUpperCase() + roverData.value.slice(1);
	document.getElementById("rover"+roverData.value).classList.remove("btn-secondary") 
	document.getElementById("rover"+roverData.value).classList.add("btn-primary")
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
			document.getElementById('frmRoverName').submit()
	}))
